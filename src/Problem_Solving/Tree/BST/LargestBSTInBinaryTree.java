package Problem_Solving.Tree.BST;

import Problem_Solving.Tree.BST.LargestBSTInBinaryTree.Node;

public class LargestBSTInBinaryTree {

	public static SubTreeInfo findLargestBST(Node root)    {
		if (root == null) {
			return new SubTreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true, null);
		}
		SubTreeInfo left = findLargestBST(root.left);
		SubTreeInfo right = findLargestBST(root.right);

		if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
			int s = left.size + right.size + 1;
			int min = Math.min(left.min, root.data);
			int max = Math.max(right.max, root.data);
			return new SubTreeInfo(min, max, s, true, root);
		} else {
			// Not BST here
			return new SubTreeInfo(0, 0, Math.max(left.size, right.size), false, null);
		}
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
	// `min`, `max` stores the minimum and the maximum value in the BT rooted
	// under the cu. node. They are relevant only if the `isBST` flag is true.
	int min, max;

	// stores size of the largest BST in the BT rooted under the current node
	int size;						//gives the largest BST's root till this node
	boolean isBST;
	Node BSTRoot;					//gives the largest BST's root till this node

	SubTreeInfo(int min, int max, int size, boolean isBST, Node n)	{
		this.min = min;
		this.max = max;
		this.size = size;
		this.BSTRoot = n;
		this.isBST = isBST;
	}
}
