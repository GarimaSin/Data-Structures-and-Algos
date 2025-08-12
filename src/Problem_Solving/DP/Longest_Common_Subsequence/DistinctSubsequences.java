package Problem_Solving.DP.Longest_Common_Subsequence;

import java.util.Arrays;

public class DistinctSubsequences {

	/***
	 * Given 2 strings s and t, return the no. of distinct subsequences of s which equals t.
	 * Input: s = "rabbbit", t = "rabbit"
	 * Output: 3
	 * rabbbit - 1st and 2nd b
	 * rabbbit - 1st and 3rd b
	 * rabbbit - 2nd and 3rd b
	 */
	
	// Working
	public static int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[s.length()+1][t.length()+1];
        return findDistinctSubsequences(s, 0, t, 0, dp);
    }

    static int findDistinctSubsequences(String s, int i, String t, int j, Integer[][] dp) {
        if(j == t.length())
            return 1; 

        if(i >= s.length())
            return 0;

        if(dp[i][j] != null)
            return dp[i][j];

        int taken = 0;
        if(s.charAt(i) == t.charAt(j)) 
        	taken = findDistinctSubsequences(s, i+1, t, j+1, dp);

        int not = findDistinctSubsequences(s, i+1, t, j, dp);
        int ans = taken+not;
        dp[i][j] = ans;
        return ans;
    }
    
    
    // Working - Giving Memory Limit Exceeded, 63/66 TCs
    public int numDistinct2(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen < tLen)
            return 0;
        int[][][] dp = new int[sLen+1][tLen+1][tLen+1];
        for(int[][] i: dp)
            for(int[] j: i)
                Arrays.fill(j, -1);
        int ans = longestCommonSubsequence(s, t, 0, 0, tLen, dp);
        return ans = ans < 0 ? -1 : ans;
    }

    public int longestCommonSubsequence(String text1, String text2, int i, int j, int len, int[][][] dp) {
        if(len == 0)
            return 1;
        
        if(i > text1.length() || j > text2.length() || len < 0) 
            return 0;

        if(dp[i][j][len] != -1)
            return dp[i][j][len];

        int l1 = 0, l2 = 0, l3 = 0;
        if(i<text1.length() && j<text2.length() && text1.charAt(i) == text2.charAt(j))
            l1 = longestCommonSubsequence(text1, text2, i+1, j+1, len-1, dp);

        	l2 = longestCommonSubsequence(text1, text2, i, j+1, len, dp);
            l3 = longestCommonSubsequence(text1, text2, i+1, j, len, dp);   

        int ans = l1 + l2 + l3;
        dp[i][j][len] = ans;
        return ans;
    }
	

	public static void main(String[] args) {
		String s = "rabbbit", t = "rabbit";
		int ans = numDistinct(s, t);
		System.out.println(ans+"..........");
	}
}
