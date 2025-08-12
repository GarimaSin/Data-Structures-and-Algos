package DataStructures.Udemy.Prims;

import java.util.ArrayList;
import java.util.PriorityQueue;


//Graph from https://youtu.be/4ZlRH0eK-qQ
public class PrimsPepcoding {
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

	static int cost = 0;
	public static void main(String[] args) throws Exception {
		int[][] arr = {{0,1,28},
				{1,2,16},
				{2,3,12},
				{3,4,22},
				{4,5,25},
				{5,0,10},
				{1,6,14},
				{6,4,24},
				{6,3,18}};
		int vtces = 7;
		@SuppressWarnings("unchecked")
		ArrayList< Edge>[] neighboringEdgesOfCurVertex = new ArrayList[vtces];	//For vertex v, list of edges from/to that vertex
																																// And there is an array for every vertex, hence array of list of edges.
		for (int i = 0; i < vtces; i++) {
			neighboringEdgesOfCurVertex[i] = new ArrayList<>();
		}

		int edges = arr.length;
		for (int i = 0; i < edges; i++) {
			int v1 = arr[i][0];
			int v2 = arr[i][1];
			int wt = arr[i][2];
			neighboringEdgesOfCurVertex[v1].add(new Edge(v1, v2, wt));
			neighboringEdgesOfCurVertex[v2].add(new Edge(v2, v1, wt));
		}
		int src = 0;
		findMST(src, neighboringEdgesOfCurVertex, vtces);
		System.out.println("Minimum cost: " + cost);
	}
	
	static void findMST(int src, ArrayList< Edge>[] neighboringEdgesOfCurVertex, int vtces) {
		PriorityQueue< Pair> queue = new PriorityQueue<>();
		queue.add(new Pair(src, -1, 0));
		boolean[] visited = new boolean[vtces];
		while (queue.size() > 0) {
			Pair rem = queue.remove();

			if (visited[rem.dest] == true) {
				continue;
			}
			visited[rem.dest] = true;
			cost = cost + rem.wt;										//MST cost
			if (rem.src != -1) {
				System.out.println("from "+rem.src + " to " + rem.dest +", edge weighted: "+ rem.wt);
			}

			for (Edge e : neighboringEdgesOfCurVertex[rem.dest]) {
				if (visited[e.nbr] == false) {
					queue.add(new Pair(e.nbr, rem.dest, e.wt));
				}
			}
		}
	}

	static class Pair implements Comparable<Pair> {
		Integer dest;
		Integer src;
		int wt;

		Pair(Integer dest, Integer src, int wt) {
			this.dest = dest;
			this.src = src;
			this.wt = wt;
		}

		public int compareTo(Pair o) {				// I - PQ will compare the current wt with existing wts in the queue.
			return this.wt - o.wt;
		}
	}
}