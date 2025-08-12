package Problem_Solving.Recursion.Pepcoding;

//Time = exponential
//https://youtu.be/BLy1wjhwHU8 
//Code same but not running
public class NDifferentQueenProblem { 

	static boolean isSafe(int board[][], int row, int col) { 
		/* Check this row on left side */
		for (int i = row, j = col; i >=0; i--) {
			if (board[i][j] > 0) 
				return false; 
		}

		for (int i = row, j = col; i <board.length; i++) {
			if (board[i][j] > 0) 
				return false; 
		}

		for (int i = row, j = col; j >= 0; j--) {
			if (board[i][j] > 0) 
				return false; 
		}

		for (int i = row, j = col; j < board.length; j++) {
			if (board[i][j] > 0) 
				return false; 
		}

		//diagonal - D1 (upper left)
		for (int i = row, j = col; i >=0 && j>=0; i--, j--) {
			if (board[i][j] > 0) 
				return false; 
		}

		//diagonal - D2 (upper right)
		for (int i = row, j = col; i >=0 && j<board.length; i--, j++) {
			if (board[i][j] > 0) 
				return false; 
		}

		//diagonal - D3 (down right)
		for (int i = row, j = col; i <board.length && j<board.length; i++, j++) {
			if (board[i][j] > 0) 
				return false; 
		}

		//diagonal - D4 (down left)
		for (int i = row, j = col; i <board.length && j >= 0; i++, j--) {
			if (board[i][j] > 0) 
				return false; 
		}
		return true; 
	} 

	static void nQueens(int board[][], int totQueens, int count) { 
		if (count == totQueens)  {
			for(int i=0; i<board.length; i++) {
				for(int j=0; j<board[0].length; j++) {
					if(board[i][j] ==0)
						System.out.print("-\t");
					else
						System.out.print("q"+board[i][j]+"\t");
				}
				System.out.println();
			}
			System.out.println("______________________________________________");
			return;
		}

		for (int cell = 0; cell < board.length*board[0].length; cell++) { 
			int row = cell / board[0].length;
			int col = cell % board[0].length;
			if (board[row][col] == 0 && isSafe(board, row, col)) { 
				board[row][col] = count+1; 
				nQueens(board, totQueens, count + 1);
				board[row][col] = 0; 															// BACKTRACK 
			} 
		} 
	} 

	public static void main(String args[]) {
		int board[][] = { { 0, 0, 0}, 
				{ 0, 0, 0}, 
				{ 0, 0, 0}}; 
		nQueens(board, 2, 0);
	} 
} 