package Problem_Solving.SlidingWindow;

import java.util.HashMap;

public class LongestSubArrayWithSumK {

	public static int lenOfLongSubarr (int A[], int N, int K) {
        int sum = 0;
        int i = 0;
        int max = 0;
        
        for(int j=0; j<A.length; j++) {
            sum = sum + A[j];
            if(sum == K) {
                max = Math.max(max, j-i+1);
                System.out.println(max);
            } else {
                while(sum > K) {
                    sum = sum - A[i];
                    i++;
                } 
            }
        }
        return max;
    }
	
	public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int j=0; j<nums.length; j++) {
            sum = sum + nums[j];
            if(sum >= target) {
                min = Math.min(min, j-i+1);
                while(sum > target) {
                    sum = sum - nums[i];
                    i++;
                }
            }
        }
        return min;
    }
	
	public static void main(String[] args) {
		int[] nums = {-13,0,6,15,16,2,15,-12,17,-16,0,-3,19,-3,2,-9,-6};
		int N = nums.length;
		int k = 15;
		int ans = lenOfLongSubarr(nums, N, k);
		System.out.println(ans+"-------");
//		minSubArrayLen(k, nums);
	}
}
