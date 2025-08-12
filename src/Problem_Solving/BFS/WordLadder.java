package Problem_Solving.BFS;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	static LinkedHashSet<String> ans = new LinkedHashSet<>();
	//Returns length of shortest chain to reach 'target' from 'start'
	//using minimum number of adjacent moves. D is dictionary
	static int shortestChainLen(String start, String target, Set<String> D) {
		if (!D.contains(target))
			return 0;
		

		int level = 0, wordlength = start.length();
		Queue<String> Q = new LinkedList<>();
		Q.add(start);

		while (!Q.isEmpty()) {
			// Increment the chain length
			++level;
			int sizeofQ = Q.size();

			for (int i = 0; i < sizeofQ; ++i) {

				// Remove the first word from the queue
				char []word = Q.peek().toCharArray();
				Q.remove();

				// For every character of the word
				for (int pos = 0; pos < wordlength; ++pos) {

					// Retain the original character at the current position
					char orig_char = word[pos];

					// Replace the current character with every possible lowercase alphabet
					for (char c = 'a'; c <= 'z'; ++c) {
						word[pos] = c;

						String tmp = String.valueOf(word);
						if (tmp.equals(target))
							return level + 1;

						if (!D.contains(tmp))
							continue;
						ans.add(tmp);
						D.remove(tmp);				/** Remove the word from the set if it is found in it else will form infinite loop**/
						Q.add(tmp);
					}
					/**Restore the original character at the current position **/
					word[pos] = orig_char;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Set<String> D = new HashSet<String>();
		D.add("des");
		D.add("der");
		D.add("dfr");
		D.add("dgt");
		D.add("dfr");
		D.add("dfs");
		String start = "der";
		String target = "dfs";
		System.out.println("Length of shortest chain is: "
				+ shortestChainLen(start, target, D));
		for(String s: ans) {
			System.out.println(s);
		}
	}
}

