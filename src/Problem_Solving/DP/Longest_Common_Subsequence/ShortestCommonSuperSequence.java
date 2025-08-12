package Problem_Solving.DP.Longest_Common_Subsequence;

import java.util.Arrays;

/**
 * 
 * +1 in all cases
 * Since we have to find min, c3 is not initialized with 0 but 9999.
 *
 */
public class ShortestCommonSuperSequence{

	//working
	public static int SCSLengthMine(String X, String Y, int m, int n)
	{
		if (m == X.length() || n == Y.length()) {
			return ((X.length()-m) + (Y.length()-n));
		}

		if (X.charAt(m) == Y.charAt(n)) {
			return 1+ SCSLengthMine(X, Y, m+1, n+1);
		}

		int c1 = 1+ SCSLengthMine(X, Y, m, n+1);
		int c2 = 1+ SCSLengthMine(X, Y, m+1, n);

		return Integer.min(c1,c2);
	}

	//working
	public static int SCSLengthMemoMine(String X, String Y, int m, int n, int memo[][])
	{
		if (m == X.length() || n == Y.length()) {
			return ((X.length()-m) + (Y.length()-n));
		}

		if(memo[m][n] == -1) {
			int c3=9999;
			if (X.charAt(m) == Y.charAt(n)) {
				c3 = 1+ SCSLengthMemoMine(X, Y, m+1, n+1, memo);		/** +1 IN ALL CASES **/
			}

			int c1 = 1+ SCSLengthMemoMine(X, Y, m, n+1, memo);
			int c2 = 1+ SCSLengthMemoMine(X, Y, m+1, n, memo);
			memo[m][n] = Integer.min(c3, Integer.min(c1,c2));
		}
		return memo[m][n];
	}



	//Working
	public static int SCSLengthMemo(String X, String Y, int m, int n, int[][] memo)
	{
		if (m == X.length() || n == Y.length()) {
			memo[m][n] = (X.length()-m) + (Y.length()-n);
			return (memo[m][n]);
		}

		if(memo[m][n] != -1)
			return memo[m][n];

		if (X.charAt(m) == Y.charAt(n)) {
			memo[m][n] = 1+ SCSLengthMemo(X, Y, m+1, n+1, memo);
			return memo[m][n];
		}

		int c1 = 1+ SCSLengthMemo(X, Y, m, n+1, memo);
		int c2 = 1+ SCSLengthMemo(X, Y, m+1, n, memo);
		memo[m][n] = Integer.min(c1,c2);
		return memo[m][n];
	}


	public static void main(String[] args) {

		String X = "AGGTAB", Y = "GXTXAYB";
		int m = X.length(), n = Y.length();
		int[][] memo = new int[m+1][n+1];

		for (int[] row: memo)
			Arrays.fill(row, -1);

		System.out.println("The length of shortest Common supersequence is " + SCSLengthMine(X, Y, 0, 0));
		System.out.println("The length of shortest Common supersequence is " + SCSLengthMemoMine(X, Y, 0, 0, memo));
		System.out.println("The length of shortest Common supersequence is " + SCSLength(X, Y, m, n));
		System.out.println("The length of shortest Common supersequence is " + SCSLengthMemo(X, Y, 0, 0, memo));
	}

	//working
	static int SCSLength(String X, String Y, int m, int n) 
	{ 
		if (m == 0) 
			return n; 
		if (n == 0) 
			return m; 

		if (X.charAt(m - 1) == Y.charAt(n - 1)) 
			return 1 + SCSLength(X, Y, m - 1, n - 1); 

		int c1 = 1+ SCSLength(X, Y, m - 1, n);
		int c2 = 1+ SCSLength(X, Y, m, n - 1);

		return Math.min(c1, c2); 
	}
}
