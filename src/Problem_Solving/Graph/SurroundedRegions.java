package Problem_Solving.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	
	public void solve(char[][] board) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(i==0 || i==board.length-1 || j==0 || j==board[0].length-1) {
					if(board[i][j]=='O') {
						bfs(board,i,j);
					}
				}
			}
		}

		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]=='s'){
					board[i][j]='O';
				} else {
					board[i][j]='X';
				}
			}
		}
	}
	int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

	public void bfs(char[][] board,int i,int j){
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(i,j));

		while(!q.isEmpty()){
			Node node=q.remove();
			board[node.i][node.j]='s';
			for(int[] d:dir){
				int r=node.i+d[0];
				int c=node.j+d[1];

				if(r>=0 && r<board.length && c>=0 && c<board[0].length){
					if(board[r][c]=='O'){
						board[r][c]='s';
						q.add(new Node(r,c));
					}
				}
			}
		}
	}
}

//class Node{
//	int i,j;
//	Node(int i,int j){
//		this.i=i;
//		this.j=j;
//	}
//}
