package Problem_Solving.Blind75.Array;

public class MaxProdSubarray {
	
	public static void main(String[] args) {
		int nums[] = {2,3,-2,4};
		int ans = maxProduct(nums);
		System.out.println(ans);
	}
	
	
	public static int maxProduct(int[] nums) {
		int min = nums[0];
		int max = nums[0];
		int max_so_far = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			int tmp = max;
			max = Math.max(nums[i], Math.max(max*nums[i], min*nums[i]));
			min = Math.min(nums[i], Math.min(tmp*nums[i], min*nums[i]));
			max_so_far = Integer.max(max_so_far, max);
		}
		return max_so_far;
	}
}
