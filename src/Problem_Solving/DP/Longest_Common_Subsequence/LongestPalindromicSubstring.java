package Problem_Solving.DP.Longest_Common_Subsequence;

import java.util.HashMap;

public class LongestPalindromicSubstring {

	
	// Working but does not returns the palindromic string
	public static int longestPalindrome1(String s) {
		Integer[][] dp = new Integer[s.length()][s.length()];
		return lps_Aux(dp, s, 0, s.length() - 1);
	}

	private static int lps_Aux(Integer[][] dp, String string, int st, int end) {
		if (st > end)  		
			return 0;
		
		if (st == end)  
			return 1;					/** Mind it - valid only for palindromic cases**/
		
		int c3 = 0;
		if (dp[st][end] == null) { 							
			if (string.charAt(st) == string.charAt(end)) {
				int remainingLength = end - st - 1;
				if(remainingLength == lps_Aux(dp, string, st + 1, end - 1))
					c3 = remainingLength + 2;
			} 
			int c1 = lps_Aux(dp, string, st + 1, end);			
			int c2 = lps_Aux(dp, string, st, end - 1);			
			dp[st][end] = Math.max(c3,Math.max(c1, c2));		
		}
		return dp[st][end];
	}
	
	
	// Working beats 86%
	public static String longestPalindrome2(String s) {
		if (s == null || s.length() < 1) 
			return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			// for cases like odd numbered palindrome eg. madam
			int len1 = expandAroundCenter(s, i, i);			
			
			// for even numbered palindrome eg. geeg coz here, say i = 1 => i+1 = 2 which means i and i+1 are equal.
			int len2 = expandAroundCenter(s, i, i + 1);	
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}
	
	
	// Working but TLE
	public static String longestPalindrome3(String s) {
		HashMap<String, String> dp = new HashMap<>();
		return lps_Aux(dp, s, 0, s.length() - 1, "");
    }

	static String s = "";
	static String lps_Aux(HashMap<String, String> dp, String string, int st, int end, String ans) {
		if (st > end)  {									// base case - even len palindrome
			if(ans.length() > 0) {
				String tmp = "";
				for(int i=ans.length()-1; i>=0; i--) {
					tmp = tmp + ans.charAt(i);				
				}
				ans = ans + tmp;
	            return ans;
			}
			return "";
		}		
		
		if (st == end) {									// base case - odd len palindrome
			String tmp = string.charAt(end)+"";
			for(int i=ans.length()-1; i>=0; i--) {
				tmp = tmp + ans.charAt(i);
			}
			ans = ans + tmp;
            return ans;
        } 
		
		String c3 = "";
        String key = st+","+end+","+ans;
		if (dp.get(key) == null) { 	
            char c = string.charAt(st);						
			if (string.charAt(st) == string.charAt(end)) {
				c3 = lps_Aux(dp, string, st + 1, end - 1, ans+c+""); //only appending single char and adding the 2nd 1/2 in base case
			} 
			String c1 = lps_Aux(dp, string, st + 1, end, "");			
			String c2 = lps_Aux(dp, string, st, end - 1, "");	
			if(c2.length() > c3.length()) {
				if(c2.length() > c1.length())
					dp.put(key, c2);
				else 
					dp.put(key, c1);
			} else {
				if(c3.length() > c1.length())
					dp.put(key, c3);
				else
					dp.put(key, c1);
			}
		}
		return dp.get(key);
	}


	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println("Longest Palindromic Sequence: " + lps.longestPalindrome3("forgeeksskeegfor"));
		
		longestPalindrome1("jimadamk");
		longestPalindrome2("geeksforgeek");
	}
}