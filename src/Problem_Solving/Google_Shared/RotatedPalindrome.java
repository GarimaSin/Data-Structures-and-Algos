package Problem_Solving.Google_Shared;

/**
 * Let the given string be S of length m. The idea is to concatenate the given string with itself i.e
 * (S = S+S) and find palindromic substring of length m in the modified string (S+S)
 * If palindromic substring of length m exists in the modified string, we return true else we return false.
 *
 */
public class RotatedPalindrome {
	// expand in both directions of low and high to find palindrome of length k
	private static boolean expand(String str, int low, int high, int k) {
		while (low >= 0 && high < str.length() &&
	(str.charAt(low) == str.charAt(high)))
		{
			// return true palindrome of length k is found
			if (high - low + 1 == k) {
				return true;
			}

			// expand in both directions
			low--;
			high++;
		}

		// return false if palindrome of length k is not found
		return false;
	}

	// Function to check if palindromic substring of length k exists or not
	private static boolean LongestPalindromicSubString(String str, int k) {
		for (int i = 0; i < str.length() - 1; i++) {
			// check if odd length or even length palindrome of length k
			// having str.charAt(i) as its mid point exists
			if (expand(str, i, i, k) || expand(str, i, i + 1, k)) {
				return true;
			}
		}

		return false;
	}

	// Function to check if given string is a rotated palindrome or not
	public static boolean isRotatedPalindrome(String str)
	{
		// length of given string
		int m = str.length();

		// return true if longest palindromic substring of length m
		// exists in the string (str + str)
		return LongestPalindromicSubString(str + str, m);
	}

	public static void main(String[] args) {
		// palindromic string
		String str = "ABCCBA";

		// rotate it by 2 units
		str = "CCBAAB";

		if (isRotatedPalindrome(str)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}