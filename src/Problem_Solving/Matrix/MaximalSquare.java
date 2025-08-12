package Problem_Solving.Matrix;

public class MaximalSquare {

	public static int maximalSquare(char[][] M) {
		int[][] memo = new int[M.length][M[0].length];
		int max = 0;

		for (int i = 0; i < M.length; i++)
		{
			for (int j = 0; j < M[0].length; j++)
			{
				if (i > 0 && j > 0 && M[i][j] == '1')  {
                    int c1 = 1+ memo[i][j-1];
					int c2 = 1+ memo[i-1][j];
					int c3 = 1+ memo[i-1][j-1];
					memo[i][j] = Integer.min(c1,Integer.min(c2,c3));
				} 
                else if(M[i][j] == '1')     //for matrix of size 2*2
						memo[i][j] = 1;

				if (max < memo[i][j]) {
					max = memo[i][j];
				}
			}
		}
		return max*max;
	    }
	
	public static void main(String[] args) {
		char matrix[][] ={{'0','1'},{'1','0'}};
		maximalSquare(matrix);
	}
}
