package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrintAllHamiltonianPath {

	public static List<List<Integer>> allHamiltonianPaths(int n, int[][] edges) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

		for (int[] e : edges) {
			int u = e[0], v = e[1];
			adj.get(u).add(v);
			adj.get(v).add(u); // undirected
		}

		// debug print
		System.out.println("Adjacency:");
		for (int i=0;i<n;i++) System.out.println(i + " -> " + adj.get(i));

		List<List<Integer>> result = new ArrayList<>();
		boolean[] visited = new boolean[n];
		for (int start = 0; start < n; start++) {
			Arrays.fill(visited, false);
			LinkedList<Integer> path = new LinkedList<>();
			dfs(start, adj, visited, path, result, n);
		}
		return result;
	}

	static void dfs(int node, List<List<Integer>> adj, boolean[] visited,
			LinkedList<Integer> path, List<List<Integer>> result, int n) {
		visited[node] = true;
		path.add(node);

		if (path.size() == n) {
			result.add(new ArrayList<>(path));
		} else {
			for (int nei : adj.get(node)) {
				if (!visited[nei]) 
					dfs(nei, adj, visited, path, result, n);
			}
		}

		visited[node] = false;
		path.removeLast();
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] edges = {{0,1},{1,2},{2,3},{0,3}}; // your input
		List<List<Integer>> paths = allHamiltonianPaths(n, edges);
		System.out.println("Total Paths: " + paths.size());
		for (List<Integer> p : paths) 
			System.out.println(p);
	}
}
