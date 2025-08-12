package Problem_Solving.Google_Shared;

import java.util.ArrayDeque;
import java.util.Queue;


/**
 * 
 * DISTANCE + 1 at line 60
 *
 */
public class ShortestPathInMazeBFS {
	// M x N matrix
	private static final int M = 10;
	private static final int N = 10;

	// Below arrays details all 4 possible movements from a cell
	private static final int row[] = { -1, 0, 0, 1 };
	private static final int col[] = { 0, -1, 1, 0 };

	// Function to check if it is possible to go to position (row, col)
	// from current position. The function returns false if (row, col)
	// is not a valid position or has value 0 or it is already visited
	
	private static boolean isValid(int mat[][], boolean visited[][], int row, int col) {
		return (row >= 0) && (row < M) && (col >= 0) && (col < N)
				&& mat[row][col] == 1 && !visited[row][col];
	}

	// Find Shortest Possible Route in a matrix mat from source cell (i, j) to destination cell (x, y)
	private static void BFS(int mat[][], int i, int j, int x, int y) {
		
		boolean[][] visited = new boolean[M][N];
		Queue<Node> q = new ArrayDeque<>();
		int min_dist = Integer.MAX_VALUE;

		visited[i][j] = true;
		q.add(new Node(i, j, 0));

		while (!q.isEmpty()) {
			Node node = q.poll();

			// (i, j) represents current cell and dist stores its min distance from the source
			i = node.x;
			j = node.y;
			int dist = node.dist;

			// if destination is found, update min_dist and stop
			if (i == x && j == y) {
				min_dist = dist;
				break;
			}

			// check for all 4 possible movements from current cell and enqueue each valid movement
			for (int k = 0; k < 4; k++) {
				// check if it is possible to go to position (i + row[k], j + col[k]) from current position
				if (isValid(mat, visited, i + row[k], j + col[k])) {
					// mark next cell as visited and enqueue it
					visited[i + row[k]][j + col[k]] = true;
					q.add(new Node(i + row[k], j + col[k], dist + 1));		/** DISTANCE +1 **/
				}
			}
		}

		if (min_dist != Integer.MAX_VALUE) {
			System.out.print("The shortest path from source to destination "
					+ "has length " + min_dist);
		}
		else {
			System.out.print("Destination can't be reached from source");
		}
	}

	public static void main(String[] args) {
		int[][] mat = {
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
		};

		// Find shortest path from source (0, 0) to destination (7, 5)
		BFS(mat, 0, 0, 7, 5);
	}
}

class Node {
	int x, y, dist;

	Node(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}




