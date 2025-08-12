package Problem_Solving.SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {

	public static int lengthOfLongestSubstring(String s) {
		if(s.length() <= 1)
			return s.length();

		int start = 0, end = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		
		while(end < s.length()) {
			char c = s.charAt(end);
			if(map.containsKey(c))
				map.put(c, map.get(c)+1);
			else
				map.put(c, 1);
			
			while(map.size() != end-start+1) {	//Shrink criteria: while map.size != window size (which means all chars in map are unique now).
				 char tmp = s.charAt(start);
				if(map.get(tmp) > 1)
					map.put(tmp, map.get(tmp)-1);
				else 
					map.remove(tmp);
				start++;
			}
			max = Math.max(max, map.size());
			end++;
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
}
