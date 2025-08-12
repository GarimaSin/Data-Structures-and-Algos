package Problem_Solving.Backtracking;

public class NQueens2 {

	public static void main(String[] args) {
		totalNQueens(1);
		System.out.println(count);
	}

	public static int totalNQueens(int n) {
		findQueenPlacement(n, 0, new int[n][n]);
		return count;
	}

	static int count = 0;
	private static void findQueenPlacement(int n, int row, int[][] board) {
		if(row == n) {
			count++;
			return;
		}
		
		for (int j = 0; j < n; j++) {
			if(isSafe(row, j, board)) {
				board[row][j] = 1;
				findQueenPlacement(n, row+1, board);
				board[row][j] = 0;
			}
		}
	}

	private static boolean isSafe(int row, int col, int[][] board) {
		for (int i = row; i >= 0; i--) {
			if(board[i][col] == 1)
				return false;
		}
		
		for (int i = row, j=col; i >= 0 && j>= 0; i--, j--) {
			if(board[i][j] == 1)
				return false;
		}
		
		for (int i = row, j=col; i >= 0 && j<board.length; i--, j++) {
			if(board[i][j] == 1)
				return false;
		}
		return true;
	}
}