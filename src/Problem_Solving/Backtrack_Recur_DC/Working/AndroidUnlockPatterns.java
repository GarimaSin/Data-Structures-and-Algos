package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

public class AndroidUnlockPatterns {

	public static void main(String[] args) {
		int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
	}
	
	boolean isExists = false;
	private boolean ifExists(char[][] board, String word, String answer, int i, int j, boolean[][] vis) {
		if(answer.equals(word)) {
			isExists = true;
			return isExists;
		}
		
		if(answer.length() > word.length())
			return isExists;
		
		if(i<0 || i>=board.length || j>=board[0].length || j<0)
			return isExists;
		if(j+1<board[0].length && !vis[i][j+1]) {				//1st check if the vertices are valid, then if visited?
			vis[i][j+1] = true;
			ifExists(board, word, answer+board[i][j+1], i, j+1, vis);
			vis[i][j+1] = false;
		}
		if(i+1<board.length && !vis[i+1][j]) {
			vis[i+1][j] = true;
			ifExists(board, word, answer+board[i+1][j], i+1, j, vis);
			vis[i+1][j] = false;
		}
		if(j-1>=0 && !vis[i][j-1]) {
			vis[i][j-1] = true;
			ifExists(board, word, answer+board[i][j-1], i, j-1, vis);
			vis[i][j-1] = false;
		}
		if(i-1>=0 && !vis[i-1][j]) {
			vis[i-1][j] = true;
			ifExists(board, word, answer+board[i-1][j], i-1, j, vis);
			vis[i-1][j] = false;
		}
		return isExists;
	}
}
