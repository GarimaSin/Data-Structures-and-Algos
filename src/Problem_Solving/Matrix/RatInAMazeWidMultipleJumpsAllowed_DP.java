package Problem_Solving.Matrix;

/**
 * 
 * https://www.geeksforgeeks.org/a-variation-of-rat-in-a-maze-multiple-steps-or-jumps-allowed/
 *
 */
public class RatInAMazeWidMultipleJumpsAllowed_DP {

	static int MAX = 50; 

	// Function to check whether the path exists 
	static boolean hasPath(int maze[][],  
			int sol[][], int N) 
	{ 
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				sol[i][j] = 0; 

		// Declaring and initializing CRF 
		// (can reach from) matrix 
		boolean [][]CRF = new boolean[N][N]; 

		CRF[N - 1][N - 1] = true; 

		// Using the DP to fill CRF matrix  
		// in correct order 
		for (int k = N - 1; k >= 0; k--)  
		{ 
			for (int j = k; j >= 0; j--)  
			{ 

				if (!(k == N - 1 && j == N - 1)) 
				{ 

					// If it is possible to get  
					// to a valid location from  
					// cell maze[k][j] 
					for (int a = 0; a <= maze[k][j]; a++) 
					{ 
						if ((j + a < N && CRF[k][j + a] == true) ||  
								(k + a < N && CRF[k + a][j] == true))  
						{ 
							CRF[k][j] = true; 
							break; 
						} 
					} 

					// If it is possible to get to  
					// a valid location from cell 
					// maze[j][k] 
					for (int a = 0; a <= maze[j][k]; a++)  
					{ 
						if ((k + a < N && CRF[j][k + a] == true) || 
								(j + a < N && CRF[j + a][k] == true))  
						{ 
							CRF[j][k] = true; 
							break; 
						} 
					} 
				} 
			} 
		} 

		// If CRF[0][0] is false it means we cannot reach 
		// the end of the maze at all 
		if (CRF[0][0] == false) 
			return false; 

		// Filling the solution matrix using CRF 
		int i = 0, j = 0; 
		while (!(i == N - 1 && j == N - 1)) 
		{ 
			sol[i][j] = 1; 
			if (maze[i][j] > 0) 

				// Get to a valid location from  
				// the current cell 
				for (int a = 1; a <= maze[i][j]; a++)  
				{ 
					if ((j + a < N && CRF[i][j + a] == true))  
					{ 
						j = j + a; 
						break; 
					} 
					else if ((i + a < N && CRF[i + a][j] == true))  
					{ 
						i = i + a; 
						break; 
					} 
				} 
		} 
		sol[N - 1][N - 1] = 1; 

		return true; 
	} 

	// Utility function to print the contents 
	// of a 2-D array 
	static void printMatrix(int sol[][], int N) 
	{ 
		for (int i = 0; i < N; i++) 
		{ 
			for (int j = 0; j < N; j++) 
				System.out.print(sol[i][j] + " "); 
			System.out.println(); 
		} 
	} 

	// Driver code 
	public static void main(String[] args)  
	{ 
		int maze[][] = {{ 2, 2, 1, 1, 0 }, 
				{ 0, 0, 3, 0, 0 },  
				{ 1, 0, 0, 0, 0 },  
				{ 0, 0, 2, 0, 1 }, 
				{ 0, 0, 3, 0, 0 }}; 
		int N = maze.length; 
		int [][]sol = new int [N][MAX]; 

		// If path exists 
		if (hasPath(maze, sol, N)) 

			// Print the path 
			printMatrix(sol, N); 
		else
			System.out.println("No path exists"); 
	}
} 
