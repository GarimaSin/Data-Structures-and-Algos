package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.HashMap;

public class PermutationString_1 {

	static void generateWords(int count, int totalBox, HashMap<Character, Integer> fmap, String ans) {
		if(count > totalBox) {
			System.out.println(ans);
			return;
		}
		for(char ch: fmap.keySet()) {				//keySet ==> unique chars only coz keys don't contain duplicate elements
			if(fmap.get(ch) > 0) {
				fmap.put(ch, fmap.get(ch) -1);
				generateWords(count+1, totalBox, fmap, ans+ch);
				fmap.put(ch, fmap.get(ch) +1);
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "aaabb";
//		int totalBox = str.length();
		HashMap<Character, Integer> fmap = new HashMap<Character, Integer>();
		for(char ch: str.toCharArray()) {
			if(fmap.containsKey(ch))
				fmap.put(ch, fmap.get(ch)+1);
			else
				fmap.put(ch, 1);
		}
		generateWords(1, 3, fmap, "");
	}
}