package Problem_Solving.DP.Udemy.LongestCommomPalindromic;

import java.util.Arrays;

/**
 * 
 * If any index starts from -1, use +1 for index memo instead of memo[index +1] - Line 49, 50 - previndex 
 *
 */
public class LongestDecreasingSubsequence {
	
	public int lengthOfLIS(int[] nums) {
        int memo[][] = new int[nums.length + 1][nums.length];
        for (int[] l : memo) {
            Arrays.fill(l, -1);
        }
        return lengthofLIS(nums, -1, 0, memo);
    }
	
	//Recursion, Time = O(2^n) Space = O(n^2)
	//Incl/Excl - Working
	public int lengthofLIS(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[curpos] < prev) {
        	taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);		// prev = num[curpos]
        }
        int nottaken = lengthofLIS(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
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
        if (previndex < 0 || nums[curpos] < nums[previndex]) {
            taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo);
        }

        int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo);
        memo[previndex + 1][curpos] = Math.max(taken, nottaken);
        return memo[previndex + 1][curpos];
    }
}
