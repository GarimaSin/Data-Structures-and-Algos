package Problem_Solving.Leetcode.Backtracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLenOfConcatenatedStringWithUniqueChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int max = 0;
    public int maxLength(List<String> inp) {
		int max = subsetsHelper(inp, 0, "", 0);
		return max;
	}


	private int subsetsHelper(List<String> inp, int start, String ans, int sum){
		if(sum > max) {
			if(isUniqueChars(ans)) {
				if(sum > max)
					max =sum;
			}
		}
		for(int i = start; i < inp.size(); i++){
			String old = ans;
			ans = ans + inp.get(i);
			subsetsHelper(inp, i + 1, ans, ans.length());
			ans = old;
		}
		return max;
	}

	private boolean isUniqueChars(String s) {
		Set<Character> set = new HashSet<>();

		for (char c : s.toCharArray()) {
			if (set.contains(c)) {
				return false;
			}
			set.add(c);
		}
		return true;
	}
}
