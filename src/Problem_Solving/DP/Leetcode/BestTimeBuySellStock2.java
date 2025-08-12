package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class BestTimeBuySellStock2 {

	public static void main(String[] args) {
		int prices[] = {1,2,3,4,5};
		System.out.println(maxProfit(prices));
		System.out.println(calculate(prices, 0));
	}

	//Working
	public static int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length+1][3];
		for(int i[]: dp)
			Arrays.fill(i, -1);
		return maxProfit(prices, 0, 1, 0, dp);
	}

	public static int maxProfit(int[] prices, int i, int canBuy, int count, int[][] dp) {
		if(count == 2) {
			if(canBuy == 1)
				return 0;
			return -999999;
//			return (canBuy == 1) ? 0 : -999999;
		}
		
		if(i == prices.length && canBuy == 1 && count == 2)
			return 0;

		if(i >= prices.length || count > 2)
			return -999999;

		if(dp[i][canBuy] == -1) {

			int i1=-999999, i2=-999999, i3=-999999, max=-999999;

			if(canBuy == 1)
				i1 = -prices[i] + maxProfit(prices, i+1, 0, count, dp);
			else 
				i2 = prices[i] + maxProfit(prices, i+1, 1, count+1, dp);

			i3 = maxProfit(prices, i+1, canBuy, count, dp);
			max = Math.max(i1, Math.max(i2, i3));
			dp[i][canBuy] = max;
		}
		return dp[i][canBuy];
	}


	// Called as: return maxProfit(prices, 0, -1, dp);
	// Memory Limit Exceeded coz buyVal is index = prices.length.
	public int maxProfit2(int[] prices, int i, int buyVal, int[][] dp) {
		if(i == prices.length && buyVal == -1)
			return 0;

		if(i >= prices.length)
			return -999999;

		if(dp[i][buyVal+1] == -1) {

			int i1=-999999, i2=-999999, i3=-999999, max=-999999;
			int val = prices[i];

			if(buyVal == -1) {
				i1 = maxProfit2(prices, i+1, i, dp);
			} else {
				if(val > prices[buyVal])
					i2 = (val-prices[buyVal]) + maxProfit2(prices, i+1, -1, dp);
			}
			i3 = maxProfit2(prices, i+1, buyVal, dp);
			max = Math.max(i1, Math.max(i2, i3));
			dp[i][buyVal+1] = max;
		}
		return dp[i][buyVal+1];
	}

	
	// TLE
	public static int calculate(int prices[], int s) {
		if (s >= prices.length)
			return 0;
		int max = 0;
		for (int start = s; start < prices.length; start++) {
			int maxprofit = 0;
			for (int i = start + 1; i < prices.length; i++) {
				if (prices[start] < prices[i]) {
					int profit = calculate(prices, i + 1) + prices[i] - prices[start];
					if (profit > maxprofit)
						maxprofit = profit;
				}
			}
			if (maxprofit > max)
				max = maxprofit;
		}
		return max;
	}
}