package Problem_Solving.Array.Pepcoding;

public class IslandPerimeter {
	public static int islandPerimeter(int[][] grid) {
		int ans = 0;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 1) {
					ans += 4;
					if(i > 0) {
						if(grid[i-1][j] == 1)
							ans -= 2;
					}
					if(j > 0) {
						if(grid[i][j-1] == 1)
							ans -= 2;
					}
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
 		islandPerimeter(grid);
	}
}
