package Problem_Solving.DP.Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LargestStringChain {

	public static void main(String[] args) {
		String words[] = {"a","b","ba","bca","bda","bdca"};
		System.out.print(longestStrChain1(words));
	}
	
	// Working
	public static int longestStrChain1(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> dp = new HashMap<>();
        int maxLen = 1;
        for (String word : words) {
            int best = 1;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            maxLen = Math.max(maxLen, best);
        }
        return maxLen;
    }
	
	// Working
	public static int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[][] dp = new int[1001][1001];
        for(int[] i: dp)
            Arrays.fill(i, -1);
		return longestStrChain(words, 0, -1, dp);
    }

    public static int longestStrChain(String[] words, int i, int prevIdx, int[][] dp) {
        if(i == words.length)
            return 0;

        if(dp[i][prevIdx+1] != -1)
            return dp[i][prevIdx+1];
    
        int take = 0;
        String word = words[i];
        String prev = "";

        if(prevIdx != -1)
            prev = words[prevIdx];

        if(prevIdx == -1) {
        	take = 1 + longestStrChain(words, i+1, i, dp);
        } else if(word.length() == prev.length()+1) {			// Check if word is predecessor
            int count=0, a=0, b=0;
            while(a<word.length() && b<prev.length()) {
                if(word.charAt(a) != prev.charAt(b)) {
                    count++; a++;
                    if(count > 1)
                        break;
                } else {
                    a++; b++;
                }
            }
            if(count <= 1)
            	take = 1 + longestStrChain(words, i+1, i, dp);
        }
        int notTake = longestStrChain(words, i+1, prevIdx, dp);
        int max = Math.max(take, notTake);
        dp[i][prevIdx+1] = max;
        return max;
    }

}
