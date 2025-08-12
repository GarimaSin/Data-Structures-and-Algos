package searches;

/**BFS uses Queue data structure
 * 
 * @author samsung
 *
 */
public class BFS {
   /* ------------------------------------------
      Data structure used to represent a graph
      ------------------------------------------ */
   int[][]  adjMatrix;
   int      rootNode = 0;
   int      NNodes;
   
   boolean[] visited; 

   /* -------------------------------
      Construct a graph of N nodes
      ------------------------------- */
   BFS(int[][] mat) {
      NNodes = mat.length;

      adjMatrix = new int[NNodes][NNodes];
      visited = new boolean[NNodes];


      for (int i=0; i < NNodes; i++)
         for (int j=0; j < NNodes; j++)
            adjMatrix[i][j] = mat[i][j];
   }

   public void BreadthFirstSearch() {
	   myQueue q = new myQueue();

      clearVisited();
      q.enqueue(0);            // Start the "to visit" at node 0

      /* ===========================================
         Loop as long as there are "active" node
         =========================================== */
      while( !q.isEmpty() )
      {
         int nextNode;                // Next node to visit
         nextNode = q.dequeue();

         if ( !visited[nextNode] )
         {
            visited[nextNode] = true;    // Mark node as visited
            System.out.println("nextNode = " + nextNode );

            for (int i = 0; i < NNodes; i++ )
               if ( adjMatrix[nextNode][i] > 0 && ! visited[i] )
                  q.enqueue(i);
         }
      }
   }

   int getUnvisitedChildNode(int n) {
      for (int j = 0; j < NNodes; j++ ) {
    	  if ( adjMatrix[n][j] > 0 ) {
    		  if ( ! visited[j] )
               return(j);
    	  }
      }
      return(-1);
   }
  
   public static void main(String[] args) {
//                        0  1  2  3  4  5  6  7  8
// ===================================================
      int[][] conn = {  { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  // 0
						{ 1, 0, 0, 0, 0, 0, 0, 1, 0 },  // 1
						{ 0, 0, 0, 1, 0, 1, 0, 1, 0 },  // 2
						{ 1, 0, 1, 0, 1, 0, 0, 0, 0 },  // 3
						{ 0, 0, 0, 1, 0, 0, 0, 0, 1 },  // 4
						{ 0, 0, 1, 0, 0, 0, 1, 0, 0 },  // 5
						{ 0, 0, 0, 0, 0, 1, 0, 0, 0 },  // 6
						{ 0, 1, 1, 0, 0, 0, 0, 0, 0 },  // 7
						{ 1, 0, 0, 0, 1, 0, 0, 0, 0 }   // 8
      };
      BFS G = new BFS(conn);
      G.BreadthFirstSearch();
   }
   

   void clearVisited() {
      for (int i = 0; i < visited.length; i++)
         visited[i] = false;
   }

   void printNode(int n) {
      System.out.println(n);
   }
}