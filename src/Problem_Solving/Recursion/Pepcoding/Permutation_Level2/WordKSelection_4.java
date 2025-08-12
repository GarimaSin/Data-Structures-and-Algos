package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.HashSet;


public class WordKSelection_4 {

	static void generateSelection(int outputLen,String inp, String ans, int lastOccurence) {
		if(ans.length() == outputLen) {
			System.out.println(ans);
			return;
		}
		for(int i=lastOccurence+1; i< inp.length(); i++) {
			char ch = inp.charAt(i);
			generateSelection(outputLen, inp, ans+ch, i);
		}
	}

	public static void main(String[] args) {
		String str = "abcbcabaccc";
		HashSet<Character> unique = new HashSet<Character>();
		String uniqueString = "";
		for(char ch: str.toCharArray()) {
			if(unique.contains(ch) == false) {
				unique.add(ch);
				uniqueString = uniqueString + ch;
			}
		}
		int outputLen = 2;
		generateSelection(outputLen, uniqueString, "", -1);
	}
}
