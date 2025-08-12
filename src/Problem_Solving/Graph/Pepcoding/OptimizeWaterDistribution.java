package Problem_Solving.Graph.Pepcoding;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class OptimizeWaterDistribution {

	public static void main(String[] args) {
		int vrtx = 3;
		int edge = 2;

		int[] wells = new int[vrtx];
		int arr[][] = {{1,2,2},
				{1,2,1},
				{2,3,1}};

		for (int i = 0; i < wells.length; i++) {
			wells[i] = arr[0][i];
		}
		int[][] pipes = new	int[edge][3];
		int j =0;
		for (int i = 1; i <= edge; i++) {
			pipes[j][0] = arr[i][0];
			pipes[j][1] = arr[i][1];
			pipes[j][2] = arr[i][2];
			j++;
		}
		System.out.println(minCostToSupplyWater(vrtx, wells, pipes));
	}

	public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i<pipes.length; i++) {
			int from = pipes[i][0];
			int to = pipes[i][1];
			int wt = pipes[i][2];

			graph.get(from).add(new Pair(to, wt));
			graph.get(to).add(new Pair(from, wt));
		}

		for (int i = 1; i <=n; i++) {
			graph.get(i).add(new Pair(0, wells[i-1]));
			graph.get(0).add(new Pair(i, wells[i-1]));
		}

		int ans = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0, 0));
		boolean[]vis = new boolean[n + 1];
		while (pq.size() > 0) {
			Pair rem = pq.remove();
			if (vis[rem.to] == true) {
				continue;
			}
			ans += rem.wt;
			vis[rem.to] = true;
			ArrayList<Pair> nbrs = graph.get(rem.to);
			for (Pair nbr : nbrs) {
				if (vis[nbr.to] == false) {
					pq.add(nbr);
				}
			}
		}
		return ans;
	}

	static class Pair implements Comparable< Pair> {
		Integer to;
		int wt;

		Pair(Integer src, int wt) {
			this.to = src;
			this.wt = wt;
		}

		public int compareTo(Pair o) {				// I - PQ will compare the current wt with existing wts in the queue.
			return this.wt - o.wt;
		}
	}
}
