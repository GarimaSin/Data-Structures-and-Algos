package Problem_Solving.DP.Longest_Common_Subsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * If any index starts from -1, use +1 for index memo instead of memo[index +1] - Line 49, 50 - previndex
 * Mind that the initial val of prev = -1
 * https://www.techiedelight.com/longest-increasing-subsequence-using-lcs/ 
 * Recur = O(2^n), TD = O(n^2)
 */

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		System.out.print("Maximum sum of increasing subsequence is " +
				lengthOfLIS(A));
	}
	
	public static String lengthOfLIS(int[] nums) {
		String[][] dp = new String[nums.length+1][nums.length+1];
//        for(int i[]: dp)
//            Arrays.fill(i, -1);
        return lengthOfLIS2(nums, 0, -1, dp);
    }

    public static int lengthOfLIS(int[] nums, int i, int prev, int[][] dp) {
        if(i == nums.length)
            return 0;

        int taken = 0;
        if(dp[i][prev+1] == -1) {
            if(prev == -1 || nums[prev] < nums[i])
                taken = 1 + lengthOfLIS(nums, i+1, i, dp);
            int nottaken = lengthOfLIS(nums, i+1, prev, dp);
            dp[i][prev+1] = Math.max(taken, nottaken);
        }
        return dp[i][prev+1];
    }
    
    
    public static String lengthOfLIS2(int[] nums, int i, int prev, String[][] dp) {
        if(i == nums.length)
            return "";

        String taken = "";
        if(dp[i][prev+1] == null) {
            if(prev == -1 || nums[prev] < nums[i])
                taken = nums[i]+" " + lengthOfLIS2(nums, i+1, i, dp);
            String nottaken = lengthOfLIS2(nums, i+1, prev, dp);
            dp[i][prev+1] = taken.length()>nottaken.length() ? taken : nottaken;
        }
        return dp[i][prev+1];
    }
    
    // Working - Using patience sort
    /**
     * Binary research, return example:
     * int[] arr = {10, 20, 30, 40}; 
     * The insertion point is 2 (between 20 and 30). The method returns -(2) - 1 = -3.
     */
    public int lengthOfLIS3(int[] nums) {
        List<Integer> piles = new ArrayList<>();
        
        for (int num : nums) {
            int idx = Collections.binarySearch(piles, num);
            
            if (idx<0) 
            	idx = -(idx + 1); // Find insertion point
            
            if (idx == piles.size()) {
                piles.add(num); // New pile
            } else {
                piles.set(idx, num); // Replace pile top
            }
        }
        return piles.size();
    }
}