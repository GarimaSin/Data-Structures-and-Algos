package Problem_Solving.Graph.Pepcoding;

import java.util.ArrayList;
import java.util.Stack;

public class MotherVertex {

	public static void main(String args[]) throws Exception {
		int nodes = 5;
		int edges = 4;
		int arr[][] = {{4,3},
				{1,2},
				{2,3},
				{3,4}};
		ArrayList<ArrayList<Integer>> graph = new ArrayList< >();
		for (int i = 0; i < nodes; i++) {
			graph.add(new ArrayList< >());
		}

		for (int i = 0; i < arr.length; i++) {
			graph.get(arr[i][0]).add(arr[i][1]);
		}
		System.out.println(findMotherVertex(nodes, graph));
	}

	public static int findMotherVertex(int N, ArrayList< ArrayList< Integer>>graph) {
		Stack< Integer> stack = new Stack< >();
		boolean[]vis = new boolean[N];
		for (int i = 1; i <= N; i++) {
			if (vis[i] == false) {
				dfs(graph, vis, i, stack);
			}
		}
		int ans = stack.pop();
		vis = new boolean[N];
		count = 0;
		dfs(graph, vis, ans);
		if (count == N) {
			return ans + 1;
		} else {
			return -1;
		}
	}


	static int count;
	public static void dfs(ArrayList< ArrayList< Integer>> graph, boolean[]visited, int cur, Stack< Integer> stack) {
		visited[cur] = true;
		for (int nbrs : graph.get(cur)) {
			if (visited[nbrs] == false) {
				dfs(graph, visited, nbrs, stack);
			}
		}
		stack.push(cur);
	}

	public static void dfs(ArrayList< ArrayList< Integer>> graph, boolean[]visited, int cur) {
		visited[cur] = true;
		count++;
		for (int nbrs : graph.get(cur)) {
			if (visited[nbrs] == false) {
				dfs(graph, visited, nbrs);
			}
		}
	}
}
