package Samsung_SWC.src;

import java.util.Arrays;
import java.util.Stack;


public class RatMaze {
	
	/* Java program to solve Rat in a Maze problem using backtracking */
	 
	    final int N = 4;
	 
	    /* A utility function to print solution matrix sol[N][N] */
	    void printSolution(int sol[][]) {
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++)
	                System.out.print(" " + sol[i][j] + " ");
	            System.out.println();
	        }
	    }
	 
	    /* A utility function to check if x,y is valid index for N*N maze */
	    boolean isSafe(int maze[][], int x, int y) {
	        // if (x,y outside maze) return false
	        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
	    }
	 
	    /* There may be more than one solutions, this function prints one of the feasible solutions.*/
	    boolean solveMaze(int maze[][]) {
	        int sol[][] = {{0, 0, 0, 0},
	            {0, 0, 0, 0},
	            {0, 0, 0, 0},
	            {0, 0, 0, 0}
	        };
	 
	        if (solveMazeUtil(maze, 0, 0, sol) == false) {
	            System.out.print("Solution doesn't exist");
	            return false;
	        }
	 
	        printSolution(sol);
	        return true;
	    }
	 
	    /* A recursive utility function to solve Maze problem */
	    boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {
	        // if (x,y is goal) return true
	        if (x == N - 1 && y == N - 1) {
	            sol[x][y] = 1;
	            return true;
	        }
	 
	        // Check if maze[x][y] is valid
	        if (isSafe(maze, x, y) == true) {
	            // mark x,y as part of solution path
	            sol[x][y] = 1;
	 
	            /* Move forward in x direction */
	            if (solveMazeUtil(maze, x + 1, y, sol))
	                return true;
	 
	            /* If moving in x direction doesn't give solution then  Move down in y direction */
	            if (solveMazeUtil(maze, x, y + 1, sol))
	                return true;
	 
	            /* If none of the above movements work then BACKTRACK: unmark x,y as part of solution path */
	            sol[x][y] = 0;
	            return false;
	        }
	        return false;
	    }
	 
	    public static void main(String args[]) {
	        RatMaze rat = new RatMaze();
	        int maze[][] = {{1, 0, 0, 0},
	            {1, 1, 0, 1},
	            {0, 1, 0, 0},
	            {1, 1, 1, 1}
	        };
	        rat.solveMaze(maze);
	    }
	    
	    public static int shortestPath(int row,int col,boolean[][] visited,String[][] map,Stack path)
	    {
	        if(row < 0 || row >= map.length || col < 0 || col >= map[0].length)
	            return -1;
	        else if(visited[row][col] == true)
	            return -1;
	        else if(map[row][col].equals("e"))
	            return 0;
	        else
	        {
	            // Mark the current cell as visited
	            visited[row][col] = true;

	            // There is a wall
	            if(map[row][col].equals("1"))
	                return -1;
	            else
	            {
	                int[] pathDist = new int[4];

	                // Start finding the path from the left
	                int left  = 1 + shortestPath(row,col-1,visited,map,path);

	                // Start searching from the right
	                int right = 1 + shortestPath(row,col+1,visited,map,path);

	                // Start searching from the bottom
	                int down  = 1 + shortestPath(row+1,col,visited,map,path);

	                // Start searching from the top
	                int up    = 1 + shortestPath(row-1,col,visited,map,path);

	                visited[row][col] = false;

	                pathDist[0] = left;
	                pathDist[1] = right;
	                pathDist[2] = down;
	                pathDist[3] = up;

	                Arrays.sort(pathDist);

	                for(Integer i : pathDist)
	                    if(i > 0) return i;
	                return -1;
	            }
	        }
	    }
	    
	}