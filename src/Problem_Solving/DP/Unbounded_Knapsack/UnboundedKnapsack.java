package Problem_Solving.DP.Unbounded_Knapsack;

public class UnboundedKnapsack {
	static int knapSack(int N, int W, int val[], int wt[]) {
		int dp[][] = new int[N+1][W+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		return findMaxValMine(W, wt, val, N, dp, 0, 0);
	}

	
	//Working - thru GFG
	static int findMaxValMine(int capacity, int[] wt, int[] val, int n, int[][] dp, int idx, int sum) {
		if(sum == capacity || idx >= wt.length)			//Code will not work if idx >= wt.length is put with line# 1.
			return 0;

		if(sum > capacity)									// Line #1 
			return Integer.MIN_VALUE;

		if(dp[idx][sum] != Integer.MIN_VALUE)
			return dp[idx][sum];
		else {
			int i1 = val[idx] + findMaxValMine(capacity, wt, val, n, dp, idx, sum+wt[idx]);
			int i2 = findMaxValMine(capacity, wt, val, n, dp, idx+1, sum);
			dp[idx][sum] = Math.max(i1, i2);
			return dp[idx][sum];
		}
	}
}
