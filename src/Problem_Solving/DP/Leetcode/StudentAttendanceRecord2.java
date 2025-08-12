package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class StudentAttendanceRecord2 {

	public static void main(String[] args) {
		int n = 2;
		checkRecord(n);
	}
	
	private static final int MOD = 1_000_000_007;
	public static int checkRecord(int n) {
		int[][][] dp = new int[n+1][2][3];
		for(int[][] i: dp)
			for(int[] j: i)
				Arrays.fill(j, -1);
		return checkRecord(n, 0, 0, dp);
	}


	static int checkRecord(int n, int absent, int consecL, int[][][] dp) {	
		if(n==0) 
			return 1;
		
		if(dp[n][absent][consecL] != -1)
			return dp[n][absent][consecL];
		
		int A=0, L=0, P=0;
		if(absent == 0)
			A = checkRecord(n-1, absent+1, 0, dp);	// abs
		if(L <= 1)
			L = checkRecord(n-1, absent, consecL+1, dp);	// late
		P = checkRecord(n-1, absent, 0, dp);	// present
		
		return dp[n][absent][consecL] = ((A+L)%MOD+P)%MOD;
	}
	
}
