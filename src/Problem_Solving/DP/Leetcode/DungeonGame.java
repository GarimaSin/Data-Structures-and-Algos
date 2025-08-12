package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class DungeonGame {
	
	public static void main(String[] args) {
		int dungeon[][] = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.println(calculateMinimumHP(dungeon));
	}

	public static int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length+1][dungeon[0].length+1];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        return calculateMinimumHP(dungeon, 0, 0, dp);
    }

    static int calculateMinimumHP(int[][] dungeon, int i, int j, int[][] dp) {
		int m = dungeon.length;
        int n = dungeon[0].length;

        if (i >= m || j >= n) 
            return Integer.MAX_VALUE;

        if (i == m-1 && j == n-1) 
            return dungeon[i][j] < 0 ? Math.abs(dungeon[i][j]) + 1 : 1;
        
        if(dp[i][j] != -1) 
            return dp[i][j];
        
        int down = calculateMinimumHP(dungeon, i+1, j, dp);
        int right = calculateMinimumHP(dungeon, i, j+1, dp);
        
        int result = Math.min(down, right) - dungeon[i][j];
        int ans = result <= 0 ? 1 : result;
        
        return dp[i][j] = ans;
	}
}
