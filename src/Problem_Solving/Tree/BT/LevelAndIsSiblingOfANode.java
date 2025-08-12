package Problem_Solving.Tree.BT;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class LevelAndIsSiblingOfANode {

	Node root;
	public static void main(String args[]) { 
		LevelAndIsSiblingOfANode tree = new LevelAndIsSiblingOfANode(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		//		tree.root.left.right.left = new Node(7); 
		//		tree.root.left.right.right = new Node(4);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.left.right = new Node(9);
		tree.levelOrder(tree.root);
		System.out.println(getLevel(tree.root, 9, 0)+1);
		System.out.println(getLevel(tree.root, 8, 0)+1);
		System.out.println();
	} 

	private static int getLevel(Node root, int ptr, int lev) {
		// base cases 
		if (root == null) 
			return 0; 

		if (root.value == ptr) 
			return lev; 

		lev++;
		// Return level if Node is present in left subtree 
		int l = getLevel(root.left, ptr, lev);  
		if(l>0)
			return l;
		// Else search in right subtree 
		l= getLevel(root.right, ptr, lev); 
		if(l>0)
			return l;
		lev--;
		return lev;
	}


	//Whether 2 nodes are siblings
	boolean isSibling(Node node, Node a, Node b) { 
		if (node == null) 
			return false; 

		return ((node.left == a && node.right == b) || 
				(node.left == b && node.right == a) || 
				isSibling(node.left, a, b) || 
				isSibling(node.right, a, b)); 
	} 

	
	//Check whether 2 nodes are cousins
	boolean foundFirst = false;
	boolean foundSec = false;
	public boolean isCousins(Node root, int x, int y) {
		Deque<Node> deque = new LinkedList<Node>();
		deque.add(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < size; i++) {
				Node temp = deque.pollFirst();

				if(temp.value== x) {
					foundFirst = true;
				} else if (temp.value== y) {
					foundSec = true;
				}

				if (temp.left != null) {
					deque.add(temp.left);
					map.put(temp.left.value, temp.value);
				}
				if (temp.right != null) {
					deque.add(temp.right);
					map.put(temp.right.value, temp.value);
				}
			}
			if (map.containsKey(x) && map.containsKey(y) && map.get(x) != map.get(y))
				return true;
			else if(foundFirst && foundSec)
				return false;
		}
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
		Node(int item)    {
			value = item;
			left = right = null;
		}
	}
}