package Problem_Solving.Recursion.Pepcoding;

public class SubseqOrSubsetInComb {

	/** 
	 * Visulaize the recursion tree in both the cases
	 */
	static void subsetInCombWithInclExcl(int set[], String curr, int i) {
		if (i >= set.length) {
			System.out.println(curr);					/** We get the subset only when we have reached the leaf of the recursion tree **/
			return;
		}

		subsetInCombWithInclExcl(set, curr + set[i], i+1); 			//include case
		subsetInCombWithInclExcl(set, curr, i+1); 							//exclude case
	}

	static void subsetInCombWithForLoop(int set[], String curr, int k, int start) {
		System.out.println(curr);					/** We get the output at every intermediate nodes of the recursion tree **/

		if (k == 0) 
			return;

		for (int i = start; i < set.length; ++i) {
			subsetInCombWithForLoop(set, curr + set[i], k - 1, i+1); 
		}
	}

	public static void main(String[] args) {             
		System.out.println("First Test");
		int set1[] = {1,2,3};
		int k = 3;
		printAllKLength(set1, k);
	}    

	static void printAllKLength(int set[], int k) {
		System.out.println("----------------");
		subsetInCombWithInclExcl(set, "", 0);
		System.out.println("----------------");
		subsetInCombWithForLoop(set, "", k, 0);
	}
}