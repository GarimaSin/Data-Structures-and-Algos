package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinNoOfVerticesToReachAllNodes {

	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		HashMap<Integer, Integer> indegree = new HashMap<>();
		for(List<Integer> edge: edges) {
			int end = edge.get(1);
			indegree.put(end, indegree.getOrDefault(end, 0) +1);
		}
		
		List<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if(!indegree.containsKey(i))
				ans.add(i);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		
	}
}
