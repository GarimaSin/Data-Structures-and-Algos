package Problem_Solving.Blind75.DP;

//Working
public class JumpGame2 {

	// Working - O(n)
	public int jump(int[] nums) {
		int currReach = 0;
		int maxReach = 0;
		int jumps = 0;

		for(int i=0; i<nums.length-1; i++) {
			if(maxReach < i+nums[i]) {
				maxReach = i+nums[i];
			}
			if(i == currReach) {
				jumps++;
				currReach = maxReach;
			}
		}
		return jumps; 
	}

	
// ==================================================================================
	
	public static int canJump(int nums[], int idx, Integer[] memo) {
		if(idx >= nums.length-1)
			return 0;

		int ans = 9999;
		if(memo[idx] == -1) {
			for (int i=1; i <= nums[idx]; i++) {
				ans = Math.min(ans, 1+canJump(nums, idx+i, memo));
			}
			memo[idx] = ans;
		}
		return memo[idx];
	}

	
	// Working - O(n2)
	public static int canJump(int[] nums) {
		return canJump(nums, 0, new Integer[nums.length+1]);
		//    	canJumpFromPosition(0, nums, 0);
		//    	return min;
	}

	public static void main(String[] args) {
		int nums[] = {2,3,1,1,4};
		System.out.println(canJump(nums));
	}
}
