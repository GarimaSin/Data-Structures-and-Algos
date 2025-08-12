package Problem_Solving.Matrix;

/**
 * 
 * A value of cell 1 means Source.
 * A value of cell 2 means Destination.
 * A value of cell 3 means Blank cell.
 * A value of cell 0 means Blank Wall.
 * 
 * 
 * Either vis/unvisit at every movement(up, down, rt, left) OR
 * for the cu x,y start and end like this code
 * 
 * My sol
 * Better Sol: Use BFS
 *
 */

public class RatInMaze {

	static int length = 0;
	static int width = 0;
	static boolean ans = false;

	public static boolean is_Possible(int[][] grid) {
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

	static boolean findPath(int[][] grid, boolean[][] vis, int x, int y) {
		if(grid[x][y] == 2) {
			ans = true;
			return ans;
		}

//		vis[x][y] = true;  

		if(isSafe(x+1, y) && !vis[x+1][y] && grid[x][y] != 0) {
			vis[x+1][y] = true;
			if(findPath(grid, vis, x+1, y))
				return true;
			vis[x+1][y] = false;
		}

		if(isSafe(x, y-1) && !vis[x][y-1] && grid[x][y] != 0) {
			vis[x][y-1] = true;
			if(findPath(grid, vis, x, y-1))
				return true;            
			vis[x][y-1] = false;
		}

		if(isSafe(x-1, y) && !vis[x-1][y] && grid[x][y] != 0) {
			vis[x-1][y] = true;
			if(findPath(grid, vis, x-1, y))
				return true;
			vis[x-1][y] = false;
		}

		if(isSafe(x, y+1) && !vis[x][y+1] && grid[x][y] != 0) {
			 vis[x][y+1] = true;
			if(findPath(grid, vis, x, y+1))
				return true;
			 vis[x][y+1] = false;
		}
//		vis[x][y] = false;
		return false;
	}

	static boolean isSafe(int i, int j) {
		if(i>=0 && i<length && j>=0 && j<width) 
			return true;
		return false;
	}

	public static void main(String[] args) {
		int grid[][] = {{3, 3, 3, 3, 0, 0, 3, 0},
			{1, 3, 3, 3, 3, 3, 3, 2},
			{3, 3, 0, 3, 0, 3, 3, 3},
			{3, 3, 3, 0, 0, 3, 3, 0},
			{0, 3, 3, 3, 3, 3, 3, 3},
			{0, 0, 0, 3, 3, 0, 3, 3},
			{0, 3, 0, 3, 3, 3, 3, 0},
			{3, 3, 3, 0, 3, 3, 3, 3}};  
		
		System.out.println(is_Possible(grid));
	}
}
