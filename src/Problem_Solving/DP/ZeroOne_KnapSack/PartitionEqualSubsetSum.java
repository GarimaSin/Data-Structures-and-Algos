package Problem_Solving.DP.ZeroOne_KnapSack;

public class PartitionEqualSubsetSum {
	
	public static void main(String[] args) {
		int[] nums = {1,5,11,5};
		int sum = 0;
        int setSize = 2;
        
		for(int i=0; i<nums.length; i++) {
			sum = sum + nums[i];
		}
		Boolean[][] dp = new Boolean[nums.length+1][sum/2+1];
		if(sum%setSize == 0) {
			System.out.println(getPartitions(nums, sum/2, dp, 0, 0));
//			ifSubsetExists(nums, dp, 0, 0, 0, sum/2);
		} 
        else
		    System.out.println(false);
	}
	
	
	//Working - check this sol
	boolean ifSubsetExists(int[] inp, Boolean[][] dp, int idx, int sum1, int sum2, int half) {
		if(idx > inp.length || sum1 > half || sum2 > half)
			return false;

		if(idx == inp.length) {
			if(sum1 == sum2)
				return true;
			else 
				return false;
		}

		if(dp[idx][sum1] != null)
			return dp[idx][sum1];
		else {
			Boolean i1 = ifSubsetExists(inp, dp, idx+1, sum1+inp[idx], sum2, half);
			Boolean i2 = ifSubsetExists(inp, dp, idx+1, sum1, sum2+inp[idx], half);
			dp[idx][sum1] = i1 || i2;
			return dp[idx][sum1]; 
		}
	}
	
	//Working
	private static boolean getPartitions(int[] nums, int target, Boolean[][] dp, int idx, int sum) {
		if(idx > nums.length || sum > target)			//Dont write idx >= inp.length, no =, coz it is checked at line 1 already.
			return false;

		/**Dont write inp.length-1 coz that will exclude adding the no. at the last index of the array to the answer **/
		if(idx == nums.length) {		//Line 1 
			if(sum == target)
				return true;
			else 
				return false;
		}

		if(dp[idx][sum] != null)
			return dp[idx][sum];
		else {
			Boolean i1 = getPartitions(nums, target, dp, idx+1, sum + nums[idx]);
			Boolean i2 = getPartitions(nums, target, dp, idx+1, sum);
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
	
	
	// Working - TLE
	boolean isPossible = false;
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for(int i=0; i<nums.length; i++) {
			sum = sum + nums[i];
		}
		if(sum%2 == 0) {
			partitionKSubsets(nums, new boolean[nums.length], 0, 2, 0, 0, sum/2, "");
			return isPossible;
		} else
			return isPossible;
	}

	private int partitionKSubsets(int[] nums, boolean[] vis, int start, int k, int currSum, int noOfPartitions, 
			int targetSum, String ans) {
		
		if(currSum > targetSum)
			return noOfPartitions;
		
		if(currSum == targetSum) {
			noOfPartitions = noOfPartitions +1;
			currSum = 0;
			if(noOfPartitions >= 2) 
				isPossible = true;
			return noOfPartitions;
		}
		
		for(int i=start; i<nums.length; i++) {
			if(!vis[i]){
        		vis[i] = true;
        		noOfPartitions = partitionKSubsets(nums, vis, i, k, currSum + nums[i], noOfPartitions, targetSum, ans+nums[i]);
        		if(isPossible) {
        			break;
        		}
        		vis[i] = false;
			}
		}
		return noOfPartitions;
	}
}
