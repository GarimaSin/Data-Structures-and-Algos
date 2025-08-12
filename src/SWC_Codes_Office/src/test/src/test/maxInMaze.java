package test.src.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class maxInMaze
{
//    private final static int MAXROW = 9;
//    private final static int MAXCOL = 9;
    static int size;
    static int max = 0;
//    private final static int size = 10;
    static int[][] sol;
    static int[][] maze;

    public static void printMaze(int[][] sol) {
        for(int x=0; x<size; x++){
            for(int y=0; y<size; y++){
                System.out.print(sol[x][y]);
            }
            System.out.println(" ");
        }
    }

    /**
     *  Will attempt to find a path out of the maze.  A path will
     *  be marked with the ! marker.  The method makes a copy of
     *  the array each time so that only the path out will be
     *  marked, otherwise extra ! markers will appear in the
     *  answer. The function is recursive.
     */
    public static void traceMaze(int[][] maze, int row, int col) {

        int[][] mazeCopy = new int[maze.length][maze[0].length];        // make a local copy of maze
        for (int r = 0; r < mazeCopy.length; r++) {
            for (int c = 0; c < mazeCopy[0].length; c++) {
                mazeCopy[r][c] = maze[r][c];
            }
        }
        
        if (0 == row && 0 == col) {
            printMaze(sol);      // base case
            return;
        }

        if (0 <= row && row < size && 0 <= col && col < size) {     // boundary check, if false, a base case
            if (1 == mazeCopy[row][col]) {                          // if false, base case
                mazeCopy[row][col] = 2;
                sol[row][col] = 1;
                max = max+1;
            }
                
            traceMaze(mazeCopy, row - 1, col);
//                    traceMaze(mazeCopy, row, col + 1);
//                    traceMaze(mazeCopy, row + 1, col);
            traceMaze(mazeCopy, row, col - 1);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
    	Scanner sc = new Scanner(new FileInputStream("maxInMaze.txt"));
		int T=sc.nextInt();
		for(int t=1;t<=1;t++) {
			size = sc.nextInt();
			sol = new int[size][size];
			maze = new int[size][size];
			for(int i=0; i<size; i++){
				for(int j=0; j<size; j++){
					maze[i][j] = sc.nextInt();
				}
			}
			printMaze(maze);
			System.out.println("            ");
			traceMaze(maze, size-1, size-1);
		}
		
        traceMaze(maze, size-1, size-1);
        System.out.println(max+"..........");
    }
}