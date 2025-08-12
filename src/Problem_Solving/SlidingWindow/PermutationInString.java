package Problem_Solving.SlidingWindow;

public class PermutationInString {

	public static boolean checkInclusion(String s1, String s2) {
        int[] frq = new int[26];
        for(char c: s1.toCharArray()) {
            frq[c-'a']++;
        }
        
        int start = 0;
        int end = 0;

        while(end <s2.length()) {
            char c = s2.charAt(end);
            frq[c-'a']--;
            if(end >= s1.length()-1) {
                if(allZeroes(frq))
                    return true;
                char tmp = s2.charAt(start);
				frq[tmp-'a']++;
				start++;
            }
            end++;
        }
        return false;
	}

	static boolean allZeroes(int[] frq) {
		for(int i=0; i<26; i++) {
			if(frq[i] != 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "ab";
		String s2 = "eidbaooo";
		boolean ans = checkInclusion(s, s2);
		System.out.println(ans);
	}
}
