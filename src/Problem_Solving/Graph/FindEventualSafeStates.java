package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
	public static List<Integer> eventualSafeNodes(int[][] graph) {
		int[] vis = new int[graph.length];
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < graph.length; i++){
			if(checkSafeNodes(graph, i, vis)){
				res.add(i);
			}
		}
		return res;
	}

	public static boolean checkSafeNodes(int[][] graph, int src, int[] vis) {
		if(vis[src] == 2) 
			return true;

		if(vis[src] == 1) 
			return false;

		vis[src] = 1;
		int[] edge = graph[src];
		for(int i = 0; i < edge.length; i++){
			if(!checkSafeNodes(graph, edge[i], vis)){
				return false;
			}
		}
		vis[src] = 2;
		return true;
	}

	public static void main(String[] args) {
		int graph[][] = {{1,2},{2,3},{5},{0},{5},{},{}};
		List<Integer> ans = eventualSafeNodes(graph);
		System.out.println(ans);
	}
}