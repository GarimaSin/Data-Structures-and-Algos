package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class PredictTheWinner {
	
	public static void main(String[] args) {
		int[] nums = {1,5,2};
		predictTheWinner(nums);
	}
	
	// Working
	public static boolean predictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] j: dp)
            Arrays.fill(j, -1);
		return findWinner(nums, 0, nums.length-1, dp) >= 0;
	}
	
	static int findWinner(int[] nums, int s, int e, int[][] dp) {
		if (s==e)
			return nums[s];

        if(dp[s][e] != -1)
            return dp[s][e];
		int a = nums[s] - findWinner(nums, s+1, e, dp);
		int b = nums[e] - findWinner(nums, s, e-1, dp);
		return dp[s][e] = Math.max(a, b);
	}
}
