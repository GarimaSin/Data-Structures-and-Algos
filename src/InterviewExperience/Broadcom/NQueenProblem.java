package InterviewExperience.Broadcom;

//Time = exponential
public class NQueenProblem { 

	static boolean isSafe(int board[][], int row, int col) { 
		/* Check this row on left side */
		for (int i = row-1, j = col; i >=0; i--) 
			if (board[i][j] == 1) 
				return false; 

		/* Check upper diagonal on left side */
		for (int i = row-1, j = col-1; i >=0 && j >=0; i--, j--) 
			if (board[i][j] == 1) 
				return false; 

		/* Check lower diagonal on left side */
		for (int i = row-1, j = col+1; i >=0 && j <board.length; i--, j++) 
			if (board[i][j] == 1) 
				return false; 

		return true; 
	} 

	static void solveNQUtil(int board[][], String ans, int row) { 
		if (row == board.length)  {
			System.out.println(ans);
			return; 
		}

		for (int col = 0; col < board.length; col++) { 
			if (isSafe(board, row, col)) { 
				board[row][col] = 1; 
				solveNQUtil(board, ans+row+","+col+"   ", row + 1);
				board[row][col] = 0; 															// BACKTRACK 
			} 
		} 
	} 


	public static void main(String args[]) {
		int board[][] = { 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 } }; 

		solveNQUtil(board, "", 0);
	} 
} 