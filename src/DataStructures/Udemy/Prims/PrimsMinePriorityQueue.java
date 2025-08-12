package DataStructures.Udemy.Prims;

import java.util.ArrayList;
import java.util.PriorityQueue;

import DataStructures.Udemy.Node.WeightedNode;

//Not working - since this code is only comparing wts of all neighbors of the cu. node, 
//but not with every other neighbors' of all the vertices vis till now.
// Check PrimsPepcoding for understanding.

public class PrimsMinePriorityQueue {

	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	ArrayList<Edge> edgeList = new ArrayList<Edge>();
	static int totalCost = 0;


	private void prims(WeightedNode node) {
		node.setDistance(0); // Setting '0' distance for Source Vertex
		PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
		queue.add(node);
		boolean isSource = true;
		
		while(!queue.isEmpty()) {
			WeightedNode tmp = queue.remove();
			tmp.setVisited(true);
			if(isSource)	{
				totalCost = 0;
				isSource = false;
				System.out.println(" Key: "+tmp.intName + " ,Parent 0");
			}
			else	{
				totalCost = totalCost + tmp.getWeightMap().get(tmp.getParent());
				System.out.println(" Key: "+tmp.intName + " ,Parent "+tmp.getParent().intName);
			}
			ArrayList<WeightedNode> neighbours = tmp.getNeighbors();
			for(WeightedNode n: neighbours) {
				if(!n.isVisited()) {
					n.setParent(tmp);
					queue.add(n);
				}
			}
		}
	}

	// add a weighted undirected edge between two nodes
	public void addWeightedUndirectedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i);
		WeightedNode second = nodeList.get(j);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
		first.getWeightMap().put(second,d);			//put node as key and dis as value
		second.getWeightMap().put(first, d);
	}

	//Constructor
	public PrimsMinePriorityQueue(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	public static void main(String[] args) {
		ArrayList<WeightedNode> nodeList = new ArrayList<>();

		//Create 5 nodes: A,B,C,D,E
		for(int i=0;i<5; i++) {
			WeightedNode node = new WeightedNode(""+(char)(65+i));
			node.intName = i;
			nodeList.add(node);
		}

		PrimsMinePriorityQueue graph = new PrimsMinePriorityQueue(nodeList);
		graph.addWeightedUndirectedEdge(0,1,10); //Add undirected Edge between A-B with Weight 10
		graph.addWeightedUndirectedEdge(0,2,20); //Add undirected Edge between A-C with Weight 20
		graph.addWeightedUndirectedEdge(1,2,30); //Add undirected Edge between B-C with Weight 30
		graph.addWeightedUndirectedEdge(1,3,5);  //Add undirected Edge between B-D with Weight 5
		graph.addWeightedUndirectedEdge(2,3,15); //Add undirected Edge between C-D with Weight 15
		graph.addWeightedUndirectedEdge(2,4,6);  //Add undirected Edge between C-E with Weight 6
		graph.addWeightedUndirectedEdge(3,4,8);  //Add undirected Edge between D-E with Weight 8

		System.out.println("Printing Prim's Algo from source: E");
		graph.prims(nodeList.get(3));
		System.out.println("Total cost: "+totalCost);
	}
	
	static class Edge {
		int src;
		int dest;
		int wt;
		
		Edge(int s, int d, int w) {
			this.src = s;
			this.dest = d;
			this.wt = w;
		}
	}
}
