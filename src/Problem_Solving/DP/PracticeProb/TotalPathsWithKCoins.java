package Problem_Solving.DP.PracticeProb;
/**
 * 
 * DP:  Time complexity is O(m*n*k).
 *
 */
public class TotalPathsWithKCoins {
	static final int R = 3; 
	static final int C = 3; 
	static final int MAX_K = 100; 

	static int [][][]dp=new int[R][C][MAX_K]; 

	static int pathCountDPRecDP(int [][]mat, int m, int n, int k) { 
		// Base cases 
		if (m < 0 || n < 0) 
			return 0; 
		if (m==0 && n==0) 
			return (k == mat[m][n] ? 1 : 0); 

		// If this subproblem is already solved 
		if (dp[m][n][k] != -1) 
			return dp[m][n][k]; 

		// (m, n) can be reached either through (m-1, n) or through (m, n-1) 
		dp[m][n][k] = pathCountDPRecDP(mat, m-1, n, k-mat[m][n]) + 
				pathCountDPRecDP(mat, m, n-1, k-mat[m][n]); 

		return dp[m][n][k]; 
	} 

	static int pathCountDP(int [][]mat, int k) {
		for(int i=0;i<R;i++) 
			for(int j=0;j<C;j++) 
				for(int l=0;l<MAX_K;l++) 
					dp[i][j][l]=-1; 

		return pathCountDPRecDP(mat, R-1, C-1, k); 
	} 

	public static void main(String []args) {
		int k = 12; 
		int[][] mat = new int[][] {
			new int[] {1, 2, 3}, 
			new int[] {4, 6, 5}, 
			new int[] {4, 2, 1} 
		}; 
		System.out.println(pathCountDP(mat, k)); 
		pathCount(mat, 0, 0, 12, mat[0][0]);
		System.out.println(ans);
	} 

	//Working - no vis since we are not moving back in any path, back = left and up
	static int ans = 0;
	static void pathCount(int mat[][], int m, int n, int k, int count) { 
		// Base cases  
		if (m == mat.length-1 && n == mat[0].length-1 && count == k) { 
			ans = ans+1;
			return; 
		} 
		
		if(count > k)
			return;
		
		if (m+1 < mat.length && n < mat[0].length) { 
			pathCount(mat, m+1, n, k, count+mat[m+1][n]) ;
		}
		if (m < mat.length && (n+1) < mat[0].length) { 
			pathCount(mat, m, n+1, k, count+mat[m][n+1]); 
		}
	} 

	//Working w/o DP - Time = exponential
	static int pathCountRec(int mat[][], int m, int n, int k) { 
		// Base cases  
		if (m < 0 || n < 0) { 
			return 0; 
		} 
		if (m == 0 && n == 0 && (k == mat[m][n])) { 
			return 1; 
		} 

		// (m, n) can be reached either through (m-1, n) or through (m, n-1)  
		return pathCountRec(mat, m - 1, n, k - mat[m][n]) 
				+ pathCountRec(mat, m, n - 1, k - mat[m][n]); 
	} 

} 
