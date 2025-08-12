package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.Arrays;
import java.util.List;

public class LetterCombinationsPhoneNumber {

	public static void main(String[] args) {
//		LetterCombinationsPhoneNumber comb = new LetterCombinationsPhoneNumber();
//		comb.letterCombinations("234");
		
		List<List<Character>> keypad = Arrays.asList(
				Arrays.asList( 'A', 'B', 'C'),
				Arrays.asList( 'E', 'F', 'G'),
				Arrays.asList( 'L', 'M', 'N'),
				Arrays.asList( 'R', 'S', 'T'),
				Arrays.asList( 'U', 'V', 'W')
		);


		// input number in the form of an array (number can't start from 0 or 1)
		int[] input = {0,1,2};

		findCombinations(keypad, input, "",  input.length - 1);
	}

	public static void findCombinations(List<List<Character>> keypad,
			int[] input, String res, int index) {
		
		// if we have processed every digit of key, print result
		if (index == -1) {
			System.out.println(res + " ");
			return;
		}

		// stores current digit
		int digit = input[index];

		// size of the list corresponding to current digit
//		int len = keypad.get(digit).size();

		// one by one replace the digit with each character in the
		// corresponding list and recur for next digit
		for (int i = 0; i < keypad.get(digit).size(); i++) {
			findCombinations(keypad, input, keypad.get(digit).get(i) + res,
					index - 1);
		}
	}
}
