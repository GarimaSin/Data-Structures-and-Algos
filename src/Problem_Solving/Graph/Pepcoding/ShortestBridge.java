package Problem_Solving.Graph.Pepcoding;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

	public static void main(String[] args)  {

		int[][] arr = {{0, 1, 0},
				{0, 0, 0},
				{1, 1, 1}};
		System.out.println(shortestBridge(arr));
	}

	private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static Queue<int[]> queue = new LinkedList<>();
	private static int[][] grid;
	private static int row, col;

	public static int shortestBridge(int[][] A) {
		grid = A;
		row = A.length;
		col = A[0].length;
		boolean[][] visited = new boolean[row][col];
		boolean found = false;

		for (int i = 0; i < row && !found; i++) {
			for (int j = 0; j < col && !found; j++) {
				if (A[i][j] == 1) {
					dfs(visited, i, j);					//find the 1st island
					found = true;						//break if 1st '1' is encountered since 1st 1 will give the all the elems of the 1st island
				}
			}
		}

		int step = 0;
		while (!queue.isEmpty()) {			//reach the 2nd island thru BFS
			int size = queue.size();
			while (size-- > 0) {
				int[] cell = queue.poll();
				for (int[] d : dirs) {
					int x = cell[0] + d[0];
					int y = cell[1] + d[1];
					if (x >= 0 && y >= 0 && x < row && y < col && !visited[x][y]) {
						if (A[x][y] == 1) {
							return step;
						}
						queue.offer(new int[] { x, y });
						visited[x][y] = true;
					}
				}
			}
			step++;
		}
		return -1;
	}

	private static void dfs(boolean[][] visited, int x, int y) {
		if (x < 0 || y < 0 || x >= row || y >= col || visited[x][y] || grid[x][y] == 0) {
			return;
		}
		visited[x][y] = true;
		queue.offer(new int[] { x, y });
		for (int[] d : dirs) {
			dfs(visited, x + d[0], y + d[1]);
		}
	}
}
