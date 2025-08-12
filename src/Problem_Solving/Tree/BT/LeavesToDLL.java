package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;


public class LeavesToDLL {

	Node root;
	static LinkedList<Integer> list = new LinkedList<>(); 
	public static void main(String args[]) { 
		LeavesToDLL tree = new LeavesToDLL(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.left.left.left = new Node(7); 
        tree.root.left.left.right = new Node(8); 
        tree.root.right.right = new Node(6);
        tree.root.right.right.left = new Node(9);
        tree.root.right.right.right = new Node(10);
        System.out.println("Level-order traversal of given tree is : "); 
        tree.levelOrder(tree.root);
        tree.removeLeaves(tree.root);
        System.out.println(""); 
        System.out.println("Extracted double link list is : "); 
        for(int n: list)
        	System.out.print(n + " ");
        System.out.println();
        System.out.println("Level-order traversal of modified tree is : ");
        tree.levelOrder(tree.root);
    }
	
	private boolean removeLeaves(Node node) {
		if(node == null)
			return true;
		
		if(isLeaf(node))
			return false;
		
		boolean l = removeLeaves(node.left);
		if(!l) {
			list.add(node.left.value);
			node.left = null;
		}
		boolean r = removeLeaves(node.right);
		if(!r) {
			list.add(node.right.value);
			node.right = null;
		}
		return true;
	}
	
	boolean isLeaf(Node n) {
		if(n != null)
			if(n.left == null && n.right == null)
				return true;
		return false;
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
