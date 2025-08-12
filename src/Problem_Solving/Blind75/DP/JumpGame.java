package Problem_Solving.Blind75.DP;

// Working
public class JumpGame {

	public static boolean canJump2(int[] nums) {
		int maxReachable = 0;
		for (int i=0; i<nums.length; i++) {
            if(i > maxReachable)
				return false;
			maxReachable = Math.max(maxReachable, i+nums[i]);
		}
		return true;
    }

	
// =================================================================================
	
	public static Boolean canJump1(int nums[], int steps, Boolean[] dp, int n) {
        if(steps == n-1) 
            return true;
        
        if(nums[steps] == 0)
			return false;
        
        if(dp[steps] != null)
            return dp[steps];
            
        for(int i=1; i<= nums[steps]; i++) {
            dp[steps] = canJump1(nums, steps+i, dp, n);
            if(dp[steps])
                return true;
        }
        return false;
    }

    public static Boolean canJump(int[] nums) {
        return canJump1(nums, 0, new Boolean[nums.length+1], nums.length);
    }
    
    public static void main(String[] args) {
		int nums[] = {2,0};
		System.out.println(canJump(nums));
	}
}
