package Problem_Solving.DP.Leetcode;

import java.util.HashMap;

public class SuperEggDrop {

	public static int superEggDrop(int k, int n) {
		if(k == 0)
			return 99999;
		HashMap<String, Integer> dp = new HashMap<>();
//		return superEggDrop(k, n, 1, n, dp);
		return dp(k, n, dp);
	}
	
	
	// TLE - 59/121
	public static int superEggDrop(int eggs, int floors, int st, int end, HashMap<String, Integer> dp) {
		if(floors == 1 || st == end)	// Only one floor
            return 1;

        int count = end-st+1;
		if(eggs == 1)					// Must check every floor
			return count;
		
		if(st > end)					// No floors to check
			return 0;
	
		if(count <= 1)
			return count;
		
		if(count==2 || count==3)
			return 2;
		
		String key = eggs+","+st+","+end;
		if(dp.containsKey(key))
			return dp.get(key);
		
		int broken = 0, notBreak = 0;
		int MIN = 999999;
		for(int i=st; i<=end; i++) {
			broken = superEggDrop(eggs-1, floors, st, i-1, dp);
			notBreak = superEggDrop(eggs, floors, i+1, end, dp);
			int ans = Math.max(broken, notBreak)+1;
			MIN = Math.min(MIN, ans);
			dp.put(key, MIN);
		}
		return MIN;
	}
	
	
	// TLE - 63/121
	private static int dp(int eggs, int floors, HashMap<String, Integer> memo) {
        if (floors == 0 || floors == 1) 
            return floors;
        if (eggs == 1) 
            return floors;

        String key = eggs + "," + floors;
        if (memo.containsKey(key)) 
            return memo.get(key);

        int minMoves = Integer.MAX_VALUE;
        for (int x = 1; x <= floors; x++) {
            int broken = dp(eggs - 1, x - 1, memo);      // Egg breaks
            int notBroken = dp(eggs, floors - x, memo);  // Egg doesn't break
            int moves = 1 + Math.max(broken, notBroken);
            minMoves = Math.min(minMoves, moves);
        }

        memo.put(key, minMoves);
        return minMoves;
    }
	
	public static void main(String[] args) {
		int k = 2, n = 2;
		System.out.println(superEggDrop(k, n));
	}
}
