package DataStructures.Traversal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import DataStructures.Graph.Representations.Graph_List_Representation;
import DataStructures.Graph.Representations.Graph_Matrix_Representation;

/**
 * 
 * It focuses on nodes and not edges, hence there might be some edges which are never visited
 *
 */
public class BFS {

	boolean vis[];
	public static void main(String[] args) {
		int size = 7;
//		Graph_Matrix_Representation g = new Graph_Matrix_Representation(size);
		Graph_List_Representation g = new Graph_List_Representation(size);
		g.addEdge(0, 1); 
        g.addEdge(0, 3); 
        g.addEdge(1, 2); 
        g.addEdge(1, 5); 
        g.addEdge(2, 4); 
        g.addEdge(2, 6); 
        g.addEdge(6, 4); 
        g.addEdge(4, 1); 
        g.addEdge(4, 5); 
        g.addEdge(5, 0); 
        g.addEdge(3, 5); 
        BFS b = new BFS();
        b.vis = new boolean[size];
        b.bfs(g);
	}
	
	public void bfs(Graph_Matrix_Representation g) {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		vis[0] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int i=0; i<g.NoOfnodes; i++) {
				if(g.adj[node][i] == 1 && !vis[i]) {
					q.add(i);
					vis[i] = true;				// MIND IT
				}
			}
		}
	}
	
	public void bfs(Graph_List_Representation g) {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		vis[0] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.println("Node "+node);
			Iterator<Integer> i = g.vertices[node].iterator();		//iterate over the neighbors of that node (List for that array)
			while(i.hasNext()) {
				int vertex = (int) i.next();
				if(!vis[vertex]) {
					q.add(vertex);
					vis[vertex] = true;
				}
			}
		}
	}
}


