package Samsung_SWC.src;

public class test {
	
	static int d = 2;
	static int depth = 2;
	static int j =0;
	public static void main(String[] args) {
		int[][] maze = new int[8][8];
		System.out.println(maze[2][3]);
		printMaze(maze);
		System.out.println("            ");
		recurssion(maze, 4,4, 0);
		printMaze(maze);
		
	}
	
	private static void printMaze(int[][] maze) {
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				System.out.print(maze[i][j]+"     ");
			}
			System.out.println("");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void recurssion(int[][] maze, int row, int col, int dep){
		System.out.println(row+"..."+col);
//		fill(maze, row, col);
		if(dep <= 2) {
			System.out.println(row+"**********"+col);
			recurssion(maze, row+1, col, ++dep);
			recurssion(maze, row, col+1, ++dep);
//			recurssion(maze, row-1, col, ++dep);
//			recurssion(maze, row, col-1, ++dep);
		}
		else
			return;
//		}
//		maze[row-1][col] = -1;
//		maze[row][col+1] = -1;
//		maze[row][col-1] = -1;
	}
	
	public static void fill(int[][] maze, int row, int col){
		maze[row][col] = -1;
//		maze[row+1][col] = -1;
//		maze[row-1][col] = -1;
//		maze[row][col+1] = -1;
//		maze[row][col-1] = -1;
	}
}
