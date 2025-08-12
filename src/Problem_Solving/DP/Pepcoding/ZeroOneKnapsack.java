package Problem_Solving.DP.Pepcoding;

public class ZeroOneKnapsack {

	public static void main(String[] args) {
		int values[] = {1,2,3};
		int weight[] = {4,5,1};
		int N = 3, W = 4;
		knapSack(W, weight, values, N);
	}
	
	static void knapSack(int W, int wt[], int val[], int n) { 
        int dp[][] = new int[n+1][W+1];
        for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
        int sum = findMaxValMine(W, wt, val, n, dp, 0, 0);
        System.out.println(sum);
   }

	
	//Working
	private static int findMaxValMine(int capacity, int[] wt, int[] val, int n, int[][] dp, int idx, int sum) {
		if(sum == capacity || idx >= wt.length)			//Code will not work if idx >= wt.length is put with line# 1.
			return 0;
		
		if(sum > capacity)									// Line #1 
			return Integer.MIN_VALUE;
		
		if(dp[idx][sum] != Integer.MIN_VALUE)
			return dp[idx][sum];
		else {
			int i1 = val[idx] + findMaxValMine(capacity, wt, val, n, dp, idx+1, sum+wt[idx]);
			int i2 = findMaxValMine(capacity, wt, val, n, dp, idx+1, sum);
			dp[idx][sum] = Math.max(i1, i2);
			return dp[idx][sum];
		}
	}
	
	//Working
	static int findMaxValMineTD(int target, int weight[], int val[]) {
		int[][] dp = new int[weight.length+1][target+1];
		
		for (int i = 0; i <= weight.length; i++) {
			for (int j = 0; j <= target; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if(weight[i-1] <= j) {
					dp[i][j] = Math.max(val[i-1] + dp[i-1][j-weight[i-1]], 		//include
							dp[i-1][j]);									//exclude
				} else {
					dp[i][j] = dp[i-1][j];			
				}
			}
		}
		return dp[weight.length][target];
	}
}
