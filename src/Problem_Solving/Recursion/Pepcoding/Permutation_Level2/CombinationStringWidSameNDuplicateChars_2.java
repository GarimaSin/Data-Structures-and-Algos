package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.HashMap;

//Question is same as:  PermutationString1 but solved using combination
public class CombinationStringWidSameNDuplicateChars_2 {

	static void generateWords(int count,String inp, Character[] spots, HashMap<Character, Integer> lastOccurence) {
		if(count == inp.length()) {
			for(int i=0; i<spots.length; i++)
				System.out.print(spots[i]);
			System.out.println();
			return;
		}

		char ch = inp.charAt(count);
		int lastOcc = lastOccurence.get(ch);
		for(int i=lastOcc+1; i< spots.length; i++) {
			if(spots[i] == null) {
				spots[i] = ch;
				lastOccurence.put(ch, i);
				generateWords(count+1, inp, spots, lastOccurence);
				lastOccurence.put(ch, lastOcc);
				spots[i] = null;
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "aab";
		HashMap<Character, Integer> lastOccurence = new HashMap<Character, Integer>();
		Character[] spots = new Character[str.length()];
		for(char ch: str.toCharArray()) {
			lastOccurence.put(ch, -1);
		}
		generateWords(0, str, spots, lastOccurence);
	}
}
