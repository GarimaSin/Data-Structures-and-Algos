package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.HashMap;

public class KLengthWords_8 {

	static void printSelections(String inp, HashMap<Character, Integer> unique, int count, int tot, String ans) {
		if(count == tot) {
			System.out.println(ans);
			return;
		}
		
		for(int i = 0; i<inp.length(); i++) {
			char ch = inp.charAt(i);
			if(unique.get(ch) > 0) {
				unique.put(ch, unique.get(ch) -1);
				printSelections(inp, unique, count+1, tot, ans+ch);
				unique.put(ch, unique.get(ch) +1);
			}
		}
	}

	public static void main(String[] args) {
		String str = "aabb";
		String inp = "";
		HashMap<Character, Integer> unique = new HashMap<Character, Integer>();
		for(char ch: str.toCharArray()) {
			if(unique.containsKey(ch))
				unique.put(ch, unique.get(ch)+1);
			else {
				unique.put(ch, 1);
				inp = inp+ch;
			}
		}
		int outputLen = 3;
		printSelections(inp,  unique, 0, outputLen, "");
	}
}