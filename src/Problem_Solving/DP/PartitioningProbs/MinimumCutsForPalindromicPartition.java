package Problem_Solving.DP.PartitioningProbs;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/problems/palindromic-patitioning4845/1
 * Find the minimum cuts needed in a String such that each partition is a palindrome
 */

public class MinimumCutsForPalindromicPartition {
	
	// Working
    static int getMinCuts(String s, int i, int j, int[][] dp) {
        if(isPalindrome(s, i, j))
            return 0;
            
        if(i == j)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
            
        int min = 9999999;
        for(int k=i; k<=j-1; k++) {
            int left = getMinCuts(s, i, k, dp);
            int right = getMinCuts(s, k+1, j, dp);
            min = Math.min(min, left+right+1);
        }
        return dp[i][j] = min;
    }
    
    static boolean isPalindrome(String s, int i, int j) {
		while(i <= j) {
			if(i == j)
				return true;

			if(s.charAt(i) != s.charAt(j))
				return false;
			j--;
			i++;
		}
		return true;
	}


	public static void main(String[] args) {
		String s = "ababbbabbababa";
		int len = s.length()-1;
        int[][] dp = new int[len+1][len+1];
        for(int i[]: dp)
            Arrays.fill(i, -1);

		System.out.print("The minimum cuts required are "
				+ getMinCuts(s, 0, len, dp));
	}
}
