package Problem_Solving.DP.Pepcoding;

public class MinCostInMazeTraversal {

	public static void main(String[] args) {
		int maze[][] = {{0, 1, 4, 2, 8, 2},
			{4, 3, 6, 5, 0, 4},
			{1, 2, 4, 1, 4, 6},
			{2, 0, 7, 3, 2, 2},
			{3, 1, 5, 9, 2, 4},
			{2, 7, 0, 8, 5, 1}};
		findMinCost(maze, 0, 0, 0);
		
		int[][] dp = new int[maze.length][maze[0].length];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				dp[i][j] = 99999;
			}
		}
		System.out.println(min);
		System.out.println(findMinCostMemoMine(maze, dp, 0, 0, 0));
	}
	
	static int min = Integer.MAX_VALUE;
	
	// Working - Recursion, Mine
	public static void findMinCost(int[][] maze, int cost, int i, int j) {
		if(i == maze.length-1 && j == maze[0].length-1) {
			cost = cost+maze[i][j];
			min = Math.min(min, cost);
			return;
		}
		
		if(i >= maze.length || j >= maze[0].length || i < 0 || j < 0) {
			return;
		}
		
		findMinCost(maze, cost+maze[i][j], i+1, j);
		findMinCost(maze, cost+maze[i][j], i, j+1);
	}
	
	
	// Working - Memo
	public static int findMinCostMemoMine(int[][] maze, int[][] dp, int cost, int i, int j) {
		if(i == maze.length-1 && j == maze[0].length-1) {
			return maze[i][j];
		}
		
		if(i >= maze.length || j >= maze[0].length || i < 0 || j < 0) {
			return 99999;
		}
		
		if(dp[i][j] != 99999)
			return dp[i][j];
		else {
			int i1 = maze[i][j] + findMinCostMemoMine(maze, dp, cost, i+1, j);
			int i2 = maze[i][j] + findMinCostMemoMine(maze, dp, cost+maze[i][j], i, j+1);
			dp[i][j] = Math.min(i1, i2);
			return dp[i][j];
		}
	}
}
