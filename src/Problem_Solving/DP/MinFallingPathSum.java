package Problem_Solving.DP;

import java.util.Arrays;

public class MinFallingPathSum {

	//Working DP sol but gives TLE in LC
	public static int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int[] rows: dp)
            Arrays.fill(rows, -1);

        int min = 99999999;
        for(int i=0; i<n; i++) {
            int ans = minPathSum(m, n, 0, i, dp, grid);
            min = Math.min(min, ans);
        }
        return min;
    }

    public static int minPathSum(int m, int n, int r, int c, int[][] dp, int[][] grid) {
        if(r<0 || c<0 || r>=m || c>=n)
            return 9999999;

        if(r == m-1)
            return grid[r][c];

        if(dp[r][c] != -1)
            return dp[r][c];

        int a1 = minPathSum(m, n, r+1, c-1, dp, grid);
        int a2 = minPathSum(m, n, r+1, c, dp, grid);
        int a3 = minPathSum(m, n, r+1, c+1, dp, grid);
        int min = Math.min(Math.min(a1,a2), a3);
        dp[r][c] = grid[r][c] + min;
        return dp[r][c];
    }
    
    public static void main(String[] args) {
    	int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
    	System.out.println(minFallingPathSum(matrix));
	}
}