package Problem_Solving.Backtrack_Recur_DC;

public class Maximum_Subarray {

	static int max = 0;
	static int size = 0;
	
	public static void main(String[] args) {
		int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
		size = nums.length;
		maxSubArray(nums, 0, 0, new boolean[nums.length]);
		System.out.println(max);
	}

	public static int maxSubArray(int[] nums, int index, int sum, boolean vis[] ) {
		if(index >= size)
			return 0;
		if(sum > max) {
			max = sum;
		}
		
		if(nums.length == 0)
			return 0;
		else if(nums.length == 1)
			return nums[0];
		else {
			for(int i=0; i<nums.length; i++) {
				vis[i] = true;
				maxSubArray(nums, index+1, sum+nums[index], vis);
				vis[i] = false;
			}
		}
		return max;
			
	}
}
