import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class hexagonProb {
	
	public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("hexagonProb.txt"));
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
        	int Size = sc.nextInt();
        	int size = (Size*2)-1;
        	int Ri, Rj, Ci, Cj;
        	int guards[][] = new int[3][size];
        	int maze[][] = new int[size][];
        	String s[] = new String[size];
        	int i = 0; int maxLen = 0;
        	int maxRow = 0; int colSize = 0;
        	for(int n=0; n<size; n++){
        		s[n] = sc.next();
        		int len = s[n].length();
        		if(maxLen<len){
        			maxLen = len;
        			maxRow = n;
        		}
        		maze[i] = new int[len];
        		for(int j=0; j<len; j++){
        			String st = new Character(s[n].charAt(j)).toString();
        			if(st.equalsIgnoreCase("."))
        				maze[i][j] = 0;
        			else if(st.equalsIgnoreCase("R")){
        				Ri = i; Rj = j;
        				maze[i][j] = -8;
        			}
        			else if(st.equalsIgnoreCase("C")){
        				Ci = i; Cj = j;
        				maze[i][j] = -9;
        			} else {
        				maze[i][j] = Integer.parseInt(st);
        				guards[0][colSize] = 0;
        				guards[1][colSize] = i;
        				guards[2][colSize] = j;
        				colSize++;
        			}
        		}
        		i++;
        	}
        	printMaze(maze, size);
        	System.out.println("....."+ maxRow);
        	for(int c=0; c<colSize; c++){
    			if(guards[0][c] == 0){
    				fillMaze(maze, guards, c, maxRow, size);
    			}
        	}
        	printMaze(maze, size);
        }
    }

	private static void fillMaze(int[][] maze, int[][] guards, int c, int maxRow, int size) {
		int row = guards[1][c];
		int col = guards[2][c];
		int depth = maze[row][col];
		System.out.println(depth+",,,,,,,,,,,,,,,");
		int[][] visited = new int[3][depth*6];
		refill(maze, size, maxRow, row, col, visited, 0);
		if(depth >= 2){
			int d = 1;
			while(d<depth){
				for(int k=(0+d)-1; k < (6*d)-1; k++){
					refill(maze, size, maxRow, visited[0][k], visited[1][k], visited, d);
					visited[2][k] = 1;
				}
				d++;
			}
		}

	}

	private static void refill(int[][] maze, int size, int maxRow, int row, int col, int[][] visited, int cu) {
		int temp = cu*6;
		if(row < maxRow){
			if(0 <= (row-1) && 0 <= (row-1) && maze[row-1][col-1] != -1) {
				maze[row-1][col-1] = -1;
				visited[0][temp] = row-1;
				visited[1][temp] = col-1;
				visited[2][temp] = 0;
				temp++;
			}
			if(size > (row+1) && (maze[row+1].length) > (col+1) && maze[row+1][col+1] != -1) {
				maze[row+1][col+1] = -1;
				visited[0][temp] = row+1;
				visited[1][temp] = col+1;
				visited[2][temp] = 0;
				temp++;
			}
		} 
		else if(row>maxRow){
			if(0 <= (row-1) && (maze[row-1].length)>(col+1) && maze[row-1][col+1] != -1) {
				maze[row-1][col+1] = -1;
				visited[0][temp] = row-1;
				visited[1][temp] = col+1;
				visited[2][temp] = 0;
				temp++;
			}
			if(size>(row+1) && 0 <= (col-1) && maze[row+1][col-1] != -1) {
				maze[row+1][col-1] = -1;
				visited[0][temp] = row+1;
				visited[1][temp] = col-1;
				visited[2][temp] = 0;
				temp++;
			}
		} 
		else {
			if(0 <= (row-1) && 0 <= (col-1) && maze[row-1][col-1] != -1) {
				maze[row-1][col-1] = -1;
				visited[0][temp] = row-1;
				visited[1][temp] = col-1;
				visited[2][temp] = 0;
				temp++;
			}
			if(size>(row+1) && 0 <= (col-1) && maze[row+1][col-1] != -1) {
				maze[row+1][col-1] = -1;
				visited[0][temp] = row+1;
				visited[1][temp] = col-1;
				visited[2][temp] = 0;
				temp++;
			}
		}
		if(0 <= (row-1) && maze[row-1][col] != -1) {
			maze[row-1][col] = -1;
			visited[0][temp] = row-1;
			visited[1][temp] = col;
			visited[2][temp] = 0;
			temp++;
		}
		if(0 <= (col-1) && maze[row][col-1] != -1) {
			maze[row][col-1] = -1;
			visited[0][temp] = row;
			visited[1][temp] = col-1;
			visited[2][temp] = 0;
			temp++;
		}
		if((maze[row].length)>(col+1) && maze[row][col+1] != -1) {
			maze[row][col+1] = -1;
			visited[0][temp] = row;
			visited[1][temp] = col+1;
			visited[2][temp] = 0;
			temp++;
		}
		if((maze[row+1].length)>(row+1) && maze[row+1][col] != -1) {
			maze[row+1][col] = -1;
			visited[0][temp] = row+1;
			visited[1][temp] = col;
			visited[2][temp] = 0;
			temp++;
		}
	}

	private static void printMaze(int[][] maze, int size) {
		for(int i=0; i<size; i++){
    		for(int j=0; j<maze[i].length; j++){
    			System.out.print(maze[i][j]+"     ");
    		}
    		System.out.println(" ");
    	}
	}
}
