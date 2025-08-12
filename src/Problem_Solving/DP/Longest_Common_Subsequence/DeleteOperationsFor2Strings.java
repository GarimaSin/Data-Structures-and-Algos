package Problem_Solving.DP.Longest_Common_Subsequence;

import java.util.Arrays;

public class DeleteOperationsFor2Strings {

	public static void main(String[] args) {
		String word1 = "sea", word2 = "eat";
		int ans = minDistance(word1, word2);
		System.out.println(ans);
	}
	
	public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        int ans = longestCommonSubsequence(word1, word2, 0, 0, dp);
        return (word1.length() + word2.length()) - ans*2;
    }

    public static int longestCommonSubsequence(String text1, String text2, int i, int j, int[][] dp) {
        if(i == text1.length() || j == text2.length()) 
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int l1 = 0, l2 = 0, l3 = 0;
        if(i<text1.length() && j<text2.length() && text1.charAt(i) == text2.charAt(j)) {
            l1 = 1 + longestCommonSubsequence(text1, text2, i+1, j+1, dp);
       } else {																	
        // }
        	l2 = longestCommonSubsequence(text1, text2, i, j+1, dp);
            l3 = longestCommonSubsequence(text1, text2, i+1, j, dp);   
       }
        int ans = Math.max(Math.max(l1, l2), l3);
        dp[i][j] = ans;
        return ans;
    }

}
