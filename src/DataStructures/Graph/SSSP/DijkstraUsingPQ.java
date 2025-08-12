package DataStructures.Graph.SSSP;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraUsingPQ {
	static class Edge {
		int src;
		int target;
		int wt;

		Edge(int src, int nbr, int wt) {
			this.src = src;
			this.target = nbr;
			this.wt = wt;
		}
	}

	public static void main(String[] args) throws Exception {

		int vtces = 7;
		//int edges = 9;
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}
		int inp[][] = {{0,1,10},
				{1,2,10},
				{2,3,10},
				{0,3,40},
				{3,4,2},
				{4,5,3},
				{5,6,3},
				{4,6,8},
				{2,5,5}};
		for (int i = 0; i < inp.length; i++) {
			int v1 = inp[i][0];
			int v2 = inp[i][1];
			int wt = inp[i][2];
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}

		int src = 0;

		PriorityQueue<Pair> queue = new PriorityQueue<>();
		queue.add(new Pair(src, src + "", 0));
		boolean[] visited = new boolean[vtces];
		while(queue.size() > 0){
			Pair rem = queue.remove();

			if(visited[rem.v] == true){
				continue;
			}
			visited[rem.v] = true;
			System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);

			for (Edge e : graph[rem.v]) {
				if (visited[e.target] == false) {
					queue.add(new Pair(e.target, rem.psf + e.target, rem.wsf + e.wt));
				}
			}
		}
	}

	static class Pair implements Comparable<Pair> {
		int v;
		String psf;
		int wsf;

		Pair(int v, String psf, int wsf){
			this.v = v;
			this.psf = psf;
			this.wsf = wsf;
		}

		public int compareTo(Pair o){
			return this.wsf - o.wsf;
		}
	}
}