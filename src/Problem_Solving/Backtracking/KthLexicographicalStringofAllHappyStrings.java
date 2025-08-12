package Problem_Solving.Leetcode.Backtracking;

import java.util.LinkedList;

public class KthLexicographicalStringofAllHappyStrings {

	static public void getHappyString(int n, int k) {
		String[] inp = {"a", "b", "c"};
		LinkedList<String> ans = new LinkedList<String>();
		helper(n, k, inp, 0, "", null, ans);
		if(ans.size() >= k)
			System.out.println(ans.get(k-1));
        else
        	System.out.println("");
	}
	
	static void helper(int n, int k, String[] inp, int ansLen, String res, String prev, LinkedList<String> ans) {
		if(ansLen == n) {
			ans.add(res);
//			System.out.println(res);
			return;
		}
		
		for (int i = 0; i < inp.length; i++) {
			if(prev != null && prev.equals(inp[i]))
				continue;
			helper(n, k, inp, ansLen+1, res+inp[i], inp[i], ans);
		}
	}

	public static void main(String[] args) {
		getHappyString(1, 3);
	}
}
