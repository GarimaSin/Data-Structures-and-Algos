package DataStructures.Combinations;

import java.util.ArrayList;
import java.util.List;

/*
 * Doesn't work on string, gives o/p in lists
 * 
 * Combination WO Repitition code
 */

public class DecompositionsOrFrontPartition {

	public static void main(String[] args) {
		DecompositionsOrFrontPartition part = new DecompositionsOrFrontPartition();
		List<List<String>> answer = part.partition("1234");
		System.out.println(answer.toString());
	}

	public List<List<String>> partition(String s) {
		List<List<String>> decompositions = new ArrayList<>();
		decomposeString(0, s, "", new ArrayList<>(), decompositions);
		return decompositions;
	}

	private void decomposeString(int start, String input, String ans, List<String> partialDecomposition, 
			List<List<String>> decompositions) {

		if (start == input.length()) {										// diff than power set
//			System.out.println(ans);
			decompositions.add(new ArrayList<>(partialDecomposition));
			return;
		}

		for (int i=start; i<input.length(); i++) {
			String palindromicSnippet = input.substring(start, i+1);								/** diff than power set, check index of substring **/
			partialDecomposition.add(palindromicSnippet);
			decomposeString(i+1, input, ans+palindromicSnippet+"  ", partialDecomposition, decompositions);
			partialDecomposition.remove(partialDecomposition.size() - 1);
		}
	}
}