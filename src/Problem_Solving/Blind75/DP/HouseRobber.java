package Problem_Solving.Blind75.DP;

import java.util.Arrays;

//Working sol
public class HouseRobber {

	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5,1,2,3,4,5};
		System.out.println(rob1(nums));
	}

	// Working
	// rob1 and rob2 r same except rob1 starts 4m last index while rob2 start 4m 0th index.
	public static int rob1(int[] nums) {
		int n = nums.length;
		int dp[] = new int[n];

		Arrays.fill(dp, -1);
		int s1 = rob1(nums, 0, 0, dp);

		Arrays.fill(dp, -1);
		int s2 = rob1(nums, 1, 1, dp);
		return Math.max(s1, s2);
	}

	public static int rob1(int[] nums, int index, int prev, int[] dp) {
		if(index < 0) 
			return 0;

		if(dp[index] != -1)
			return dp[index];

		//	      if(prev != index-1)			no need of this since already using index-2
		int a = nums[index] + rob1(nums, index+2, index, dp);	
		int b = rob1(nums, index+1, prev, dp);
		int s = Math.max(a,b);
		dp[index] = s;

		return s;
	}

	// Working
	public int rob2(int[] nums) {
		int n = nums.length;
		int dp[] = new int[n];

		Arrays.fill(dp, -1);
		return rob2(nums, 0, dp);
	}

	public int rob2(int[] nums, int index, int[] dp) {
		if(index >= nums.length) 
			return 0;

		if(dp[index] != -1)
			return dp[index];

		int a = nums[index] + rob2(nums, index+2, dp);	
		int b = rob2(nums, index+1, dp);
		int s = Math.max(a,b);
		dp[index] = s;
		return s;
	}

	// Working
	public int rob3(int[] nums) {
		int n = nums.length;
		int dp[][] = new int[n][n];
		for(int[] a: dp)
			Arrays.fill(a, -1);

		return rob3(nums, 0, 0, dp);
	}

	public int rob3(int[] nums, int index, int prev, int[][] dp) {
		if(index >= nums.length) 
			return 0;

		if(dp[index][prev] != -1)
			return dp[index][prev];

		int a = 0;
		if(prev != 1)
			a = nums[index] + rob3(nums, index+1, 1, dp);	// 1 = robbed
		int b = rob3(nums, index+1, 0, dp);					// 0 = not robbed
		int s = Math.max(a,b);
		dp[index][prev] = s;
		return s;
	}

	//DP - Working
	public static int robHouse1(int[] nums, int memo[], int ind) {
		if(nums == null || nums.length == 0)
			return 0;

		if(nums.length == 1)
			return nums[0];

		if(nums.length == 2)
			return Math.max(nums[1], nums[0]);

		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for(int i=2; i<nums.length; i++) {
			dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
		}
		return dp[nums.length-1];
	}
}