package Problem_Solving.Matrix.TotalNoOfPaths_Same;

import java.util.Stack;
/**
 * 
 * No vis[], vis will be required when we are allowed to move up or left or both.
 * Same as TotNoOfUniquePathsInMaze but with vis[]
 * Try using DP
 *
 */

public class PrintAllPathsInAMaze {

	static int numberOfPaths(int m, int n) { 
		// If either given row number is first or given column number is first 
		if (m == 1 || n == 1) 
			return 1; 

		// If diagonal movements are allowed then the last addition is required. 
		return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1); 
		// + numberOfPaths(m-1, n-1); 
	} 

	public static void main(String args[]) { 
		System.out.println(numberOfPaths(3, 3)); 
		
		int[][] mat = { 	{ 1, 2, 3 }, 
                    			{ 4, 5, 6 }, 
                    			{ 7, 8, 9 }};
			Stack<Integer> path = new Stack<>();
			// start from (0, 0) cell
			int x = 0, y = 0;
			findPaths(mat, path, x, y);
	}

	public static void findPaths(int[][] mat, Stack<Integer> path, int i, int j)	{
		int M = mat.length;
		int N = mat[0].length;

		// if we have reached the last cell, print the route
		if (i == M - 1 && j == N - 1)	{
			path.add(mat[i][j]);
			System.out.println(path);
			path.pop();
			return;
		}
		// include current cell in path
		path.add(mat[i][j]);

		// move right
		if ((i >= 0 && i < M && j + 1 >= 0 && j + 1 < N)) { 
//				&& mat[i][j+1] == 1)) {
			findPaths(mat, path, i, j + 1);
		}

		// move down
		if ((i + 1 >= 0 && i + 1 < M && j >= 0 && j < N)) { 
//				&& mat[i+1][j] == 1)) {
			findPaths(mat, path, i + 1, j);
		}
		// remove current cell from path
		path.pop();
	}
}