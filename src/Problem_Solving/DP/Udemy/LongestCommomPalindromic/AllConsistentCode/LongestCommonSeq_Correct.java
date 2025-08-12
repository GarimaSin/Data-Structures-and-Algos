package Problem_Solving.DP.Udemy.LongestCommomPalindromic.AllConsistentCode;

public class LongestCommonSeq_Correct {

	public int longestCommonSubsequence(String text1, String text2) {
		int[][] dp = new int[text1.length()][text2.length()]; 		
		for (int i = 0; i < text1.length(); i++) 					
			for (int j = 0; j < text2.length(); j++)
				dp[i][j] = -1;
		return findLCSLengthAux(dp, text1, text2, 0, 0);
	}

	//Working
	private int findLCSLengthAux(int[][] dp, String s1, String s2, int i1, int i2) {

		if (i1==s1.length() || i2 == s2.length()) { 		
			return 0;
		}

		int c3 = 0;
		if (dp[i1][i2] == -1) { 								
			if (s1.charAt(i1) == s2.charAt(i2)) {
				c3 = 1 + findLCSLengthAux(dp, s1, s2, i1 + 1, i2 + 1);	
			} 
			int c1 = findLCSLengthAux(dp, s1, s2, i1 + 1, i2);			
			int c2 = findLCSLengthAux(dp, s1, s2, i1, i2 + 1);			
			dp[i1][i2] = Math.max(c3,Math.max(c1, c2));		
		}
		return dp[i1][i2];
	}
	
	public static void main(String[] args) {
		LongestCommonSeq_Correct lcs = new LongestCommonSeq_Correct();
		System.out.println(lcs.longestCommonSubsequence("ABEF", "CADE"));

	}
}
