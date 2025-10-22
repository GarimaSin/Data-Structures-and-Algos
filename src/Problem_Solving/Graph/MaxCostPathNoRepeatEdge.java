package Problem_Solving.Graph;

import java.util.*;

/**
 * Max cost path in an undirected graph where each edge may be used at most once.
 * This prevents immediate backtracking and also guarantees finiteness (no infinite positive cycles).
 *
 * Complexity: exponential in worst-case (longest path problem is NP-hard).
 */
public class MaxCostPathNoRepeatEdge {

	static class Edge {
		int to;
		int wt;
		int id; // unique id for the undirected edge
		Edge(int to, int wt, int id) { 
			this.to = to; this.wt = wt; this.id = id; 
		}
	}


	static class Result {
		int maxCost = Integer.MIN_VALUE;
		List<Integer> bestPath = new ArrayList<>();
	}

	static void dfs(int node, int dest, List<List<Edge>> adj, boolean[] usedEdge, int currentCost, LinkedList<Integer> path, Result res) {
		if (node == dest) {
			if (currentCost > res.maxCost) {
				res.maxCost = currentCost;
				res.bestPath = new ArrayList<>(path);
			}
			// continue searching if u want other paths as well (but edges can't be reused)
			// return if you want to stop at 1st found
		}

		for (Edge e : adj.get(node)) {
			if (!usedEdge[e.id]) {
				// take edge e
				usedEdge[e.id] = true;
				path.addLast(e.to);
				dfs(e.to, dest, adj, usedEdge, currentCost + e.wt, path, res);
				path.removeLast();
				usedEdge[e.id] = false;
			}
		}
	}

	/**
	 * Build adjacency list and run DFS backtracking.
	 * @param n number of nodes (0..n-1)
	 * @param edges list of edges: each entry {u, v, w}
	 * @param src source node
	 * @param dest destination node
	 * @return Result containing maxCost and bestPath (empty path if no path exists)
	 */
	public static Result maxCostPath(int n, int[][] edges, int src, int dest) {
		int m = edges.length;
		// adjacency list
		List<List<Edge>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<>());

		// assign an id to each undirected edge (0..m-1)
		for (int i = 0; i < m; i++) {
			int u = edges[i][0], v = edges[i][1], w = edges[i][2];
			adj.get(u).add(new Edge(v, w, i));
			adj.get(v).add(new Edge(u, w, i));
		}

		boolean[] usedEdge = new boolean[m];
		Result res = new Result();

		LinkedList<Integer> path = new LinkedList<>();
		path.add(src);
		dfs(src, dest, adj, usedEdge, 0, path, res);

		return res;
	}

	public static void main(String[] args) {
		// Graph: 0--1(10), 1--2(10), 0--2(3), 1--3(6), 2--3(7)
		// edges format: {u, v, weight}
		int[][] edges = {
				{0,1,10},
				{1,2,10},
				{0,2,3},
				{1,3,6},
				{2,3,7}
		};
		int n = 4;
		int src = 0, dest = 3;

		Result ans = maxCostPath(n, edges, src, dest);
		if (ans.maxCost == Integer.MIN_VALUE) {
			System.out.println("No path from " + src + " to " + dest);
		} else {
			System.out.println("Max cost = " + ans.maxCost);
			System.out.println("Path = " + ans.bestPath);
		}
	}
}