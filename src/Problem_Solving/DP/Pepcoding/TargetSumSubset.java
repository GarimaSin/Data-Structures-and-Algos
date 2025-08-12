package Problem_Solving.DP.Pepcoding;

public class TargetSumSubset {

	public static void main(String[] args) {
		int arr[] = {4,2,7,1,3};
		int target = 10;
		Boolean dp[][] = new Boolean[arr.length+1][target+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = null;
			}
		}
		System.out.println(ifSubsetExists(arr, target, dp, 0, 0));
		System.out.println(ifSubsetExistsTD(arr, target, dp));
	}


	//Working - mine
	static boolean ifSubsetExists(int[] inp, int target, Boolean[][] dp, int idx, int sumIdx) {
		if(idx >= inp.length || sumIdx > target)
			return false;

		if(idx == inp.length-1) {
			if(sumIdx == target)
				return true;
		}

		if(dp[idx][sumIdx] != null)
			return dp[idx][sumIdx];
		else {
			Boolean i1 = ifSubsetExists(inp, target, dp, idx+1, sumIdx + inp[idx]);
			Boolean i2 = ifSubsetExists(inp, target, dp, idx+1, sumIdx);
			dp[idx][sumIdx] = i1 || i2;
			return dp[idx][sumIdx]; 
		}
	}


	//Working
	static boolean ifSubsetExistsTD(int[] inp, int target, Boolean[][] dp) {
		dp[0][0] = true;

		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = false;
				} else if (j == 0) {
					dp[i][j] = true;
				} else {
					if(inp[i-1] <= j)
						dp[i][j] = dp[i-1][j-inp[i-1]] || dp[i-1][j];
					else 
						dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[inp.length][target]; 
	}
}