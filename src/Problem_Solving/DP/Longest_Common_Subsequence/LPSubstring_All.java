package Problem_Solving.DP.Longest_Common_Subsequence;

import java.util.HashSet;
import java.util.Set;

public class LPSubstring_All {

	static int max = 0;
	static String answer = "";
	
	public static void main(String[] args) {
		LPSubstring_All lps = new LPSubstring_All();
//		Set<String> ans = lps.findLPSLength("forgeeksskeegfor");
		Set<String> ans = lps.findLPSLength("XYYZXZYZXXYZ");
		for(String s: ans) {
			System.out.println(s);
		}
		System.out.println("Biggest palindromic substring is: " + answer +", with length: "+max);
	}
	
	public Set<String> findLPSLength(String s) {
		return lps_Aux(s, 0, s.length() - 1);
	}
	
	//wkg
	private Set<String> lps_Aux(String string, int st, int end) {
		Set<String> ans = new HashSet<String>();
		if (st > end) { 		
			ans.add("");
			return ans;
		}
		if (st == end) { 
			return ans;
		}

		if (string.charAt(st) == string.charAt(end)) {
			if(isPalindrome(string, st, end)) {
				String tmp = string.substring(st, end+1);
				int len = end - st + 1;
				if(max < len) {
					max = len;
					answer = tmp;
				}
				ans.add(tmp);
			}
		}
		ans.addAll(lps_Aux(string, st + 1, end));			
		ans.addAll(lps_Aux(string, st, end - 1));			
		
		return ans;
	}

	public boolean isPalindrome(String s, int begin, int end){
		if(begin<0) return false;
		while(begin<end){
			if(s.charAt(begin++)!=s.charAt(end--)) return false;
		}
		return true;
	}
}