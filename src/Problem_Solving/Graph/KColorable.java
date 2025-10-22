
package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KColorable {
	//	private static String COLORS[] = {"", "BLUE", "GREEN", "RED", "YELLOW",
	//			"ORANGE", "PINK", "BLACK", "BROWN", "WHITE", "PURPLE"};

	static boolean isSafe(List<List<Integer>> adj, int[] color, int vertex, int c) {
		for (int neighbor : adj.get(vertex)) {
			if (color[neighbor] == c)
				return false;
		}
		return true;
	}


	static boolean kColorable(List<List<Integer>> adj, int[] color, int m, int vertex, int n) {
		if (vertex == n)
			return true;

		for (int c = 1; c <= m; c++) {
			if (isSafe(adj, color, vertex, c)) {
				color[vertex] = c;
				if (kColorable(adj, color, m, vertex + 1, n))
					return true;
				color[vertex] = 0; // backtrack
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// List of graph edges as per the above diagram
		List<Edge> edges = Arrays.asList(
				new Edge(0, 1), new Edge(0, 4), new Edge(0, 5), new Edge(4, 5),
				new Edge(1, 4), new Edge(1, 3), new Edge(2, 3), new Edge(2, 4)
				);
		
		
		// Set number of vertices in the graph
		int n = 6;
		
		Graph g = new Graph(edges, n);
		int k = 3;
		int[] color = new int[n];
		kColorable(g.adjList, color, k, 0, n);
	}
	
	static class Edge {
		int source, dest;

		public Edge(int source, int dest)  {
			this.source = source;
			this.dest = dest;
		}
	}
	
	static class Graph {
		List<List<Integer>> adjList = null;

		// Constructor
		Graph(List<Edge> edges, int n)  {
			adjList = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				adjList.add(new ArrayList<>());
			}

			// add edges to the undirected graph
			for (Edge edge: edges)  {
				int src = edge.source;
				int dest = edge.dest;

				adjList.get(src).add(dest);
				adjList.get(dest).add(src);
			}
		}
	}
}