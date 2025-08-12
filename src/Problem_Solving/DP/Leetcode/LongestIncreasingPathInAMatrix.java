package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

//Working
public class LongestIncreasingPathInAMatrix {
	public static void main(String[] args) {
		int[][] mat = {{3,4,5},{3,2,6},{2,2,1}};
		int[][] memo = new int [mat.length+1][mat[0].length+1];
		for(int[] l: memo) {
			Arrays.fill(l, -1);
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				int ans = findLongestPath1(mat, new boolean[mat.length][mat[0].length], i, j, memo);
				max = Math.max(max, ans);
			}
		}
		System.out.println(max+1);
	}

	
	static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	//	static int max1 = Integer.MIN_VALUE;
	//Working
	public static int findLongestPath(int mat[][], boolean vis[][], int i, int j, int[][] memo)  {
		if(memo[i][j] == -1) {
			int d1 = 0, d2 = 0, d3 = 0, d4 = 0;
			int tmp = mat[i][j];
			if(isSafe(i+1, j, mat, vis, tmp)) {
				vis[i+1][j] = true;
				d1 = 1 + findLongestPath(mat, vis, i+1, j, memo);
				vis[i+1][j] = false;
			}
			if(isSafe(i, j+1, mat, vis, tmp)) {
				vis[i][j+1] = true;
				d2 = 1 + findLongestPath(mat, vis, i, j+1, memo);
				vis[i][j+1] = false;
			}
			if(isSafe(i-1, j, mat, vis, tmp)) {
				vis[i-1][j] = true;
				d3 = 1 + findLongestPath(mat, vis, i-1, j, memo);
				vis[i-1][j] = false;
			}
			if(isSafe(i, j-1, mat, vis, tmp)) {
				vis[i][j-1] = true;
				d4 = 1 + findLongestPath(mat, vis, i, j-1, memo);
				vis[i][j-1] = false;
			}
			memo[i][j] = Math.max(d1, Math.max(d2, Math.max(d3, d4)));
		}
		return memo[i][j];
	}

	
	//Working - but giving wrong ans with static var max1.
	public static int findLongestPath1(int mat[][], boolean vis[][], int i, int j, int[][] memo)  {
		int max1 = 0;
		if(memo[i][j] == -1) {
			for (int k = 0; k < dir.length; k++) {
				int x = i+dir[k][0];
				int y = j+dir[k][1];
				int tmp = mat[i][j];
				if(isSafe(x, y, mat, vis, tmp)) {
					vis[x][y] = true;
					max1 = Math.max(max1, 1 + findLongestPath1(mat, vis, x, y, memo));
					vis[x][y] = false;
				}
			}
			memo[i][j] = max1;
		}
		return memo[i][j];
	}

	
	static boolean isSafe(int i, int j, int[][] mat, boolean[][] vis, int prev) {
		if(i >=0 && j >=0 && i < mat.length && j < mat[0].length && prev < mat[i][j] && !vis[i][j])
			return true;
		return false;
	}
}