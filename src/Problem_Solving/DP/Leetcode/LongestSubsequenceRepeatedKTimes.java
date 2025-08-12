package Problem_Solving.DP.Leetcode;

public class LongestSubsequenceRepeatedKTimes {

	public static void main(String[] args) {
		String s = "letsleetcode";
		int k = 2;
		longestSubsequenceRepeatedK(s, k);
	}
	
	static String result = "";
	public static String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        boolean[] canUse = new boolean[26];
        int[] requiredFreq = new int[26];

        for (int i=0; i<26; i++) {
            if (freq[i] >= k) {
                canUse[i] = true;
                requiredFreq[i] = freq[i] / k;
            }
        }
        
        int maxLen = n / k;
        StringBuilder curr = new StringBuilder();
        backtracking(s, curr, canUse, requiredFreq, k, maxLen);

        return result;
    }
	
	
    // Check if seq * k is a subsequence of s
    private static boolean isSubsequence(String s, String sub, int k) {
        int i=0, j=0, len=sub.length(), n=s.length();

        while (i<n && j< k*len) {
            if (s.charAt(i) == sub.charAt(j%len)) {
                j++;
            }
            i++;
        }
        return j == k*len;
    }

    
    // Permutation code coz canUse = Vis
    private static void backtracking(String s, StringBuilder curr, boolean[] canUse, int[] requiredFreq, int k, int maxLen) {
        if (curr.length() > maxLen) 
        	return;

        String currStr = curr.toString();
        System.out.println(currStr);
        if ((curr.length() > result.length() || 
             (curr.length() == result.length() && currStr.compareTo(result) > 0)) &&
            isSubsequence(s, currStr, k)) {
            result = currStr;
        }

        for (int i=25; i>=0; i--) { // from 'z' to 'a' for lexicographically larger result
            if (!canUse[i] || requiredFreq[i] == 0) 
            	continue;

            curr.append((char) (i + 'a'));
            requiredFreq[i]--;

            backtracking(s, curr, canUse, requiredFreq, k, maxLen);

            curr.deleteCharAt(curr.length() - 1);
            requiredFreq[i]++;
        }
    }
}
