package Problem_Solving.Matrix;

/**
 * 
 * office code
 *
 */
public class LongestPathInMaze {
	static int max = 0;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1,0, 0};
	static int size;
	static boolean[][] visited;

	public static void main(String args[]) throws Exception    {
		//    	Scanner sc = new Scanner(new FileInputStream("LongestPath.txt"));
		//        int T = sc.nextInt();
		//        for(int test_case = 0; test_case < T; test_case++) {
		//
		//            size = sc.nextInt();
		//             mat = new int[size][size];
		//             visited = new boolean[size][size];
		//
		//            for (int i = 0; i < size; i++) {
		//                for (int j = 0; j < size; j++) {
		//                    mat[i][j] = sc.nextInt();
		//                }
		//            }
		//
		//            for (int i = 0; i < size; i++) {
		//                for (int j = 0; j < size; j++) {
		//                    if (mat[i][j] == 1) {
		//                        visited[i][j] = true;
		//                        backTrack(i, j, 1);
		//                        visited[i][j] = false;
		//                    }
		//                }
		//            }
		//            // Print the answer to standard output(screen).
		//            System.out.println("Case #"+(test_case+1));
		int mat[][] =
			{
					{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
					{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
					{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
					{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
					{ 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
					{ 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
					{ 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
					{ 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
					{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
			};
		size = mat.length;
		visited= new boolean[mat.length][mat[0].length];

		// (0,0) are the source cell coordinates and (5, 7) are the destination cell coordinates
		backTrack(0, 0, 0, mat);

		System.out.println("Maximum length path is " + max);
//		max = 0;
	}

	public static void backTrack(int x, int y, int count, int[][] mat){
		if(x == 5 && y==7) {
			max = Math.max(max, count);
			return;
		}
		
		if (mat[x][y] == 0) {
			return;
		}

		for (int k = 0; k < 4; k++) {
			int adjX = x + dx[k];
			int adjY = y + dy[k];

			if (isSafe(adjX, adjY, mat)) {
				visited[adjX][adjY] = true;
				backTrack(adjX, adjY, count+1, mat);
				visited[adjX][adjY] = false;
			}
		}
	}


	public static boolean isSafe(int x, int y, int[][] mat){
		return x >= 0 && y >=0 && x < size && y < size && mat[x][y] == 1 && !visited[x][y];
	}
}
