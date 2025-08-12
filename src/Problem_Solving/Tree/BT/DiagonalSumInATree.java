package Problem_Solving.Tree.BT;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;


public class DiagonalSumInATree {

	Node root;
	public static void main(String args[]) { 
		DiagonalSumInATree tree = new DiagonalSumInATree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(9); 
		tree.root.left.right = new Node(6); 
		tree.root.left.right.left = new Node(11); 
		tree.root.left.left.right = new Node(10);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(5);
		tree.root.right.left.left = new Node(12);
		tree.root.right.left.right = new Node(7);
		//        tree.levelOrder(tree.root);
		tree.diagonalTravesal(tree.root);
		//        tree.findSum(tree.root, 0);
		System.out.println();
	} 

	private void diagonalTravesal(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		LinkedHashMap<Integer, LinkedList<Node>> map = new LinkedHashMap<>();
		node.setLevel(0);
		q.add(node);
		while(!q.isEmpty()) {
			Node tmp = q.remove();
			if(map.containsKey(tmp.level)) {
				LinkedList<Node> list = map.get(tmp.level);
				list.add(tmp);
			} else {
				LinkedList<Node> list = new LinkedList<>();
				list.add(tmp);
				map.put(tmp.level, list);
			}
			if(tmp.left!= null) {
				tmp.left.setLevel(tmp.level+1);				// +1 for left child
				q.add(tmp.left);
			}
			if(tmp.right!=null) {
				tmp.right.setLevel(tmp.level);				//   + 0 for right child
				q.add(tmp.right);
			}
		}
		for(Integer key: map.keySet() ) {
			int sum = 0;
			for(Node tmp: map.get(key)) {
				sum = sum + tmp.data;
			}
			System.out.println("key = " + key+", value = "+sum);
		}
	}

	void levelOrder(Node root) {
		// make a queue for level order. Queue is Interface and LinkedList is class
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			System.out.print(presentNode.data + " ");
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null)
				queue.add(presentNode.right);
		}
		System.out.println();
	}

	static class Node {
		int data;
		int level;
		Node left, right;
		Node(int item)    {
			data = item;
			left = right = null;
		}

		void setLevel(int l) {
			this.level = l;
		}
	}
}
