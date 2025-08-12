package Problem_Solving.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		int m = matrix.length, n = matrix[0].length;

		int top = 0, down = m-1, left = 0, right = n-1, direc = 0;

		while(top <= down && left <= right) {
			if(direc == 0) {
				for(int i = left; i <= right; i++)
					list.add(matrix[top][i]);
				top++;
				direc = 1;
			}
			else if(direc == 1) {
				for(int i = top; i <= down; i++)
					list.add(matrix[i][right]);
				right--;
				direc = 2;
			}
			else if(direc == 2) {
				for(int i = right; i >= left; i--)
					list.add(matrix[down][i]);
				down--;
				direc = 3;
			}
			else if(direc == 3) {
				for(int i = down; i >= top; i--)
					list.add(matrix[i][left]);
				left++;
				direc = 0;
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int mat[][] = { {1, 2, 3, 4}, 
				{5, 6, 7, 8}, 
				{9, 10, 11, 12},
				{13, 14, 15, 16}}; 

		spiralOrder(mat); 
	}
}
