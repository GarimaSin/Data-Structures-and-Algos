package Problem_Solving.Tree.BT;

// https://leetcode.com/problems/flip-equivalent-binary-trees/description/ 
public class FlipEquivalentBT {

	TreeNode root;
	public static void main(String args[]) { 
		TreeNode root1 = null;
		TreeNode root2 = null;
		Integer[] a1 = {1,2,3,4,5,6,null,null,null,7,8};
		Integer[] a2 = {1,3,2,null,6,4,5,null,null,null,null,8,7};
		ConstructTreeFromAnArray tree = new ConstructTreeFromAnArray();
		root1 = tree.contstructTree(a1, root1);
		root2 = tree.contstructTree(a2, root2);
		System.out.println(flipEquiv(root1, root2));
		tree.levelOrder(root1);
	}
	

	public static boolean flipEquiv(TreeNode r1, TreeNode r2) {
		if(r1 == null && r2 == null)
			return true;
		
		if(r1 == null || r2 == null)
			return false;
		
		if(r1.val != r2.val)
			return false;
		
		boolean b1 = flipEquiv(r1.left, r2.left) && flipEquiv(r1.right, r2.right);
		boolean b2 = flipEquiv(r1.left, r2.right) && flipEquiv(r1.right, r2.left);
        return b1 || b2;
    }
}
