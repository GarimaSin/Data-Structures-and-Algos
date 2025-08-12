package Problem_Solving.Matrix.TotalNoOfPaths_Same;

import java.util.LinkedList;
import java.util.Queue;

public class TotNoOfUniquePathsUsingQ {
	static int m = 4; 
	static int n = 3; 
	
	static class pair { 
		int first, second; 
		public pair(int first, int second) { 
			this.first = first; 
			this.second = second; 
		} 
	} 

	//Function to return the number of valid paths in the given maze 
	static int Maze(int matrix[][]) {
		Queue<pair> q = new LinkedList<>(); 

		// Insert the starting point i.e. (0, 0) in the queue 
		q.add(new pair(0, 0)); 

		int count = 0; 
		while (!q.isEmpty()) { 
			pair p = q.peek(); 
			q.remove(); 

			// Increment the count of paths since it is the destination 
			if (p.first == n - 1 && p.second == m - 1) 
				count++; 

			// If moving to the next row is a valid move 
			if (p.first + 1 < n && matrix[p.first + 1][p.second] == 1) { 
				q.add(new pair(p.first + 1, p.second)); 
			} 

			// If moving to the next column is a valid move 
			if (p.second + 1 < m && matrix[p.first][p.second + 1] == 1)	{ 
				q.add(new pair(p.first, p.second + 1)); 
			} 
		} 
		return count; 
	} 

	public static void main(String[] args) { 
		int matrix[][] = {{ 1, 0, 0, 1 }, 
								   { 1, 1, 1, 1 }, 
								   { 1, 1, 1, 1 }}; 

		System.out.println(Maze(matrix)); 
	} 
} 