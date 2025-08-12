package Problem_Solving.DP.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BurstBalloons {
	
	/**
	 * Input: nums = [3,1,5,8] Output: 167
	 * Explanation:
	 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
	 * coins =  3*1*5 + 3*5*8 + 1*3*8 + 1*8*1 = 167
	 */
	
	public static void main(String[] args) {
		int nums[] = {3,1,5,8};
		System.out.println(maxCoins(nums));
	}


	// Working - TLE - 31/73
	public static int maxCoins(int[] nums) {
		List<Integer> balloons = new ArrayList<>();
        balloons.add(1);
        for (int num : nums) 
        	balloons.add(num);
        balloons.add(1);
        Map<String, Integer> memo = new HashMap<>();
        return getMaxCoins(balloons, memo);
	}
	
	static int getMaxCoins(List<Integer> balloons, Map<String, Integer> memo) {
        int n = balloons.size();
        if (n == 2)
            return 0;

        // Use the list's state as a key
        String key = balloons.toString();			// Check the key
        if (memo.containsKey(key))
            return memo.get(key);

        int max = 0;
        for (int i=1; i<n-1; i++) {
            int b = balloons.get(i-1) * balloons.get(i) * balloons.get(i+1);	// calculate coins
            int tmp = balloons.get(i);
            balloons.remove(i); 					// Burst the balloon

            int a = getMaxCoins(balloons, memo);

            balloons.add(i, tmp); 					// Backtrack
            int coins = a+b;
            max = Math.max(max, coins);
        }
        memo.put(key, max);
        return max;
    }
	
	// Working
	public int maxCoins1(int[] iNums) {
	    int[] nums = new int[iNums.length + 2];
	    int n = 1;
	    for (int x : iNums) 
	    	if (x > 0) 
	    		nums[n++] = x;
	    
	    nums[0] = nums[n++] = 1;
	    int[][] memo = new int[n][n];
	    return burst(memo, nums, 0, n - 1);
	}

	public int burst(int[][] memo, int[] nums, int start, int end) {
	    if (start + 1 == end) 
	    	return 0;
	    
	    if (memo[start][end] > 0) 
	    	return memo[start][end];
	    
	    int ans = 0;
	    for (int i = start+1; i<end; ++i) {
	    	int left = burst(memo, nums, start, i);
	    	int right = burst(memo, nums, i, end);
	    	ans = Math.max(ans, nums[start] * nums[i] * nums[end] + left + right);
	    }
	    memo[start][end] = ans;
	    return ans;
	}
	
	// Working - Bottom up
	public int maxCoins2(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
	    int n = 1;
	    for (int x : iNums) if (x > 0) nums[n++] = x;
	    nums[0] = nums[n++] = 1;

	    int[][] dp = new int[n][n];
	    for (int k = 2; k < n; ++k)
	        for (int left = 0; left < n - k; ++left) {
	            int right = left + k;
	            for (int i = left + 1; i < right; ++i)
	                dp[left][right] = Math.max(dp[left][right], 
	                nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
	        }
	    return dp[0][n - 1];
    }

}
