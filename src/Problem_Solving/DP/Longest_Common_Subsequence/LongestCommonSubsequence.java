package Problem_Solving.DP.Longest_Common_Subsequence;

import java.util.Arrays;

/**
 * 
 * Time = O(mn), Space = O(mn) (O(n) extra space is occupied in recursion methods)
 * I - commented else in longestCommonSubsequence() means if 1 sol is found, dont 
 * recurse on EXCLUDE recursive calls which cud not give the best sol.
 *
 */
public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String text1 = "abcde";
		String text2 = "ace";
		int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        int ans = longestCommonSubsequence(text1, text2, 0, 0, dp);
        System.out.println(ans);
	}
	
    // Working
    public static int longestCommonSubsequence(String text1, String text2, int i, int j, int[][] dp) {
        if(i == text1.length() || j == text2.length()) 
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int l1 = 0, l2 = 0, l3 = 0;
        if(i<text1.length() && j<text2.length() && text1.charAt(i) == text2.charAt(j)) {
            l1 = 1 + longestCommonSubsequence(text1, text2, i+1, j+1, dp);
//        } else {																	// Works with this also.
            		// I - else means if 1 sol is found, dont recurse on EXCLUDE recursive calls which cud not give the best sol.
        }
        	l2 = longestCommonSubsequence(text1, text2, i, j+1, dp);
            l3 = longestCommonSubsequence(text1, text2, i+1, j, dp);   
//        }
        int ans = Math.max(Math.max(l1, l2), l3);
        dp[i][j] = ans;
        return ans;
    }
    
    
    // Working
    private int findLCSLengthAux(String s1, String s2, int i1, int i2, int[][] dp) {
		if (i1 == s1.length() || i2 == s2.length())
			return 0;

		if (dp[i1][i2] == -1) {	
			if (s1.charAt(i1) == s2.charAt(i2)) {
				dp[i1][i2] = 1 + findLCSLengthAux(s1, s2, i1+1, i2+1, dp); 
				return dp[i1][i2];
			} else {
				int c1 = findLCSLengthAux(s1, s2, i1, i2+1, dp);			
				int c2 = findLCSLengthAux(s1, s2, i1+1, i2, dp);			
				dp[i1][i2] = Math.max(c1, c2);
			}
		}
		return dp[i1][i2];
	}
    
    // Working Bottom-up
    public static int LCSLengthBU(String X, String Y) {
		int m = X.length(), n = Y.length();

		int[][] L = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) { 
			for (int j = 0; j <= n; j++) { 
				if (i == 0 || j == 0) 
					L[i][j] = 0; 
				else if (X.charAt(i - 1) == Y.charAt(j - 1)) 
					L[i][j] = L[i - 1][j - 1] + 1; 
				else
					L[i][j] = Math.max(L[i - 1][j], 
							L[i][j - 1]); 
			} 
		}
		// LCS will be last entry in the lookup table
		return L[m][n]; 
	}
    
    /** Space optimized using 1D array **/
	public static int LCSLength1(String X, String Y) {
		int m = X.length(), n = Y.length();

		// allocate storage for 1-D arrays curr and prev
		int[] curr = new int[n + 1];
		int[] prev = new int[n + 1];

		// fill the lookup table in bottom-up manner
		for (int i = 0; i <= m; i++)
		{
			for (int j = 0; j <= n; j++)
			{
				if (i > 0 && j > 0) {
					// if current char of X and Y matches
					if (X.charAt(i - 1) == Y.charAt(j - 1)) {
						curr[j] = prev[j - 1] + 1;
					}
					// else if current char of X and Y don't match
					else {
						curr[j] = Integer.max(prev[j], curr[j - 1]);
					}
				}
			}
			// replace contents of previous array with current array
			System.arraycopy(curr, 0, prev, 0, n + 1);
		}

		// LCS will be last entry in the lookup table
		return curr[n];
	}
}
