package SWC_Codes_Office.src.test.src.Advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class rook {
	static int size;
	static int[][] row;
	static int[][] col;
	static int[][] visited;
	
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("rook.txt"));
		int T=sc.nextInt();
		for(int t=0;t<1;t++) {
			int size = sc.nextInt();
			int sol = -1;
			int[][] board = new int[size][size];
			int[][] visited = new int[size][size];
			int[][] row = new int[2][size];
			int[][] col = new int[2][size];
			boolean flag = false;
			int posX = -1; 
			int posY = -1;
			for(int i=0; i<size; i++){
				for(int j=0; j<size; j++){
					visited[i][j]=0;
					String c = sc.next();
					if(c.equalsIgnoreCase("X"))
						if(!flag) {
							posX = i; 
							posY = j;
							flag = true;
						} 
						else {
							board[i][j] = -1;
							row[1][i] = 1;
							col[1][i] = 1;
						}
					else
						board[i][j] = 0;
				}
			}
			if(!flag)
				sol = size;
			else {
				fillBoard(board, posX, posY);
			}
			
			for(int i=0; i<size; i++){
				for(int j=0; j<size; j++){
					if(board[i][j] == -1 && visited[i][j] == 0) { 
						fillBoard(board, posX, posY);
						visited[posX][posY] = 1;
					}
				}
			}
			
			System.out.println("Case #"+t);
			System.out.println(sol);
		}
	}
		
		
	private static int[][] fillBoard(int[][] board, int posX, int posY) {
		if(row[0][posX-1] == 0 && col[0][posY] == 0){
			board[posX-1][posY] = 1;
			row[0][posX-1] = 1;
			col[0][posY] = 1;
		}
		if(row[0][posX+1] == 0 && col[0][posY] == 0) {
			board[posX+1][posY] = 1;
			row[0][posX+1] = 1; 
			col[0][posY] = 1;
		}
		if(row[0][posX] == 0 && col[0][posY-1] == 0) {
			board[posX][posY-1] = 1;
			row[0][posX] = 1; 
			col[0][posY-1] = 1;
		}
		if(row[0][posX] == 0 && col[0][posY+1] == 0) {
			board[posX][posY+1] = 1;
			row[0][posX] = 1;
			col[0][posY+1] = 1;
		}
		
		return board;
	}
}
