package Problem_Solving.Tree.BST;

public class ValidateBST {
	
	public static boolean isValidBST(Node root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

	//Working - leetcode
	public static boolean isValidBST(Node root, long minVal, long maxVal) {
		if (root == null) 
			return true;
		
		if (root.val >= maxVal || root.val <= minVal) 
			return false;
		
		boolean left = isValidBST(root.left, minVal, root.val);
		boolean right = isValidBST(root.right, root.val, maxVal);
		return left && right;
	}
	
	public Node lowestCommonAncestorBST(Node root, Node p, Node q) {
        if( root == null || root == p || root == q )
            return root;
        
        if(root.val == p.val || root.val == q.val)
            return root;
        
        // If both nodes values are less than root, than LCA exist in left subtree
        if( p.val < root.val && q.val < root.val ) 
            return lowestCommonAncestorBST(root.left, p, q);
        
        // If both nodes values are greater than root, than LCA exist in right subtree
        if( p.val > root.val && q.val > root.val ) 
            return lowestCommonAncestorBST(root.right, p, q);
        
        // 1 of the nodes is in the left subtree & the other is in right, so the root is the LCA
        return root;
    }

	public static void main(String[] args) {
		Node root = new Node(-2147483648);
		//        root.left = new Node(3);
		root.right = new Node(2147483647);
		//        root.left.left = new Node(10);
		//        root.left.right = new Node(2);
		//        root.right.left = new Node(4);
		//        root.right.right = new Node(6);
		System.out.println(isValidBST(root));
	}

	static class Node	{
		int val;
		Node left = null, right = null;

		Node(int val) {
			this.val = val;
		}
	}

	static class BSTPair {
		int min;
		int max;
		boolean isBST;

		BSTPair(int min, int max, boolean isBST) {
			this.min = min;
			this.max = max;
			this.isBST = isBST;
		}
	}
}