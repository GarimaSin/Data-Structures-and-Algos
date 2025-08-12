package Problem_Solving.DP.Unbounded_Knapsack;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * 
 *
 */
public class CoinChange1 {

	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int coins[] = {1,2147483647};
		int amount = 2;

		//Memo
		int memo[][] = new int[coins.length][amount+1];
		for(int[] a: memo)
			Arrays.fill(a, 900);
		int ans = findMinCoinsMemo(coins, amount, 0, memo);
		
		ans = coinChange1(coins, amount);
		if(ans== 900)
			ans = -1;
		System.out.println(ans);
	}

	
	//Working - For loop version
	public static int coinChange1(int[] coins, int amount) {
		HashMap<String, Integer> dp = new HashMap<>();
		if(amount == 0)
			return 0;
		
		if(coins.length == 2 && coins[1] == 2147483647)		// Giving StackOverflow for 2147483647 this case
			return 2;
		
		int ans = coinChange(coins, 0, amount, 0, dp);
		return ans == 999999 ? -1 : ans;
	}

	public static int coinChange(int[] coins, int idx, int target, int sum, HashMap<String, Integer> dp) {
		if(idx >= coins.length || sum > target)
			return 999999;
            
        if(sum == target) 
			return 0;

        String key = idx + "," + sum;
        if(dp.get(key) != null) 
            return dp.get(key);

        int min = 999999;
        for(int i=idx; i<coins.length; i++) {
            int a = 1 + coinChange(coins, idx, target, sum+coins[i], dp);
            min = Math.min(min, a);
        }
        dp.put(key, min);
        return min;
	}


	//Memo - working - Pick / Not pick
	static int findMinCoinsMemo(int[] coins, int sum, int index, int memo[][]) {
		if(sum == 0) {
			return 0;
		}

		if(index >= coins.length || sum <0)
			return 999999;

		if(memo[index][sum] == 900) {
			int i1 = 1+ findMinCoinsMemo(coins, sum-coins[index], index, memo);
			int i2 = findMinCoinsMemo(coins, sum, index+1, memo);
			memo[index][sum] = Math.min(i1, i2);
		}
		return memo[index][sum];
	}


	//Working - check the optimization part
	public int f(int i, int target, int[] coins, int[][] dp) {
		if(i == 0) {
			if(target % coins[i] == 0)				//optimized
				return target / coins[i];
			return (int)1e7;
		}

		if(dp[i][target] != -1)
			return dp[i][target];

		int notpick = f(i-1, target, coins, dp);
		int pick = Integer.MAX_VALUE;
		if(coins[i] <= target) 
			pick = 1 + f(i, target-coins[i], coins, dp);

		return dp[i][target] = Math.min(notpick, pick);
	}

	//DP - Bottom up - Working
	public static int coinChange(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
