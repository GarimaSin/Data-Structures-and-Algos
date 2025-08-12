package Problem_Solving.DP.Pepcoding;

public class GoldMine {

	static int max = Integer.MIN_VALUE;
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) {
		int maze[][] = {
			{0, 1, 4, 2, 8, 2},
			{4, 3, 6, 5, 0, 4},
			{1, 2, 4, 1, 4, 6},
			{2, 0, 7, 3, 2, 2},
			{3, 1, 5, 9, 2, 4},
			{2, 7, 0, 8, 5, 1}};
		for (int i = 0; i < maze.length; i++) {
			max = Integer.MIN_VALUE;
			findMaxCost(maze, 0, i, 0);
			ans = Math.max(ans, max);
		}
		System.out.println(ans);
		
		int[][] dp = new int[maze.length][maze[0].length];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		ans = Integer.MIN_VALUE;
		for (int i = 0; i < maze.length; i++) {
			int i1 = findMaxCostMemoMine(maze, dp, i, 0);
			ans = Math.max(ans, i1);
		}
		System.out.println(ans);
	}
	
	
	// Working - Recursion, Mine
	public static void findMaxCost(int[][] maze, int cost, int i, int j) {
		if(i >= 0 && i < maze.length && j == maze[0].length-1) {
			cost = cost+maze[i][j];
			max = Math.max(max, cost);
			return;
		}
		
		if(i >= maze.length || j >= maze[0].length || i < 0 || j < 0) {
			return;
		}
		
		findMaxCost(maze, cost+maze[i][j], i-1, j+1);
		findMaxCost(maze, cost+maze[i][j], i, j+1);
		findMaxCost(maze, cost+maze[i][j], i+1, j+1);
	}
	
	
	// Working - Memo
	public static int findMaxCostMemoMine(int[][] maze, int[][] dp, int i, int j) {
		if(i >= 0 && i < maze.length && j == maze[0].length-1) {
			return maze[i][j];
		}
		
		if(i >= maze.length || j >= maze[0].length || i < 0 || j < 0) {
			return -1;
		}
		
		if(dp[i][j] != -1)
			return dp[i][j];
		else {
			int i1 = maze[i][j] + findMaxCostMemoMine(maze, dp, i-1, j+1);
			int i2 = maze[i][j] + findMaxCostMemoMine(maze, dp, i, j+1);
			int i3 = maze[i][j] + findMaxCostMemoMine(maze, dp, i+1, j+1);
			dp[i][j] = Math.max(Math.max(i1, i2), i3);
			return dp[i][j];
		}
	}
}
