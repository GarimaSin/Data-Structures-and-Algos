package searches;

/**DFS uses Stack data structure
 * 
 * @author samsung
 *
 */
public class DFS
{
	/* ------------------------------------------
      Data structure used to represent a graph
      ------------------------------------------ */
	int[][]  adjMatrix;
	int      rootNode = 0;
	int      NNodes;				// size of matrix

	boolean[] visited; 

	/* ---------------------------------------------
      Construct a graph with the adjacency matrix
      --------------------------------------------- */
	public DFS(int[][] mat) {
		NNodes = mat.length;

		adjMatrix = new int[NNodes][NNodes];
		visited = new boolean[NNodes];

		for (int i=0; i < NNodes; i++)
			for (int j=0; j < NNodes; j++)
				adjMatrix[i][j] = mat[i][j];
	}

	public void DepthFirstSearch() {
		// Visit nodes using a Stack to store "to visit" nodes

		myStack s = new myStack();  // Create a stack
		clearVisited();       		// Set all visited[i] = 0

		s.push(0);            		// Start the "to visit" at node 0

		/* ===========================================
		Loop as long as there are "active" node
		=========================================== */
		while( !s.isEmpty() ) {
			int nextNode;                // Next node to visit
			nextNode = s.pop();

			if ( ! visited[nextNode] ) {
				visited[nextNode] = true;    // Mark node as visited
				System.out.println("nextNode = " + nextNode );

				for (int i = NNodes-1; i >=0 ; i-- )
					if ( adjMatrix[nextNode][i] > 0 && ! visited[i] )
						s.push(i);
			}
		}
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
				{ 1, 0, 0, 0, 1, 0, 0, 0, 0 } };// 8

		DFS G = new DFS(conn);
		G.DepthFirstSearch();
	}

	void clearVisited() {
		for (int i = 0; i < visited.length; i++)
			visited[i] = false;
	}

	void printNode(int n) {
		System.out.println(n);
	}
}
