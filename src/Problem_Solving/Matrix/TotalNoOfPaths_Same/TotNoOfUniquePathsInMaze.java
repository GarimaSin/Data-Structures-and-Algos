package Problem_Solving.Matrix.TotalNoOfPaths_Same;


/**
 * 
 * vis[]
 * Same as PrintAllPaths but with vis[]
 * Try using DP
 *
 */
public class TotNoOfUniquePathsInMaze {
	private static int N;
	private static int M;

	// Check if cell (x, y) is valid or not
	private static boolean isValidCell(int x, int y)	{
		if (x < 0 || y < 0 || x >= N || y >= M)
			return false;

		return true;
	}

	static int ans = 0;
	private static int countPaths(int maze[][], int x, int y, boolean visited[][], int count) {
		// if destination (bottom-rightmost cell) is found, increment the path count
		if (x == N - 1 && y == M - 1) {
			count++;
			ans++;
			return count;
		}
		visited[x][y] = true;

		if (isValidCell(x, y) && maze[x][y] == 1) {
			// go down (x, y) --> (x + 1, y)
			if (x + 1 < N && !visited[x + 1][y])
				count = countPaths(maze, x + 1, y, visited, count);

			// go right (x, y) --> (x, y + 1)
			if (y + 1 < M && !visited[x][y + 1])
				count = countPaths(maze, x, y + 1, visited, count);
		}
		visited[x][y] = false;
		return count;
	}

	public static void main(String[] args) {
		int[][] maze =	{		{ 1, 0, 0, 1 }, 
										{ 1, 1, 1, 1 }, 
										{ 1, 1, 1, 1 }};

		int count = 0;
		N = maze.length;
		M = maze[0].length;

		boolean[][] visited = new boolean[N][M];
		// start from source cell (0, 0)
		count = countPaths(maze, 0, 0, visited, count);
		System.out.println("Total number of unique paths are " + count);
		System.out.println("Answer using static var: "+ans );
	}
}