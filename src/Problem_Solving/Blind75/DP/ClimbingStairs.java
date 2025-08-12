package Problem_Solving.Blind75.DP;

public class ClimbingStairs {

	public static void main(String[] args) {
		int ans = climbStairs(45);
//		System.out.println(ans);
		System.out.println(climbStairsTab(45));
		System.out.println(countWaysMemo(0, 45, new Integer[45+1]));
	}
	
	public static int climbStairs(int n) {
		return countWays(0, n);
    }
    
	//Working
    static int countWays(int steps, int totSteps) {
    	if(steps == totSteps) {
    		return 1;
    	}
    	
    	if(steps > totSteps)
    		return 0;
    	
    	int i1 = countWays(steps+1, totSteps);
    	int i2 = countWays(steps+2, totSteps);
    	return i1+i2;
    }
    
    //Working
    static int countWaysMemo(int steps, int totSteps, Integer[] dp) {
    	if(steps == totSteps) {
    		return 1;
    	}
    	
    	if(steps > totSteps)
    		return 0;
    	
    	if(dp[steps] != null)
    		return dp[steps];
    	else {
    		int i1 = countWaysMemo(steps+1, totSteps, dp);
        	int i2 = countWaysMemo(steps+2, totSteps, dp);
        	dp[steps] = i1+i2;
        	return i1+i2;
    	}
    }
    
    //Working
    public static int climbStairsTab(int n) {
         if (n == 1) {
             return 1;
         }
         int[] dp = new int[n + 1];
         dp[1] = 1;
         dp[2] = 2;
         for (int i = 3; i <= n; i++) {
             dp[i] = dp[i - 1] + dp[i - 2];
         }
         return dp[n];
    }
}
