package test.src.test;

public class constellation {
    private final static int size = 7;
    static int count = 0, bigeestCol = 0;
    static int[][] sol = new int[size][size];
    static int[][] maze = new int[][]{
        {0, 1, 1, 0, 0, 0, 0},
        {0, 1, 1, 0, 1, 0, 0},
        {1, 1, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 1, 1, 0},
        {0, 1, 0, 1, 1, 0, 0},
};
    static int[][] mazeCopy = new int[maze.length][maze[0].length];        // make a local copy of maze
    public static void traceMaze(int[][] maze, int row, int col) {

        if (0 <= row && row < size && 0 <= col && col < size) {     // boundary check, if false, a base case
            if (1 == mazeCopy[row][col]) {                          // if false, base case
                mazeCopy[row][col] = 2;
                traceMaze(mazeCopy, row - 1, col);
                traceMaze(mazeCopy, row, col + 1);
                traceMaze(mazeCopy, row + 1, col);
                traceMaze(mazeCopy, row, col - 1);
            } else {
            	count++;
            }
        }
    }

    public static void main(String[] args) {
        traceMaze(maze, 0, 0);
        for (int r = 0; r < mazeCopy.length; r++) {
            for (int c = 0; c < mazeCopy[0].length; c++) {
                mazeCopy[r][c] = maze[r][c];
            }
        }
    }
    
    public static void printMaze(int[][] sol) {
        for(int x=0; x<size; x++){
            for(int y=0; y<size; y++){
                System.out.print(sol[x][y]);
            }
            System.out.println(" ");
        }
    }
}
