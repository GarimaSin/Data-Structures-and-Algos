package DataStructures.Udemy.Kruskal;

import java.util.Arrays;


//Graph from https://youtu.be/4ZlRH0eK-qQ
public class KruskalPepcoding {
	public static void main(String[] args) throws Exception {
		int v = 7;
		int e = 8;
		
		int[][] arr = {{0,1,28},
				{1,2,16},
				{2,3,12},
				{3,4,22},
				{4,5,25},
				{5,0,10},
				{1,6,14},
				{6,4,24},
				{6,3,18}};

		int[][] edges = new int[e][3];
		for (int i = 0; i < e; i++) {
			edges[i][0] = arr[i][0];
			edges[i][1] = arr[i][1];
			edges[i][2] = arr[i][2];
		}
		System.out.println(minCostToSupplyWater(v, edges));
	}

	static int[] parent;
	static int[] rank;

	public static class Pair implements Comparable<Pair> {
		int u;
		int v;
		int wt;

		Pair(int u, int v, int wt) {
			this.u = u;
			this.v = v;
			this.wt = wt;
		}

		@Override
		public int compareTo(Pair o) {
			return this.wt - o.wt;
		}
	}

	public static int minCostToSupplyWater(int n, int[][] pipes) {
		Pair[] edges = new Pair[pipes.length];

		for (int i = 0; i < pipes.length; i++) {
			int u = pipes[i][0];
			int v = pipes[i][1];
			int wt = pipes[i][2];
			edges[i] = new Pair(u, v, wt);
		}

		int ans = 0;
		Arrays.sort(edges);
		parent = new int[n + 1];
		rank = new int[n + 1];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		for (int i = 0; i < edges.length; i++) {
			int u = edges[i].u;
			int v = edges[i].v;
			int wt = edges[i].wt;

			boolean flag = union(u, v);
			if (flag == false) {
				ans += wt;
			}
		}
		return ans;
	}

	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		int temp = find(parent[x]);
		parent[x] = temp;
		return temp;
	}

	public static boolean union(int x, int y) {
		int lx = find(x);
		int ly = find(y);

		if (lx == ly) {
			return true;
		}

		if (rank[lx] > rank[ly]) {
			parent[ly] = lx;
		} else if (rank[lx] < rank[ly]) {
			parent[lx] = ly;
		} else {
			parent[lx] = ly;
			rank[ly]++;
		}
		return false;
	}

	static class Edge {
		int src;
		int nbr;
		int wt;

		Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
}