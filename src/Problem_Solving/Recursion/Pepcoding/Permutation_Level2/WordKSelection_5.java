package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.ArrayList;
import java.util.HashMap;


public class WordKSelection_5 {

	//Mine - working (storing the sol)
	static ArrayList<String> generateSelection(int outputLen, String ans, int i, HashMap<Character, Integer> unique, String inp) {
		if(i == inp.length()-1) {
			ArrayList<String> asf = new ArrayList<String>();
			char ch = inp.charAt(i);
			String tmp = "";
			for(int j = 1; j <= unique.get(ch); j++) {
				tmp = tmp + ch;
				if(tmp.length() <= outputLen)
					asf.add(tmp);
			}
			return asf;
		}

		char ch = inp.charAt(i);
		ArrayList<String> asf = generateSelection(outputLen, ans+ch, i+1, unique, inp);
		ArrayList<String> list = new ArrayList<String>();
		String tmp = "";
		for(String s: asf) {
				list.add(s);
		}
		for(int j = 1; j <= unique.get(ch); j++) {
			tmp = tmp + ch;
			list.add(tmp);
			for(String s: asf) {
				if((tmp+s).length() <= outputLen)
					list.add(tmp+s);
			}
		}
		return list;
	}

	//Working - print the sol
	static void printSelections(String inp, HashMap<Character, Integer> unique, int idx, String ans, int k) {
		if(k<0)
			return;
		
		if(idx == inp.length()) {
			if(k == 0)
				System.out.println(ans);
			return;
		}
		
		char ch = inp.charAt(idx);					//comb step
		for(int i=unique.get(ch); i >= 0; i--) {
			String s = "";
			for(int j=0; j<i; j++) {
				s=s+ch;
			}
			printSelections(inp, unique, idx+1, ans+s, k-i);
		}
	}
	
	
	//Working - removed for loop in printSelections
	static void printSelections1(String inp, HashMap<Character, Integer> unique, int idx, String ans, int outputLen) {
		if(outputLen<0)
			return;
		
		if(idx == inp.length()) {
			if(outputLen == 0)
				System.out.println(ans);
			return;
		}
		
		char ch = inp.charAt(idx);						//iterating over unique chars only
		if(unique.get(ch) > 0) {
			unique.put(ch, unique.get(ch)-1);
			printSelections1(inp, unique, idx, ans+ch, outputLen-1);			//not idx+1 since same char can be selected till when its frq != 0
			unique.put(ch, unique.get(ch)+1);
		}
		printSelections1(inp, unique, idx+1, ans, outputLen);
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
		ArrayList<String> ans = generateSelection(outputLen, "", 0, unique, inp);
		for(String s: ans) {
			if(s.length() == outputLen)
				System.out.println(s);
		}
		System.out.println("_________________________");
		printSelections(inp, unique, 0, "", outputLen);
		
		System.out.println("_________________________");
		printSelections1(inp, unique, 0, "", outputLen);
	}
}