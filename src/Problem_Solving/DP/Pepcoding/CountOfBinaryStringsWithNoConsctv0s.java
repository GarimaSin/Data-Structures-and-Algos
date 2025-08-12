package Problem_Solving.DP.Pepcoding;

public class CountOfBinaryStringsWithNoConsctv0s {

	public static void main(String[] args) {
		int n = 6;
		countBinaryStringsMine(n, 0, 0);
		countBinaryStringsMine(n, 0, 1);
		System.out.println(ans);
		int dp[] = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = -1;
		}
		int i1 = countBinaryStringsMine(n, 0, 0, dp);
		int i2 = countBinaryStringsMine(n, 0, 1, dp);
		System.out.println(i1+i2);
	}
	
	static int ans = 0;
	
	//Recursive - working
	static void countBinaryStringsMine(int count, int idx, int prev) {
		if(idx == count-1) {
			ans = ans+1;
			return;
		}
		
		if(prev != 0) {
			countBinaryStringsMine(count, idx+1, 0);
			countBinaryStringsMine(count, idx+1, 1);
		} else {
			countBinaryStringsMine(count, idx+1, 1);
		}
	} 
	
	//Not working
	static int countBinaryStringsMine(int count, int idx, int prev, int[] dp) {
		if(idx == count-1) {
			return 1;
		}
		
		if(dp[idx] != -1)
			return dp[idx];
		else {
			int i1 = 0, i2 = 0, i3 = 0;
			if(prev != 0) {
				i1 = countBinaryStringsMine(count, idx+1, 0, dp);
				i2 = countBinaryStringsMine(count, idx+1, 1, dp);
			} else {
				i3 = countBinaryStringsMine(count, idx+1, 1, dp);
			}
			dp[idx] = i1+i2+i3;
			return dp[idx];
		}
	} 
}
