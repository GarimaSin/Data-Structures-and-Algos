package Problem_Solving.DP.Leetcode;


/**
 * 
 * Assuming there are 3 posts, if the first one and the second one has the same color, 
 * then the third one has k-1 options. The first and second together has k options.
	If the first and the second do not have same color, the total is k * (k-1), then the third one has k options. 
	Therefore, f(3) = (k-1)*k + k*(k-1)*k = (k-1)(k+k*k)
 *
 */
public class PaintFence {

	int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int n = 3, k=2;
		PaintFence min = new PaintFence();
		System.out.println(min.getNumWays(n,k));
	}
	
	private int getNumWays(int n, int k) {
		int dp[] = {0, k , k*k, 0};
		 
	    if(n <= 2)
	        return dp[n];
	 
	    for(int i = 2; i < n; i++){
	        dp[3] = (k - 1) * (dp[1] + dp[2]);
	        dp[1] = dp[2];
	        dp[2] = dp[3];
	    }
	 
	    return dp[3];
	}
	
}
