package Problem_Solving.Recursion.Pepcoding;

//Time = exponential
public class TwoDCombination2 { 

	//boardSize = 9, (if board = 3*3), totCells = if we have reached the last cell = 9.
	//2D Solution
	static void combine(int count, int[][] board, int totItem, int row, int col,  boolean[][] vis) {
		int size = board.length;
		if(count == totItem)  {
			printBoard(board);
			System.out.println(".......................");
			return; 
		}

		for(int j=col+1; j<size; j++) {
			vis[row][j] = true;
			board[row][j] = 1;
			combine(count + 1, board, totItem, row, j, vis);
			vis[row][j] = false;
			board[row][j] = 0;
		}
		
		
		for(int i=row+1; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(!vis[i][j]) {
					vis[i][j] = true;
					board[i][j] = 1;
					combine(count + 1, board, totItem, i, j, vis);
					vis[i][j] = false;
					board[i][j] = 0;
				}
			}
		}
	}
	
	//Convert to 1D, Easy sol
	static void combinationIn1D(int count, int totItems, boolean[][] board, int lastPosition) {
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
			System.out.println("...............................");
			return;
		}
		
		for(int cell=lastPosition+1; cell<board.length*board.length; cell++) {
			int row = cell/board.length;
			int col = cell%board.length;
			board[row][col] = true;
			combinationIn1D(count+1, totItems, board, cell);
			board[row][col] = false;
		}
	}

	public static void main(String args[]) {
		int totItems = 2;
		int[][] board = new int[2][2];
		boolean[][] board1 = new boolean[2][2];
		combine(0, board, totItems, 0, -1, new boolean[board.length][board.length]);
		combinationIn1D(0, totItems, board1, -1);
	} 

	private static void printBoard(int[][] board) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
} 