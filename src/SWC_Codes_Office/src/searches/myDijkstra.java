package SWC_Codes_Office.src.searches;

/** Working Dijkstra's Algo
 * 
 * @author samsung
 *
 */
public class myDijkstra
{
	static int size = 7;
   public static void main(String[] args) {
	   
    /*                    A  B  C  D  E  F  G  H  I
     					  0  1  2  3  4  5  6  7  8
// ===================================================
      int[][] graph = { { 0, 3, 7, 5, 0, 0, 0, 0, 0 },  // A
						{ 3, 0, 1, 0, 7, 0, 0, 0, 0 },  // B
						{ 7, 1, 0, 3, 2, 1, 3, 0, 0 },  // C
						{ 5, 0, 3, 0, 0, 0, 2, 0, 0 },  // D
						{ 0, 7, 2, 0, 0, 2, 0, 1, 0 },  // E
						{ 0, 0, 1, 0, 2, 0, 3, 3, 2 },  // F
						{ 0, 0, 3, 2, 0, 3, 0, 0, 4 },  // G
						{ 0, 0, 0, 0, 1, 3, 0, 0, 5 },  // H
						{ 0, 0, 0, 0, 0, 2, 4, 5, 0 } };// I
      
      
      
      int[][] graph = { { 0, 5, 10, 0, 0},  // A
						{ 5, 0, 3, 11, 0},  // B
						{ 10, 3, 0, 2, 0},  // C
						{ 0, 11, 2, 0, 3},  // D
						{ 0, 0, 0, 3, 0}};// E
	   
	  
		  0  1  2  3  4  5  6  7  8
//===================================================
*/
	   
	   int[][] graph = { 
		
//        A   B   C   D  E  F  G  H  I
		{ 0,  5,  10, 0, 0, 0, 0},  // A
		{ 5,  0,  0,  6, 3, 0, 0},  // B
		{ 10, 0,  0,  0, 2, 0, 0},  // C
		{ 0,  6,  0,  0, 2, 6, 0},  // D
		{ 0,  3,  2,  2, 0, 0, 2},  // E
		{ 0,  0,  0,  6, 0, 0, 2},  // F
		{ 0,  0,  0,  0, 2, 2, 0}  // G
			};// I
      

      myDijkstra G = new myDijkstra();
      G.dijkstra(graph, 1);
   }
   
   int minDistance(int dist[], boolean visited[]) {
      // Returns the vertex with the minimum value (from dist[]) and visited == false
	   // Eg. for Src = b, it returns 0, 3, 6 etc.
	   
      int min = Integer.MAX_VALUE, min_index = 0;
    
      for (int v = 0; v < size; v++)
        if (visited[v] == false && dist[v] <= min){
            min = dist[v]; min_index = v;
        }
    
      return min_index;
   }
   
   void dijkstra(int graph[][], int src) {
        int dist[] = new int[size]; 
    
        boolean visited[] = new boolean[size]; // visited[i] will true if vertex i is included in shortest path tree or shortest distance from src to i is finalized
    
        for (int i = 0; i < size; i++){
           dist[i] = Integer.MAX_VALUE; 
           visited[i] = false;
        }
    
        dist[src] = 0;
    
        // Find shortest path for all vertices
        for (int count = 0; count < size-1; count++)
        {
          // Pick the minimum distance vertex from the set of vertices not yet processed. u is always equal to src in first iteration.
          int u = minDistance(dist, visited);
    
          // Mark the picked vertex as processed
          visited[u] = true;
    
          // Update dist value of the adjacent vertices of the picked vertex.
          for (int v = 0; v < size; v++){
    
            // Update dist[v] only if is not in visited, there is an edge from u to v, and total weight of path from src to  v through u is smaller than current value of dist[v]
            if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE 
                                          && dist[u]+graph[u][v] < dist[v])
               dist[v] = dist[u] + graph[u][v];
          }
        }
        printSolution(dist, size);
   }
   
   void printSolution(int dist[], int n) {
      System.out.println("Vertex   Distance from Source\n");
      for (int i = 0; i < size; i++)
    	  System.out.printf("%d \t\t %d\n", i, dist[i]);
   }
}
