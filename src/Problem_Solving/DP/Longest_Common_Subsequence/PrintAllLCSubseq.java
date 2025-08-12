package Problem_Solving.DP.Longest_Common_Subsequence;

import java.util.HashSet;
import java.util.Set;

/** Declare a set at the beginning, Line# 14 **/
public class PrintAllLCSubseq {

	// Print all LCS
	private static Set<String> lcs(int[][] dp, String fst, String snd, int i, int j) {
		Set<String> ans = new HashSet<>();

	    if (i == 0 || j == 0) {
	        ans.add("");
	    } else if (fst.charAt(i-1) == snd.charAt(j-1)) {
	        for (String lcs : lcs(dp, fst, snd, i-1, j-1)) {
	            ans.add(lcs + fst.charAt(i-1));
	        }
	    } else {
	        if (dp[i-1][j] >= dp[i][j-1]) {
	            ans.addAll(lcs(dp, fst, snd, i-1, j));
	        }

	        if (dp[i][j-1] >= dp[i-1][j]) {
	            ans.addAll(lcs(dp, fst, snd, i, j-1));
	        }
	    }
	    return ans;
	}
	
	
	// Print the LCS
    public static String printLongestCommonSubsequence(String text1, String text2, int i, int j, String[][] dp) {
        if(i == text1.length() || j == text2.length()) 
            return "";

        if(dp[i][j] != null)
            return dp[i][j];

        String l1 = "", l2 = "", l3 = "";
        if(i<text1.length() && j<text2.length() && text1.charAt(i) == text2.charAt(j)) {
            l1 = text1.charAt(i) + printLongestCommonSubsequence(text1, text2, i+1, j+1, dp);
        }

        l2 = printLongestCommonSubsequence(text1, text2, i, j+1, dp);
        l3 = printLongestCommonSubsequence(text1, text2, i+1, j, dp);   
        if(l1.length() > l2.length()) {
        	if(l1.length() > l3.length())
        		dp[i][j] = l1;
        	else
        		dp[i][j] = l3;
        } else {
        	if(l2.length() > l3.length())
        		dp[i][j] = l2;
        	else
        		dp[i][j] = l3;
        }
        return dp[i][j];
    }
    

	// Driver Code 
	public static void main(String[] args) { 
		String X = "abcde"; 
		String Y = "bdgek"; 
		int m = X.length(); 
		int n = Y.length(); 

		int dp[][] = new int[m+1][n+1];
		for(String s: lcs(dp, X, Y, m, n))
			System.out.println("LCS is " + s); 
		
		String[][] dp1 = new String[X.length()+1][Y.length()+1];
		
		System.out.println(printLongestCommonSubsequence(X, Y, 0, 0, dp1));
	} 
}
