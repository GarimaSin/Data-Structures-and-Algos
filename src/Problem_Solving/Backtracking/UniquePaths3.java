package Problem_Solving.Leetcode.Backtracking;

public class UniquePaths3 {

	int ans;
	int zeroes = 1; // to nullify the starting case. zeroCount is incremented by 1 even when grid[x][y] == 1
	public int uniquePathsIII(int[][] grid) {
		int x = 0;
		int y = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1) {								//coordinates of starting pos.
					x = i;
					y = j;
				} else if(grid[i][j] == 0) {
					zeroes++;
				}
			}
		}
		solve(grid, x, y, 0);
		return ans;
	}

	void solve(int[][] grid, int i, int j, int zeroCount) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1) {
			return;
		}
		if(grid[i][j] == 2) {
			if(zeroCount == zeroes) {
				ans++;
			}
			return;
		}

		grid[i][j] = -1;
		solve(grid, i + 1, j, zeroCount + 1);
		solve(grid, i - 1, j, zeroCount + 1);
		solve(grid, i, j + 1, zeroCount + 1);
		solve(grid, i, j - 1, zeroCount + 1);
		grid[i][j] = 0;
	}
}
