package Problem_Solving.DP;

import java.util.Arrays;

public class CreatePartitionsWithGivenDiff {

	/***
	 * Input: arr = [1, 1, 2, 3], diff = 1 Output: 3
		Explanation: The subsets are [1, 2] and [1, 3], [1, 3] and [1, 2], [1, 1, 2] and [3].
		
		Input: arr = [1, 2, 3, 4], diff = 2 Output: 2
		Explanation: The subsets are [1, 3] and [2, 4], [1, 2, 3] and [4].
	 * 
	 */
	public static void main(String a[])	{
		int diff = 1;
		int arr[] = {1, 1, 2, 3};
		System.out.println(countPartitions(diff, arr));
	}

	public static int countPartitions(int diff, int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++)
			sum = sum + arr[i];

		int[][] dp = new int[arr.length+1][sum+1];  
		for(int i[]: dp)
			Arrays.fill(i, -1);
		return createPartition(arr, 0, 0, sum, 0, dp, diff)/2; 
	}

	public static int createPartition(int[] nums, int ss1, int ss2, int sum, int idx, int[][] dp, int diff) {
		if(idx > nums.length)
			return 0;

		if(idx == nums.length) {
			if(Math.abs(ss1-ss2) == diff)
				return 1;
			return 0;
		}

		if(dp[idx][ss1] != -1)
			return dp[idx][ss1];

		int d1 = createPartition(nums, ss1+nums[idx], ss2, sum, idx+1, dp, diff);
		int d2 = createPartition(nums, ss1, ss2+nums[idx], sum, idx+1, dp, diff);

		int tmp = d1 + d2;
		dp[idx][ss1] = tmp;
		return tmp;
	}
}
