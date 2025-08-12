package Problem_Solving.DP.PracticeProb;

//https://www.geeksforgeeks.org/count-strings-can-formed-using-b-c-given-constraints/
public class CountStringPermutation {

	static int countStrUtil(int[][][] dp, int n, int bCount, int cCount) { 
		if (bCount < 0 || cCount < 0) {
			return 0; 
		} 
		if (n == 0) {
			return 1; 
		} 
		if (bCount == 0 && cCount == 0) {  
			return 1; 
		} 

		// if we had seen this combination previously  
		if (dp[n][bCount][cCount] != -1) { 
			return dp[n][bCount][cCount]; 
		} 

		// Three cases, we choose, a or b or c. In all three cases n decreases by 1.  
		int res = countStrUtil(dp, n - 1, bCount, cCount); 
		res += countStrUtil(dp, n - 1, bCount - 1, cCount); 
		res += countStrUtil(dp, n - 1, bCount, cCount - 1); 

		return (dp[n][bCount][cCount] = res); 
	} 


	static int countStr1(int n, int bCount, int cCount, String ans) {
		if (bCount < 0 || cCount < 0) 
			return 0;
		if (n == 0) 
			return 1;
		if (bCount == 0 && cCount == 0) {
			System.out.println(ans);
			return 1;
		}

		// Three cases, we choose, a or b or c
		// In all three cases n decreases by 1.
		int res = countStr1(n - 1, bCount, cCount, ans+"a");				//Choose a
		res += countStr1(n - 1, bCount - 1, cCount, ans+"b");			//Choose b
		res += countStr1(n - 1, bCount, cCount - 1, ans+"c");			//Choose c

		return res;
	}

	// A wrapper over countStrUtil()  
	static int countStr(int n, int bCount, int cCount) {
		int[][][] dp = new int[n + 1][2][3]; 
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] = -1; 
				} 
			} 
		} 
		return countStrUtil(dp, n,bCount,cCount); 
	} 

	public static void main(String[] args) {
		int n = 3; // Total number of characters  
		int bCount = 1, cCount = 2; 
//		System.out.println(countStr(n,bCount,cCount)); 
		System.out.println(countStr1(n,bCount,cCount, "")); 
	} 
}
