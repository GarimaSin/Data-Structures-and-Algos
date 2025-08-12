package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReorderRoutesToMakeAllPathsLeadToCityZero {

	public static int minReorder(int n, int[][] connections) {
		HashMap<Integer, List<Integer>> graph = new HashMap<>();

		for(int i=0; i<n; i++)
			graph.put(i, new ArrayList<>());

		HashSet<String> set = new HashSet<>();
		int ans = 0;

		for(int[] edge: connections){
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);

			set.add(edge[0]+","+edge[1]);
		}

		boolean[] visited = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		visited[0] = true;
		q.offer(0);

		while(!q.isEmpty()){
			int src = q.poll();

			for(int u: graph.get(src)) {
				if(!visited[u]) {
					visited[u] = true;
					if(!set.contains(u+","+src))
						ans++;

					q.offer(u);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int n = 3, connections[][] = {{1,0},{2,0}}; 
		minReorder(n, connections);
	}
}
