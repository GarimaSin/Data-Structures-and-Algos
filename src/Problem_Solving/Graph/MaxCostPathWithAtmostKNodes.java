package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxCostPathWithAtmostKNodes {

	static int V;
	static int maxCostPath(int src, int dest, int K, Graph g) {
		boolean[] visited = new boolean[V];
		return dfs(src, dest, K + 1, 0, visited, g);
	}
	
	//DFS Approach
	//Top - Down version 
	private static int dfs(int node, int dest, int edgesLeft, int cost, boolean[] visited, Graph g) {
		if (node == dest) 
			return cost;			// Return cost
		
		if (edgesLeft == 0) 
			return Integer.MIN_VALUE; // used too many edges

		visited[node] = true;
		int max = Integer.MIN_VALUE;

		for (Edge e : g.adj.get(node)) {
			if (!visited[e.to]) {
				int val = dfs(e.to, dest, edgesLeft - 1, cost + e.weight, visited, g);
				if (val > max) 
					max = val;
			}
		}

		visited[node] = false; 	// backtrack
		return max;
	}
	
	// =================================================================================
	
	//Bottom - up version
	private static int dfs(int node, int dest, int edgesLeft, boolean[] visited, Graph g) {
	    if (node == dest) 
	        return 0; // remaining cost from dest to dest = 0

	    if (edgesLeft == 0)
	        return Integer.MIN_VALUE;

	    visited[node] = true;
	    int max = Integer.MIN_VALUE;

	    for (Edge e : g.adj.get(node)) {
	        if (!visited[e.to]) {
	            int val = dfs(e.to, dest, edgesLeft - 1, visited, g);
	            if (val != Integer.MIN_VALUE)
	                max = Math.max(max, e.weight + val); // add cost on return
	        }
	    }

	    visited[node] = false;
	    return max;
	}
	
	
	// =================================================================================
	
	//Top-down with global tracking
	static int maxCost;
	private static void dfs1(int node, int dest, int edgesLeft, int cost, boolean[] visited, Graph g) {
	    if (node == dest) {
	        maxCost = Math.max(maxCost, cost);
	        return;
	    }

	    if (edgesLeft == 0)
	        return;

	    visited[node] = true;
	    for (Edge e : g.adj.get(node)) {
	        if (!visited[e.to]) {
	            dfs1(e.to, dest, edgesLeft - 1, cost + e.weight, visited, g);
	        }
	    }
	    visited[node] = false;
	}
	
	
	
	// =================================================================================
	
	//BFS Approach
	class State {
	    int node, cost, steps;
	    State(int n, int c, int s){ node=n; cost=c; steps=s; }
	}

	int maxCostPathPQ(List<List<Edge>> graph, int src, int dest, int K) {
	    PriorityQueue<State> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.cost, a.cost)); // max-heap
	    pq.offer(new State(src, 0, 0));
	    int max = Integer.MIN_VALUE;

	    while (!pq.isEmpty()) {
	        State cur = pq.poll();
	        if (cur.node == dest) 
	        	max = Math.max(max, cur.cost);
	        
	        if (cur.steps == K + 1) 
	        	continue;
	        
	        for (Edge e : graph.get(cur.node))
	            pq.offer(new State(e.to, cur.cost + e.weight, cur.steps + 1));
	    }
	    return max == Integer.MIN_VALUE ? -1 : max;
	}

	public static void main(String[] args) {
		V = 6;
		Graph g = new Graph(V);
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 5, 1);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);

		int src = 0, dest = 5, K = 3;
		int ans = maxCostPath(src, dest, K, g);

		if (ans == Integer.MIN_VALUE)
			System.out.println("No path within " + K + " intermediate nodes.");
		else
			System.out.println("Maximum cost path (≤ " + K + " intermediate nodes): " + ans);
	}
	
	
	static class Edge {
		int to, weight;
		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static class Graph {
		int V;
		List<List<Edge>> adj;

		Graph(int v) {
			V = v;
			adj = new ArrayList<>();
			for (int i = 0; i < v; i++)
				adj.add(new ArrayList<>());
		}

		void addEdge(int u, int v, int w) {
			adj.get(u).add(new Edge(v, w));
		}
	}

}
