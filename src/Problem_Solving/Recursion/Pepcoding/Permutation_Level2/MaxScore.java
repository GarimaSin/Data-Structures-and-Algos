package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

public class MaxScore {

	public static void main(String[] args) {
		String[] words = {"dog", "cat", "dad", "good"};
		char[] letters = {'a', 'b', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};

		int[] score = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		System.out.println(getMaxScore(words, farr, score, 0));
	}

	private static int getMaxScore(String[] words, int[] farr, int[] score, int idx) {
		if(idx == words.length) {
			return 0;
		}
		int sno = 0 + getMaxScore(words, farr, score, idx+1);					//words not included
		
		//word to include
		int scoreWord = 0;
		String word = words[idx];
		boolean flag = true;									//true if yes call can be made
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			
			if(farr[ch - 'a'] == 0) {
				flag = false;
			}
			
			farr[ch - 'a']--;
			scoreWord += score[ch - 'a'];
		}
		int syes = 0;
		if(flag) {
			syes = scoreWord + getMaxScore(words, farr, score, idx+1);
		}
		
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			farr[ch - 'a']++;
		}
		
		return Math.max(sno, syes);
	}
}
