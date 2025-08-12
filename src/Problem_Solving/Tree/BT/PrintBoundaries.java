package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;


public class PrintBoundaries {

	Node root;
	int maxLevel = 0;
	public static void main(String args[]) { 
		PrintBoundaries tree = new PrintBoundaries(); 
		tree.root = new Node(2); 
		tree.root.left = new Node(7); 
		tree.root.right = new Node(5); 
		tree.root.left.left = new Node(2); 
		tree.root.left.right = new Node(6); 
		tree.root.left.right.left = new Node(5); 
		tree.root.left.right.right = new Node(11);
		tree.root.right = new Node(5);
		tree.root.right.right = new Node(9);
		tree.root.right.right.left = new Node(4);
		tree.preOrder(tree.root);
//		LinkedList<Integer> path = new LinkedList<Integer>();
//		path.add(tree.root.value);
//		tree.printBoundaries(tree.root, path, 1);
	} 

	private void printBoundaries(Node node, LinkedList<Integer> path, int level) {
		if(node == null) 
			return;
		
		if(level > maxLevel) {
			maxLevel = level;
			System.out.println(node.value);
		}
		
		if(node.left == null && node.right == null)	{
			System.out.println(node.value);
		}
		if(node.left != null) {
			path.add(node.left.value);
			printBoundaries(node.left, path, level);
			path.remove(path.size()-1);
		}
		if(node.right != null) {
			path.add(node.right.value);
			printBoundaries(node.right, path, level);
			path.remove(path.size()-1);
		}
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
	
	
	void preOrder(Node root) {
		if(root == null)
			return;
		System.out.print(root.value + " ");
		preOrder(root.left);
		preOrder(root.right);
	}


	static class Node {
		int value;
		Node left, right;
		int level;
		Node(int item)    {
			value = item;
			left = right = null;
		}

		void setLevel(int level) {
			this.level = level;
		}
	}
}
