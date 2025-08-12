package Problem_Solving.Queue;

import java.util.LinkedList;

/**
 * 
 * vis[] is v.imp o/w program will enter into infinite loop 
 *
 */
public class RotOranges {
	static int row[] = {-1, 1, 0, 0};
	static int col[] = {0, 0, -1, 1};

	public static int orangesRotting(int[][] grid, boolean[][] vis) {
		LinkedList<Cell> queue = new LinkedList<Cell>();

		boolean foundRot = false;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 2) {
					foundRot = true;
					queue.add(new Cell(i,j,0));
					vis[i][j] = true;
				}
			}
		}
		if(!foundRot)
			return 0;
		int maxTime = 0;
		while(!queue.isEmpty()) {
			Cell cell = queue.remove();
			
			for(int i=0; i<row.length; i++) {
				int x = cell.getR() + row[i];
				int y = cell.getC() + col[i];
				int tm = cell.getTime();
				
				if(x>=0 && x<grid.length && y>=0 && y<grid[0].length) {
					if(!vis[x][y] && grid[x][y]==1) {
						vis[x][y] = true;
						maxTime = tm+1;
						queue.add(new Cell(x,y, tm+1));
					}
				}
			}
		}
		return maxTime; 
	}

	public static void main(String[] args) {
		int grid[][] = {{0,1,2},{0,1,2},{2,1,1}};
		boolean[][] vis = new boolean[grid.length][grid[0].length];
		int time = orangesRotting(grid, vis);
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				// If any orange is found to be not rotten then ans is not possible
				if (!vis[i][j] && grid[i][j]==1)
					System.out.println(-1);
			}
		}
		System.out.println(time);
	}

	static class Cell {
		int r;
		int c;
		int time = -1;
		Cell(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

		int getC(){
			return this.c;
		}

		int getR(){
			return this.r;
		}

		int getTime(){
			return this.time;
		}
	}
}