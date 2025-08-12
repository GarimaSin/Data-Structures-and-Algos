package Problem_Solving.Recursion.Pepcoding;

//Time = exponential
public class NQueenProblemBranchNBound { 

	static void solveNQUtil(boolean board[][], int row, boolean[] cols, boolean[] ldiag, boolean[] rdiag, String ans) { 
		if (row == board.length)  {
			System.out.println(ans+",");
			return; 
		}

		for (int col = 0; col < board.length; col++) { 
			if (cols[col] == false && ldiag[row-col+board.length-1] == false && rdiag[row+col] == false) { 
				board[row][col] = true; 
				cols[col] = true;
				ldiag[row-col+board.length-1] = true;
				rdiag[row+col] = true;
				solveNQUtil(board, row+1, cols, ldiag, rdiag, ans+row+"-"+col+", ");
				board[row][col] = false; 															// BACKTRACK 
				board[row][col] = false; 
				cols[col] = false;
				ldiag[row-col+board.length-1] = false;
				rdiag[row+col] = false;
			} 
		} 
	} 


	public static void main(String args[]) {
		boolean board[][] = new boolean[4][4]; 
		boolean[] cols = new boolean[board.length];
		boolean[] ldiag = new boolean[2*board.length-1];
		boolean[] rdiag = new boolean[2*board.length-1];
		solveNQUtil(board, 0, cols, ldiag, rdiag, "");
	} 
} 
