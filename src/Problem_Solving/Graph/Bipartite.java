package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Using BFS
public class Bipartite {

	final static int V = 4; // No. of Vertices

	public boolean possibleBipartition(int n, int[][] dislikes) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] d : dislikes) {
            graph.get(d[0]).add(d[1]);
            graph.get(d[1]).add(d[0]);
        }
        
        int[] color = new int[n + 1]; // 0 = uncolored, 1 and -1 are two groups
        
        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) 
            	continue;
            
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;
            
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int neighb : graph.get(node)) {
                    if (color[neighb] == 0) {
                        color[neighb] = -color[node];
                        q.add(neighb);
                    } else if (color[neighb] == color[node]) {
                        return false; // conflict
                    }
                }
            }
        }
        return true;
    }

	public static void main(String[] args) {
		int dislikes[][] = {{1,2},{1,3},{2,4}};
		Bipartite b = new Bipartite();
		if (b.possibleBipartition(5, dislikes))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}