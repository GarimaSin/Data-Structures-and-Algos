package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;


public class HeightOfSpiralTree {

	Node root;
	public static void main(String args[]) { 
		HeightOfSpiralTree tree = new HeightOfSpiralTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.left.left.left = new Node(6); 
		//		tree.root.left.right.right = new Node(4);
		//		tree.root.right.left = new Node(2);
		//		tree.root.right.right = new Node(2);
		tree.levelOrder(tree.root);
		System.out.println(tree.findHeight(tree.root));
	} 

	private int findHeight(Node node) {
		if(node == null) 
			return 0;
		if(node.vis)
			return 0;

		node.vis = true;				//spiral tree's check
		if(node.left == null && node.right == null) {
			System.out.println();
		}
		int left = 1 + findHeight(node.left);
		int right = 1 + findHeight(node.right);
		return Math.max(left, right);
	}

	static boolean isLeaf(Node node)  {
		return (node.left != null && node.left.right == node
				&& node.right != null
				&& node.right.left == node);
	}

	static int maxDepth(Node node)   {
		if (node == null)
			return 0;

		if (isLeaf(node))
			return 1;

		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}


	void levelOrder(Node root) {
		// make a queue for level order. Queue is Interface and LinkedList is class
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			System.out.print(presentNode.value + " ");
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null)
				queue.add(presentNode.right);
		}
		System.out.println();
	}


	static class Node {
		int value;
		Node left, right;
		boolean vis;
		int level;
		Node(int item)    {
			value = item;
			left = right = null;
			vis = false;
		}

		void setLevel(int level) {
			this.level = level;
		}
	}
}
