package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
//		dict.add("hiring");
		String sentence = "catsanddog";
		List<String> ans = new LinkedList<String>();
		wordBreak(sentence, "", dict, ans);
		for(String l: ans)
			System.out.println(l);
	}
	
	public static void wordBreak(String inp, String str, HashSet<String>	dict, List<String> ans) {
		if (inp.length() == 0) {
//			System.out.println(str);
			ans.add(str);
			return;
		}
		
		for (int i = 0; i < inp.length(); i++) {
			String left = inp.substring(0, i + 1);
			if (dict.contains(left)) {
				String right = inp.substring(i + 1);
				wordBreak(right, str + left + " ", dict, ans);
			}
		}
	}
	
	public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length() + 1];
		Arrays.fill(memo, -1);
		return wordBreak(wordDict, s, memo);
    }
    
    public boolean wordBreak(List<String> dict, String str, int[] memo) {
		int n = str.length();

		if (n == 0)
			return true;

		if (memo[n] == -1) {
			memo[n] = 0;

			for (int i = 1; i <= n; i++) {
				String prefix = str.substring(0, i);

				if (dict.contains(prefix) && wordBreak(dict, str.substring(i), memo))	{
					memo[n] = 1;
					return true;
				}
			}
		}
		return memo[n] == 1;
	}
}
