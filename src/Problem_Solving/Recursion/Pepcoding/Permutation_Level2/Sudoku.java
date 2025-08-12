package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

//Code same as pepcoding, not printing o/p
public class Sudoku {

	public static void main(String[] args) {
		int board[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
				{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },
				{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		solveSudoku(board, 0, 0);
	}

	private static void solveSudoku(int[][] board, int i, int j) {
		/*  If we have reached the 8th row and 9th column (0 indexed matrix) ,
        we are returning true to avoid further backtracking 
        Coz if we return from 8th col, then there cud be a case that 8th row, 8th col might have 0. */
		if(i == board.length-1 && j == board.length)	{
			display(board);
			return;
		}

		if (j == board[0].length) {
			i++;
			j = 0;
		}

		if(board[i][j] != 0) {
			solveSudoku(board, i, j+1);
		} else {
			for(int po = 1; po <= 9; po++) {
				if(isValid(board, i, j, po) == true) {
					board[i][j] = po;
					solveSudoku(board, i, j+1);
					board[i][j] = 0;
				}
			}
		}
	}

	private static boolean isValid(int[][] board, int x, int y, int val) {
		for(int j=0; j<board[0].length; j++) {
			if(board[x][j] == val)
				return false;
		}

		for(int i=0; i<board.length; i++) {
			if(board[i][y] == val)
				return false;
		}

		int smi = x/3*3;
		int smj = y/3*3;

		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board[smi+i][smj+j] == val)
					return false;
			}
		}
		return true;
	}

	static void display(int[][] board) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class solution2 {
	public void solveSudoku(char[][] board) {
		if(!solve(board))
			System.out.println("Cannot be solved");
	}

	public boolean solve(char[][] board) {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {

				if(board[i][j] == '.') {
					for(char c='1'; c<='9'; c++) {
						if(isValid(board, c, i, j)) {
							board[i][j] = c; // put it
							if(solve(board))
								return true;
							else
								board[i][j] = '.'; // if cannot solve remove the value placed
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	boolean isValid(char[][] grid, char val, int row, int col){
		for (int i = 0; i < 9; i++) {
			if (grid[i][col] == val)
				return false;

			if (grid[row][i] == val)
				return false;

			if (grid[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val)
				return false;
		}
		return true;
	}
}
