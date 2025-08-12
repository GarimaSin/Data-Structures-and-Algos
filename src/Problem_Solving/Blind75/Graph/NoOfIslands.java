package Problem_Solving.Blind75.Graph;

public class NoOfIslands {

	int count = 0;
	public int numIslands(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == '1') {
					countIslands(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	int dir[][] = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
	private void countIslands(char[][] grid, int i, int j) {
		for (int k = 0; k < dir.length; k++) {
			int m = i+dir[k][0];
			int n = j+dir[k][1];
			if(isSafe(grid, m, n)) {
				grid[m][n] = '2';
				countIslands(grid, m, n);
			}
		}
	}
	
	private boolean isSafe(char[][] grid, int m, int n) {
		if(grid[m][n] == '1' && m >= 0 && n >=0 && m <grid.length && n < grid[0].length)
			return true;
		return false;
	}
}
