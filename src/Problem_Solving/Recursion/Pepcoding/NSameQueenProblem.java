package Problem_Solving.Recursion.Pepcoding;

//Time = exponential
public class NSameQueenProblem { 

	static boolean isSafe(boolean board[][], int row, int col) { 

		/* Check this row on left side */
		for (int i = row, j = col; i >=0; i--) 
			if (board[i][j]) 
				return false; 
		
		for (int i = row, j = col; j >=0; j--) 
			if (board[i][j]) 
				return false; 

		/* Check upper diagonal on left side */
		for (int i = row, j = col; i >=0 && j >=0; i--, j--) 
			if (board[i][j]) 
				return false; 

		/* Check lower diagonal on left side */
		for (int i = row, j = col; i >=0 && j <board.length; i--, j++) 
			if (board[i][j]) 
				return false; 

		return true; 
	} 

	static void nQueensComb(int count, int totItems, boolean[][] board, int lastPosition) {
		if(count == totItems) {
			for(int i=0; i<board.length; i++) {
				for(int j=0; j<board[0].length; j++) {
					if(board[i][j])
						System.out.print("q\t");
					else
						System.out.print("-\t");
				}
				System.out.println();
			}
			System.out.println(".................................");
			return;
		}
		
		for(int cell=lastPosition+1; cell<board.length*board.length; cell++) {
			int row = cell/board.length;
			int col = cell%board.length;
			if(board[row][col] == false && isSafe(board, row, col)) {
				board[row][col] = true;
				nQueensComb(count+1, totItems, board, cell);
				board[row][col] = false;
			}
		}
	}


	public static void main(String args[]) {
		int totItems = 4;
		boolean[][] board = new boolean[4][4];
		nQueensComb(0, totItems, board, -1);
	} 
} 
