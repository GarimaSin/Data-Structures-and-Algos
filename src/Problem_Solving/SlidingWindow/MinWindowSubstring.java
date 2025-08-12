package Problem_Solving.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

	//Working
	public static String minWindowSub(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
			return "";
		}

		Map<Character, Integer> dictT = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			int count = dictT.getOrDefault(t.charAt(i), 0);
			dictT.put(t.charAt(i), count + 1);
		}

		int uniqueChars = dictT.size();
		int l = 0, r = 0;
		int match = 0;
		int  min = Integer.MAX_VALUE;
		Map<Character, Integer> window = new HashMap<Character, Integer>();
		int[] ans = {-1, 0, 0};
		
		while(r < s.length()) {
			Character c = s.charAt(r);
			if(dictT.containsKey(c)) {
				int tmp = window.getOrDefault(c, 0);
				window.put(c, tmp+1);
				
				if(tmp+1 == dictT.get(c))
					match++;
				
				if(match == uniqueChars) {
					if(min > r-l+1) {
						ans[0] = 0;
						ans[1] = l;
						ans[2] = r;
					}
				}
			}
			
			while(l <= r && match == uniqueChars) {
				Character c1 = s.charAt(l);
				if(window.containsKey(c1) && window.get(c1) > 0) {
					window.put(c1, window.get(c1)-1);
					if (dictT.containsKey(c1) && window.get(c1).intValue() < dictT.get(c1).intValue()) {
						if(min > r-l+1) {
							ans[0] = 0;
							ans[1] = l;
							ans[2] = r;
							min = Math.min(min, r-l+1);
						}
						match--;
					}
				}
				l++;
			}
			r++;
		}
		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
	}
	
	public static void main(String[] args) {
		String s = "cabwefgewcwaefgcf";
		String t = "cae";
		String ans = minWindowSub(s, t);
		System.out.println(ans);
	}
}