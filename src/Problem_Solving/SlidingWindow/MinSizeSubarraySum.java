package Problem_Solving.SlidingWindow;

public class MinSizeSubarraySum {
	public static int minSubArrayLen(int target, int[] nums) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;

		while(end < nums.length) {
			sum = sum + nums[end];
			while(sum >= target && start <= end) {
				int len = end-start+1;
				min = Math.min(min, len);
				sum = sum - nums[start];
				start++;                
			}
			end++;
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
	
	public static void main(String[] args) {
		int nums[] = {2,3,1,2,4,3};
		int target = 7;
		int ans = minSubArrayLen(target, nums);
		System.out.println(ans);
	}
}
