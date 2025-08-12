package SWC_Codes_Office.src.test.src.Advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class advance {
	
	static int[][] maze = new int [5][5];
	static int[][] vis = new int [5][5];
	static int size = 5; 
	static int val = 1;
	@SuppressWarnings({ "resource" })
	public static void main(String a[]) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("adv.txt"));
		size = sc.nextInt();
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				maze[i][j]=sc.nextInt();
			}
		}
		
		
	}
	
	
	
	public static void calc(int[][] maze, int size, int ro, int co){
		if(ro<size && co<size && ro>=0 && co>=0){
			int num = maze[ro][co];
			vis[ro][co] = 1;
			if(ro+1<size && maze[ro+1][co] == num){
				calc(maze, size, ro+1, co);
				val++;
			}
			if(co+1<size && maze[ro][co+1] == num){
				calc(maze, size, ro, co+1);
				val++;
			}
			if(ro-1>=0 && maze[ro-1][co] == num){
				calc(maze, size, ro-1, co);
				val++;
			}
			if(co-1>=0 && maze[ro][co-1] == num){
				calc(maze, size, ro, co-1);
				val++;
			} else
				return;
		}
	}
}
