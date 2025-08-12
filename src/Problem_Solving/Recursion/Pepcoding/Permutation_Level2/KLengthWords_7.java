package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.HashMap;

public class KLengthWords_7 {

	static void printSelections1(String inp, boolean[] vis, int count, int tot, String ans) {
		if(count == tot) {
			System.out.println(ans);
			return;
		}
		for(int i = 0; i<inp.length(); i++) {
			char ch = inp.charAt(i);
			if(!vis[i]) {
				vis[i] = true;
				printSelections1(inp, vis, count+1, tot, ans+ch);
				vis[i] = false;
			}
		}
	}
	//Permutation solved like comb prob - coz at level we have placed chars > spots
	static void printSelections2(String inp, Character[] spots, int count, int tot, String ans, int ssf) {
		if(count == inp.length()) {										//both lines are imp
			if(ssf == tot) {														//both lines are imp
				for(int i = 0; i<spots.length; i++) {
					System.out.print(spots[i]);
				}
				System.out.println();
			}
			return;
		}

		char ch = inp.charAt(count);
		for(int i = 0; i<spots.length; i++) {				// loop from 0 not idx/start
			if(spots[i] == null) {
				spots[i] = ch;
				printSelections2(inp, spots, count+1, tot, ans, ssf+1);
				spots[i] = null;
			}
		}
		printSelections2(inp, spots, count+1, tot, ans, ssf+0);
	}

	public static void main(String[] args) {
		String str = "abcabc";
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
		boolean vis[] = new boolean[inp.length()];
		Character spots[] = new Character[outputLen];
		printSelections1(inp,  vis, 0, outputLen, "");
		System.out.println("_________________________");
		printSelections2(inp,  spots, 0, outputLen, "", 0);
	}
}