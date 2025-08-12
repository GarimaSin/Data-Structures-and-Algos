package Problem_Solving.Tree.BT;

public class SubtreesHavingSameValueOfNodes {
	static class Node {
		int data;
		Node left = null, right = null;

		Node(int data) {
			this.data = data;
		}
	}

	static int count = 0; 
	public static int countSubtrees(Node root)  {
		// base case: empty tree
		if (root == null) {
			return 0;
		}

		// if the root is a leaf node, increase the count and return root node data
		if (root.left == null && root.right == null)  {
			count++;
			return root.data;
		}

		// recur for the left and right subtree
		int left = countSubtrees(root.left);
		int right = countSubtrees(root.right);

		// 1. The left subtree is empty, and the right subtree data matches the root
		// 2. The right subtree is empty, and the left subtree data matches the root
		// 3. Both left and right subtrees are non-empty, and their data matches root

		if ((left == 0 && right == root.data) ||
				(right == 0 && left == root.data) ||
				(left == right && left == root.data))  {
			// increase the count and return root node data
			count++;
			return root.data;
		}
		return 0;
	}

	public static void main(String[] args) {
		/* Construct the following tree
	                     1
	                   /   \
	                  2     3
	                /     /   \
	               4     5     6
	             /     /   \     \
	            4     5     5     7
		 */

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.left.left.left = new Node(4);
		root.right.left.left = new Node(5);
		root.right.left.right = new Node(5);
		root.right.right.right = new Node(7);

		System.out.print(countSubtrees(root));
	}
}