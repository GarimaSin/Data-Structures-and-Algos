package Problem_Solving.DP.Leetcode;

public class CountSquareSubmatricesWithAllOnes {

	public static void main(String[] args) {
		
	}
	
	public int countSquares(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        // System.out.println(r+", "+c);
        return countSquares(r, c, matrix, new int[r][c]);
    }
	
	int countSquares (int n, int m, int[][] arr, int[][] dp) { 
		for (int j = 0; j<m; j++) 
			dp[0][j] = arr[0][j];
		
		for (int i=0;i<n;i++) 
			dp[i][0] = arr[i][0];
		
		for (int i=1; i<n; i++) {
			for (int j=1; j<m; j++) {
				if(arr[i][j] == 0) 
					dp[i][j] = 0; 
				else {
					dp[i][j] = 1 + Math.min(dp[i-1][j], 
							Math.min(dp[i-1][j-1], dp[i-1][j]));
				}
			}
		}
		int sum = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m;j++) {
				sum += dp[i][j];
			}
		}
		return sum;
	}

}
