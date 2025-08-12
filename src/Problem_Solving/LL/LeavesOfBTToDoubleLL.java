package Problem_Solving.LL;

import java.util.LinkedList;
import java.util.Queue;

public class LeavesOfBTToDoubleLL {

	Node root; 
	Node head; // will point to head of DLL 
	Node prev; // temporary pointer 
	
	
	// Driver program to test above functions 
	public static void main(String args[]) { 
		LeavesOfBTToDoubleLL tree = new LeavesOfBTToDoubleLL(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 

		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.right = new Node(6); 
		tree.root.left.left.left = new Node(7); 
		tree.root.left.left.right = new Node(8); 
		tree.root.right.right.left = new Node(9); 
		tree.root.right.right.right = new Node(10); 
		
		printLeaves(tree.root);										// Just a method to print all leaves in reverse order
		System.out.println("Level-order traversal of given tree is : ");
		tree.levelOrder(tree.root); 
		tree.extractLeafList(tree.root); 
		System.out.println(""); 
		System.out.println("Extracted double link list is : "); 
		tree.printDLL(tree.head); 
		System.out.println(""); 
		System.out.println("Level-order traversal of modified tree is : "); 
		tree.levelOrder(tree.root); 
	} 
	
	static void printLeaves(Node n) {
		if(n == null)
			return;
		if(n.left == null && n.right == null) {
			
			System.out.println(n.data + " ");
		}
		printLeaves(n.right);						// Move left up, to print the leaves in left to right order
		printLeaves(n.left);
	}

	static class Node { 
		int data; 
		Node left, right; 

		Node(int item) 	{ 
			data = item; 
			right = left = null; 
		} 
	} 


	// Main function that links the list list to be traversed 
	public Node extractLeafList(Node root) { 
		if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            if (head == null) {
                head = root;
                prev = root;
            }
            else {
                prev.right = root;
                root.left = prev;
                prev = root;
            }
            return null;
        }
        root.left = extractLeafList(root.left);			//in case of a leaf, return null to attach null as left child of the cu. node
        root.right = extractLeafList(root.right);	//in case of a leaf, return null to attach null as right child of the cu. node
        return root;
	} 

	//Prints the DLL in both forward and reverse directions. 
	public void printDLL(Node head) { 
//		Node last = null; 
		while (head != null) { 
			System.out.print(head.data + " "); 
//			last = head; 
			head = head.right; 
		} 
	} 

	void levelOrder(Node root) {
		// make a queue for level order. Queue is Interface and LinkedList is class
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
}