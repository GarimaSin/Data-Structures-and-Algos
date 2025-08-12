package Problem_Solving.DP.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings {

	public static void main(String[] args) {
		countSubstrings("aaaaa");
	}

	public static int countSubstrings(String s) {
        if (s == null || s.length() < 1) 
			return 0;
		int count = 0;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			// for cases like odd numbered palindrome eg. madam
			count += expandAroundCenter(s, i, i, set);			
			// for even numbered palindrome eg. geeg coz here, say i = 1 => i+1 = 2 which means i and i+1 are equal.
			count += expandAroundCenter(s, i, i + 1, set);	
		}
		return count;
    }
    
	private static int expandAroundCenter(String s, int left, int right, Set<String> set) {
		int L = left, R = right;
        int res = 0;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            res++;						//answer is added here
            set.add(s.substring(L, R + 1));
			L--;
			R++;
		}
		return res;
	}
}
