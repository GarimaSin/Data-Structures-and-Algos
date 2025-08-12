package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class BestTimeBuySellStock3 {

	static int MAX = Integer.MIN_VALUE;
	public static void main(String[] args) {
		int prices[] = {1,2,9,4,5};
		System.out.println(maxProfit(prices));
	}
	
	
	// Working
	public static int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][3][3];
		for(int i[][]: dp)
            for(int j[]: i)
			    Arrays.fill(j, -1);
            int ans = maxProfit(prices, 0, 1, 0, dp);
		return (ans<0) ? 0 : ans;
    }


    public static int maxProfit(int[] prices, int i, int canBuy, int count, int[][][] dp) {
		if(count == 2) {
			return (canBuy == 1) ? 0 : -999999;
		}
		
		if(i == prices.length && canBuy == 1 && count <= 2)
			return 0;

		if(i >= prices.length || count > 2)
			return -999999;

		if(dp[i][canBuy][count] == -1) {
			int i1=-999999, i2=-999999, i3=-999999, max=-999999;

			if(canBuy == 1)
				i1 = -prices[i] + maxProfit(prices, i+1, 0, count, dp);
			else 
				i2 = prices[i] + maxProfit(prices, i+1, 1, count+1, dp);

			i3 = maxProfit(prices, i+1, canBuy, count, dp);
			max = Math.max(i1, Math.max(i2, i3));
			dp[i][canBuy][count] = max;
		}
		return dp[i][canBuy][count];
	}
	
	
	// Working - Better, avoided 1 extra DP parameter
    public int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length+1][4];
		for(int i[]: dp)
			Arrays.fill(i, -1);
            int ans = maxProfit1(prices, 0, 0, dp);
		return (ans<0) ? 0 : ans;
    }


    public int maxProfit1(int[] prices, int i, int count, int[][] dp) {
    	if(count == 4) 
			return 0;
		
		if(i == prices.length && count <= 4)
			return 0;

		if(i >= prices.length || count > 4)
			return -999999;

		if(dp[i][count] == -1) {
			int i1=-999999, i2=-999999, max=-999999;

			if(count%2 == 0)
				i1 = -prices[i] + maxProfit1(prices, i+1, count+1, dp);
			else 
				i1 = prices[i] + maxProfit1(prices, i+1, count+1, dp);

			i2 = maxProfit1(prices, i+1, count, dp);
			max = Math.max(i1,i2);
			dp[i][count] = max;
		}
		return dp[i][count];
	}
}
