package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseSchedule4 {

	public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
		int[][] dist = constructGraph(numCourses, prerequisites);

		int V = numCourses;
		for (int k = 0; k < V; k++) { 
			for (int i = 0; i < V; i++) { 
				for (int j = 0; j < V; j++) { 
					if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
						dist[i][j] = 1;
					} 
				} 
			} 
		}
		List<Boolean> result = new ArrayList<>();
		for(int i = 0; i < queries.length; i++) {
			if(dist[queries[i][0]][queries[i][1]] != Integer.MAX_VALUE) {
				result.add(true);
			} else {
				result.add(false);
			}
		}
		return result;
	}

	int[][] constructGraph(int n, int[][] edges) {
		int[][] dist = new int[n][n];
		for(int i = 0; i < n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[i][i] = 1;
		}

		for(int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			dist[u][v] = 1;
		}

		return dist;
	}
}
