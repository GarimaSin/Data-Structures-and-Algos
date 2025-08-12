package Problem_Solving.DP.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

	public static void main(String[] args) {
		String s1 = "great", s2 = "rgeat";
		System.out.println(isScramble(s1, s2));
	}

	
	public static boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())
			return false;
		if(s1.equals(s2))
			return true;
		
        Map<String, Boolean> memo = new HashMap<>();
		return isScrambled(s1, s2, memo);
    }
	
    static boolean isScrambled(String s1, String s2, Map<String, Boolean> memo) {
		if (s1.equals(s2)) 
			return true;
		
	    if (s1.length() != s2.length()) 
	    	return false;
		
	    String key = s1 + "#" + s2;
        if (memo.containsKey(key)) 
            return memo.get(key);

		boolean swapped = false, notSwapped = false;
		for(int i=1; i<s1.length(); i++) {
			int len = s2.length();
			notSwapped = isScrambled(s1.substring(0, i), s2.substring(0, i), memo) && 
					isScrambled(s1.substring(i), s2.substring(i), memo);
			
			if(notSwapped)
				return true;
			
			swapped = isScrambled(s1.substring(0, i), s2.substring(len-i), memo) && 
					isScrambled(s1.substring(i), s2.substring(0, len-i), memo);
            
            if(swapped)
				return true;
		}
		boolean result = swapped || notSwapped;
		memo.put(key, result);
		return result;
	}
}
