package Problem_Solving;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test {


	public static void main(String[] args) {
		int[][] graph = {{1,2},{3},{3},{}};
		allPathsSourceTarget(graph);
	}
	public static List<List<Integer>> allPathsSourceTarget(int[][] inp) {
		List<List<Integer>> graph = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		
		for (int i=0; i < inp.length; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i=0; i < inp.length; i++) {
			List<Integer> list = graph.get(i);
			for(int j=0; j<inp[i].length; j++) {
				list.add(inp[i][j]);
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while(!q.isEmpty() ) {
			int node = q.remove();
			for (int neighb : graph.get(node)) {
				
			}
		}
		
		return graph;
	}
}
