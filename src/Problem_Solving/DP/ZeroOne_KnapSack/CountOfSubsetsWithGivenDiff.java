package Problem_Solving.DP.ZeroOne_KnapSack;

import java.util.Arrays;

public class CountOfSubsetsWithGivenDiff {

	public static void main(String[] args) {
		int inp[] = {1, 3, 3, 2, 1};
		int diff = 5;
		System.out.println(countPartitions(inp, diff));
	}

	static int countPartitions(int[] nums, int diff) {
        int totSum = 0, tmp = 0;
        for(int i: nums) {
			totSum = totSum + i;
			tmp = tmp + Math.abs(i);
		}
		
		if((totSum+diff)%2 == 1)
		    return 0;
        
		int dp[][] = new int[nums.length+1][tmp+1];
		for (int i[]: dp) 
			Arrays.fill(i, -1);;
		
		return getCountOfSubsetsMine(nums, dp, 0, 0, diff, totSum);
    }
    
    public static int getCountOfSubsetsMine(int[] nums, int[][] dp, int idx, int sum, int diff, int totSum) {
		if(idx == nums.length) {	
			if(sum == (totSum+diff)/2)
				return 1;
			return 0;
		}

		if(dp[idx][sum] != -1) {
			return dp[idx][sum];
		}
		else {
			int i1 = getCountOfSubsetsMine(nums, dp, idx+1, sum + nums[idx], diff, totSum);
			int i2 = getCountOfSubsetsMine(nums, dp, idx+1, sum, diff, totSum);
			int ans = i1+i2;
			dp[idx][sum] = ans;
			return ans; 
		}
	}
}