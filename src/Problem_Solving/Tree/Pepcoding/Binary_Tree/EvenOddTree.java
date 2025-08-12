package Problem_Solving.Tree.Pepcoding.Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;


public class EvenOddTree {

	TreeNode root;
	public boolean isEvenOddTree(TreeNode root) {
		if(root.left == null && root.right == null)
			return true;
		Boolean ans = helper(root);
		System.out.println(ans);
		return ans;
	}

	public boolean helper(TreeNode root) {
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		int level = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			int prev = 0;
			while(size > 0) {
				TreeNode tmp = que.remove();
				if(level % 2 ==0) {
					if(tmp.val % 2 == 0)
						return false;
					if(prev != 0 && prev >= tmp.val)
						return false;
				} else {
					if(tmp.val % 2 != 0)
						return false;
					if(prev != 0 && prev <= tmp.val)
						return false;
				}
				if(tmp.left != null)
					que.add(tmp.left);
				if(tmp.right != null)
					que.add(tmp.right);
				prev = tmp.val;
				size--;
			} 
			level = level+1;
		}
		return true;
	}

	public static void main(String[] args) {
		EvenOddTree tree = new EvenOddTree();
		tree.root = new TreeNode(1); 
		tree.root.left = new TreeNode(10); 
		tree.root.right = new TreeNode(4); 
		tree.root.left.left = new TreeNode(3); 
		tree.root.left.left.left = new TreeNode(12); 
//		tree.root.left.right.left = new TreeNode(7); 
//		tree.root.left.right.right = new TreeNode(4);
		tree.root.right.left = new TreeNode(7);
		tree.root.right.right = new TreeNode(9);
		tree.root.right.left.left = new TreeNode(6);
		tree.root.right.right.right = new TreeNode(2);
		tree.isEvenOddTree(tree.root);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
