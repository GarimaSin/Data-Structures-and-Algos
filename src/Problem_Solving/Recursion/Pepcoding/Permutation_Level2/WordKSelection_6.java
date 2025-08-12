package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.HashMap;

//Same ques as WordKSelection_5
public class WordKSelection_6 {

	static void printSelections(String inp, HashMap<Character, Integer> unique, int count, int tot, String ans, int lastIdx) {
		if(count == tot) {
			System.out.println(ans);
			return;
		}
		
		for(int i = lastIdx; i<inp.length(); i++) {
			char ch = inp.charAt(i);
			if(unique.get(ch) > 0) {
				unique.put(ch, unique.get(ch) -1);
				printSelections(inp, unique, count+1, tot, ans+ch, i);
				unique.put(ch, unique.get(ch) +1);
			}
		}
	}

	
	public static void main(String[] args) {
		String str = "baabb";
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
		printSelections(inp, unique, 0, outputLen, "", 0);
	}
}