package Problem_Solving.Recursion.Pepcoding;

public class PermutationsUsingBacktracking {

	static boolean vis[];
	
	public static void main(String[] args) {
		permute(new int[4], 1, 2);
		System.out.println(".................................");
		
		char set1[] = {'a', 'b', 'c'};
        int n = set1.length;    
        vis = new boolean[n];
        permuteString(set1, "", n, 0);
	}

	// Put 2 items in 4 boxes
	static void permute(int[] boxes, int currentItem, int totItem) {
		if (currentItem >	 totItem) {										// > and not = coz currentItem is starting from 1 and not 0
			for (int i = 0; i < boxes.length; i++) 
				System.out.print(boxes[i]);
			System.out.println();
			return;
		}

		for (int i = 0; i < boxes.length; i++) {
			if(boxes[i] == 0) {												// if the box is empty
				boxes[i] = currentItem;
				permute(boxes, currentItem+ 1, totItem);
				boxes[i] = 0;
			}
		}
	}

	static void permuteString(char set[], String curr, int totItemPositions, int ansLen) {
		if (ansLen >= totItemPositions) {
			System.out.println(curr);
			return;
		}

		for (int i = 0; i < totItemPositions; ++i) {				// for all positions (boxes)
			if(!vis[i]) {																// if position is not occupied
				vis[i] = true;
				permuteString(set, curr+ set[i], totItemPositions, ansLen + 1);
				vis[i] = false;
			}
		}
	}
}