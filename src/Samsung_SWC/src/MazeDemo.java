/**
 * Created by Garima on 6/17/2015.
 */
public class MazeDemo {
    private final static int MAXROW = 9;
    private final static int MAXCOL = 9;
    private final static int size = 10;
    static int[][] sol = new int[size][size];
    static int[][] maze = new int[][]{
            {1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 1, 1, 1},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1, 1, 0, 1},
    };

    public static void main(String[] args) {
        MazeDemo mazeWalker = new MazeDemo();
        mazeWalker.traceMaze(maze, 0, 0);
    }

    private void traceMaze(int[][] maze, int i, int j) {
        int[][] mazeCopy = new int[maze.length][maze[0].length];        // make a local copy of maze
        for (int r = 0; r < mazeCopy.length; r++) {
            for (int c = 0; c < mazeCopy[0].length; c++) {
                mazeCopy[r][c] = maze[r][c];
            }
        }

        if(0 <= i && i<size && 0 <= j && j<size){               // boundary check, if false, a base case
            if(1 == mazeCopy[i][j]){                            // if false, base case
                mazeCopy[i][j] = 2;
                sol[i][j] = 1;
                if(i == MAXROW && j == MAXCOL)
                    printMaze(sol);
                else{                                          // base case
                    traceMaze(mazeCopy,i+1,j);
                    traceMaze(mazeCopy,i-1,j);
                    traceMaze(mazeCopy,i,j+1);
                    traceMaze(mazeCopy,i,j-1);
                }
            }
        }
    }

    public void printMaze(int[][] sol) {
        for(int x=0; x<size; x++){
            for(int y=0; y<size; y++){
                System.out.print(sol[x][y]);
            }
            System.out.println(" ");
        }
    }
}
