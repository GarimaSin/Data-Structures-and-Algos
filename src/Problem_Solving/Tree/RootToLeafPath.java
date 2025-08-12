package Problem_Solving.Tree;

import java.util.Deque;
import java.util.LinkedList;

// Java program to print all the node to leaf path 

/* A binary tree node has data, pointer to left child 
and a pointer to right child */
class Node 
{ 
	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

public class RootToLeafPath 
{ 
	Node root; 
	
	/*Given a binary tree, print out all of its root-to-leaf 
	paths, one per line. Uses a recursive helper to do 
	the work.*/
	void printPaths(Node node) 
	{ 
		int path[] = new int[1000]; 
		printPathsRecur(node, path, 0); 
	} 

	//Sol 1
	/* Recursive helper function -- given a node, and an array 
	containing the path from the root node up to but not 
	including this node, print out all the root-leaf paths.*/
	void printPathsRecur(Node node, int path[], int pathLen) 
	{ 
		if (node == null) 
			return; 

		/* append this node to the path array */
		path[pathLen] = node.data; 
		pathLen++; 

		/* it's a leaf, so print the path that led to here */
		if (node.left == null && node.right == null) 
			printArray(path, pathLen); 
		else
		{ 
			/* otherwise try both subtrees */
			printPathsRecur(node.left, path, pathLen); 
			printPathsRecur(node.right, path, pathLen); 
		} 
	} 
	
	//Sol 2 - Easy, using stack and recursion (add b4 and remove after recursion)
	public static void printRootToleafPaths(Node node, Deque<Integer> path)  {
		// base case
		if (node == null) {
			return;
		}

		// include current node to the path
		path.addLast(node.data);

		// if leaf node is found, print the path
		if (node.left == null && node.right == null) {
			System.out.println(path);
		}

		// recur for left and right subtree
		printRootToleafPaths(node.left, path);
		printRootToleafPaths(node.right, path);

		// remove current node after left and right subtree are done
		path.removeLast();
	}


	/* Utility function that prints out an array on a line. */
	void printArray(int ints[], int len) 
	{ 
		int i; 
		for (i = 0; i < len; i++) 
		{ 
			System.out.print(ints[i] + " "); 
		} 
		System.out.println(""); 
	} 

	// driver program to test above functions 
	public static void main(String args[]) { 
		RootToLeafPath tree = new RootToLeafPath(); 
		tree.root = new Node(10); 
		tree.root.left = new Node(8); 
		tree.root.right = new Node(2); 
		tree.root.left.left = new Node(3); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(2); 
		
		/* Let us test the built tree by printing Insorder traversal */
//		tree.printPaths(tree.root); 
		printRootToleafPaths(tree.root, new LinkedList<Integer>());
	} 
} 