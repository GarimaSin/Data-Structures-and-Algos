package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FindTheCityWithSmallestNoOfNeighbors {

	public static void findTheCity(int n, int[][] edges, int distanceThreshold) {
		ArrayList<Edge> graph[] = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < edges.length; i++) {
			int from = edges[i][0];
			int to = edges[i][1];
			int wt = edges[i][2];
			ArrayList<Edge> list = graph[from];
			list.add(new Edge(to, wt));
			graph[from] = list;

			ArrayList<Edge> list1 = graph[to];
			list1.add(new Edge(from, wt));
			graph[to] = list1;
		}

		ArrayList<List<Integer>> ans  = new ArrayList<List<Integer>>();
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			min = Dijkstra(graph, n, i, distanceThreshold, ans, new ArrayList<Integer>(), min);
		}
	}
	
	static int result = -1;
	static int Dijkstra(ArrayList<Edge> graph[], int n, int source, int target, List<List<Integer>> ans, ArrayList<Integer> list, int minCity) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.wt, b.wt));
		boolean[] vis = new boolean[n];
		pq.add(new Edge(source, 0));
		vis[source] = true;
		int count  = 0;

		while(!pq.isEmpty()) {
			Edge e = pq.remove();
			for(Edge tmp: graph[e.dest]) {
				if(!vis[tmp.dest] && tmp.wt+e.wt <= target) {
					list.add(tmp.dest);
					count++;
					vis[tmp.dest] = true;
					pq.add(new Edge(tmp.dest, tmp.wt+e.wt));
				}
			}
		}
		System.out.println("Count: - "+count+"   source: - "+source);
		if(count <= minCity){
			minCity = count;
			result = source;
		}
		return minCity;
	}


public static void main(String[] args) {
	int n = 6, edges[][] = {{0,1,10},{0,2,1},{2,3,1},{1,3,1},{1,4,1},{4,5,10}}, distanceThreshold = 20;
	findTheCity(n, edges, distanceThreshold);
}


static class Edge {
	int dest;
	int wt;

	Edge (int dest, int wt){
		this.dest = dest;
		this.wt = wt;
	}
}
}
