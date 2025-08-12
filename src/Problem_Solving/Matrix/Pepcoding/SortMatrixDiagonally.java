package Problem_Solving.Matrix.Pepcoding;

public class SortMatrixDiagonally {

	public int[][] diagonalSort(int[][] mat) {
		for(int i=0; i<mat.length; i++) {
			sortDiagonal(mat, i, 0);
		}
		for(int j=0; j<mat[0].length; j++) {
			sortDiagonal(mat, 0, j);
		}
		return mat;
	}

	void sortDiagonal(int[][] mat, int r, int c) {
		int count[] = new int[101];
		int a = r, b = c;
		while(r <mat.length && c <mat[0].length) {
			count[mat[r][c]] = count[mat[r][c]] + 1;
			r++;
			c++;
		}

		for(int i=0; i<101; i++) {
			while(count[i] > 0) {
				mat[a][b] = i;
				count[i] = count[i] - 1;
				a++;
				b++;
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
