package Problem_Solving.Leetcode.Backtracking;

public class CampusBike {

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
