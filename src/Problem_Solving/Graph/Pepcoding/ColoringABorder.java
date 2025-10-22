package Problem_Solving.Graph.Pepcoding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ColoringABorder {


	public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int originalColor = grid[row][col];
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        visited[row][col] = true;

        List<int[]> borders = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            int countSame = 0; // number of same-color neighbors
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (grid[nr][nc] == originalColor) {
                        countSame++;
                        if (!visited[nr][nc]) {
                            visited[nr][nc] = true;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
            
            // Border if not fully surrounded
            if (countSame < 4) {
                borders.add(new int[]{r, c});
            }
        }

        // Recolor borders
        for (int[] b : borders) {
            grid[b[0]][b[1]] = color;
        }

        return grid;
    }

	public static void main(String[] args) {
		int grid[][] = {{1,1,1},{1,1,1},{1,1,1}};
		int row = 1;
		int col = 1;
		int color = 2;
		colorBorder(grid, row, col, color);
		for(int r=0; r<grid.length; r++) {
			for(int c=0; c<grid[0].length; c++)
				if(grid[r][c] <0)
					grid[r][c] = color;
		}

		for(int r=0; r<grid.length; r++) {
			for(int c=0; c<grid[0].length; c++)
				System.out.print(grid[r][c] + " ");
			System.out.println();
		}
	}
}
