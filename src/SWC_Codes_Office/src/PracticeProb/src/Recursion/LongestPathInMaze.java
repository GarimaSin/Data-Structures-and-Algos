package SWC_Codes_Office.src.PracticeProb.src.Recursion;

//Working
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 
 * office code
 *
 */
public class LongestPathInMaze {
	static int Answer;
    static int max = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1,0, 0};
    static int size;
    static int[][] mat;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception    {
    	Scanner sc = new Scanner(new FileInputStream("LongestPath.txt"));
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {

            size = sc.nextInt();
             mat = new int[size][size];
             visited = new boolean[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (mat[i][j] == 1) {
                        visited[i][j] = true;
                        backTrack(i, j, 1);
                        visited[i][j] = false;
                    }
                }
            }
            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(max);
            max = 0;
        }
    }

    public static void backTrack(int x, int y, int count){
        if (max <= count) {
            max = count;
        }

        for (int k = 0; k < 4; k++) {
            int adjX = x + dx[k];
            int adjY = y + dy[k];

            if (isSafe(adjX, adjY)) {
                visited[adjX][adjY] = true;
                backTrack(adjX, adjY, count+1);
                visited[adjX][adjY] = false;
            }
        }
    }


public static boolean isSafe(int x, int y){
        return x >= 0 && y >=0 && x < size && y < size && mat[x][y] == 1 && !visited[x][y];
    }
}
