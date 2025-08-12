package Problem_Solving.Google_Shared;

import java.util.HashMap;
import java.util.Map;

/**
 * The idea is to remove all the non-repeated characters from the string and check if the resultant string is palindrome or not. 
 * If the remaining string is palindrome then it is not repeated, else there is a repetition. 
 * One special case we need to handle for inputs like “AAA”, which are palindrome but their repeated subsequence exists. 
 * Repeated subsequence exists for a palindrome string if it is of odd length and its middle letter is same as left(or right) character.
 * 
 * I - If a char is repeated comes at least 3 times means the char is a repeated subseq in itself
 * 	else create a string wid all the chars appearing more than once and find if it is a palindrome. 
 * If yes ==> no repeated subseq
 */
class RepeatedSubsequence {

	public static boolean isPalindrome(String str, int low, int high) {
		if (low >= high) {
			return true;
		}

		return (str.charAt(low) == str.charAt(high)) &&
				isPalindrome(str, low + 1, high - 1);
	}

	// Function to checks if repeated subsequence is present in the string
	public static boolean repeatedSubsequence(String str) {
		// map to store frequency of each distinct character of given string
		Map<Character, Integer> freq = new HashMap<>();

		// update map with frequency
		for (int i = 0; i < str.length(); i++) {
			// if frequency of any character becomes 3,
			// we have found the repeated subsequence

			if (freq.get(str.charAt(i)) == null){
				freq.put(str.charAt(i), 0);
			}

			freq.put(str.charAt(i), freq.get(str.charAt(i)) + 1);

			if (freq.get(str.charAt(i)) >= 3) {	/** If a char is repeated comes at least 3 times means the char is a repeated subseq in itself **/
				return true;
			}
		}

		StringBuilder sb = new StringBuilder() ;

		// consider all repeated elements (frequency 2 or more)
		// and discard all non-repeating elements (frequency 1)
		for (int i = 0; i < str.length(); i++) {
			if (freq.get(str.charAt(i)) >= 2) {
				sb.append(str.charAt(i));
			}
		}

		// return false if temp is a Palindrome
		return !isPalindrome(sb.toString(), 0, sb.length() - 1);
	}

	public static void main(String[] args)
	{
		String str = "maadaam";		// XB is repeated subsequence

		if (repeatedSubsequence(str))
			System.out.println("Repeated Subsequence present");
		else
			System.out.println("No Repeated Subsequence");
	}
}