package Problem_Solving.SlidingWindow;

import java.util.HashMap;

public class LongestRepeatingCharReplacement {

	
	// Working
	public static int characterReplacement1(String s, int k) {
		HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, maxWindow = 0, maxCount = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxCount = Math.max(maxCount, map.get(ch));		// max frq element in array

            // shrink window if more than k replacements are needed
            while ((right-left+1) - maxCount > k) {	// len of window - maxCount = frq of chars other than max frq char
            	char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;

                // recompute maxCount in current window
                maxCount = 0;
                for (int val : map.values()) {
                    maxCount = Math.max(maxCount, val);
                }
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        return maxWindow;
	}
	
	
	// =============================================================================================================
	
	
	// Working
	public static int characterReplacement(String s, int k){
        int left = 0;
        int freq[] = new int[26];
        int res = 0;
        int right = 0;
        int maxf = 0;
        
        // ababcb, k = 2
        // r <= k
        while(right<s.length()) {
            char c = s.charAt(right);
            freq[c-'A']++;
        	maxf = Math.max(maxf, freq[c-'A']);
            
            if((right-left+1) - maxf > k){
                char starting = s.charAt(left);
                freq[starting-'A']--;
                left++;
            }
            res = Math.max(res, right-left+1);
            right++;
        }
        return res;
    }
	
	public static void main(String[] args) {
		String s = "BAAAB";
		int k = 2;
		characterReplacement(s, k);
	}
}
