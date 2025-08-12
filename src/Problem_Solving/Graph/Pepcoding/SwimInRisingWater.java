package Problem_Solving.Graph.Pepcoding;

import java.util.PriorityQueue;

//Working - submitted in LC
public class SwimInRisingWater {

	private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public int swimInWater(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) 
			return 0;
		final int M = grid.length, N = grid[0].length;

		PriorityQueue<Cell> heap = new PriorityQueue<>((c1, c2) -> Integer.compare(c1.val, c2.val));
		boolean[][] visited = new boolean[M][N];
		heap.add(new Cell(0, 0, grid[0][0]));
		visited[0][0] = true;
		int max = grid[0][0];

		while (!heap.isEmpty()) {
			Cell cell = heap.poll();
			max = Math.max(max, cell.val);
			if (cell.row == M - 1 && cell.col == N - 1) {
				break;
			}
			for (int[] dir : DIRS) {
				int i = cell.row + dir[0];
				int j = cell.col + dir[1];
				if (outOfBound(i, j, grid) || visited[i][j]) 
					continue;
				visited[i][j] = true;
				heap.add(new Cell(i, j, grid[i][j]));
			}
		}
		return max;
	}

	private boolean outOfBound(int i, int j, int[][] grid) {
		return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
	}

	class Cell {
		int row, col, val;
		Cell(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}
	public static void main(String[] args) {

	}
}