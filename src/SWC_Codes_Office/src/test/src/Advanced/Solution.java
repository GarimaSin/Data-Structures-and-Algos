package SWC_Codes_Office.src.test.src.Advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("chemical.txt"));
		int T=sc.nextInt();
		for(int t=0;t<1;t++) {
			int size = sc.nextInt();
			int[][] arr = new int[size][size];
			for(int row=0; row<size; row++){
				for(int col=0; col<size; col++){
					arr[row][col] = sc.nextInt();
				}
			}
			int startCol = 0, startRow = 0;
			int endCol = 0, endRow = 0;
			boolean found = false;
			for(int row=0; row<size; row++){
				for(int col=0; col<size; col++){
					if(arr[row][col] != 0 && found == false){
						startCol = col;
						startRow = row;
						found = true;
					} else if(arr[row][col] != 0 && found == true && row == startRow){
						endCol = col;
					}
				}
				checkSubMatrix(arr, startRow, startCol, endCol, size);
			}
			printSol(arr, size);
		}
	}
	
	private static void checkSubMatrix(int[][] arr, int startRow, int startCol, int endCol, int size) {
		for(int row=0; row<size; row++){
			for(int col=0; col<size; col++){
				
			}
		}
	}

	static void printSol(int[][] arr, int size){
		for(int row=0; row<size; row++){
			for(int col=0; col<size; col++){
				System.out.print(arr[row][col]);
			}
			System.out.println("");
		}
	}
}
