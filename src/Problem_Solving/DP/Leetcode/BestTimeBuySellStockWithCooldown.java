package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class BestTimeBuySellStockWithCooldown {

	public static void main(String[] args) {
		int prices[] = {1,2,3,0,2};
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
		for(int i[]: dp)
			Arrays.fill(i, -1);
            int ans = maxProfit(prices, 0, 1, dp);
		return (ans<0) ? 0 : ans;
    }

    public static int maxProfit(int[] prices, int i, int canBuy, int[][] dp) {		
		if(i == prices.length && canBuy == 1)
			return 0;

		if(i >= prices.length) // coz v r jumping by 2 steps also so can move to i==prices.length or i>prices.length
			return 0;

		if(dp[i][canBuy] == -1) {
			int i1=-9999, i2=-9999, max=-9999;

			if(canBuy == 1)
				i1 = -prices[i] + maxProfit(prices, i+1, 0, dp);
			else 
				i1 = prices[i] + maxProfit(prices, i+2, 1, dp);

			i2 = maxProfit(prices, i+1, canBuy, dp);
			max = Math.max(i1, i2);
			dp[i][canBuy] = max;
		}
		return dp[i][canBuy];
	}

}