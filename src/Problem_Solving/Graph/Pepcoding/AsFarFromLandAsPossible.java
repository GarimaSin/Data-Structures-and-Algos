package Problem_Solving.Graph.Pepcoding;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {

	public static int maxDistance(int[][] grid) {
		Queue< Pair> queue = new LinkedList< >();
		for (int i = 0; i < grid.length; i++)	{
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1)
					queue.add(new Pair(i, j));
			}
		}

		if (queue.size() == 0 || queue.size() == grid.length * grid.length)
			return -1;

		int level = -1;
		int [][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		while (queue.size() > 0)	{
			level ++;

			int qs = queue.size();

			while (qs-- > 0)	{
				Pair rem = queue.remove();

				for (int i = 0; i < dirs.length; i++)	{
					int r  = rem.row + dirs[i][0];
					int c = rem.col + dirs[i][1];

					if (r >= 0 && c >= 0 && r < grid.length && c < grid.length && grid[r][c] == 0)	{
						queue.add(new Pair(r, c));
						grid[r][c] = 1;
					}
					else
						continue;
				}
			}
		}
		return level;
	}

	public static void main(String[] args)  {
		int[][] arr = {{1,0,1},{0,0,0},{1,0,1}};
		System.out.println(maxDistance(arr));
	}

	public static class Pair	{
		int row;
		int col;

		Pair(int row, int col)	{
			this.row = row;
			this.col = col;
		}
	}
}
