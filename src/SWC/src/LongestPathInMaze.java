	//Working

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestPathInMaze {

	static int size = 0;
	static int[][] maze;
	static int[][] vis;
	static int max = 0;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("LongestPathInMaze.txt"));
        int T = sc.nextInt();
        for(int t=0; t<1; t++){
        	size = sc.nextInt();
        	maze = new int[size][size];
        	vis = new int[size][size];
        	for(int i=0; i<size; i++){
        		for(int j=0; j<size; j++){
        			maze[i][j] = sc.nextInt();
        		}
        	}
        	
        	for(int i=0; i<size; i++){
        		for(int j=0; j<size; j++){
        			if(maze[i][j] == 1){
        				vis[i][j] = 1;
        				findPath(i, j, 1);
        				vis[i][j] = 0;
        			}
        		}
        	}
        	System.out.println(max+"...");
        }
	}
	private static void findPath(int i, int j, int len) {
		if(max < len)
			max = len;
		if((i+1) < size && maze[i+1][j]==1 && vis[i+1][j]==0){
			vis[i+1][j] = 1;
			findPath(i+1, j, len+1);
			vis[i+1][j] = 0;
		}
		if((j+1) < size && maze[i][j+1]==1 && vis[i][j+1]==0){
			vis[i][j+1] = 1;
			findPath(i, j+1, len+1);
			vis[i][j+1] = 0;
		}
		if((i-1) > 0 && maze[i-1][j]==1 && vis[i-1][j]==0){
			vis[i-1][j] = 1;
			findPath(i-1, j, len+1);
			vis[i-1][j] = 0;
		}
		if((j-1) > 0 && maze[i][j-1]==1 && vis[i][j-1]==0){
			vis[i][j-1] = 1;
			findPath(i, j-1, len+1);
			vis[i][j-1] = 0;
		}
	}

}
