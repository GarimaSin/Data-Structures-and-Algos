package Problem_Solving.Matrix;

import java.util.LinkedList;

public class RatInMazeBFS {

	int length = 0;
	int width = 0;
	boolean ans = false;
	int row[] = {1, -1, 0, 0};
	int col[] = {0, 0, 1, -1};

	public boolean is_Possible(int[][] grid) {
		length = grid.length;
		width = grid[0].length;

		boolean[][] vis = new boolean[length][width];

		for(int i=0; i<length; i++) {
			for(int j=0; j<width; j++) {
				if(grid[i][j]==1)
					return findPath(grid, vis, i, j);   
			}
		}
		return false;
	}

	boolean findPath(int[][] grid, boolean[][] vis, int x, int y) {
		LinkedList<Cell> que = new LinkedList<Cell>();
		que.add(new Cell(x,y));
		vis[x][y] = true;

		while(!que.isEmpty()) {
			Cell tmp = que.remove();

			for(int i=0; i<row.length; i++) {
				int r = tmp.x + row[i];
				int c = tmp.y + col[i];
				if(isSafe(r, c) && grid[r][c] == 2)
					return true;
				if(isSafe(r, c) && !vis[r][c] && grid[r][c] != 0) {
					vis[r][c] = true;
					que.add(new Cell(r,c));
				}
			}
		}
		return false;
	}

	boolean isSafe(int i, int j) {
		if(i>=0 && i<length && j>=0 && j<width) 
			return true;
		return false;
	}

	public static void main(String[] args) {
		int grid[][] = {
				{3, 3, 3, 3, 0, 0, 3, 0},
				{1, 3, 3, 3, 3, 3, 3, 2},
				{3, 3, 0, 3, 0, 3, 3, 3},
				{3, 3, 3, 0, 0, 3, 3, 0},
				{0, 3, 3, 3, 3, 3, 3, 3},
				{0, 0, 0, 3, 3, 0, 3, 3},
				{0, 3, 0, 3, 3, 3, 3, 0},
				{3, 3, 3, 0, 3, 3, 3, 3}}; 

		RatInMazeBFS maze = new RatInMazeBFS();
		System.out.println(maze.is_Possible(grid));
	}
}

class Cell {
	int x;
	int y;

	Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
