package Problem_Solving.Tree.BST;

import Problem_Solving.Tree.BT.TreeNode;

public class KthSmallestElemInBST {

	//Working
	public int kthSmallest(TreeNode root, int k) {
		inorder(root, k);
		return result;
	}

	private int count = 0;
	private int result = -1;
	void inorder(TreeNode node, int k) {
		if (node == null) 
			return;

		inorder(node.left, k);

		count++;
		if (count == k) {
			result = node.val;
			return; 	// found it, stop further traversal
		}
		inorder(node.right, k);
	}

	public static void main(String[] args) {

	}
}
