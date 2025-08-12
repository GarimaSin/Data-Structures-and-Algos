package Problem_Solving.Blind75.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneAGraph {

	HashMap<Node, Node> map = new HashMap<>(); 	//acts as vis[]
	//Working
	public Node cloneGraph(Node node) {
		if(node == null)
			return null;

		Queue<Node> queue = new LinkedList<>();
		map.put(node, new Node(node.val, new ArrayList<>()));
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node temp = queue.remove();
			for(Node neig: temp.neighbors){
				if(!map.containsKey(neig)){
					map.put(neig, new Node(neig.val, new ArrayList<>()));
					queue.add(neig);
				}
				map.get(temp).neighbors.add(map.get(neig));		// .add(map.get(neigh))
			}
		}
		return map.get(node);
	}
}

class Node {
	public int val;
	public List<Node> neighbors;
	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}
