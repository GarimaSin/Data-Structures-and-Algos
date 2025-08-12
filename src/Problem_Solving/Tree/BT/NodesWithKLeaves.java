package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;

public class NodesWithKLeaves {


	Node root;
	static LinkedList<Integer> list = new LinkedList<>();
	public static void main(String[] args) {

		NodesWithKLeaves tree = new NodesWithKLeaves(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(4); 
		tree.root.left.left = new Node(5); 
		tree.root.left.right = new Node(6); 
		tree.root.left.left.left = new Node(9); 
		tree.root.left.left.right = new Node(10); 
//		tree.root.left.right.right = new Node(14); 
		tree.root.right.left = new Node(7); 
		tree.root.right.right = new Node(8); 
		tree.root.right.left.right = new Node(12); 
		tree.root.right.left.left = new Node(11); 

		System.out.println("the inorder traversal of tree is "); 
		tree.levelOrder(tree.root);
		int k = 2;
		tree.printKLeavesNodes(tree.root, k); 
		for(int n: list)
			System.out.println(n);
	}

	//Sum is not giving right ans but list holds correct ans
	private int printKLeavesNodes(Node node, int k) {
		if(isLeaf(node))
			return 1;
		if(node == null)
			return 0;
		
		int l = printKLeavesNodes(node.left, k);
		int r = printKLeavesNodes(node.right, k);
		int sum = l+r;
		if(sum == k) 
			list.add(node.val);
		return sum;
	}

	boolean isLeaf(Node n) {
		if(n!= null)
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
		System.out.println();
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