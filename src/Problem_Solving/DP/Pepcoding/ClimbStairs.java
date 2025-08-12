package Problem_Solving.DP.Pepcoding;

public class ClimbStairs {

	public static void main(String[] args) {
		int n = 4;
		int[] qb = new int[n + 1];
		int paths = countPaths(n, qb);
		System.out.println(paths);
	}

	//Memo
	public static int countPaths(int n, int[] qb) {
		if (n == 0) {				//If we are at 0th stair ==> we have 1 way to reach 0th stair = do not go anywhere
			return 1;
		} else if (n < 0) {		// if v r in basement, there is no way v can go back.
			return 0;
		}
		if (qb[n] != 0) {
			return qb[n];
		}
		int p1 = countPaths(n - 1, qb);
		int p2 = countPaths(n - 2, qb);
		int p3 = countPaths(n - 3, qb);

		qb[n] = p1 + p2 + p3;
		return qb[n];
	}

	
	//Tabulation
	public static int countPathsTab(int n) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}
		int[] dp = new int[n + 1];

		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1];
			if (i >= 2)
				dp[i] += dp[i - 2];
			if (i >= 3)
				dp[i] += dp[i - 3];
		}
		return dp[n];
	}
}