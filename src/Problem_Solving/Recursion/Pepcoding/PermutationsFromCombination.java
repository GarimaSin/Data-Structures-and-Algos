package Problem_Solving.Recursion.Pepcoding;

public class PermutationsFromCombination {

	static boolean vis[];
	
	public static void main(String[] args) {
//		permute(1, 3, new int[2], 0, 2, "");
//		System.out.println(".................................");
		char[] items = {'1' , '2', '3'};
		boolean[] vis = new boolean[items.length];
		permuteString(items, "", items.length, 0, vis);
	}

	// Put 2 items in 3 boxes
	static void permute(int cuBox, int totBoxes, int[] items, int selectionSoFar, int totSelections, String ans) {
		if (cuBox >	 totBoxes) {										// > and not = coz currentItem is starting from 1 and not 0
			if(selectionSoFar == totSelections)
				System.out.println(ans);
			return;
		}

		for (int i = 0; i < totSelections; i++) {					//total items
			if(items[i] == 0) {												// if item is not placed in any box yet (different from permutation)
				items[i] = 1;
				permute(cuBox+1, totBoxes, items, selectionSoFar+1, totSelections, ans + (i+1));
				items[i] = 0;
			}
		}
		permute(cuBox+1, totBoxes, items, selectionSoFar, totSelections, ans + 0);
	}

	static void permuteString(char set[], String curr, int totItemPositions, int ansLen, boolean[] vis) {
		if (ansLen >= totItemPositions) {
			System.out.println(curr);
			return;
		}

		for (int i = 0; i < totItemPositions; ++i) {				// for all positions (boxes)
			if(!vis[i]) {																// if position is not occupied
				vis[i] = true;
				permuteString(set, curr+ set[i], totItemPositions, ansLen + 1, vis);
				vis[i] = false;
			}
		}
	}
}