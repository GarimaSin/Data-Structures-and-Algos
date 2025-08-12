package Problem_Solving.Google_Shared;

import java.util.Arrays;
import java.util.List;

/**
 * we store the key only in leaf node.
 * Line# 41 and 27
 */

public class LexicographicSortingOfWords {
	// Iterative function to insert a String in Trie
	public static void insert(Trie head, String str) {
		// start from root node
		Trie curr = head;

		for (int i = 0; i < str.length(); i++) {
			// create a new node if path doesn't exists
			if (curr.character[str.charAt(i) - 'a'] == null) {		/** char - 'a' makes the int value 0 **/
				curr.character[str.charAt(i) - 'a'] = new Trie();
			}
			// go to next node
			curr = curr.character[str.charAt(i) - 'a'];
		}
		
		/** store key in leaf node **/
		curr.key = str;
//		System.out.println();
	}

	// Function to perform pre-order traversal of given Trie
	public static void preorder(Trie curr) {
		// return false if Trie is empty
		if (curr == null) {
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (curr.character[i] != null) {
				// if leaf node, print key
				if (curr.character[i].key != null) 
					System.out.println(curr.character[i].key);
			}
			preorder(curr.character[i]);
		}
	}

	public static void main (String[] args) {
		// given set of keys
//		List<String> dict = Arrays.asList(
//				"lexicographic", "sorting", "of", "a", "set", "of", "keys",
//				"can", "be", "accomplished", "with", "a", "simple", "trie",
//				"based", "algorithm", "we", "insert", "all", "keys", "in", 
//				"a", "trie", "output", "all", "keys", "in", "the", "trie",
//				"by", "means", "of", "preorder", "traversal", "which",
//				"results", "in", "output", "that", "is", "in",
//				"lexicographically", "increasing", "order",
//				"preorder", "traversal", "is", "a", "kind", 
//				"of", "depth", "first", "traversal"
//			);
		
		List<String> dict = Arrays.asList(
				"set", "of", "keys", "can"
			);

		Trie head = new Trie();

		// insert all keys of dictionary into trie
		for (String word: dict) {
			insert(head, word);
		}

		// print keys in lexicographic order
		preorder(head);
	}
}


class Trie {
	String key;	// non-empty when node is a leaf node
	Trie[] character = null;

	Trie() {
		// Trie supports lowercase English characters (a - z) so character size is 26
		character = new Trie[26];
	}
}