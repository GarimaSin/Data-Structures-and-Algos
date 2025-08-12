package Problem_Solving.DP.Unbounded_Knapsack;

/**
 * 
 * Given a rod of length N inches and an array of prices, price[] that 
 * contains prices of all pieces of size smaller than N. Determine the 
 * max value obtainable by cutting up the rod and selling the pieces.
 *
 */

public class RodCutting {

	public static void main(String[] args) {
		int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
		int n = 8;
		cutRod(price, n, 0, 0, 0);
		System.out.println(".........."+max);
		
		System.out.println(cutRod(price, n, 0, 0, 0, ""));
		
		int dp[][] = new int[n+1][n+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		System.out.println(cutRod(price, n, 0, 0, dp));
	}
	
	
	//Recursion - Working
	static int max = Integer.MIN_VALUE;
	static public void cutRod(int price[], int n, int i, int len, int val) {
		if(i > n || len > n)
			return ;
		
		if(i == n) {
			if(len == n)
				max = Math.max(max, val);
			return;
		}
		cutRod(price, n, i, len+i+1, val+price[i]);
		cutRod(price, n, i+1, len, val);
	}
	
	
	//Tested in techiedelight + gfg TLE after 100 TCs passed - working
	public static int cutRod(int price[], int n, int i, int len, int val, String ans) {
		if(i > n || len > n)
			return -1;
		
		if(i == n) {
			if(len == n) {
				return val;
			}
			return -1;
		}
		int i1 = cutRod(price, n, i, len+i+1, val+price[i], "");
		int i2 = cutRod(price, n, i+1, len, val, "");
		return Math.max(i1, i2);
	}
	
	
	//Memoized - working
	static public int cutRod(int price[], int n, int i, int len, int[][] dp) {
		if(i > n || len > n)
			return Integer.MIN_VALUE;
		
		if(i == n) {
			if(len == n) {
				return 0;
			}
			return Integer.MIN_VALUE;
		}
		if(dp[i][len] != Integer.MIN_VALUE)
			return dp[i][len];
		int i1 = price[i] + cutRod(price, n, i, len+i+1, dp);
		int i2 = cutRod(price, n, i+1, len, dp);
		dp[i][len] = Math.max(i1, i2);
		return dp[i][len];
	}
}
