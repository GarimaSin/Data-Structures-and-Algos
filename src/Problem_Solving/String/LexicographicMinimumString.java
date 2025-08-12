package Problem_Solving.String;

import java.util.Arrays;

public class LexicographicMinimumString {

	static String minLexRotation(String str)
	{
		int n = str.length();

		// Create an array of strings to store all rotations
		String arr[] = new String[n];

		// Create a concatenation of String with itself
		String concat = str + str;

		// One by one store all rotations
		// of str in array. A rotation is
		// obtained by getting a substring of concat
		for (int i = 0; i < n; i++)
			arr[i] = concat.substring(i, i + n);

		// Sort all rotations
		Arrays.sort(arr);

		// Return the first rotation from the sorted array
		return arr[0];
	}

	public static void main(String[] args) {
		System.out.println(minLexRotation("GEEKSFORGEEKS"));
		System.out.println(minLexRotation("GEEKSQUIZ"));
		System.out.println(minLexRotation("BCABDADAB"));
	}
}
