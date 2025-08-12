package Problem_Solving.Tree.BST;

import java.util.LinkedList;
import java.util.Queue;

public class PredecessorAndSuccessor {

	Node root;
	static Node pre, suc;
	public static void main(String[] args) {
		PredecessorAndSuccessor tree = new PredecessorAndSuccessor();
		tree.root = new Node(50); 
		tree.root.left = new Node(30); 
		tree.root.right = new Node(70); 
		tree.root.left.left = new Node(20); 
		tree.root.left.right = new Node(40); 
		tree.root.right.left = new Node(60); 
		tree.root.right.right = new Node(80); 
//		tree.root.left.right.left = new Node(9); 
//		tree.root.left.right.right = new Node(10); 
//		tree.root.left.right.left.left = new Node(11);

		System.out.println("the level order traversal of tree is "); 
		tree.levelOrder(tree.root);
		int target = 60; 
		findPreSuc(tree.root, target);
		System.out.println(pre.data+" "+suc.data);
	}


	static void findPreSuc(Node root, int key)	{
	    if (root == null)
	        return;
	 
	    // If key is present at root
	    if (root.data == key)	{
	    	
	        // The maximum value in left  subtree is predecessor
	        if (root.left != null)	{
	            Node tmp = root.left;
	            while (tmp.right != null)
	                tmp = tmp.right;
	                 
	            pre = tmp;
	        }
	        // The minimum value in right subtree is successor
	        if (root.right != null)	{
	            Node tmp = root.right;
	            while (tmp.left != null)
	                tmp = tmp.left;
	            suc = tmp;
	        }
	        return;
	    }
	    // If key is smaller than root's key, go to left subtree
	    if (root.data > key)	{
	        suc = root;
	        findPreSuc(root.left, key);
	    }
	    // Go to right subtree
	    else	{
	        pre = root;
	        findPreSuc(root.right, key);
	    }
	}
	 

	void levelOrder(Node root) {
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

	static class Node  { 
		int data; 
		Node left, right; 

		Node(int item)  {
			data = item; 
			left = right = null; 
		} 
	}
}
