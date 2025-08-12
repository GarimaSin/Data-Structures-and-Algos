package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;


public class SumTree {

	Node root;
	public static void main(String[] args) {

		SumTree tree = new SumTree(); 
		tree.root = new Node(10); 
		tree.root.left = new Node(-2); 
		tree.root.right = new Node(6); 
		tree.root.left.left = new Node(8); 
		tree.root.left.right = new Node(-4); 
//		tree.root.left.left.left = new Node(); 
		tree.root.right.left = new Node(7); 
		tree.root.right.right = new Node(5); 
//		tree.root.right.left.left = new Node(6); 

		System.out.println("the inorder traversal of tree is "); 
		tree.levelOrder(tree.root);
		System.out.println("*************");

		tree.findSum(tree.root); 
		System.out.println("____________________");
		tree.levelOrder(tree.root);
	}

	private int findSum(Node node) {
		if(node == null)
			return 0;
		if(isLeaf(node)) {
			int tmp = node.val;
			node.val = 0;
			return tmp;
		}
		int s1 = findSum(node.left);
		int s2 = findSum(node.right);
		int sum = s1+ s2 + node.val;
		node.val = s1+ s2;
		return sum;
	}
	
	boolean isLeaf(Node n) {
		if(n == null)
			return false;
		if(n.left == null && n.right == null)
			return true;
		return false;
	}

	void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			System.out.print(presentNode.val + " ");
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null)
				queue.add(presentNode.right);
		}
	}

	static class Node  { 
		int val; 
		Node left, right; 

		Node(int item)  {
			val = item; 
			left = right = null; 
		} 
	}	
}