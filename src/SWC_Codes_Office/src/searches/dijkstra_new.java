package SWC_Codes_Office.src.searches;


public class dijkstra_new {
	static int size = 7;
	static int dist[] = new int[size]; 
	static boolean visited[] = new boolean[size];
	static int[][] roads = { 
			
//	          A   B   C   D  E  F  G  
			{ 0,  5,  10, 0, 0, 0, 0},  // A
			{ 5,  0,  0,  6, 3, 0, 0},  // B
			{ 10, 0,  0,  0, 2, 0, 0},  // C
			{ 0,  6,  0,  0, 2, 6, 0},  // D
			{ 0,  3,  2,  2, 0, 0, 2},  // E
			{ 0,  0,  0,  6, 0, 0, 2},  // F
			{ 0,  0,  0,  0, 2, 2, 0}  // G
				};// I
	      

		
	   public static void main(String[] args) {
		  
//			  0  1  2  3  4  5  6  7  8
	////===================================================
		   
		   
		   for (int i = 0; i < size; i++){
	           dist[i] = Integer.MAX_VALUE; // sptSet[i] = false;
	        }
		   dijkstra(0);
		   printSolution(dist, size);
	   }
	   
	   static void dijkstra(int src){
	        int u=-2;
	        for(int count=0;count<size;count++){
	        u=findMinDist();
	        if(u!=-1){
	        visited[u]=true;
	        for(int i=0;i<size;i++){
	            if(!visited[i] && roads[u][i]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+roads[u][i]<dist[i]){
	                dist[i]=dist[u]+roads[u][i];
	            }
	          }
	         }
	        }
	    }

		
		static int findMinDist(){
	        long min=Long.MAX_VALUE;
	        int min_index=-1;
	        for(int i=0;i<size;i++){
	            if(!visited[i] && dist[i]<min){
	                min=dist[i];
	                min_index=i;
	            }
	        }
	        return min_index;
	    }
		
		static void printSolution(int dist[], int n) {
		      System.out.println("Vertex   Distance from Source\n");
		      for (int i = 0; i < size; i++)
		    	  System.out.printf("%d \t\t %d\n", i, dist[i]);
		   }

//	private static void calculateDistance(int[][] graph, int src) {
//		int dist[] = new int[size]; 
//		Queue<Integer> que = new LinkedList<Integer>();
//		int[] q = new int[size];
//	    
//        boolean visited[] = new boolean[size]; 
//        for (int i = 0; i < size; i++){
//           dist[i] = Integer.MAX_VALUE; visited[i] = false;
//        }
//        
//       dist[src] = 0;
//       int count = 0;
//       if(visited[src] == false){
//	       for(int i=0; i<size; i++){
//	    	   if(graph[src][i] != 0){
////	    		   que.add(i);
//	    		   q[count] = i;
//	    	   }
//	       }
//	       
//	       for(int j=0; j<q.length; j++){
////	    	   dist[q[j]] = 
//	       }
//       }
//	}

}
