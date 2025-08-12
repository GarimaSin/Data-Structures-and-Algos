package Problem_Solving.DP.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordBreak2 {

	public static void main(String[] args) {
		String s = "pineapplepenapple";
		List<String> wordDict = new ArrayList<String>();
		// "apple","pen","applepen","pine","pineapple"
		wordDict.add("apple");
		wordDict.add("pen");
		wordDict.add("applepen");
		wordDict.add("pine");
		wordDict.add("pineapple");
		wordBreak(s, wordDict);
	}

	// Working
	public static List<String> wordBreak(String s, List<String> wordDict) {
		List<List<String>> ans = new ArrayList<>();
		List<String> result = new ArrayList<>();
		solve(s, wordDict, new ArrayList<String>(), ans, 0);
		String tmp = "";
		for(List<String> l: ans) {
			tmp = "";
			for(int i=0; i<l.size()-1; i++)
				tmp = tmp + l.get(i)+" ";
			tmp = tmp + l.get(l.size()-1);
			result.add(tmp);
		}
//		System.out.println(result.toString());
		return result;
	}

	static void solve(String inp, List<String> dict, ArrayList<String> list, List<List<String>> ans, int st) {
		if(inp.length() == 0) {
			ans.add(new ArrayList<>(list));
			return;
		}

		for (int i=st; i<inp.length(); i++) {
			String left = inp.substring(st, i+1);	
			if(!dict.contains(left))
				continue;
			String right = inp.substring(i+1);				// same as above just replaced 0 with st
			
			list.add(left);
			solve(right, dict, list, ans, st);
			list.remove(list.size()-1);
		}
	}
}
