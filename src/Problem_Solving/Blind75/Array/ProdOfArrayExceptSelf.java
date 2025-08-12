package Problem_Solving.Blind75.Array;

public class ProdOfArrayExceptSelf {

	public static void main(String[] args) {
		int nums[] = {1,2,3,4};
		int ans[] = productExceptSelf1(nums);
		for(int i: ans) {
			System.out.print(i + " ");
		}
	}


	//Time = O(n) = space
	public static int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int pre[] = new int[len];
		int post[] = new int[len];
		int ans[] = new int[len];

		for(int i=0; i<len; i++) {
			if(i != 0)
				pre[i] = pre[i-1] * nums[i];
			else
				pre[i] = nums[i];
		}
		for(int i = len-1; i>=0; i--) {
			if(i != len-1)
				post[i] = post[i+1] * nums[i];
			else
				post[i] = nums[i];
		}
		for(int i=0; i<len; i++) {
			if(i != 0 && i != len-1)
				ans[i] = pre[i-1] * post[i+1];
			else if(i == 0)
				ans[i] = post[i+1];
			else if(i == len-1)
				ans[i] = pre[i-1];
		}
		return ans;
	}

	// Time = O(n), space = O(1)
	public static int[] productExceptSelf1(int[] nums) {
		int len = nums.length;
		int ans[] = new int[len];

		for(int i=0; i<len; i++) {
			if(i != 0)
				ans[i] = ans[i-1] * nums[i];
			else
				ans[i] = nums[i];
		}
		
		int post = 1;
		
		for(int i = len-1; i>=0; i--) {
			if(i != 0) {
				ans[i] = ans[i-1] * post;
			}
			else
				ans[i] = post;
			post = post * nums[i];
		}

		return ans;
	}
}
