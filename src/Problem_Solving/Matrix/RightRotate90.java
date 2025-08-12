package Problem_Solving.Matrix;

public class RightRotate90 {

	public static void transpose(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public static void reverseRow(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			int left = 0;
			int right = matrix.length - 1;

			while (left < right) {
				int temp = matrix[r][left];
				matrix[r][left] = matrix[r][right];
				matrix[r][right] = temp;

				left++;
				right--;
			}
		}
	}

	public static void rightRotate(int[][] matrix) {
		transpose(matrix);
		reverseRow(matrix);
	}


	public static void main(String[] args) {
		int mat[][] = { {1, 2, 3, 4}, 
				{5, 6, 7, 8}, 
				{9, 10, 11, 12},
				{13, 14, 15, 16}}; 

		int row = mat.length;
		int col = mat[0].length;
		printMatrix(mat, row, col);
		System.out.println();
		rightRotate(mat); 
		printMatrix(mat, row, col);
	}

	private static void printMatrix(int[][] mat, int row, int col) {
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(mat[i][j] + "   ");
			}
			System.out.println();
		}
	}
}
