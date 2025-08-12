package Problem_Solving.Tree.BST;

public class ValidateBST {

	public static boolean isValidBST(Node root) {
		if(root.left == null && root.right == null)
			return true;
		BSTPair ans = isBST(root);
		isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
		return ans.isBST;
	}

	//Sol: 1 - Pepcoding
	static BSTPair isBST(Node root) {
		if(root == null) {
			return new BSTPair(999999, -999999, true);
		}

		BSTPair l = isBST(root.left);
		BSTPair r = isBST(root.right);
		if(!l.isBST || !r.isBST)
			return new BSTPair(Integer.MAX_VALUE, Integer.MIN_VALUE, false);

		int min = Math.min(l.min, Math.min(r.min, root.val));
		int max = Math.max(l.max, Math.max(r.max, root.val));

		boolean isBST = l.isBST && r.isBST && l.max < root.val && r.min > root.val;
		return new BSTPair(min, max, isBST);
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