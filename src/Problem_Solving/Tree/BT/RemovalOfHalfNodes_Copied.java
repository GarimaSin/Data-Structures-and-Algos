package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;

public class RemovalOfHalfNodes_Copied {

	public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
    
    public static Node truncate(Node root)    {
        if (root == null) {
            return null;
        }
 
        // recursively truncate the left subtree and subtree first
        root.left = truncate(root.left);
        root.right = truncate(root.right);
 
        // do nothing if the current node is a leaf node or has two children
        if ((root.left != null && root.right != null) || isLeaf(root)) {
            return root;
        }
 
        // if the current node has exactly one child, then delete it and replace it with the child node
        Node child = (root.left != null) ? root.left: root.right;
        return child;
    }
 
    public static void main(String[] args)    {
        /* Construct the following tree
                     0
                   /   \
                  /     \
                 1       2
                /        /
               /        /
              3        4
             /        / \
            /        /   \
           5        6     7
        */
 
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.left = new Node(4);
        root.left.left.left = new Node(5);
        root.right.left.left = new Node(6);
        root.right.left.right = new Node(7);
 
        truncate(root);
        levelOrder(root);
    }
    
    static void levelOrder(Node root) {
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
	}
    
   static class Node {
        int data;
        Node left = null, right = null;
     
        Node(int data) {
            this.data = data;
        }
    }
}