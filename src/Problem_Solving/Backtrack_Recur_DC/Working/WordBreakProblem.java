package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 
 * Check memo logic 
 *
 */
public class WordBreakProblem {
	
	//Memo - working
	public static boolean wordBreak(List<String> dict, String str, int[] memo) {
		
		int n = str.length();

		// return true if we have reached the end of the String
		if (n == 0)
			return true;

		// if sub-problem is seen for the first time
		if (memo[n] == -1) {
			// mark sub-problem as seen (0 initially assuming String can't be segmented)
			memo[n] = 0;

			for (int i = 1; i <= n; i++) {
				// consider all prefixes of current String
				String prefix = str.substring(0, i);

				// if prefix is found in dictionary, then recur for suffix
				if (dict.contains(prefix) && 
						wordBreak(dict, str.substring(i), memo))	{
					// return true if the String can be segmented
					memo[n] = 1;
					return true;
				}
			}
		}
		return memo[n] == 1;
	}
	
	
	//Recursion - Working = CombWORep
	public boolean word_Break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {		// mind the indexes for substring and recursive call
                return true;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		// we can also use trie or Set to store dictionary
		List<String> dict = Arrays.asList("this", "th", "is", "famous",
				"Word", "break", "b", "r", "e", "a", "k",
				"br", "bre", "brea", "ak", "problem");

		String str = "Wordbreakproblem";

		int[] memo = new int[str.length() + 1];
		Arrays.fill(memo, -1);

		if (wordBreak(dict, str, memo))
			System.out.print("String can be segmented");
		else
			System.out.print("String can't be segmented");
	}
}
