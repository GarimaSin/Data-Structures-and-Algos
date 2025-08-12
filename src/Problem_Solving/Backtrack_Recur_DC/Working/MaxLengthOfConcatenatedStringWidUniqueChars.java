package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Power set comb code
 *
 */
public class MaxLengthOfConcatenatedStringWidUniqueChars {

	int max = 0;
	public static void main(String[] args) {
		MaxLengthOfConcatenatedStringWidUniqueChars ml = new MaxLengthOfConcatenatedStringWidUniqueChars();
		List<String> inp = new ArrayList<String>();
		inp.add("un");
		inp.add("iq");
		inp.add("ue");
		ml.maxLength(inp);
	}

	public int maxLength(List<String> inp) {
		int max = subsetsHelper(inp, 0, "", 0);
		return max;
	}


	private int subsetsHelper(List<String> inp, int start, String ans, int sum){
		System.out.println(ans+"  , len:"+sum);
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
