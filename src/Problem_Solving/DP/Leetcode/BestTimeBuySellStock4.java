package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class BestTimeBuySellStock4 {

	public static void main(String[] args) {
		int prices[] = {3,2,6,5,0,3};
		int k = 2;
		System.out.println(maxProfit(prices, k));
	}
	
	// Working - Better, avoided 1 extra DP parameter
    public static int maxProfit(int[] prices, int k) {
        int[][] dp = new int[prices.length+1][k*2];
		for(int i[]: dp)
			Arrays.fill(i, -1);
            int ans = maxProfit(prices, 0, 0, k*2, dp);
		return (ans<0) ? 0 : ans;
    }


    public static int maxProfit(int[] prices, int i, int count, int k, int[][] dp) {
    	if(count == k) 
			return 0;
		
		if(i == prices.length && count <= k)
			return 0;

		if(i >= prices.length || count > k)
			return -999999;

		if(dp[i][count] == -1) {
			int i1=-999999, i2=-999999, i3=-999999, max=-999999;

			if(count%2 == 0)
				i1 = -prices[i] + maxProfit(prices, i+1, count+1, k, dp);
			else 
				i2 = prices[i] + maxProfit(prices, i+1, count+1, k, dp);

			i3 = maxProfit(prices, i+1, count, k, dp);
			max = Math.max(i1, Math.max(i2, i3));
			dp[i][count] = max;
		}
		return dp[i][count];
	}
}
