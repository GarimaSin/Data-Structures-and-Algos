package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

/**
 * Ques:
 * A string S represents a list of words. Each letter in the word has 1 or more options.  
 * If there is one option, the letter is represented as it is. If there is more than one option, 
 * then curly braces delimit the options.  For example, "{a,b,c}" represents options ["a", "b", "c"].
	For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].
	Return all words that can be formed in this manner, in lexicographical order.

	Example 1:
	Input: "{a,b}c{d,e}f"
	Output: ["acdf","acef","bcdf","bcef"]
	
	Example 2:
	Input: "abcd"
	Output: ["abcd"]

	Note:
	1 <= S.length <= 50
	There are no nested curly brackets.
	All characters inside a pair of consecutive opening and ending curly brackets are different.
 */

import java.util.ArrayList;
import java.util.List;

public class BraceExpansion_Mine {

	public static void main(String[] args) {
//		String s = "abc{d,e}f{gh,ij}";
		String s = "{a,b}c{d,e}f";
//		String s = "{a,b,c}d{e,f}";
		BraceExpansion_Mine bex = new BraceExpansion_Mine();
		bex.helper(s);
	}

	//divide the input string on , and {} and use a list<list<String>> to store it.
	List<String> helper(String s) {
		List<List<String>> decomp = new ArrayList<List<String>>();
		String temp = "";
		List<String> list = new ArrayList<>();;
		for(Character ch: s.toCharArray()) {
			if(ch==',') {
				list.add(temp);
				temp = "";
				continue;
			}
			if(ch=='{' || ch=='}') {
				list.add(temp);
				decomp.add(list);
				temp = "";
				list = new ArrayList<>();
				continue;
			}
			temp = temp + ch;
		}
		if(temp != "") {
			list = new ArrayList<>();
			list.add(temp);
			decomp.add(list);
		}

		//Uncomment below 2 for loops to understand how input string is distributed
//		for(int i=0; i<decomp.size(); i++) {
//			for(int j=0; j<decomp.get(i).size(); j++) {
//				System.out.print(decomp.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}

		List<String> ans = combineDiffArrays(decomp, "", decomp.size(), 0, new ArrayList<String>());

		for(int j=0; j<ans.size(); j++) 
			System.out.print(ans.get(j) + " ");
		return ans;
	}

	private List<String> combineDiffArrays(List<List<String>> decomp, String output, int length, 
			int curIndex, List<String> ans) {

		if(curIndex >= length) {
//			System.out.println(output);
			ans.add(output);
			return ans;
		}

		for(int j=0; j<decomp.get(curIndex).size(); j++) 	//curIndex = index of outer list/loop, 
															//j = index of inner list/loop
			
			combineDiffArrays(decomp, output+decomp.get(curIndex).get(j), 
					length, curIndex+1, ans); 		/** VERY IMP curIndex+1 **/

		return ans;
	}

}
