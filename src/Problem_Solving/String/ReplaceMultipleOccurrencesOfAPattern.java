package Problem_Solving.String;

public class ReplaceMultipleOccurrencesOfAPattern {

	// compare two strings `S` and `P` and returns true if `P` is a prefix of `S`
	public static boolean compare(char[] S, int k, char[] P)	{
		int i = 0;
		while (i + k < S.length && i < P.length)	{
			if (S[i + k] != P[i]) {
				break;
			}
			i++;
		}
		return i == P.length;
	}

	// In-place replace single or multiple occurrences of a pattern with a specified char
	public static String convert(String word, String pattern, char ch)	{
		// base case
		if (word == null || pattern == null) {
			return "";
		}

		char[] S = word.toCharArray();
		char[] P = pattern.toCharArray();

		int k = 0;

		// do for each character of the string
		for (int i = 0; i < S.length; i++)	{
			boolean found = false;

			// compare substring S[i,i+n] with pattern `P`
			while (compare(S, i, P))	{
				// move ahead by the length of the pattern
				i += P.length;
				found = true;
			}

			// if the pattern is found at least once
			if (found)	{
				// replace all consecutive occurrences of the pattern with the specified character
				S[k++] = ch;
			}

			// copy the current character to the next available position, `k`
			if (i < S.length) {
				S[k++] = S[i];
			}
		}
		// terminate the resultant string
		return new String(S).substring(0, k);
	}

	public static void main(String[] args)
	{
		// input string, pattern, and character
		String word = "PABCABCXABC";
		String pattern = "ABC";
		char ch = '@';

		String s = convert(word, pattern, ch);
		System.out.println(s);
	}
}
