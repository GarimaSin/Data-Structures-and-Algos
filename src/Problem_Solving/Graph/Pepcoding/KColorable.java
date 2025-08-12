package Problem_Solving.Graph.Pepcoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KColorable {
	private static String COLORS[] = {"", "BLUE", "GREEN", "RED", "YELLOW",
			"ORANGE", "PINK", "BLACK", "BROWN", "WHITE", "PURPLE"};

	private static boolean isSafe(Graph graph, int[] color, int v, int c)  {
		// check the color of every adjacent vertex of `v`
		for (int u: graph.adjList.get(v)) {
			if (color[u] == c) {
				return false;
			}
		}
		return true;
	}

	public static void kColorable(Graph g, int[] color, int k, int v, int n)  {
		// if all colors are assigned, print the solution
		if (v == n)  {
			for (v = 0; v < n; v++) {
				System.out.printf("%-8s" , COLORS[color[v]]);
			}
			System.out.println();
			return;
		}

		// try all possible combinations of available colors
		for (int c = 1; c <= k; c++)  {
			if (isSafe(g, color, v, c))  {
				// assign color `c` to vertex `v`
				color[v] = c;
				kColorable(g, color, k, v + 1, n);
				color[v] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// List of graph edges as per the above diagram
		List<Edge> edges = Arrays.asList(
				new Edge(0, 1), new Edge(0, 4), new Edge(0, 5), new Edge(4, 5),
				new Edge(1, 4), new Edge(1, 3), new Edge(2, 3), new Edge(2, 4)
				);
		// Set number of vertices in the graph
		int n = 6;
		// build a graph from the given edges
		Graph g = new Graph(edges, n);
		int k = 3;
		int[] color = new int[n];
		kColorable(g, color, k, 0, n);
	}
}


//A class to store a graph edge
class Edge {
	int source, dest;

	public Edge(int source, int dest)  {
		this.source = source;
		this.dest = dest;
	}
}

class Graph {
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