package Problem_Solving.Recursion.Pepcoding;

//Time = exponential
public class NSameKnightProblem { 

	static boolean isKnightSafe(boolean board[][], int i, int j) { 

		/* Check this row on left side */
		if (i-1 >= 0 && j-2 >= 0 && board[i-1][j-2]) 
			return false; 

		if (i-2 >= 0 && j-1 >= 0 && board[i-2][j-1]) 
			return false; 

		if (i-2 >= 0 && j+1 < board.length && board[i-2][j+1]) 
			return false; 

		if (i-1 >= 0 && j+2 < board.length && board[i-1][j+2]) 
			return false; 

		return true; 
	} 

	static void nQueensComb(int count, int totItems, boolean[][] board, int lastPosition) {
		if(count == totItems) {
			for(int i=0; i<board.length; i++) {
				for(int j=0; j<board[0].length; j++) {
					System.out.print(board[i][j] ? "k\t" : "-\t");
					//						System.out.print("-\t");
				}
				System.out.println();
			}
			System.out.println(".................................");
			return;
		}

		for(int cell=lastPosition+1; cell<board.length*board.length; cell++) {
			int row = cell/board.length;
			int col = cell%board.length;
			if(board[row][col] == false && isKnightSafe(board, row, col)) {
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
