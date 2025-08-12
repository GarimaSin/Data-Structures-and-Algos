package Problem_Solving.DP;

import java.util.Arrays;

public class UniquePaths {

	public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for(int[] rows: dp)
            Arrays.fill(rows, -1);
        return uniquePaths(m, n, 0, 0, dp);
    }

    public static int uniquePaths(int m, int n, int r, int c, int[][] dp) {
        if(r == m-1 && c == n-1)
            return 1;
        
        if(r<0 || c<0 || r>=m || c>=n)
            return 0;

        if(dp[r][c] != -1)
            return dp[r][c];
        
        int down = uniquePaths(m, n, r+1, c, dp);
        int right = uniquePaths(m, n, r, c+1, dp);
        dp[r][c] = down + right;
        return dp[r][c];
    }
    
    public static void main(String[] args) {
    	System.out.println(uniquePaths(4, 4));
	}
}