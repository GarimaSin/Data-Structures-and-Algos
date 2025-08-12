package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;


public class NetworkDelayTime {

	static ArrayList<Edge>[] graph =null;
	public static int networkDelayTime(int[][] times, int N, int K) {
		ArrayList<Edge>[] graph = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int[] arr: times) {
			int from = arr[0];
			int dest = arr[1];
			int weight = arr[2];
			ArrayList<Edge> list = graph[from];
			list.add(new Edge(dest, weight));
			graph[from] = list;
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(K, 0));				//Check this step
		HashSet<Integer> vis = new HashSet<Integer>();
		int max = Integer.MIN_VALUE;
		while(!pq.isEmpty()) {
			Edge e = pq.remove();
			int to = e.to;
			int wt = e.wt;
			if (vis.contains(to)) 
				continue;
			vis.add(to);
			max = Math.max(max, wt);
			ArrayList<Edge> edges = graph[to];
			if(edges != null) {
				for(Edge l: edges) {
					if(!vis.contains(l.to)) {
						pq.add(new Edge(l.to, l.wt+wt));
					}
				}
			}
		}
		return vis.size() != N ? -1 : max;
	}

	public static void main(String[] args) {
		int[][] times = {{1,2,1}};
		int n = 2, k = 2;
		System.out.println(networkDelayTime(times, n, k));
	}
	
	static class Edge implements Comparable<Edge>{
		int to;
		int wt;

		public int compareTo(Edge n1) {
			return this.wt-n1.wt;
		}

		Edge(int to, int wt) {
			this.to = to;
			this.wt = wt;
		}
	}
}

