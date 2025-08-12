package Problem_Solving.DP.Longest_Common_Subsequence;

import java.util.Arrays;

public class ShortestCommonSuperSeqAll{
	
	// Working 
	public static String shortestCommonSupersequence1(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        String[][] dp = new String[l1+1][l2+1];
        String a = printLongestCommonSubsequence(str1, str2, 0, 0, dp);
        System.out.println(a);

        String ans = "";
        int i = 0, j = 0, k = 0;
        while(i<l1 && j<l2 && k<a.length()) {
            if(str1.charAt(i) == str2.charAt(j) && str2.charAt(j) == a.charAt(k)) {
                ans = ans + a.charAt(k);
                i++; 
                j++;
                k++;
            } else {
                while (str1.charAt(i) != a.charAt(k)) {
                    ans = ans + str1.charAt(i);
                    i++;
                }
                while (str2.charAt(j) != a.charAt(k)) {
                    ans = ans + str2.charAt(j);
                    j++;
                }
            } 
            continue;    
        }

        while (i<l1) {
            ans = ans + str1.charAt(i);
            i++;
        }
        while (j<l2) {
            ans = ans + str2.charAt(j);
            j++;
        }
        return ans;
    }

    static String printLongestCommonSubsequence(String text1, String text2, int i, int j, String[][] dp) {
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

	
	//working - Memo - Mem Limit Exceeded - 47/50.
	public static String SCSLengthMine(String X, String Y, int m, int n, String[][] dp) {
		if (m == X.length() || n == Y.length()) {
			dp[m][n] = (X.substring(m) + Y.substring(n));
			return dp[m][n];
		}

		if(dp[m][n] != null)
			return dp[m][n];

		if (X.charAt(m) == Y.charAt(n)) {
			dp[m][n] = X.charAt(m) + SCSLengthMine(X, Y, m+1, n+1, dp);
			return dp[m][n];
		}

		String c1 = Y.charAt(n) + SCSLengthMine(X, Y, m, n+1, dp);
		String c2 = X.charAt(m) + SCSLengthMine(X, Y, m+1, n, dp);
		dp[m][n] = (c1.length() <= c2.length()) ? c1 : c2;
		return dp[m][n];
	}

	public static void main(String[] args) {

		String X = "bbbaaaba", Y = "bbababbb";
		int m = X.length(), n = Y.length();
		int[][] memo = new int[m+1][n+1];

		for (int[] row: memo)
			Arrays.fill(row, 999);

		System.out.println("Shortest Common supersequence is " + shortestCommonSupersequence(X, Y));
		
		System.out.println("Shortest Common supersequence is " + shortestCommonSupersequence1(X, Y));
	}

	public static String shortestCommonSupersequence(String str1, String str2) {
		int len1 = str1.length()+1;
		int len2 = str2.length()+1;
		String[][] dp = new String[len1][len2];
		return SCSLengthMine(str1, str2, 0, 0, dp);
	}
}
