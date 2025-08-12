package Problem_Solving.DP.ZeroOne_KnapSack;

public class CountOfSubsetSum {

	public static void main(String[] args) {
		int arr[] = {2,3,5,6,8,10};
		int target = 10;
		int dp[][] = new int[arr.length+1][target+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = 0;
			}
		}
		System.out.println(getSubsetCount(arr, target, dp, 0, 0, ""));
		System.out.println(getSubsetCountTD(arr, target, dp));
	}


	//Working - mine
	static int getSubsetCount(int[] inp, int target, int[][] dp, int idx, int sumIdx, String ans) {
		if(idx > inp.length || sumIdx > target)					//Dont write idx >= inp.length, no =, coz it is checked at line 1 already.
			return 0;

		/**Dont write inp.length-1 coz that will exclude adding the no. at the last index of the array to the answer **/
		if(idx == inp.length ) {			//Line 1 
			if(sumIdx == target)
				return 1;
			else 
				return 0;
		}

		if(dp[idx][sumIdx] != 0)
			return dp[idx][sumIdx];
		else {
			int i1 = getSubsetCount(inp, target, dp, idx+1, sumIdx + inp[idx], ans+inp[idx]);
			int i2 = getSubsetCount(inp, target, dp, idx+1, sumIdx, ans);
			dp[idx][sumIdx] = i1 + i2;
			return dp[idx][sumIdx]; 
		}
	}


	//Working
	static int getSubsetCountTD(int[] inp, int target, int[][] dp) {
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = 1;
				} else if (i == 0) {
					dp[i][j] = 0;
				} else if (j == 0) {
					dp[i][j] = 1;
				} else {
					if(inp[i-1] <= j)
						dp[i][j] = dp[i-1][j-inp[i-1]] + dp[i-1][j];
					else 
						dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[inp.length][target]; 
	}
}