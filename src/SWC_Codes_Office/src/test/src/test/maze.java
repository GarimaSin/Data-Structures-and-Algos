package SWC_Codes_Office.src.test.src.test;

class maze
{
    private final static int MAXROW = 9;
    private final static int MAXCOL = 9;
    private final static int size = 10;
    static int[][] sol = new int[size][size];
    static int[][] maze = new int[][]{
            {1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 1, 1, 1},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
            {1, 1, 0, 0, 0, 0, 1, 1, 0, 1},
    };

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

        if (0 <= row && row < size && 0 <= col && col < size) {     // boundary check, if false, a base case
            if (1 == mazeCopy[row][col]) {                          // if false, base case
                mazeCopy[row][col] = 2;
                sol[row][col] = 1;
                if (MAXROW == row && MAXCOL == col) {
                    printMaze(sol);      // base case
                    return;
                }
                else {
                    traceMaze(mazeCopy, row - 1, col);
                    traceMaze(mazeCopy, row, col + 1);
                    traceMaze(mazeCopy, row + 1, col);
                    traceMaze(mazeCopy, row, col - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        traceMaze(maze, 0, 0);
    }
}