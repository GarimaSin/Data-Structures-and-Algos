package Problem_Solving.Recursion.Pepcoding;

//Time = exponential
public class TwoDPermutation { 
	final int N = 4; 

	static void permute(int board[][], int totItems, int count) { 
		if (count == totItems)  {
			for (int row = 0; row < board.length; row++) { 
				for (int col = 0; col < board[0].length; col++) { 
					if(board[row][col] == 0)
						System.out.print("-\t");
					else
						System.out.print("q"+board[row][col]+"\t");
				}
				System.out.println();
			}
			System.out.println("****************************");
			return; 
		}
		
		for (int row = 0; row < board.length; row++) { 
			for (int col = 0; col < board[0].length; col++) { 
				if (board[row][col] == 0) { 
					board[row][col] = count + 1; 
					permute(board, totItems, count + 1);
					board[row][col] = 0; 															// BACKTRACK 
				} 
			}
		} 
	} 

	public static void main(String args[]) {
		int board[][] = { { 0, 0}, 
				{ 0, 0 }, }; 

		permute(board, 2, 0);
	} 
} 