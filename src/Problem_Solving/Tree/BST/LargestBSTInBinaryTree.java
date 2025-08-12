package Problem_Solving.Tree.BST;

import Problem_Solving.Tree.BST.LargestBSTInBinaryTree.Node;

public class LargestBSTInBinaryTree {

	public static SubTreeInfo findLargestBST(Node node)    {
		if (node == null) {
			SubTreeInfo tree = new SubTreeInfo();
			tree.isBST = true;
			tree.max = Integer.MIN_VALUE;
			tree.min = Integer.MAX_VALUE;
			tree.size = 0;
			tree.BSTRoot = null;
			return tree;
//         return new SubTreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
		}

		SubTreeInfo left = findLargestBST(node.left);
		SubTreeInfo right = findLargestBST(node.right);
		SubTreeInfo tree = new SubTreeInfo();

		// Check if a binary tree rooted under the current root is a BST
		tree.isBST = left.isBST && right.isBST && 
				(node.data >= left.max && node.data <= right.min);	

		//calculating min and max for parent
		tree.min = Math.min(node.data, Math.min(left.min, right.min));				//new pair's min and max vals
		tree.max = Math.max(node.data, Math.max(left.max, right.max));
		
		if(tree.isBST) {
			tree.BSTRoot = node;
			tree.size = left.size + right.size + 1;
		} else if(left.size > right.size) {
			tree.BSTRoot = left.BSTRoot;
			tree.size = left.size;
		} else {
			tree.BSTRoot = right.BSTRoot;
			tree.size = right.size;
		}
		return tree;
	}

	public static void main(String[] args)	{
		/* Construct the following tree
                      10
                    /    \
                   /      \
                  15       8
                 / \      / \
                /   \    /   \
               12   20  5     9
              / \      / \     \
             /   \    /   \     \
            2    14  4    7     10
		 */

		Node root = new Node(10);

		root.left = new Node(15);
		root.right = new Node(8);

		root.left.left = new Node(12);
		root.left.right = new Node(20);
		root.right.left = new Node(5);
		root.right.right = new Node(9);

		root.left.left.left = new Node(2);
		root.left.left.right = new Node(14);
		root.right.left.left = new Node(4);
		root.right.left.right = new Node(7);

		root.right.right.right = new Node(10);

		System.out.print("The size of the largest BST is " +
				findLargestBST(root).size);
	}

	static class Node	{
		int data;
		Node left, right;

		Node(int data)	{
			this.data = data;
			this.left = this.right = null;
		}
	}
}

class SubTreeInfo	{
	// `min`, `max` stores the minimum and the maximum value in the binary tree rooted
	// under the current node. They are relevant only if the `isBST` flag is true.
	int min, max;

	// stores size of the largest BST in the binary tree rooted under the current node
	int size;								//gives the largest BST's root till this node
	boolean isBST;
	Node BSTRoot;					//gives the largest BST's root till this node

	public SubTreeInfo() {
	}

	SubTreeInfo(int min, int max, int size, boolean isBST, Node n)	{
		this.min = min;
		this.max = max;
		this.size = size;
		this.BSTRoot = n;
		this.isBST = isBST;
	}
}
