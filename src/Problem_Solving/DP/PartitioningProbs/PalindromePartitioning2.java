package Problem_Solving.DP.PartitioningProbs;

import java.util.Arrays;

/**
 * Can use Longest Palindromic Substring 
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s
 * LC - 132
 * 
 */

public class PalindromePartitioning2 {

	public static void main(String[] args) {
		String s = "abcb";
		System.out.println(minCut(s));
	}

	public static int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        boolean[][] isPal = new boolean[n][n];

        // Precompute all palindromic substrings
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && 
                		(end - start <= 2 || isPal[start + 1][end - 1])) {
                    isPal[start][end] = true;
                }
            }
        }
		return countPalindromePartitions(0, s, dp, isPal)-1;
    }

	
	// Working
    static int countPalindromePartitions(int start, String inp, int[] dp, boolean[][] isPal) {
    	if(inp.length() == 0 ||start == inp.length()) 
			return 0;

		if (dp[start] != -1) 
			return dp[start];


		int min = 999999, r = 0;
		for (int i=start; i<inp.length(); i++) {
//			String left = inp.substring(0, i+1);	// USing same logicin cu. code
//			String right = inp.substring(i+1);

			if(isPal[start][i]) {	
				r = countPalindromePartitions(i+1, inp, dp, isPal);
                min = Math.min(min, r+1);
			}
		}
        dp[start] = min;
		return min;
	}
    
    
    // Working - Bottom up
    public int minCut1(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        int[] dp = new int[n];

        // Precompute palindromic substrings
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) &&
                    (end - start <= 2 || isPal[start + 1][end - 1])) {
                    isPal[start][end] = true;
                }
            }
        }

        // DP to find minimum cuts
        for (int i = 0; i < n; i++) {
            if (isPal[0][i]) {
                dp[i] = 0; // No cut needed if s[0..i] is a palindrome
            } else {
                dp[i] = i; // Max cuts (cut between every character)
                for (int j = 1; j <= i; j++) {
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
