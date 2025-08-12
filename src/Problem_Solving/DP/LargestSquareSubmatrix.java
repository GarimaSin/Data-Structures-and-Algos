package Problem_Solving.DP;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Leetcode - Maximal Square
 * 
 * DP logic - https://www.youtube.com/watch?v=FO7VXDfS8Gk
 * Time and Space complexity : O(mn)
 * 
 * Memo logic - https://www.techiedelight.com/find-size-largest-square-sub-matrix-1s-present-given-binary-matrix/
 * Time = exponential, Space = O(1)
 *
 * DP is better 
 */

public class LargestSquareSubmatrix {
	
	//Memo - working
	public static int findLargestSquare(int[][] M, int m, int n, AtomicInteger max_size)
	{
		if (m == M.length || n == M[0].length) {
			return 0;
		}

		int left = 1+ findLargestSquare(M, m, n+1, max_size);
		int top = 1+ findLargestSquare(M, m+1, n, max_size);
		int diagonal = 1+ findLargestSquare(M, m+1, n+1, max_size);

		int size = 0;					//initialized to 0 since left top and diagonal are new every time
		if (M[m][n] != 0) {
			size = Integer.min(Integer.min(top, left), diagonal);
		}

		max_size.set(Integer.max(max_size.get(), size));
		return size;
	}
	
	
	//DP - working
	public static int findLargestSquare(int[][] M)
	{
		int[][] memo = new int[M.length][M[0].length];
		int max = 0;

		for (int i = 0; i < M.length; i++)
		{
			for (int j = 0; j < M[0].length; j++)
			{
				memo[i][j] = M[i][j];				/** Watch this or if i=0 || j=0 then memo[i][j] = M[i][j] **/

				// if we are not at the first row or first column and current cell has value 1
				if (i > 0 && j > 0 && M[i][j] == 1)
				{
					// largest square sub-matrix ending at M[i][j] will be
					// 1 plus minimum of largest square sub-matrix
					// ending at M[i][j-1], M[i-1][j] and M[i-1][j-1]

					int c1 = 1+ memo[i][j - 1];
					int c2 = 1+ memo[i - 1][j];
					int c3 = 1+ memo[i - 1][j - 1];
					memo[i][j] = Integer.min(c1,Integer.min(c2,c3));
				}

				// update maximum size found so far
				if (max < memo[i][j]) {
					max = memo[i][j];
				}
			}
		}
		return max;
	}


	public static void main(String[] args)
	{
//		int[][] M =
//			{
//					{ 0, 0, 1, 0, 1, 1 },
//					{ 0, 1, 1, 1, 0, 0 },
//					{ 0, 0, 1, 1, 1, 1 },
//					{ 1, 1, 0, 1, 1, 1 },
//					{ 1, 1, 1, 1, 1, 1 },
//					{ 1, 1, 0, 1, 1, 1 },
//					{ 1, 0, 1, 1, 1, 1 },
//					{ 1, 1, 1, 0, 1, 1 }
//			};
		
		int[][] N =
		{
			{ 1, 0, 1, 0, 0},
			{1, 0, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 0, 0, 1, 0}
	};

		// size stores the size of largest square sub-matrix of 1's
		// and it is passed by reference using AtomicInteger
		AtomicInteger max = new AtomicInteger();

		findLargestSquare(N, 1, 1, max);
		System.out.println("The size of largest square sub-matrix of 1's is " + max);
		System.out.println(findLargestSquare(N));
	}
}
