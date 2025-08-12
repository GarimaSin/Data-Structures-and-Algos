package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class LongestBitonicSubsequence {

	
	// Working
	public static void main(String[] args) {
		int nums[] = {1, 11, 2, 10, 4, 5, 2, 1};
		
//		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int ans = allLisEndingAt(nums);
        System.out.println(ans);
	}
	
	
	public static int lisEndingAtiFromLeft(int[] nums, int i, int[] ans) {
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
            	ans[i] = Math.max(ans[i], 1 + ans[j]);
            }
        }
        return ans[i];
    }
	
	public static int lisEndingAtiFromRight(int[] nums, int i, int[] ans) {
        for (int j = nums.length-1; j >= i; j--) {
            if (nums[j] < nums[i]) {
            	ans[i] = Math.max(ans[i], 1 + ans[j]);
            }
        }
        return ans[i];
    }

    public static int allLisEndingAt(int[] nums) {
        int n = nums.length;
        int[] lis1 = new int[n];
        Arrays.fill(lis1, 1);
        
        int[] lis2 = new int[n];
        Arrays.fill(lis2, 1);

        for (int i=1; i < n; i++) 
        	lis1[i] = lisEndingAtiFromLeft(nums, i, lis1);
        
        for (int i=n-2; i >= 0; i--) 
        	lis2[i] = lisEndingAtiFromRight(nums, i, lis2);
        
        int max = 0;
        for(int i=0; i<lis1.length; i++) {
        	max = Math.max(max, lis1[i] + lis2[i] - 1);
        }
        return max;
    }
}
