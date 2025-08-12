package Problem_Solving.DP.Longest_Common_Subsequence;

class LongestPalindromicSubsequence {

	//I - time = O(n*n) = as tot. no of computation = size of 2d matrix
	public int findLPSLength(String string) {
		Integer[][] dp = new Integer[string.length()][string.length()];
		return lps_Aux(dp, string, 0, string.length() - 1);
	}


	//Working
	private int lps_Aux(Integer[][] dp, String string, int st, int end) {
		if (st > end) 		//BASE CASE - If we have traversed more than 1/2 of string then return 0 as we don't need to process it
			return 0;
		
		if (st == end) 		//BASE CASE - If both the index are at same position then its a palindrome as its 1 character.
			return 1;
		
		int c3 = 0;
		if (dp[st][end] == null) { 								
			if (string.charAt(st) == string.charAt(end)) {
				c3 = 2 + lps_Aux(dp, string, st + 1, end - 1);
			} 
			int c1 = lps_Aux(dp, string, st + 1, end);			
			int c2 = lps_Aux(dp, string, st, end - 1);			
			dp[st][end] = Math.max(c3,Math.max(c1, c2));		
		}
		return dp[st][end];
	}
	
	
	//Working
	public int findLPSLength_BU(String st) {
		int[][] dp = new int[st.length()][st.length()];
		for (int col = 0; col < st.length(); col++) {
			for (int row = st.length()-1; row >= 0; row--) {
				if (row > col) { // BASE CASE - If we have traversed more than 1/2 of string then return 0 as we dont need to process it
					dp[row][col] = 0;
				} else if (row == col) { // BASE CASE - If both the index are at same position then its a palindrome as its 1 character.
					dp[row][col] = 1;
				} else {
					if (st.charAt(row) == st.charAt(col)) {
						dp[row][col] = Math.max(2+dp[row + 1][col - 1], Math.max(dp[row][col - 1], dp[row + 1][col]));
					} else {
						dp[row][col] = Math.max(dp[row][col - 1], dp[row + 1][col]);
					}
				}
			} 
		}
		return dp[0][st.length()-1];
	}



	public static void main(String[] args){
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		System.out.println("Longest Palindromic Sequence: " + lps.findLPSLength("ABBDCACB"));
		System.out.println("Longest Palindromic Sequence: " + lps.findLPSLength_BU("abgfrba"));
	}
}