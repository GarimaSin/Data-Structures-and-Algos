package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

public class Tribonacci {

	public static void main(String[] args) {
		Tribonacci t = new Tribonacci();
		int i = t.tribonacci(4);
		System.out.println(i);
	}
	
	public int tribonacci(int n) {
        int dp[] = new int[n+1];
        if(n == 0) {
        	dp[0] = 0;
            return dp[0];
        }
        if(n == 1) {
        	dp[1] = 1;
            return dp[1];
        }
        if(n == 2) {
        	dp[2] = 1;
            return dp[2];
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-3] +dp[i-2] +dp[i-1];
        }
        
        return dp[n];
    }

}
