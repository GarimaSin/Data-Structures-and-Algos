package Problem_Solving.DP;

import java.util.Arrays;

public class UniquePaths2 {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1] == 1)
            return 0;
            
        int dp[][] = new int[m+1][n+1];
        for(int[] rows: dp)
            Arrays.fill(rows, -1);
        return uniquePaths(m, n, 0, 0, dp, obstacleGrid);
    }

    public static int uniquePaths(int m, int n, int r, int c, int[][] dp, int[][] grid) {
        if(r == m-1 && c == n-1)
            return 1;
        
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c] == 1)
            return 0;

        if(dp[r][c] != -1)
            return dp[r][c];
        
        int down = uniquePaths(m, n, r+1, c, dp, grid);
        int right = uniquePaths(m, n, r, c+1, dp, grid);
        dp[r][c] = down + right;
        return dp[r][c];
    }
    
    public static void main(String[] args) {
    	int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
    	System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}
}