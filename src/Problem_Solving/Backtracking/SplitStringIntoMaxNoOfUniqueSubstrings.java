package Problem_Solving.Leetcode.Backtracking;

import java.util.HashSet;

public class SplitStringIntoMaxNoOfUniqueSubstrings {

	public static void main(String[] args) {
		String s = "ababccc";
		solution(s, new HashSet<String>());
		System.out.println(max);
	}


	static int max = 0;
	static void solution(String inp, HashSet<String> ans) {
		if(inp.length() == 0) {
			if(max < ans.size())
				max = ans.size();
			return;
		}

		for(int i=1; i<inp.length()+1; i++) {
			String left = inp.substring(0, i);
			String right = inp.substring(i);
			if(ans.contains(left))
				continue;
			else {
				ans.add(left);
				solution(right, ans);
				ans.remove(left);
			}
		}
	}
}
