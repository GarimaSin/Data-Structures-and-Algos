package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

//Working
public class CourseSchedule2 {
	static boolean[] vis;
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        int n = numCourses;
        vis = new boolean[n];
        buildGraph(prerequisites, graph, numCourses);
        
        int ans[] = new int[numCourses];
        boolean[] processed = new boolean[n];
        for (int i = 0; i < n; i++)
            if (isCycllic(graph, numCourses, i, vis, processed))
                return new int[n];
        
        Stack<Integer> stack = new Stack<>();
		for (int i = 0; i <n ; i++) {
			if (vis[i] == false) 
				topSort(i, stack, graph);
		}
        int i = 0;
		while (stack.empty()==false) {
            ans[i] = stack.pop();
            i++;
        }
        return ans;
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
    
    static void topSort(int vertex, Stack<Integer> stack, ArrayList<Integer> graph[]) {
		vis[vertex] = true;
		Iterator<Integer> it = graph[vertex].iterator();
		while(it.hasNext()) {
			int temp = it.next();
			if(!vis[temp]) 
				topSort(temp, stack, graph);		
		}
		stack.push(vertex);				
	}
    
    static void buildGraph(int[][] prerequisites, ArrayList<Integer> graph[], int n) {
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
		
        for(int[] edge : prerequisites) {
            int source = edge[1];
            int dest = edge[0];
            graph[source].add(dest);
        }
    }
    
    public static void main(String[] args) {
		int numCourses = 2, prerequisites[][] = {{1,0}, {0,1}};
		int ans[] = findOrder(numCourses, prerequisites);
		for(int i: ans)
			System.out.print(i + " ");
	}
}
