package Problem_Solving.Graph;

import java.util.ArrayList;

//Working
public class CourseSchedule {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0) 
			return true; 

		ArrayList<Integer> graph [] = new ArrayList[numCourses];
		int n = numCourses;
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int[] edge : prerequisites) {
			int source = edge[1];
			int dest = edge[0];
			graph[source].add(dest);
		}
		boolean[] vis = new boolean[n];
		boolean[] processed = new boolean[n];
		for (int i = 0; i < n; i++)
			if (isCycllic(graph, numCourses, i, vis, processed))
				return false;
		return true;
	}

	static boolean isCycllic(ArrayList<Integer>[] graph, int count, int node, boolean[] vis, boolean[] processed) {
		if(vis[node])
			return true;

		if(processed[node])		//coz then v r exploring the already explored path
		return false;

		vis[node] = true;
		processed[node] = true;
		for(int tmp: graph[node]) {
			if(isCycllic(graph, count, tmp, vis, processed))
				return true;
		}
		vis[node] = false;
		return false;
	}

	public static void main(String[] args) {
		int numCourses = 2, prerequisites[][] = {{1,0}, {0,1}};
		System.out.println(canFinish(numCourses, prerequisites));
	}
}