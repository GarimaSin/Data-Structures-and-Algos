package Problem_Solving.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfEnclaves {
	public int numEnclaves(int[][] grid) {
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1) {
					if(grid[i][j]== 1) {
						bfs(grid,i,j);
					}
				}
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1) {
					count++;
					grid[i][j] = 0;
					countIslands(grid, i, j);
				}
			}
		}
		return count;
	}

	int count = 0;
	int dir[][] = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
	private void countIslands(int[][] grid, int i, int j) {
		for (int k = 0; k < dir.length; k++) {
			int m = i+dir[k][0];
			int n = j+dir[k][1];
			if(isSafe(grid, m, n)) {
				count++;
				grid[m][n] = 0;
				countIslands(grid, m, n);
			}
		}
	}

	public void bfs(int[][] board,int i,int j){
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(i,j));

		while(!q.isEmpty()) {
			Node node=q.remove();
			board[node.i][node.j] = 0;
			for(int[] d:dir) {
				int r=node.i+d[0];
				int c=node.j+d[1];

				if(r>=0 && r<board.length && c>=0 && c<board[0].length) { 
					if(board[r][c] == 1){
						board[r][c] = 0;
						q.add(new Node(r,c));
					}
				}
			}
		}
	}

	private boolean isSafe(int[][] grid, int m, int n) {
		if(m >= 0 && n >=0 && m <grid.length && n < grid[0].length && grid[m][n] == '1' )
			return true;
		return false;
	}
}

class Node{
	int i,j;
	Node(int i,int j){
		this.i=i;
		this.j=j;
	}
}
