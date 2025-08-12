package DataStructures.Graph.APSP;


/**
 * Loop = k, i, j. i-k, k-j < i-j
 * No visited arr[] but dis[] initialized to original graph's value
 *
 */
public class FloydWarshall { 
	final static int INF = 99999, V = 4; 

	boolean negCyclefloydWarshall(int graph[][]) { 
		int dist[][] = new int[V][V]; 
		int i, j, k; 

		/* Initialize the solution matrix same as input graph matrix. Or we can say the initial values of shortest distances 
		are based on shortest paths considering no intermediate vertex. */
		for (i = 0; i < V; i++) 
			for (j = 0; j < V; j++) 
				dist[i][j] = graph[i][j]; 

		/* Add all vertices one by one to the set of intermediate vertices. 
		---> Before start of an iteration, we have shortest distances between all pairs of vertices such that 
			the shortest distances consider only the vertices in set {0, 1, 2, .. k-1} as intermediate vertices. 
		----> After the end of an iteration, vertex no. k is added to the set of intermediate vertices and the set 
				becomes {0, 1, 2, .. k} */
		
		/**   MAIN FW FUNCTION  **/
		for (k = 0; k < V; k++) { 
			// Pick all vertices as source one by one 
			for (i = 0; i < V; i++) { 
				// Pick all vertices as destination for the above picked source 
				for (j = 0; j < V; j++) { 
					// If vertex k is on the shortest path from i to j, then update the value of dist[i][j] 
					if (dist[i][k] + dist[k][j] < dist[i][j]) 
						dist[i][j] = dist[i][k] + dist[k][j]; 
				} 
			} 
		} 
		
		
		/**   FUNCTION TO CHECK -VE CYCLE  **/
		for (i = 0; i < V; i++) 
            if (dist[i][i] < 0) 
                return true; 
  
		// Print the shortest distance matrix 
		printSolution(dist);
        return false; 
	} 

	void printSolution(int dist[][]) { 
		System.out.println("The following matrix shows the shortest "+ 
				"distances between every pair of vertices"); 
		for (int i=0; i<V; ++i) { 
			for (int j=0; j<V; ++j) { 
				if (dist[i][j]==INF) 
					System.out.print("INF "); 
				else
					System.out.print(dist[i][j]+" "); 
			} 
			System.out.println(); 
		} 
	} 

	public static void main (String[] args) { 
		/* Let us create the following weighted graph 
		10 
		(0)------->(3) 
		|		 /|\ 
		5 |		 | 
		|		 | 1 
		\|/		 | 
		(1)------->(2) 
		3		 */
		int graph[][] = { {0,   5,  INF, 10}, 
                {INF, 0,   3, INF}, 
                {INF, INF, 0,   1}, 
                {INF, INF, INF, 0} 
              }; 
		
//		int graph[][] = { 						-ve cycle graph
//				{0, -8, INF, 1}, 
//				{INF, 0, 1, INF}, 
//				{4, INF, 0, INF}, 
//				{INF, 2, 9, 0} 
//		}; 
		
		
		FloydWarshall a = new FloydWarshall(); 
		
		if (a.negCyclefloydWarshall(graph)) 
            System.out.print("Yes"); 
        else
            System.out.print("No"); 
	} 
} 

