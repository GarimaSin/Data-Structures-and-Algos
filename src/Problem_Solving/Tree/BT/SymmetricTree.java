package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

	Node root;
	private boolean isSymmetric(Node left, Node right) {

		if(left == null && right == null)
			return true;
		if(left == null || right == null)
			return false;

		if(isLeaf(left) && isLeaf(right))
			if(left.value == right.value)
				return true;
			else 
				return false;
		
		if((left != null && right != null) && (left.value ==  right.value) &&
                    isSymmetric(left.left, right.right) &&				//left node = right and right = left node
                    isSymmetric(left.right, right.left))				// can be thought of as node1.left = node2.right && node1.right = node2.left
                    return true;
		
		return false;
	}
	
	boolean isLeaf(Node node) {
		if(node.left == null && node.right == null)
			return true;
		return false;
	}

	public static void main(String args[]) { 
		SymmetricTree tree = new SymmetricTree(); 
		tree.root = new Node(5); 
		tree.root.left = new Node(1); 
		tree.root.right = new Node(1); 
		tree.root.left.left = new Node(2); 
//		tree.root.left.right = new Node(4); 
		//        tree.root.left.right.left = new Node(7); 
		//        tree.root.left.right.right = new Node(4);
//		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(2);
		tree.levelOrder(tree.root);
		if(tree.root.left != null && tree.root.right != null)
			System.out.println(tree.isSymmetric(tree.root.left, tree.root.right));
//		System.out.println();
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
