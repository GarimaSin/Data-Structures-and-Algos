package Problem_Solving.Tree.BST;

import java.util.LinkedList;

//Java program to construct BST from given preorder traversal

public class BSTFromPreOrder {
	static int idx;

	public static Node constructTree1(int[] preorder) {
		idx = 0;
		return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}


	//Working
	public static Node helper (int[] preorder, int min, int max) {
		if (idx == preorder.length) {
			return null;
		}
		int val = preorder [idx];

		if (val < min || val > max) {
			return null;
		}

		idx++;

		Node left = helper (preorder, min, val);				// min to val
		Node right = helper (preorder, val, max);				// val to max

		Node root = new Node (val);
		root.left = left;
		root.right= right;

		return root;
	}


	// ==========================================================================================

	//Working
	int pi = 0;
	public Node find(int[] preorder, int si, int ei) {
		if (si > ei || pi >= preorder.length)
			return null;

		Node root = new Node(preorder[pi++]);
		if (si == ei)
			return root;

		// find first index greater than root.val
		int breakidx = ei + 1;
		for (int i = si; i <= ei; i++) {
			if (preorder[i] > root.val) {
				breakidx = i;
				break;
			}
		}
		root.left = find(preorder, si + 1, breakidx - 1);
		root.right = find(preorder, breakidx, ei);
		return root;
	}



	public static void main(String[] args) {
		BSTFromPreOrder tree = new BSTFromPreOrder();
		int pre[] = new int[] {10, 30, 20, 5, 15};
		Node root = BSTFromPreOrder.constructTree1(pre);
		System.out.println(
				"Inorder traversal of the constructed tree is ");
		tree.printInorder(root);
		tree.printLevelorder(root);
	}


	void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}

	void printLevelorder(Node root) {
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		System.out.println("");
		while(!queue.isEmpty()) {
			Node temp = queue.remove();
			System.out.print(temp.val +" ");
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
		}
	}
}
