package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;


/**
 * 
 * On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D 
 * 	coordinate on this grid.
	We assign one unique bike to each worker so that the sum of the Manhattan distances between each worker 
	and their assigned bike is minimized.
	The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
	Return the minimum possible sum of Manhattan distances between each worker and their assigned bike.
 *
 */
public class campus_bikes_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int min = Integer.MAX_VALUE;

	public int assignBikes(int[][] workers, int[][] bikes) {
		dfs(workers, bikes, 0, 0, new boolean[bikes.length], new int[workers.length][bikes.length]);
		return min;
	}
	public void dfs(int[][] workers, int[][] bikes, int index, int distance, boolean[] isOccupied, int[][] dis) {
		if (index == workers.length) {
			min = Math.min(min, distance);
			return; 
		}

		if (distance >= min) {
			return;
		}
		for (int i = 0; i < bikes.length; i++) {
			if (!isOccupied[i]) {
				isOccupied[i] = true;

				if (dis[index][i] == 0) {
					dis[index][i] = calcDistance(workers[index], bikes[i]);
				}

				dfs(workers, bikes, index + 1,  dis[index][i] + distance, isOccupied, dis);
				isOccupied[i] = false;
			}
		}
		return;
	}
	public int calcDistance(int[] worker, int[] bike) {
		return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
	}

}
