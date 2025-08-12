package DataStructures.Graph.Representations;

import java.util.LinkedList;

public class Graph_List_Representation {
	public LinkedList<Integer> vertices[];			// Declared an array of linked list
	int size;
	
	public Graph_List_Representation(int size) {
		this.size = size;
		this.vertices = new LinkedList[size];
		for(int i=0; i<size; i++){
			LinkedList<Integer> adj = new LinkedList<Integer>();
			vertices[i] = adj;
		}
	}
	
	public void addEdge(int from, int to) {
		vertices[from].add(to);
	}
}
