package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.HashSet;


public class WordKSelection_3 {


	static void generateSelection(int i, String inp, int count, int finalLen, String ans) {
		if(i == inp.length()) {
			if(count == finalLen)
				System.out.println(ans);
			return;
		}
		char ch = inp.charAt(i);
		generateSelection(i+1, inp, count+0, finalLen, ans+"");
		generateSelection(i+1, inp, count+1, finalLen, ans+ch);
	}

//	static void generateSelection1(int start, String inp, int count, int finalLen, String ans) {
//		if(count == finalLen)	{
//			System.out.println(ans);
//			return;
//		}
//
//		for (int j = start; j < inp.length(); j++) {
//			generateSelection1(j+1, inp, count+1, finalLen, ans+inp.charAt(j));
//		}
//	}

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
		generateSelection(0, uniqueString, 0, outputLen, "");
		System.out.println("_______________________________");
//		generateSelection1(0, uniqueString, 0, outputLen, "");
	}
}