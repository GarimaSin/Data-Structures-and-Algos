package DataStructures.Graph.SSSP;

import java.util.LinkedList;
import java.util.Queue;

/**  
 * SAME AS BFS UNTIL THE CONDITION at line 80
 * Initialize a new dis[] with integer.max, it stores the final answer
 * For all vertex, enque in Q the src, deQ the vertex and check FOR ALL ITS NEIGHBOURS, 
 * is vertex not visited and dis. of the vertex is less than dis of current vertex + the edge's weight
 **/

//Working 
public class Dijkstra_Mine {
	static int size;
	boolean vis[];
	static int dis[];
	static AdjList adjList; 
	public static void main(String[] args) {

		Dijkstra_Mine dj = new Dijkstra_Mine();
		size = 6;
		int source = 0;
		dis = new int[size];
		dj.vis = new boolean[size];

		AdjMat adj = new AdjMat(size);
		adjList = new AdjList(size); 

		adj.addUndirectedEdge(0, 2, 3);
		adj.addUndirectedEdge(0, 1, 4);
		adj.addUndirectedEdge(1, 2, 1);
		adj.addUndirectedEdge(1, 3, 2);
		adj.addUndirectedEdge(3, 2, 4);
		adj.addUndirectedEdge(3, 4, 2);
		adj.addUndirectedEdge(5, 4, 6);


		adjList.addUndirectedEdge(0, 2, 3);
		adjList.addUndirectedEdge(0, 1, 4);
		adjList.addUndirectedEdge(1, 2, 1);
		adjList.addUndirectedEdge(1, 3, 2);
		adjList.addUndirectedEdge(3, 2, 4);
		adjList.addUndirectedEdge(3, 4, 2);
		adjList.addUndirectedEdge(5, 4, 6);
		
		//Prims's
		adj.addUndirectedEdge(1,2,10); //Add undirected Edge between A-B with Weight 10
		adj.addUndirectedEdge(1,3,20); //Add undirected Edge between A-C with Weight 20
		adj.addUndirectedEdge(2,3,30); //Add undirected Edge between B-C with Weight 30
		adj.addUndirectedEdge(2,4,5);  //Add undirected Edge between B-D with Weight 5
		adj.addUndirectedEdge(3,4,15); //Add undirected Edge between C-D with Weight 15
		adj.addUndirectedEdge(3,5,6);  //Add undirected Edge between C-E with Weight 6
		adj.addUndirectedEdge(4,5,8);  //Add undirected Edge between D-E with Weight 8

		for(int i=0; i<size; i++)
			dis[i] = Integer.MAX_VALUE;				/** Initialize distance to infinite **/
		dj.findPath(source, adj.nodes);
		for(int i=0; i<size; i++)
			System.out.println("Node "+i+" distance = "+dis[i]);
		
		
		for(int i=0; i<size; i++)
			dis[i] = Integer.MAX_VALUE;				/** Initialize distance to infinite **/
		dj.findPathAdjList(source, adjList.neighbours);
		for(int i=0; i<size; i++)
			System.out.println("Node "+i+" distance = "+dis[i]);
	}


	//Working 
	private void findPath(int source, int[][] adj) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(source);
		dis[source] = 0;
		while(!que.isEmpty()) {
			int curr = que.remove();
			vis[curr] = true;
			for(int i=0; i<size; i++) {
				if(adj[curr][i] != 0 && !vis[i]) {
					que.add(i);										/*** Same as BFS until here	***/
					if(dis[i] > dis[curr]+adj[curr][i])
						dis[i] = dis[curr]+adj[curr][i];
				}
			}
		}
	}

	
	//Not working, modify to get corresponding weights
	private void findPathAdjList(int source, LinkedList<Node> list[]) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(source);
		dis[source] = 0;
		while(!que.isEmpty()) {
			int curr = que.remove();
			vis[curr] = true;
			for(int i=0; i<list[curr].size(); i++) {
				if(!vis[i]) {
					que.add(i);
					if(dis[i] > dis[curr] + adjList.getWeight(adjList.getNodeList(curr).get(i)));
						dis[i] = dis[curr] + adjList.getWeight(adjList.getNodeList(curr).get(i));
				}
			}
		}
	}
}

class AdjMat{
	int nodes[][];

	AdjMat(int size){
		nodes = new int[size][size];
	}

	public void addUndirectedEdge(int to, int from, int weight) {
		nodes[to][from] = weight;
		nodes[from][to] = weight;
	}
}



class AdjList {
	LinkedList<Node> neighbours[];

	AdjList(int size){
		this.neighbours = new LinkedList[size];
		for(int i=0; i<size; i++) {
			LinkedList<Node> list = new LinkedList<Node>();
			neighbours[i] = list;
		}
	}

	public void addUndirectedEdge(int to, int from, int weight) {
		neighbours[from].add(new Node(to, weight));
		neighbours[to].add(new Node(from, weight));
	}
	
	public LinkedList<Node> getNodeList(int index) {
		return neighbours[index];
	}

	public int getWeight(Node n) {
		return n.weight;
	}
}

class Node {
	public int vertex;
	public int weight;
	boolean vis;							// not using

	Node (int vertex, int weight){
		this.vertex = vertex;
		this.weight = weight;
		this.vis = false;
	}
}