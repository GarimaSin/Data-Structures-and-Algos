/**
 * Created by Dev Computer on 6/14/2015.
 */
public class Maze_Prob {

    static int[][] maze = new int[][]{
            {1, 0, 0, 1, 1},
            {1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 1, 0},
            {1, 0, 0, 1, 1}
    };
    static int[][] mazeCopy = new int[][]{
            {1, 0, 0, 1, 1},
            {1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 1, 0},
            {1, 0, 0, 1, 1}
    };
    static int startX = 0;
    static int startY = 0;
    static int endX = 4;
    static int endY = 4;
    static int size = 5;
    static int[][] sol = new int[size][size];
    public static void main(String a[]){
        makeMove(startX, startY, sol);
    }

    static boolean makeMove(int row, int col, int[][] sol){
        boolean isPossible = false;
        if(row == endX && col == endY){
            isPossible = true;
            printSolution(sol);
            return isPossible;
        }
        if(isMovePossible(maze, row+1, col)) {
            makeMove(row + 1, col, sol);          // Down
        }
        if(isMovePossible(maze, row, col+1)) {
            makeMove(row, col + 1, sol);          // Right
        }
        if(isMovePossible(maze, row, col-1)) {
            makeMove(row, col - 1, sol);          // Left
        }

        return isPossible;
    }

    private static boolean isMovePossible(int[][] maze, int row, int col) {
        if(row < size && col < size && maze[row][col] == 1) {
            sol[row][col] = 1;
            maze[row][col] = 2;
            return true;
        }
        else
            return false;
    }

    private static void printSolution(int[][] sol) {
        for(int x=0; x<size; x++){
            for(int y=0; y<size; y++){
                System.out.print(sol[x][y]);
            }
            System.out.println(" ");
        }
    }
}