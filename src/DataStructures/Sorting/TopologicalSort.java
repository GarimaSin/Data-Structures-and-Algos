package DataStructures.Sorting;

import java.util.LinkedList;
import java.util.Stack;
/**
 * 
 * For explanation: https://youtu.be/6Vi5Td_a8B8
 * Eg. in https://www.geeksforgeeks.org/topological-sorting/ 
 *
 */

public class TopologicalSort {

	static int size;
	boolean vis[] = new boolean[size];
	GraphListRepresentation g;

	public static void main(String[] args) {
		size = 6;				//no. of vertices
		GraphListRepresentation g = new GraphListRepresentation(size);
		g.addEdge(5, 2); 
		g.addEdge(5, 3); 
		g.addEdge(5, 0); 
		g.addEdge(4, 0); 
		g.addEdge(4, 1); 
		g.addEdge(2, 3); 
		g.addEdge(3, 1);

		TopologicalSort t = new TopologicalSort();
		t.tologicalSortUtil(g);
	}

	private void topSort(int vertex, Stack<Integer> stack, GraphListRepresentation g) {
		vis[vertex] = true;
//		Iterator<Integer> it = g.vertices[vertex].iterator();
		if(g.vertices[vertex] != null) {
			for(Integer temp : g.vertices[vertex]) {
				if(!vis[temp]) 
					topSort(temp, stack, g);		// for a vertex, traverse to all its child to reach the leaf vertex
			}
		}
		System.out.print(vertex + ", ");		// Code by me - reverse order of Topological
		stack.push(vertex);				//post-order of DFS
	}

	private void tologicalSortUtil(GraphListRepresentation g) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < size; i++) {
			if (vis[i] == false) 
				topSort(i, stack, g);
		}
		System.out.println(" ");
		while (stack.empty()==false) 
			System.out.print(stack.pop() + " "); 
	}
}

class GraphListRepresentation{
	int size;
	LinkedList<Integer> vertices[];

	@SuppressWarnings("unchecked")
	public GraphListRepresentation(int size) {
		this.size = size;
		this.vertices = new LinkedList[size];
		for(int i=0; i<size; i++) {
			LinkedList<Integer> callingNeighbours = new LinkedList<Integer>();
			vertices[i] = callingNeighbours;
		}
	}

	public void addEdge(int from, int to) {
		vertices[from].add(to);
	}
}
