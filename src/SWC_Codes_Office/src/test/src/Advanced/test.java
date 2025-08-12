package SWC_Codes_Office.src.test.src.Advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;



public class test {
	
	static int maze[][];
	static int row = 0;
	static int col = 0;
	static Stack<Integer> st = new Stack<Integer>();
	static Positon[] pos;
	static int i = 0, count = 0;
	
	public static void main(String args[]) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileInputStream("bomb.txt"));
		int T=sc.nextInt();
		for(int t=1;t<=1;t++) {
			col = sc.nextInt();
			row = sc.nextInt();
			maze = new int[row][col];
			pos = new Positon[row*4];
			for(int l=0; l<row; l++){
				for(int j=0; j<col; j++){
					maze[l][j] = sc.nextInt();
				}
			}
			
			int bombX = sc.nextInt();
			int bombY = sc.nextInt();
			System.out.println(bombX+"    "+bombY);
			maze[bombX][bombY] = -100;
			fill(maze, bombX, bombY);
			printMaze(maze, row, col);
		}
	}

	private static int fillMaze(int[][] maze2, int bombX, int bombY, int sec) {
		if(bombX <= 0 || bombX >= row || bombY <=0 || bombY >= col || maze[bombX][bombY] != 1) {
			return sec;
		} else {
			count = 0;
			if(maze[bombX-1][bombY] == 1){
				pos[i].x=bombX-1;
				pos[i].y=bombY;
				pos[i].itr=count+1;
				i++;
			}
			if(maze[bombX+1][bombY] == 1){
				pos[i].x=bombX+1;
				pos[i].y=bombY;
				pos[i].itr=count+1;
				i++;
			}
			if(maze[bombX][bombY-1] == 1){
				pos[i].x=bombX;
				pos[i].y=bombY-1;
				pos[i].itr=count+1;
				i++;
			}
			if(maze[bombX][bombY+1] == 1){
				pos[i].x=bombX;
				pos[i].y=bombY+1;
				pos[i].itr=count+1;
				i++;
			}
		}
		
		return sec;
	}

	private static void printMaze(int[][] maze2, int row, int col) {
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				System.out.print(maze[i][j]);
			}
			System.out.println(" ");
		}
	}
	
	public static int fill(int[][] maze, int x, int y){
		count = 1;
		//UP
		if(maze[x-1][y] == 1) {
			pos[i] = new Positon(x-1, y, count);
			i++;
		}
		
		//RIGHT
		if(maze[x][y+1] == 1) {
			pos[i] = new Positon(x, y+1, count);
			i++;
		}
		
		//DOWN
		if(maze[x+1][y] == 1) {
			pos[i] = new Positon(x+1, y, count);
			i++;
		}
		
		//LEFT
		if(maze[x][y-1] == 1) {
			pos[i] = new Positon(x, y-1, count);
			i++;
		}
		
		for(int a=0; a<i; a++){
			calculateNei(pos[a].x, pos[a].y, count+1);
			maze[pos[a].x][pos[a].y] = -1;
		}
		count++;
		return 0;
	}
	
	public static void calculateNei(int x, int y, int count){
		if(x < 0 || y >= row || y < 0 || x >= col || maze[x][y] != 1) {
			return;
		} else {
			//UP
			if(maze[x-1][y] == 1) {
				pos[i] = new Positon(x-1, y, count);
				i++;
			}
			
			//RIGHT
			if(maze[x][y+1] == 1) {
				pos[i] = new Positon(x, y+1, count);
				i++;
			}
			
			//DOWN
			if(maze[x+1][y] == 1) {
				pos[i] = new Positon(x+1, y, count);
				i++;
			}
			
			//LEFT
			if(maze[x][y-1] == 1) {
				pos[i] = new Positon(x, y-1, count);
				i++;
			}
		}
	}

}


class Positon{
	int x = -100;
	int y = -100;
	int itr = 0;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public Positon(int x, int y, int itr){
		this.x = x;
		this.y = y;
		this.itr = itr;
	}
}