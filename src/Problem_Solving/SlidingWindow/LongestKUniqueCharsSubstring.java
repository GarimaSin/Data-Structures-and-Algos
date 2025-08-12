package Problem_Solving.SlidingWindow;

public class LongestKUniqueCharsSubstring {

	public static int longestkSubstr(String s, int k) {
		int start = 0;
        int end = 0;
        int count = 0;
        int max = -1;
        int[] chars = new int[26];
        
        while(end < s.length()) {
            char c = s.charAt(end);
            if(chars[c-'a'] == 0)
                count++;
            chars[c-'a'] = chars[c-'a'] + 1;
            
            if(count == k) {
                max = Math.max(max, end-start+1);
            }
            
            if(count > k) {
                while(count > k) {
                    char tmp = s.charAt(start);
                    chars[tmp -'a'] = chars[tmp-'a'] - 1;
                    if(chars[tmp -'a'] == 0)
                        count--;
                    start++;
                }
            }
            end++;
        }
        return max;
	}
	
	public static void main(String[] args) {
		String s = "aabacbebebe";
		int k = 3;
		System.out.println(longestkSubstr(s, k));
	}
}
