package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestPathWithAlternatingColors {

	public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
		int[] res = new int[n];
		Arrays.fill(res, Integer.MAX_VALUE);
		List<List<pair>> graph = new ArrayList<>(n);
		for(int i=0;i<n;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int[] r : redEdges) {
			int color = 0;
			int dest = r[1];
			graph.get(r[0]).add(new pair(dest, color));
		}

		for(int[] b : blueEdges) {
			int color = 1;
			int dest = b[1];
			graph.get(b[0]).add(new pair(dest, color));
		}

		int level = 0;
		Set<String> visited = new HashSet<>();
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(0,2));

		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				pair p = q.poll();
				int col = p.color;
				int src = p.dest;
				String s = src+"-"+col;
				if(visited.contains(s))
					continue;
				visited.add(s);
				res[src] = Math.min(res[src], level);
				for(pair e : graph.get(src)){
					if(col != e.color){
						q.add(e);
					}
				}
			}
			level++;
		}
		
		for(int i = 0; i < n; i++) {
			if(res[i]==Integer.MAX_VALUE){
				res[i] = -1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int n = 3, redEdges[][] = {{0,1},{0,2}}, blueEdges[][] = {{1,0}};
		int ans[] = shortestAlternatingPaths(n, redEdges, blueEdges);
		for(int i: ans)
			System.out.print(i+" ");
	}
	
	static class pair {
		int color;		// red : 0	// blue : 1
		int dest;
		public pair(int dest, int color) {
			this.color = color;
			this.dest = dest;
		}
	}
}
