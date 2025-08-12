package Problem_Solving.Tree.BT;

import java.util.LinkedList;

public class AddOneRowToTree {

	public static void main(String args[]) { 
		TreeNode root = null;
		Integer[] a = {4,2,null,3,1};
		ConstructTreeFromAnArray tree = new ConstructTreeFromAnArray();
		root = tree.contstructTree(a, root);
		TreeNode ans = addRowDfs(root, 1, 3);
		tree.levelOrder(ans);
	}
	
	//Working
	private static TreeNode addRowDfs(TreeNode root, int val, int depth) {
		if(root == null)
			return root;
		
		if(depth == 1) {
			TreeNode n1 = new TreeNode(val);
			n1.left = root;
			return n1;
		}
		
		if(depth == 2) {
			TreeNode n1 = new TreeNode(val);
			n1.left = root.left;
			root.left = n1;
			TreeNode n2 = new TreeNode(val);
			n2.right = root.right;
			root.right = n2;
			return root;
		}
		
		addRowDfs(root.left, val, depth-1);
		addRowDfs(root.right, val, depth-1);
		
		return root;
	}

	//Working
	private static TreeNode addRow(TreeNode root, int val, int depth) {
		if(root == null)
			return root;
		
		if(depth == 1) {
			TreeNode n1 = new TreeNode(val);
			n1.left = root;
			return n1;
		}
			
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int len = q.size();
			depth--;
			while(len --> 0) {
				TreeNode cu = q.remove(); 
				if(depth == 1) {
					TreeNode n1 = new TreeNode(val);
					n1.left = cu.left;
					cu.left = n1;
					TreeNode n2 = new TreeNode(val);
					n2.right = cu.right;
					cu.right = n2;
				} else {
					if(cu.left != null) {
						q.add(cu.left);
					}
					if(cu.right != null) {
						q.add(cu.right);
					}
				}
			}
			if(depth == 1) 
				return root;
		}
		return root;
	}
}
