package DataStructures.Graph.MinSpanngTree;

import DataStructures.Udemy.Node.WeightedNode;

public class Prims_Mine {

	
	public void addWeightedUndirectedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i-1);
		WeightedNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
		first.getWeightMap().put(second,d);
		second.getWeightMap().put(first, d);
	}
}
