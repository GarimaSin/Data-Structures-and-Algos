package DataStructures.Udemy.Prims;


import java.util.ArrayList;
import java.util.PriorityQueue;
import DataStructures.Udemy.Node.WeightedNode;

// kind of graph class
public class Prims {

	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	//Constructor
	public Prims(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}


	void prims(WeightedNode node) {
		for (int i = 0; i < nodeList.size(); i++) { 		      
			nodeList.get(i).setDistance(Integer.MAX_VALUE); 		//set every node's value = infinity
		} 
		
		node.setDistance(0); // Setting '0' distance for Source Vertex

		PriorityQueue<WeightedNode> queue = new PriorityQueue<>();

		queue.addAll(nodeList);
		while (!queue.isEmpty()) {
			WeightedNode presentNode = queue.remove(); // Remove vertex which has min distance


			for (WeightedNode neighbor : presentNode.getNeighbors()) {
				if (queue.contains(neighbor)) {//If vertex is not processed, only then enter in if-else 
					//If known weight of this ‘adjacent vertex’ is more than current edge, 
					//then update ‘adjacent vertex’s’ distance and parent
					if (neighbor.getDistance() > presentNode.getWeightMap().get(neighbor)) {
						neighbor.setDistance(presentNode.getWeightMap().get(neighbor));
						neighbor.setParent(presentNode);
						queue.remove(neighbor); // Refresh the priority queue
						queue.add(neighbor);
					}
				}
			}
		}

		int cost = 0;
		// print table of node with minimum distance and shortest path from source
		for (WeightedNode nodeToCheck : nodeList) {
			System.out.println("Node " + nodeToCheck + ", key: " + nodeToCheck.getDistance() + ", Parent: " + nodeToCheck.getParent());
			cost = cost + nodeToCheck.getDistance();
		}
		System.out.println("\nTotal cost of MST: " + cost);
	}


	// add a weighted undirected edge between two nodes
	public void addWeightedUndirectedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i-1);
		WeightedNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
		first.getWeightMap().put(second,d);			//put node as key and dis as value
		second.getWeightMap().put(first, d);
	}
}