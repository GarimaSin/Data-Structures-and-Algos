package Problem_Solving.Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Working fine, leetcode answer is wrong
public class LetterTilePossiblities {

	public static void main(String[] args) {
		String inp = "aaabbc";
		numTilePossibilities(inp);
	}

	public static void numTilePossibilities(String tiles) {
		String inp = "";
		HashMap<Character, Integer> unique = new HashMap<Character, Integer>();
		for(char ch: tiles.toCharArray()) {
			if(unique.containsKey(ch))
				unique.put(ch, unique.get(ch)+1);
			else {
				unique.put(ch, 1);
				inp = inp+ch;
			}
		}
		List<List<String>> ans = new ArrayList<List<String>> ();
		ArrayList<String> list = new ArrayList<String>();
		subsetsHelper(ans, list, inp, unique, "");
		System.out.println(count);
	}
	
	static int count = 0;
	private static void subsetsHelper(List<List<String>> ans, ArrayList<String> list, String inp, 
			HashMap<Character, Integer> unique, String res) {
		if(!res.equals("")) {
			System.out.println(res);
			count++;
		}

		for (int i = 0; i < inp.length(); i++) {
			char ch = inp.charAt(i);
			if(unique.get(ch) > 0) {
				unique.put(ch, unique.get(ch) -1);
				subsetsHelper(ans, list, inp, unique, res+ch);
				unique.put(ch, unique.get(ch) +1);
			}
		}
	}
}