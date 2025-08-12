package Problem_Solving.Blind75.DP;

import java.util.Arrays;

//Working sol
public class HouseRobber2 {

	public static void main(String[] args) {
		int nums[] = {1,2,3,1};
		System.out.println(rob1(nums));
	}
    
    //Working
    public static int rob1(int[] nums) {
		int n = nums.length;
		int dp[] = new int[n];

		Arrays.fill(dp, -1);
		int s1 = rob1(nums, 0, nums.length-1, dp);

		Arrays.fill(dp, -1);
		int s2 = rob1(nums, 1, nums.length, dp);
		return Math.max(s1, s2);
	}

	public static int rob1(int[] nums, int index, int end, int[] dp) {
		if(index >= end) 
			return 0;

		if(dp[index] != -1)
			return dp[index];

		//	      if(prev != index-1)			no need of this since already using index-2
		int a = nums[index] + rob1(nums, index+2, end, dp);	
		int b = rob1(nums, index+1, end, dp);
		int s = Math.max(a,b);
		dp[index] = s;

		return s;
	}
	
	//Working
	public int rob(int[] nums) {
        int n = nums.length;
		int dp[][] = new int[n][n];
        
        for(int a[]: dp)
		    Arrays.fill(a, -1);
		return rob2(nums, 0, 0, dp);
    }

    public int rob2(int[] nums, int index, int firstRobbed, int[][] dp) {
		if(index >= nums.length-1 && firstRobbed == 1) 		// if 1st index is robbed		
			return 0;
		
		if(index >= nums.length) 
			return 0;

		if(dp[index][firstRobbed] != -1)
			return dp[index][firstRobbed];

        int a = 0, b = 0;
        if(index == 0) {
            a = nums[index] + rob2(nums, index+2, 1, dp);	// 1st index is robbed
            b = rob2(nums, index+1, 0, dp);					// 1st index is skipped
        } else {
            a = nums[index] + rob2(nums, index+2, firstRobbed, dp);
            b = rob2(nums, index+1, firstRobbed, dp);   
        }
		int s = Math.max(a,b);
		dp[index][firstRobbed] = s;
		return s;
	}
}