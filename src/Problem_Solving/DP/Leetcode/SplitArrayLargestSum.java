package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class SplitArrayLargestSum {

	public static void main(String[] args) {

	}

	int[][] memo;
	int[] prefixSum;

	
	// Working
	public int splitArray(int[] nums, int k) {
		int n = nums.length;
		// Compute prefix sum for O(1) range sum
		prefixSum = new int[n + 1];
		for (int i = 0; i < n; i++) {
			prefixSum[i + 1] = prefixSum[i] + nums[i];
		}

		memo = new int[n][k + 1];
		for (int[] row : memo) {
			Arrays.fill(row, -1);
		}
		return dp(0, k, nums);
	}


	int dp(int i, int k, int[] nums) {
		int n = nums.length;
		if (memo[i][k] != -1) 
			return memo[i][k];
		
		if (k == 1) 
			// Only one subarray left: take the sum of the rest
			return memo[i][k] = prefixSum[n] - prefixSum[i];

		int minLargestSum = Integer.MAX_VALUE;

		// ensures: Every subproblem has enough elements to complete the remaining k-1 split 
		// or All subarrays are non-empty, as required
		for (int j = i+1; j <= n-(k-1); j++) {			

			int leftSum = prefixSum[j] - prefixSum[i];
			int rightMax = dp(j, k-1, nums);
			int largest = Math.max(leftSum, rightMax);
			minLargestSum = Math.min(minLargestSum, largest);

			if (leftSum >= minLargestSum) 
				break; // Prune if already too big
		}
		return memo[i][k] = minLargestSum;
	}



	// Working
	public int splitArray1(int[] nums, int k) {
		int max = 0;
		int sum = 0;

		for (int num : nums) {
			max = Math.max(max, num);
			sum += num;
		}

		// Binary search range: [max element, total sum]
		int left = max, right = sum;
		while (left < right) {
			int mid = left + (right-left) / 2;
			if (canSplit(nums, k, mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	boolean canSplit(int[] nums, int k, int maxSumAllowed) {
		int count = 1;
		int currSum = 0;

		for (int num : nums) {
			if (currSum + num > maxSumAllowed) {
				count++;
				currSum = num;
				if (count > k) {
					return false;
				}
			} else {
				currSum += num;
			}
		}
		return true;
	}
}
