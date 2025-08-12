package DataStructures.Combinations;

import java.util.ArrayList;
import java.util.List;

class PermWORep_Iterative {

	// Iterative function to find permutations of a String in Java using Collections
	public static void permutations(String s) {
		// create an empty ArrayList to store (partial) permutations
		// and initialize it with first character of the string
		List<String> partial = new ArrayList<>();
		partial.add(String.valueOf(s.charAt(0)));

		// do for every character of the specified string
		for (int i = 1; i < s.length(); i++) {
			
			// consider previously constructed partial permutation one by one
			// (we're iterating backwards in the list to avoid ConcurrentModificationException)
			for (int j = partial.size() - 1; j >= 0 ; j--) {
				// remove current partial permutation from the ArrayList
				String str = partial.remove(j);

				// Insert next character of the specified string in all
				// possible positions of current partial permutation. Then
				// insert each of these newly constructed string in the list
				for (int k = 0; k <= str.length(); k++) {
					partial.add(str.substring(0, k) + s.charAt(i) + 
								str.substring(k));
				}
			} 
		}
		System.out.println(partial);
	}

	public static void main(String[] args) {
		String s = "ABC";
		permutations(s);
	}
}