package Problem_Solving.DP.Udemy.LongestCommomPalindromic.LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * 
 * If any index starts from -1, use +1 for index memo instead of memo[index +1] - Line 49, 50 - previndex
 * Mind that the initial val of prev = -1 
 * https://www.techiedelight.com/increasing-subsequence-with-maximum-sum/
 */
public class LongestIncreasingSubsequenceMaxSum {
	
	
	//Recursion, Time = O(2^n) Space = O(n^2)
	//Incl/Excl - Working
	public static int lengthofLIS(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[curpos] > prev) {
        	taken = nums[curpos] + lengthofLIS(nums, nums[curpos], curpos + 1);		// prev = num[curpos]
        }
        int nottaken = lengthofLIS(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }
	
	public int lengthOfLIS(int[] nums) {
        int memo[][] = new int[nums.length + 1][nums.length];
        for (int[] l : memo) {
            Arrays.fill(l, -1);
        }
        return lengthofLIS(nums, -1, 0, memo);
    }
	
	//Working
    public int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo) {
        if (curpos == nums.length) {
            return 0;
        }
        if (memo[previndex + 1][curpos] >= 0) {
            return memo[previndex + 1][curpos];
        }
        int taken = 0;
        if (previndex < 0 || nums[curpos] > nums[previndex]) {
            taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo);
        }

        int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo);
        memo[previndex + 1][curpos] = Math.max(taken, nottaken);
        return memo[previndex + 1][curpos];
    }
    
    
    public static void main(String[] args)
	{
		int[] A = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };

		System.out.print("Maximum sum of increasing subsequence is " +
				lengthofLIS(A, -1, 0));
	}
}
