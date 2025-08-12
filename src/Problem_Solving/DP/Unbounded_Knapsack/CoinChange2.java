package Problem_Solving.DP.Unbounded_Knapsack;

//No. of ways to achieve the target amount
public class CoinChange2 {

	public static void main(String[] args) {
		int coins[] = {1,2,5};
		int amount = 5;
		int dp[][] = new int[coins.length+1][amount+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		int ans = findCombMine(coins, amount, dp, 0, 0, "");
		System.out.println(ans+".....");
	}
	
	
	//Working
	static int findCombMine(int[] coins, int amount, int[][] dp, int idx, int sum, String ans) {
		if(sum == amount) {
			System.out.println(ans);
			return 1;
		}
		
		if(idx >= coins.length || sum > amount)
			return 0;
		
		if(dp[idx][sum] != -1)
			return dp[idx][sum];
		else {
			int i1 = findCombMine(coins, amount, dp, idx, sum+coins[idx], ans+coins[idx]);
			int i2 = findCombMine(coins, amount, dp, idx+1, sum, ans);
			dp[idx][sum] = i1+i2;
			return dp[idx][sum];
		}
	}
}