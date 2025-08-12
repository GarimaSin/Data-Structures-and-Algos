package Problem_Solving.Recursion.Pepcoding;

//import java.util.ArrayList;
//import java.util.List;

//Time = exponential
//Working - LC - 51
public class NSameQueenProblem2 { 

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

	//Working - LC - 51
	static void solveNQUtil(int board[][], String ans, int row) { 
		if (row == board.length)  {
			System.out.println(ans);
			return; 
		}

		//for incg rows, check every col
		for (int col = 0; col < board.length; col++) { 
			if (isSafe(board, row, col)) { 
				board[row][col] = 1; 
				solveNQUtil(board, ans+row+","+col+"   ", row + 1);		//keep inc the row everytime
				board[row][col] = 0; 															// BACKTRACK 
			} 
		} 
	} 


	//Working - Same code as above, just made compatible with LC
//	public static List<List<String>> solveNQueens(int n) {
//		List<List<String>> ans = new ArrayList <>();
//		List<String> list = new ArrayList<>();
//		for(int i=0; i<n; i++) {
//			String tmp = "";
//			for (int j = 0; j < n; j++) {
//				tmp = tmp + "."; 
//			}
//			list.add(tmp);
//		}
//		return helper(new int[n][n], ans, 0, list);
//	}
//
//	static List<List<String>> helper(int[][] board, List<List<String>> ans, int row, List<String> list) {
//		if (row == board.length)  {
//			ans.add(new ArrayList<>(list));
//			return ans;
//		}
//
//		for (int col = 0; col < board.length; col++) { 
//			if (isSafe(board, row, col)) { 
//				board[row][col] = 1; 
//				String tmp1 = list.get(row);
//				String tmp2 = tmp1;
//				tmp1 = tmp1.substring(0, col) + "Q" + tmp1.substring(col+1);
//				list.set(row, tmp1);
//				helper(board, ans, row + 1, list);
//				list.set(row, tmp2);
//				board[row][col] = 0; 
//			} 
//		}
//		return ans;
//	}


	public static void main(String args[]) {
		int board[][] = { 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 } }; 

		solveNQUtil(board, "", 0);
//		List<List<String>> ans = solveNQueens(4);
//		for(List<String> l: ans) {
//			System.out.println(l.toString());
//		}
	} 
} 