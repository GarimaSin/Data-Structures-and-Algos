package Problem_Solving.Graph.Pepcoding;

import java.util.List;

public class ColoringABorder {


	public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
		dfs(grid,row,col,color,grid[row][col],new boolean[grid.length][grid[0].length]);
		return grid;
	}

	public void dfs(int[][] grid, int row, int col, int val, List<int[]> l, boolean[][] visited)  {
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] != val)
			return;

		visited[row][col] = true;

		if(boundary(grid, row, col, val))
			l.add(new int[]{row, col});

		dfs(grid, row-1, col, val, l, visited);
		dfs(grid, row, col+1, val, l, visited);
		dfs(grid, row+1, col, val, l, visited);
		dfs(grid, row, col-1, val, l, visited);
	}

	public boolean boundary(int[][] grid, int row, int col, int val){
		if(row == 0 || row == grid.length-1 || col == 0 || col == grid[0].length-1)
			return true;

		int count = 0;

		if(grid[row-1][col] == val)
			count++;

		if(grid[row][col+1] == val)
			count++;

		if(grid[row+1][col] == val)
			count++;

		if(grid[row][col-1] == val)
			count++;

		return count == 4 ? false : true;
	}

	public static void dfs(int[][] grid,int row,int col,int color,int pcolor,boolean[][] visited){
		visited[row][col]=true;
		int count=0;
		if(row-1>=0){
			if(visited[row-1][col]==true){
				count++;
			}else if(grid[row-1][col]==pcolor){
				count++;
				dfs(grid,row-1,col,color,pcolor,visited);
			}
		}
		if(col-1>=0){
			if(visited[row][col-1]==true){
				count++;
			} else if(grid[row][col-1]==pcolor){
				count++;
				dfs(grid,row,col-1,color,pcolor,visited);
			} 
		}
		if(col+1<grid[0].length) {
			if(visited[row][col+1]==true) {
				count++;
			} else if(grid[row][col+1]==pcolor) {
				count++;
				dfs(grid,row,col+1,color,pcolor,visited);
			} 
		}
		if(row+1<grid.length) {
			if(visited[row+1][col]==true) {
				count++;
			} else if(grid[row+1][col]==pcolor) {
				count++;
				dfs(grid,row+1,col,color,pcolor,visited);
			} 
		}
		if(count!=4){
			grid[row][col]=color;		//change the colors of only those grids which r not surrounded on all sides by val 
		}
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
