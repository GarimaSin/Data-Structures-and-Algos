package Problem_Solving.Tree.BST;

import Problem_Solving.Tree.BT.ConstructTreeFromAnArray;
import Problem_Solving.Tree.BT.TreeNode;

public class ConvertBSTToGreaterTree {

	public static void main(String[] args) {
		TreeNode root = null;
		Integer[] a1 = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
		ConstructTreeFromAnArray tree = new ConstructTreeFromAnArray();
		root = tree.contstructTree(a1, root);
		tree.levelOrder(root);
		convertBST(root);
//		System.out.println(sum);
	}
	
	private static int sum = 0;
    public static TreeNode convertBST(TreeNode root) {
        if (root == null) 
            return null;

        convertBST(root.right);

        sum += root.val;
        root.val = sum;

        convertBST(root.left);
        return root;
    }

}
