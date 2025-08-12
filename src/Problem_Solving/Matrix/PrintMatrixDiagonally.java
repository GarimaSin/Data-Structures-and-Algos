package Problem_Solving.Matrix;

/**
 * 
 * https://www.geeksforgeeks.org/print-matrix-diagonal-pattern/
 *
 */
public class PrintMatrixDiagonally {
	static final int MAX = 100; 

	static void printMatrixDiagonal(int mat[][], int n) {
		// Initialize indexes of element to be printed next 
		int i = 0, j = 0; 

		// Direction is initially from down to up 
		boolean isUp = true; 

		// Traverse the matrix till all elements get traversed 
		for (int k = 0; k < n * n;) { 
			// If isUp = true then traverse from downward to upward 
			if (isUp) { 
				for (; i >= 0 && j < n; j++, i--) { 
					System.out.print(mat[i][j] + " "); 
					k++; 
				} 

				// Set i and j according to direction 
				if (i < 0 && j <= n - 1) 
					i = 0; 
				if (j == n) { 			//when we have reached the mid (longest) diagonal's top-most cell then set i=2nd row
					i = i + 2; 
					j--; 
				} 
			} 

			// If isUp = 0 then traverse up to down 
			else { 
				for (; j >= 0 && i < n; i++, j--) { 
					System.out.print(mat[i][j] + " "); 
					k++; 
				} 

				// Set i and j according to direction 
				if (j < 0 && i <= n - 1) 
					j = 0; 
				if (i == n) { 			//when we have reached the mid (longest) diagonal's bottom-most cell then set j=2nd col
					j = j + 2; 
					i--; 
				} 
			} 

			// Revert the isUp to change the direction 
			isUp = !isUp; 
		} 
	} 

	public static void main(String[] args) { 
		int mat[][] = { {1,   2, 	  3,   4}, 
								{5,   6, 	  7,   8}, 
								{9,   10,  11, 12},
								{13, 14,  15, 16}}; 

		int n = 4; 
		printMatrixDiagonal(mat, n); 
	} 
} 
