package DataStructures.Traversal;

import java.util.Iterator;
import java.util.Stack;

import DataStructures.Graph.Representations.Graph_List_Representation;
import DataStructures.Graph.Representations.Graph_Matrix_Representation;



public class DFS {
	
	boolean vis[];
	boolean vis1[];
	boolean vis2[];
	public static void main(String[] args) {
		int size = 7;
		Graph_Matrix_Representation g1 = new Graph_Matrix_Representation(size);
		Graph_List_Representation g = new Graph_List_Representation(size);
//		g.addEdge(0, 1); 
//        g.addEdge(0, 3); 
//        g.addEdge(1, 2); 
//        g.addEdge(1, 5); 
//        g.addEdge(2, 4); 
//        g.addEdge(2, 6); 
//        g.addEdge(6, 4); 
//        g.addEdge(4, 1); 
//        g.addEdge(4, 5); 
//        g.addEdge(5, 0); 
//        g.addEdge(3, 5); 
		
		g1.addEdge(0, 1); 
        g1.addEdge(0, 2); 
        g1.addEdge(1, 2); 
        g1.addEdge(2, 0); 
        g1.addEdge(2, 3); 
        g1.addEdge(3, 3); 
		
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        DFS d = new DFS();
        d.vis = new boolean[size];
        d.vis1 = new boolean[size];
        d.vis2 = new boolean[size];
        d.dfs(g);
        System.out.println("_______________________");
        d.dfs(g1);
        System.out.println("Recursion...................");
        d.DFSRecursion(g, 0, d.vis2);
	}
	
    
    public void dfs(Graph_List_Representation g) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		vis[0] = true;
		while(!stack.isEmpty()) {
			int node = stack.pop();
			System.out.println("Node "+node);
			Iterator<Integer> i = g.vertices[node].iterator();
			while(i.hasNext()) {
				int vertex = (int) i.next();
				if(!vis[vertex]) {
					stack.push(vertex);
					vis[vertex] = true;				// MARK TRUE
				}
			}
		}
	}
	
	public void dfs(Graph_Matrix_Representation g) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		vis1[0] = true;
		while(!stack.isEmpty()) {
			int node = stack.pop();
			System.out.println("Node "+node);
			for(int i=0; i<g.adj[node].length; i++) {
				if(g.adj[node][i] == 1 && !vis1[i]) {
					stack.push(i);
					vis1[i] = true;
				}
			}
		}
	}
	
	private void DFSRecursion(Graph_List_Representation graph, int v, boolean[] visited) {
		visited[v] = true;
		System.out.println("Node "+v);
		// do for every edge (v -> u)
		for (int u : graph.vertices[v])
		{
			// u is not visited
			if (!visited[u])
				DFSRecursion(graph, u, visited);
		}
	}
}
