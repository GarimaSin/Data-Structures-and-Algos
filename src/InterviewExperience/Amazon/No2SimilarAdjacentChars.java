package InterviewExperience.Amazon;

import java.util.Comparator;
import java.util.PriorityQueue; 

/**
 * Rearrange characters in a string such that no two adjacent are same
 * Here, no 2 same char will be placed next to each other (even if the after placing it in the output,
 * the next highest frequency is of the same char) since after adding the char in the output string 'str', that key is removed 
 * from PQ and isn't added back to the PQ until another key is added to 'str'. 
 *
 */
class KeyComparator implements Comparator<Key> { 

	public int compare(Key k1, Key k2) { 
		if (k1.freq < k2.freq) 
			return 1; 
		else if (k1.freq > k2.freq) 
			return -1; 
		return 0; 
	} 
} 

class Key { 
	int freq; // store frequency of character 
	char ch; 
	Key(int val, char c) { 
		freq = val; 
		ch = c; 
	} 
} 

public class No2SimilarAdjacentChars { 
	static int MAX_CHAR = 26; 

	static void rearrangeString(String str) 	{ 
		int n = str.length(); 

		// Store frequencies of all characters in string 
		int[] count = new int[MAX_CHAR]; 

		for (int i = 0; i < n; i++) 
			count[str.charAt(i) - 'a']++; 

		// Insert all characters with their frequencies into a priority_queue 
		PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator()); 
		for (char c = 'a'; c <= 'z'; c++) { 
			int val = c - 'a'; 
			if (count[val] > 0) 
				pq.add(new Key(count[val], c)); 
		} 

		str = "" ; 

		// work as the previous visited element initial previous element be. ('#' and it's frequency '-1') 
		Key prev = new Key(-1, '#'); 

		while (pq.size() != 0) { 

			Key k = pq.peek(); 
			pq.poll(); 
			str = str + k.ch; 

			// If frequency of previous character is less than zero that means it is useless, we need not to push it 
			if (prev.freq > 0) 
				pq.add(prev); 

			// make current character as the previous 'char' decrease frequency by 'one' 
			(k.freq)--; 
			prev = k; 
		} 

		// If length of the resultant string and original string is not same then string is not valid 
		if (n != str.length()) 
			System.out.println(" Not valid String "); 
		else
			System.out.println(str); 
	} 

	public static void main(String args[]) 	{ 
		String str = "bbbba" ; 
		rearrangeString(str); 
	} 
} 
