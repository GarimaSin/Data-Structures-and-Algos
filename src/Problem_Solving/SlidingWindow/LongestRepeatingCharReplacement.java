package Problem_Solving.SlidingWindow;

public class LongestRepeatingCharReplacement {

	public static int characterReplacement(String s, int k){
        int left = 0;
        int freq[] = new int[26];
        int res = 0;
        int right = 0;
        int maxf = 0;
        
        while(right<s.length()) {
            char c = s.charAt(right);
            freq[c-'A']++;
        	int currCharCount = freq[c-'A'];
        	maxf = Math.max(maxf, currCharCount);
            
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
