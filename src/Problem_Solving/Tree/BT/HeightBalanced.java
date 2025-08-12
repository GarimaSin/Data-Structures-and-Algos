package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;


public class HeightBalanced {
	Node root;
	static boolean isBalanced = true;
	
	public static void main(String[] args) {

		HeightBalanced tree = new HeightBalanced(); 
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(2); 
        tree.root.right.right = new Node(3); 
        tree.root.left.left = new Node(3); 
//        tree.root.left.right = new Node(3); 
        tree.root.left.left.left = new Node(4);
        tree.root.right.right.right = new Node(4); 

		System.out.println("the inorder traversal of tree is "); 
		tree.levelOrder(tree.root);
		System.out.println("*************");

		tree.isBalanced(tree.root); 
		System.out.println(isBalanced);
//		tree.levelOrder(tree.root);
	}
	
	boolean isBalanced(Node root)   {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        isHeightBalanced(root);
        return isBalanced;
    }
	
	public int isHeightBalanced(Node node) {
		if (node == null || !isBalanced) {
            return 0;
        }

		int left_height = isHeightBalanced(node.left);
        int right_height = isHeightBalanced(node.right);
 
        if (Math.abs(left_height - right_height) > 1) {
            isBalanced = false;
        }
        return Math.max(left_height, right_height) + 1;			// same as adding 1 to left_ht and right_ht individually
	}
	
	//Mine 
	public int isHeightBalanced1(Node node) {
		if (node == null) {
            return 0;
        }
        
        int left = 1+ isHeightBalanced1(node.left);
        int right = 1+ isHeightBalanced1(node.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right);
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
