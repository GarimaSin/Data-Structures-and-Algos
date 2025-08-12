package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BoundaryTraversalOfBT {

	Node root;
	static Queue<Integer> leftList = new LinkedList<>();
	static Queue<Integer> leafList = new LinkedList<>();
	static Stack<Integer> rightList = new Stack<>();
	public static void main(String[] args) {

		BoundaryTraversalOfBT tree = new BoundaryTraversalOfBT(); 
		tree.root = new Node(20); 
		tree.root.left = new Node(8); 
		tree.root.right = new Node(22); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(12); 
		tree.root.left.right.left = new Node(10); 
		tree.root.left.right.right = new Node(14); 
		//		tree.root.right.left = new Node(7); 
		tree.root.right.right = new Node(25); 
		tree.root.right.right.right = new Node(26); 
		//		tree.root.right.left.left = new Node(6); 

		System.out.println("the inorder traversal of tree is "); 
		tree.levelOrder(tree.root);

		tree.boundaryTraversal(tree.root); 
		tree.printLeaves(tree.root);
		System.out.println("____________________");
		for(int n: leftList)
			System.out.print(n + " ");
		for(int n: leafList)
			System.out.print(n + " ");
		while(!rightList.isEmpty())
			System.out.print(rightList.pop() + " ");
	}

	private void boundaryTraversal(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);

		while(!queue.isEmpty()) {
			int count = queue.size();
			int size = count;
			while(count != 0) {
				Node tmp = queue.remove();

				if(tmp.left != null)
					queue.add(tmp.left);
				if(tmp.right != null)
					queue.add(tmp.right);

				if(isLeaf(tmp)) {
					count--;
					continue;
				}
				else if(count == size)							//leftmost element
					leftList.add(tmp.val);
				else if (count == 1)								//rightmost element
					rightList.push(tmp.val);

				count--;
			}
		}
	}

	public void printLeaves(Node node) {
		if(node == null)
			return;

		if(isLeaf(node))
			leafList.add(node.val);
		printLeaves(node.left);
		printLeaves(node.right);

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
