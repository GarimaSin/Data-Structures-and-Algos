package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

public class WordSearch {
	boolean isExists = false;
	public static void main(String[] args) {
		char[][] board = 
						{{'C','A','A'},
						{'A','A','A'},
						{'B','C','D'}};
//						 {{'A','B','C'},
//						 {'A','E','D'},
//						 {'A','F','G'}};
		WordSearch word = new WordSearch();
		String searchString = "AAB";
		word.exist(board, searchString);
		System.out.println(word.isExists);
	}

	public boolean exist(char[][] board, String word) {
		int rows = board.length;
        int cols = board[0].length;
        boolean[][] vis = new boolean[rows][cols];
        
        if(board.length ==1 && board[0].length==1) {
        	if(new String(board[0]).equals(word)) {
        		isExists = true;
        		return isExists;
        	}
        }
        
		for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                	vis[i][j]=true;							//Include the cu. item in the answer and mark it as visited
                    if (ifExists(board, word, word.charAt(0)+"", i, j, vis)) {
                        return true;
                    } else
                    	vis[i][j]=false;
                }
            }
        } 
		return isExists;
	}

	private boolean ifExists(char[][] board, String word, String answer, int i, int j, boolean[][] vis) {
		if(answer.equals(word)) {
			isExists = true;
			return isExists;
		}
		
		if(answer.length() > word.length())
			return isExists;
		
		if(i<0 || i>=board.length || j>=board[0].length || j<0)
			return isExists;
		if(j+1<board[0].length && !vis[i][j+1]) {				//1st check if the vertices are valid, then if visited ?
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
