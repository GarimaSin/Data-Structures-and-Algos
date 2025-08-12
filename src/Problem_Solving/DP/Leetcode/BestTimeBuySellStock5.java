package Problem_Solving.DP.Leetcode;

public class BestTimeBuySellStock5 {

	public static void main(String[] args) {
		int prices[] = {3,2,6,5,0,3};
		int k = 2;
		System.out.println(maximumProfit(prices, k));
	}
	
	// Working
	public static long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        Long[][][] dp = new Long[n][k + 1][3];
        long ans = solve(0, k, 0, n, prices, dp);
        return ans;
    }

    static long solve(int i, int k, int decider, int n, int[] prices, Long[][][] dp) {
        if (i == n) {
            if (k >= 0 && decider == 0)
                return 0;
            return Integer.MIN_VALUE;
        }

        if (dp[i][k][decider] != null)
            return dp[i][k][decider];

        long take = Integer.MIN_VALUE, dontTake = Integer.MIN_VALUE;
        if (k > 0) {
            if (decider == 1) { 
                take = prices[i] + solve(i+1, k-1, 0, n, prices, dp);	//Only here k is reduced
            } else if (decider == 2) { 
                take = -prices[i] + solve(i+1, k-1, 0, n, prices, dp);	//Only here k is reduced
            } else {
            	long a = prices[i] + solve(i+1, k, 2, n, prices, dp);
            	long b = -prices[i] + solve(i+1, k, 1, n, prices, dp);
                take = Math.max(a, b);
            }
        }

        dontTake = solve(i+1, k, decider, n, prices, dp);
        return dp[i][k][decider] = Math.max(take, dontTake);
    }
}
