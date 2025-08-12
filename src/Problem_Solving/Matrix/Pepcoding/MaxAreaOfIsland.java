package Problem_Solving.Matrix.Pepcoding;

public class MaxAreaOfIsland {
	private static int [][] directions = {
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};

	public static int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length, n = grid[0].length;
		boolean [][] visited = new boolean[m][n];
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (grid[i][j] == 1) {
					if (!visited[i][j]) {
						area = 1;
						helper1(grid, i, j, m, n, visited);
					}
				}
			}
		}
		max_area = Math.max(max_area, area);
        if(max_area < 0)
        	max_area = 0;
        System.out.println(max_area);
        return max_area;
	}

	
	//Working
	static int area = 0;
	public static int max_area = Integer.MIN_VALUE;
	public static void helper1(int[][] grid, int i, int j, int m, int n, boolean [][] visited) {
		visited[i][j] = true;
		for (int [] dir : directions) {
			int x = dir[0] + i;
			int y = dir[1] + j;
			if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !visited[x][y]) {
				area = area + 1;
				max_area = Math.max(max_area, area);
				System.out.println(area);
				helper1(grid, x, y, m, n, visited);
			}
		}
	}
	
	//Working
	private int findArea(int[][] grid, int r, int c, int Area){
        grid[r][c] = 0;

        if (r + 1 < grid.length && grid[r + 1][c] == 1) 
            Area = findArea(grid, r + 1, c, Area + 1);
        if (r - 1 >= 0 && grid[r - 1][c] == 1) 
            Area = findArea(grid, r - 1, c, Area + 1);
        if (c + 1 < grid[r].length && grid[r][c + 1] == 1) 
            Area = findArea(grid, r, c + 1, Area + 1);
        if (c - 1 >= 0 && grid[r][c - 1] == 1) 
            Area = findArea(grid, r, c - 1, Area + 1);

        return Area;
    }
	
	//Working 
	private static int helper(int[][] grid, int i, int j, int m, int n, boolean [][] visited) {
        visited[i][j] = true;
        int area = 1;
        for (int [] dir : directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !visited[x][y]) {
            	int tmp = helper(grid, x, y, m, n, visited);
            	System.out.println(tmp);
                area += tmp;
            }
        }
        return area;
    }
	
	public static void main(String[] args) {
		int grid[][] = {{1}};
		maxAreaOfIsland(grid);
	}
}
