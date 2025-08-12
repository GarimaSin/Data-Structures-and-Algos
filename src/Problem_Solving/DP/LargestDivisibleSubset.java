package Problem_Solving.DP;

import java.util.Arrays;

public class LargestDivisibleSubset {

	public static int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo) {
		if(curpos > nums.length)
			return 0;
		
		if(curpos == nums.length)
			return 1;
		
		if(memo[previndex+1][curpos] == -1) {
			int a1 = 0, a2 = 0;
			if(previndex < 0 || nums[curpos] % nums[previndex] == 0) 
				a1 = 1+ lengthofLIS(nums, curpos, curpos+1, memo);
			
			a2 = lengthofLIS(nums, previndex, curpos+1, memo);
			memo[previndex+1][curpos] = Math.max(a1, a2);
		}
		return memo[previndex+1][curpos];
	}
	
	public static void main(String[] args) {
		int nums[] = {1,2,3};
		Arrays.sort(nums);
		int memo[][] = new int[nums.length + 1][nums.length];
		for (int[] l : memo) {
			Arrays.fill(l, -1);
		}
		System.out.println(lengthofLIS(nums, -1, 0, memo));
	}
}
