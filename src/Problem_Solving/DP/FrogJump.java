package Problem_Solving.DP;

import java.util.Arrays;

public class FrogJump {
	
	/***
	 * Ques:
	 * There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach 'Nth' stair. 'HEIGHT[i]' is d ht of d '(i+1)th' stair. If Frog jumps 4m 'ith' to 'jth' stair, energy lost in d jump = absolute(HEIGHT[i-1] - HEIGHT[j-1]). 
	 * If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find d min tot energy used by d frog to reach from '1st' stair to 'Nth' stair.
		Eg. If the given ‘HEIGHT’ array is [10,20,30,10], the ans 20 as frog can jump 4m 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump 4m 2nd stair to last stair (|10-20| = 10 energy lost). 
		So, the tot energy lost is 20.
	 */

	public static void main(String a[]){
		int ans = frogJump(4, new int[]{10, 20, 30, 10});
		System.out.println(ans);
	}
	
	public static int frogJump(int n, int heights[]) {
        System.out.println(frogJump(n, heights, 0, 0));
        System.out.println(frogJump(heights, n-1, 0));
        
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
		int ans = rec(0, heights,dp);
		return ans;
        
    }

	// Working
    public static int frogJump(int n, int heights[], int steps, int sum) {
        if(steps == n-1) 
            return sum;

        if(steps >= n) 
        	return 9999999;

        int one = 9999999, two = 9999999;
        if(steps+1 < n)
        	one = frogJump(n, heights, steps+1, sum+(Math.abs(heights[steps] - heights[steps+1]))); 
        if(steps+2 < n)
        	two = frogJump(n, heights, steps+2, sum+(Math.abs(heights[steps] - heights[steps+2])));
        return Math.min(one, two);  
    }
    
    // Working
    public static int frogJump(int heights[], int steps, int sum) {
        if(steps == 0)
            return sum;

        if(steps < 0)
        	return 9999999;

        
        int one = 9999999, two = 9999999;
        if(steps-1 >= 0)
        	one = frogJump(heights, steps-1, sum+(Math.abs(heights[steps] - heights[steps-1]))); 
        if(steps-2 >= 0)
        	two = frogJump(heights, steps-2, sum+(Math.abs(heights[steps] - heights[steps-2])));
        return Math.min(one, two);  
    }
    
 // Working - DP
    private static int rec(int i, int heights[], int dp[]) {
		if (i == heights.length - 1)	// Reached the last stair.
			return 0;
	
		if(dp[i] != -1)
			return dp[i];
	
		// Two available choices.
		int oneJump = Integer.MAX_VALUE;
		int twoJump = Integer.MAX_VALUE;
	
		if (i + 1 < heights.length){
			oneJump = Math.abs(heights[i] - heights[i + 1]) + rec(i + 1, heights, dp);
		}
	
		if (i + 2 < heights.length){
			twoJump = Math.abs(heights[i] - heights[i + 2]) + rec(i + 2, heights, dp);
		}
	
		int ans = Math.min(oneJump, twoJump);
		dp[i] = ans;
		return ans;
	}

    
// 	  Not Working
//    public static int frogJump(int heights[], int steps, int sum, int[] dp) {
//        if(steps == 0) 
//            return sum;
//
//        if(steps < 0) 
//        	return 9999999;
//
//        if(dp[steps] != -1) return dp[steps];
//        int one = 9999999, two = 9999999;
//        if(steps-1 >= 0)
//        	one = frogJump(heights, steps-1, sum+(Math.abs(heights[steps] - heights[steps-1])), dp); 
//        if(steps-2 >= 0)
//        	two = frogJump(heights, steps-2, sum+(Math.abs(heights[steps] - heights[steps-2])), dp);
//        dp[steps] = Math.min(one, two);
//        return dp[steps];  
//    }
}
