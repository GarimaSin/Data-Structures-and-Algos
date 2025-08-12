package Problem_Solving.Tree.BST;

import java.util.LinkedList;

//Java program to construct BST from given preorder traversal

public class BSTFromPreOrder {
	static int idx;

	public static Node constructTree1(int[] preorder) {
		idx = 0;
		return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	void kthLargestUtil(Node node, int k, int count) {
        if (node == null || count >= k)
            return;
         
        this.kthLargestUtil(node.right, k, count);
        count++;
        if (count == k) {
            System.out.println(k+"th largest element is "+node.val);
            return;
        }
        this.kthLargestUtil(node.left, k, count);
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

		Node left = helper ( preorder, min, val);				// min to val
		Node right = helper (preorder, val, max);				// val to max

		Node root = new Node (val);
		root.left = left;
		root.right= right;

		return root;
	}

	//Working
	public Node find(int[] preorder, int si, int ei) {
		if(si > ei)					//breaking condition
			return null;

		Node root = new Node(preorder[si]);
		si++;
		
		if(si == ei)				//breaking condition
			return root;

		int breakidx = ei + 1;
		for(int i = si; i <= ei; i++) {
			if(preorder[i] > preorder[si]) {
				breakidx = i;
				break;
			}
		}
		root.left = find(preorder, si, breakidx - 1);
		root.right = find(preorder, breakidx, ei);
		return root;
	}


	class Index {
		int index = 0;
	}



	Index index = new Index();
	//Working
	Node constructTreeUtil(int pre[], Index preIndex, int low, int high, int size)  {
		// Base case
		if (preIndex.index >= size || low > high) {
			return null;
		}

		// The first node in preorder traversal is root. So
		// take the node at preIndex from pre[] and make it
		// root, and increment preIndex
		Node root = new Node(pre[preIndex.index]);
		preIndex.index = preIndex.index + 1;

		// If the current subarray has only one element, no need to recur
		if (low == high) {
			return root;
		}

		// Search for the first element greater than root
		int i;
		for (i = low; i <= high; ++i) {
			if (pre[i] > root.val) {
				break;
			}
		}

		// Use the index of element found in preorder to
		// divide preorder array in two parts. Left subtree
		// and right subtree
		root.left = constructTreeUtil(pre, preIndex, preIndex.index, i - 1, size);
		root.right = constructTreeUtil(pre, preIndex, i, high, size);

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
