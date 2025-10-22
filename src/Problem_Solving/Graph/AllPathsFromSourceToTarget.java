package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(0);
        helper(al, l, graph, 0);
        return al;
    }
	
    void helper(List<List<Integer>> al, List<Integer> l, int[][] graph, int source) {
        if(source == graph.length-1) {
            al.add(new ArrayList<>(l));
            return;
        }
        
        for(int x: graph[source]) {
            l.add(x);
            helper(al, l, graph, x);
            l.remove(l.size()-1);
        }
    }
}