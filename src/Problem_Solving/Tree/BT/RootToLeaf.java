package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;


public class RootToLeaf {

	TreeNode root;
	public static void main(String args[]) { 
		RootToLeaf tree = new RootToLeaf(); 
		tree.root = new TreeNode(10); 
		tree.root.left = new TreeNode(8); 
		tree.root.right = new TreeNode(2); 
		tree.root.left.left = new TreeNode(3); 
		tree.root.left.right = new TreeNode(5); 
//		tree.root.left.right.left = new TreeNode(7); 
//		tree.root.left.right.right = new TreeNode(4);
		tree.root.right.left = new TreeNode(2);
//		tree.root.right.right = new TreeNode(2);
		tree.levelOrder(tree.root);
		LinkedList<Integer> path = new LinkedList<Integer>();
		path.add(tree.root.val);
		tree.rootToLeafPath(tree.root, path);
	} 

	private void rootToLeafPath(TreeNode TreeNode, LinkedList<Integer> path) {
		if(TreeNode == null) 
			return;
		
		if(TreeNode.left == null && TreeNode.right == null)	{
			for(int no: path)
				System.out.print(no+" ");
			System.out.println();
		}
		if(TreeNode.left != null) {
			path.add(TreeNode.left.val);
			rootToLeafPath(TreeNode.left, path);
			path.remove(path.size()-1);
		}
		if(TreeNode.right != null) {
			path.add(TreeNode.right.val);
			rootToLeafPath(TreeNode.right, path);
			path.remove(path.size()-1);
		}
	}

	void levelOrder(TreeNode root) {
		// make a queue for level order. Queue is Interface and LinkedList is class
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode presentTreeNode = queue.remove();
			System.out.print(presentTreeNode.val + " ");
			if (presentTreeNode.left != null) {
				queue.add(presentTreeNode.left);
			}
			if (presentTreeNode.right != null)
				queue.add(presentTreeNode.right);
		}
		System.out.println();
	}
}
