package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class NoOfLongestIncreasingSubsequence {

	public static void main(String[] args) {
		int nums[] = {1,4,6,3,5};
		
        int lisAtEach = findNumberOfLIS(nums);
        System.out.println(lisAtEach);
	}
	
	// Working
	public static int findNumberOfLIS(int[] nums) {
        return lisEndingAt(nums);
    }

    public static int lisEndingAt(int[] nums) {
    	int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
		int count[] = new int[nums.length];
	    Arrays.fill(count, 1);
    	int max = lis[0];
    	
    	for (int i=1; i<nums.length; i++) {
	        for (int j=0; j<i; j++) {
	            
	        	if (nums[j] < nums[i]) {
	            	int tmp = 1 + lis[j]; 
	            	
	            	if(lis[i] == tmp) {
	            		count[i] = count[i] + count[j];
	            	} else if(tmp > lis[i]) {
	            		lis[i] = tmp;		// same as updating lis[i] in lisEndingAt
	            		max = Math.max(lis[i], max);
	            		count[i] = count[j];
	            	}
	            }
	        }
    	}
    	int answer = 0;
    	for(int i=0; i<nums.length; i++) {
    		if(lis[i] == max) {
    			answer = answer + count[i];
    		}
    	}
        return answer;
    }
    
}
