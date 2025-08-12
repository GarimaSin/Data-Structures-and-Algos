package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class FindTheCountOfMonotonicPairsII {

	private static final int MOD = 1_000_000_007;
	public static void main(String[] args) {
		int[] nums = {2,3,2};
		System.out.println(countOfPairs(nums));
	}


	public static int countOfPairs(int[] nums) {
        int n = nums.length;
        
        int[][][] dp = new int[n][101][101]; 
        for (int[][] d1 : dp) {
            for (int[] d2 : d1) {
                Arrays.fill(d2, -1);
            }
        }
        // Start with prevA = 0 (lower bound) and prevB = 100 (max upper bound) 
        // coz all other nos. will b less than this and Hence non decreasing.
        
        
//      return dfs(nums, 0, 0, 100, dp);
        
        
        int[][] dp1 = new int[n][1001]; 
        for (int[] d1 : dp1) {
        	Arrays.fill(d1, -1);
        }
        return dfs2(nums, 0, 0, dp1);
//      return solve(nums, 0, 0, 100, dp);
    }
	
	static int solve(int[] nums, int idx, int prevA, int prevB, int[][][] dp) {
        if (idx == nums.length) 
            return 1;
        
        if (dp[idx][prevA][prevB] != -1) 
            return dp[idx][prevA][prevB];

        int total = 0;
        int sum = nums[idx];

        for (int a = 0; a <= sum; a++) {
            int b = sum - a;

            // a must be >= prevA (non-decreasing)
            // b must be <= prevB (non-increasing)
            if (a >= prevA && b <= prevB) {
                total = (total + solve(nums, idx+1, a, b, dp)) % MOD;
            }
        }

        dp[idx][prevA][prevB] = total;
        return total;
    }

	
	// Non-decreasing sequence for a is enforced by starting the loop at a = prevA
	// Time = O(n * M * 10^4), Space = O(n * 10^4)
    static int dfs(int[] nums, int idx, int prevA, int prevB, int[][][] dp) {
        if (idx == nums.length) 
            return 1;
        
        if (dp[idx][prevA][prevB] != -1) 
            return dp[idx][prevA][prevB];

        long total = 0; 		// Use long to prevent overflow before modulo
        int sum = nums[idx];

        // Try all (a, b) such that a + b = sum
        for (int a=prevA; a <= sum; a++) {
            int b = sum - a;

            if (b <= prevB && b >= 0) {
                total = (total + dfs(nums, idx+1, a, b, dp)) % MOD;
            }
        }

        dp[idx][prevA][prevB] = (int) total;
        return dp[idx][prevA][prevB];
    }
    
    
    // Working - TLE - 797/801
    static int dfs2(int[] nums, int idx, int prevA, int[][] dp) {
    	if (idx == nums.length) 
            return 1;
        
        if (dp[idx][prevA] != -1) 
            return dp[idx][prevA];

        long total = 0; 

        for (int a=prevA; a <= nums[idx]; a++) {
            int b = nums[idx]-a;

            if (idx == 0 || (b <= nums[idx-1]-prevA && b >= 0)) {
                total = (total + dfs2(nums, idx+1, a, dp)) % MOD;
            }
        }
        dp[idx][prevA] = (int) total;
        return dp[idx][prevA];
    }
    
    
    // Working
    public int countOfPairs1(int[] nums) {
        int n = nums.length;
        int m = 1001;

        // dp[i][j]: the valid monotonic pairs in nums[0...i] when arr1[i] == j
        int[][] dp = new int[n][m];

        // Base case: arr1[0] can be any value from 0 to nums[0]
        for (int num=0; num <= nums[0]; num++) {
            dp[0][num] = 1;
        }

        for (int i=1; i<n; i++) {
            int[] presum = new int[m+1]; // prefix sum array of size m+1

            for (int j=0; j<m; j++) {
                presum[j+1] = (presum[j] + dp[i-1][j]) % MOD;
            }

            // For each possible value of arr1[i] = num1
            for (int num1=0; num1 <= nums[i]; num1++) {
                int prv1 = Math.min(num1, nums[i-1]-nums[i]+num1);
                if (prv1 < 0) 
                	continue;

                // presum[prv1 + 1] is prefix sum of dp[i - 1][0...prv1]
                dp[i][num1] = presum[prv1+1];
            }
        }

        // Sum of all valid ways ending at dp[n - 1][*]
        long result = 0;
        for (int x=0; x<m; x++) {
            result = (result + dp[n-1][x]) % MOD;
        }

        return (int) result;
    }

}
