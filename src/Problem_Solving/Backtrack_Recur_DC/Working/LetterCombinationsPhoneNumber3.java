package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsPhoneNumber3 {

	// Iterative function to find all possible combinations of words
	// formed from mobile keypad
	public static void findCombinations(List<List<Character>> keypad, int[] input) {

		List<String> outputList = new ArrayList<>();

		// push all character associated with first digit into output list
		for (Character ch: keypad.get(input[0])) {
			outputList.add(String.valueOf(ch));
		}

		// start from second digit
		for (int i = 1; i < input.length; i++) 	{
			// create a temporary list and clear contents of output list
			List<String> prevList = new ArrayList<>(outputList);
			outputList.clear();

			// for each character associated with current digit in the keypad
			for (Character ch: keypad.get(input[i])) 			{
				// append current character to each word in the output list
				for (String s: prevList) {
					outputList.add(s + ch);
				}
			}
		}

		// print output list containing all combinations of words possible
		System.out.println(outputList);
	}

	public static void main(String[] args) {
		List<List<Character>> keypad = Arrays.asList(
					// 0 and 1 digit don't have any characters associated
					Arrays.asList(),
					Arrays.asList(),
					Arrays.asList( 'A', 'B', 'C' ),
					Arrays.asList( 'D', 'E', 'F' ),
					Arrays.asList( 'G', 'H', 'I' ),
					Arrays.asList( 'J', 'K', 'L' ),
					Arrays.asList( 'M', 'N', 'O' ),
					Arrays.asList( 'P', 'Q', 'R', 'S'),
					Arrays.asList( 'T', 'U', 'V' ),
					Arrays.asList( 'W', 'X', 'Y', 'Z')
		);

		// input number in the form of an array (number can't start from 0 or 1)
		int[] input = { 2, 3, 4 };

		// find all combinations
		findCombinations(keypad, input);
	}
}