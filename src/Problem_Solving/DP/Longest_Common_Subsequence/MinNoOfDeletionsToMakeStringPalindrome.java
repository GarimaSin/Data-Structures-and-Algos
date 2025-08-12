package Problem_Solving.DP.Longest_Common_Subsequence;

public class MinNoOfDeletionsToMakeStringPalindrome {


	//Sol 1: Working
	public static int getMinDel(String str, int i, int j, Integer[][] dp) {
		if (i >= j)
			return 0;
            
        if(dp[i][j] != null)
            return dp[i][j];

		if (str.charAt(i) == str.charAt(j)) {
			return getMinDel(str, i + 1, j - 1, dp);
		}

        int ans = 1 + Math.min(getMinDel(str, i + 1, j, dp),
        		getMinDel(str, i, j - 1, dp));
        
		dp[i][j] = ans;
        return ans; 
	}
	
	// Not working - 
	// Diff from sol 1 = return when charAt(i) == charAt(j)
	// TC - 40/58. Failing for s = zjveiiwvc, Ans = 5, giving 6.
	// Analysing the above sol and cu. failed i/p, V shud always take the matching chars in palindrome and not ignore 
	// if 2 chars r matching in 2 halves of the string and hence return directly if matching (Line# 15).
	
	static int findMinDel(String s, int i, int j, Integer[][] dp) {
        if(i > s.length() || j < 0 || i > j)
            return 999999;
        
        if(i >= j)
            return 0;

        if(dp[i][j] != null)
            return dp[i][j];

        int i1 = 999999, i2 = 999999, i3 = 999999;
        if(s.charAt(i) == s.charAt(j)) {
            i1 = findMinDel(s, i+1, j-1, dp);
        // }
        } else {
            i2 = 1 + findMinDel(s, i+1, j, dp);
            i3 = 1 + findMinDel(s, i, j-1, dp);
        }
        
        int ans = Math.min(Math.min(i1, i2), i3);
        dp[i][j] = ans;
        return ans;
    }


	public static void main(String[] args) {
		String s = "abefbac";
		Integer[][] dp = new Integer[s.length()+1][s.length()+1];
		System.out.println("Minimum element of deletions = " +
				getMinDel(s, 0, s.length() - 1, dp));
		
		dp = new Integer[s.length()+1][s.length()+1];
		System.out.println(findMinDel(s, 0, s.length()-1, dp));
		
		
		dp = new Integer[s.length()+1][s.length()+1];
		int ans = findLongestPalindrome(s, 0, s.length()-1, dp);
		System.out.println(s.length() - ans);
	
	
	}


	// Working - Sol = s.length() - LPS
    static int findLongestPalindrome(String s, int i, int j, Integer[][] dp) {
        if(i > s.length() || j < 0 || i > j)
            return 0;
        
        if(i == j)
            return 1;

        if(dp[i][j] != null)
            return dp[i][j];

        int i1 = 0;
        if(i<s.length() && j<s.length() && s.charAt(i) == s.charAt(j)) {
            i1 = 2 + findLongestPalindrome(s, i+1, j-1, dp);
        }
        int i2 = findLongestPalindrome(s, i+1, j, dp);
        int i3 = findLongestPalindrome(s, i, j-1, dp);
        int ans = Math.max(Math.max(i1, i2), i3);
        dp[i][j] = ans;
        return ans;
    }
}
