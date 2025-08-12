package Problem_Solving.Graph.Pepcoding;

import java.util.LinkedList;

public class ZeroOneMatrix {
	private static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args)  {

		int arr[][] = {{0,0,0},{0,1,0},{0,0,0}};
		int[][] ans = updateMatrix(arr);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] updateMatrix(int[][] matrix) {
		LinkedList<Pair> queue = new LinkedList<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					matrix[i][j] = -1;
				} else {
					queue.addLast(new Pair(i, j));
				}
			}
		}
		
		int distance = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			distance++;
			for (int i = 0; i < size; i++) {
				Pair rem = queue.removeFirst();
				for (int[] dir : dirs) {
					int idash = rem.x + dir[0];
					int jdash = rem.y + dir[1];

					if (idash >= 0 && jdash >= 0 && idash < matrix.length && jdash < matrix[0].length) {
						if (matrix[idash][jdash] == -1) {
							matrix[idash][jdash] = distance;
							queue.addLast(new Pair(idash, jdash));
						}
					}
				}
			}
		}
		return matrix;
	}
}