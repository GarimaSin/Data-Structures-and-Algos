package Problem_Solving.DP.ZeroOne_KnapSack;

public class SubsetSumProb {

	public static void main(String[] args) {
		int arr[] = {6, 1, 2, 1};
		int target = 4;
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
	static boolean ifSubsetExists(int[] inp, int target, Boolean[][] dp, int idx, int sum) {
		if(idx > inp.length || sum > target)						//Dont write idx >= inp.length, no =, coz it is checked at line 1 already.
			return false;

		if(idx == inp.length) {			//Line 1 /**Dont write inp.length-1 coz that will exclude adding the no. at the last index of the array **/ 
			if(sum == target)
				return true;
			else 
				return false;
		}

		if(dp[idx][sum] != null)
			return dp[idx][sum];
		else {
			Boolean i1 = ifSubsetExists(inp, target, dp, idx+1, sum + inp[idx]);
			if(i1)
                return dp[idx][sum] = true;
			Boolean i2 = ifSubsetExists(inp, target, dp, idx+1, sum);
			dp[idx][sum] = i1 || i2;
			return dp[idx][sum]; 
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