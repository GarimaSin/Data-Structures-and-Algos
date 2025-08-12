package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AncestorsOfANode {

	Node root;
	static LinkedList<Integer> ancestors = new LinkedList<>();
	public static void main(String args[]) { 
		AncestorsOfANode tree = new AncestorsOfANode(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		//		tree.root.left.right.left = new Node(7); 
		//		tree.root.left.right.right = new Node(4);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
//		tree.root.left.left.left = new Node(8);
//		tree.root.left.left.left.right = new Node(9);
//		levelOrder(tree.root);
		if(!tree.getAncestors(tree.root, 6))
			System.out.println("not found");
		else {
			for(int n: ancestors) 
				System.out.print(n + " ");
		}
		System.out.println();
		ancestors = new LinkedList<Integer>(); 
		ancestors.add(tree.root.value);
		tree.findAncestors(tree.root, 6);
	} 

	//Working
	boolean getAncestors(Node node, int target) {
		if(node == null)
			return false;
		
		if(node.value == target) {
			ancestors.add(target);
			return true;
		}
		
		boolean left = false, right = false;
		if(node.left != null)
			left = getAncestors(node.left, target);
		
		if(node.right != null) 
			right = getAncestors(node.right, target);
		
		if(left || right) {
			ancestors.add(node.value);
			return true;
		}
		return false;
	}
	
	//Removes the path added even after target is found, since we are not able to differentiate whether the target is reached or not
	List<Integer> findAncestors(Node node, int target) {
		if(node == null)
			return ancestors;
		
		if(node.value == target) {
			System.out.println(ancestors);					//answer
			return ancestors;
		}
		
		if(node.left != null) {
			ancestors.add(node.left.value);
			findAncestors(node.left, target);
			ancestors.remove(ancestors.size()-1);
		}
		
		if(node.right != null) {
			ancestors.add(node.right.value);
			findAncestors(node.right, target);
			ancestors.remove(ancestors.size()-1);
		}
		return ancestors;
	}
	
	static void levelOrder(Node root) {
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
		Node(int item)    {
			value = item;
			left = right = null;
		}
	}
}