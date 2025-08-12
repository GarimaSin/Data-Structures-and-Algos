package Problem_Solving.Recursion.Pepcoding;


//Code same as pepcoding but not printing o/p
public class KnightsTour {

	static int dr[] = { -2, -1, 	1, 		2, 	 2, 	1, 	 -1, -2 };
	static int dc[] = { 1, 	2, 2, 		1, -1, 	-2, -2, -1 };
	static int size = 5;

	public static void main(String[] args) {
		int board[][] = new int[size][size];
		findPath(3,2, board, 1);
	}

	private static void findPath(int r, int c, int[][] board, int move) {

		if(r<0 || r>=board.length || c<0 || c>=board.length || board[r][c] > 0)
			return;

		if(move == size*size) {
			System.out.println("................");
			board[r][c] = move;
			printBoard(board);
			board[r][c] = 0;
			return;
		}

		board[r][c] = move;

		findPath(r-2, c+1,  board, move+1);
		findPath(r-1, c+2,  board, move+1);
		findPath(r+1, c+2,  board, move+1);
		findPath(r+2, c+1,  board, move+1);
		findPath(r+2, c-1,  board, move+1);
		findPath(r+1, c-2,  board, move+1);
		findPath(r-1, c-2,  board, move+1);
		findPath(r-2, c-1,  board, move+1);
		board[r][c] = 0;
	}

	private static void printBoard(int[][] board) {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("__________________________");
	}
}
