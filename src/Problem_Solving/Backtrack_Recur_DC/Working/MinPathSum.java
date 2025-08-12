package Problem_Solving.Backtrack_Recur_DC.Working;

import java.util.Arrays;

public class MinPathSum {

	static int[][] memo;

	public static int minPathSum(int[][] grid) {
		int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int[] rows: dp)
            Arrays.fill(rows, -1);
        return minPathSum(m, n, 0, 0, dp, grid);
	}

	public static int minPathSum(int m, int n, int r, int c, int[][] dp, int[][] grid) {
        if(r == m-1 && c == n-1)
            return grid[r][c];
        
        if(r<0 || c<0 || r>=m || c>=n)
            return 9999999;

        if(dp[r][c] != -1)
            return dp[r][c];

        int a = grid[r][c] + minPathSum(m, n, r+1, c, dp, grid);
        int b = grid[r][c] + minPathSum(m, n, r, c+1, dp, grid);
        int min = Math.min(a,b);
        dp[r][c] = min;
        return min;
    }

	//	public static int find(int grid[][], int m, int n, int[][] memo) {
	//		if(memo[m][n]!=0)
	//			return memo[m][n];
	//		else {
	//			int d1 = 9999, d2 = 9999;
	//			if(isSafe(m+1, n, grid)) {
	//				d1 = grid[m][n] + find(grid, m+1, n, memo);
	//			}
	//			if(isSafe(m, n+1, grid)) {
	//				d2 = grid[m][n] + find(grid, m, n+1, memo);
	//			}
	//			memo[m][n] = Math.min(d1, d2);
	//			return memo[m][n];
	//		}
	//	}

	static boolean isSafe(int i, int j, int[][] mat) {
		if(i >=0 && j >=0 && i < mat.length && j < mat[0].length)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int grid[][] = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(grid));
	}
}

