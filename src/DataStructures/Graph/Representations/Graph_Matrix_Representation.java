package DataStructures.Graph.Representations;

public class Graph_Matrix_Representation {

	public int NoOfnodes;
	public int adj[][];
	
	
	public Graph_Matrix_Representation(int NoOfnodes) {
		this.NoOfnodes = NoOfnodes;
		adj = new int[NoOfnodes][NoOfnodes];
	}
	
	public void addEdge(int from, int to) {
		adj[from][to] = 1;
	}
}
