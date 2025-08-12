package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;


public class ConstructTreeFromAnArray {
	
	
	TreeNode root;
	public static void main(String args[]) { 
		TreeNode root = null;
		Integer[] a1 = {0,0,null,null,0,0,null,null,0,0};
		ConstructTreeFromAnArray tree = new ConstructTreeFromAnArray();
		root = tree.contstructTree(a1, root);
		tree.levelOrder(root);
	}

	
	public TreeNode contstructTree(Integer[] a1, TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		root = new TreeNode(a1[0]);
		q.add(root);
		int i = 1;
		while (i <= a1.length-1) {
			while(!q.isEmpty()) {
				TreeNode root1 = q.remove();
				if(root1 == null) 
					continue;
				if(i >= a1.length)
					break;
				if(a1[i] == null) 
					root1.left = null;
				else 
					root1.left = new TreeNode(a1[i]);
				i++;
				if(i >= a1.length)
					break;
				if(a1[i] == null) 
					root1.right = null;
				else 
					root1.right = new TreeNode(a1[i]);
				i++;
				q.add(root1.left);
				q.add(root1.right);
			}
		}
		return root;
	}
	
	
	public void levelOrder(TreeNode root) {
		// Make a queue for level order. Queue is Interface and LinkedList is class
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int i = queue.size();
			while(i-->0) {
				TreeNode presentTreeTreeNode = queue.remove();
				System.out.print(presentTreeTreeNode.val + " ");
				if (presentTreeTreeNode.left != null) {
					queue.add(presentTreeTreeNode.left);
				}
				if (presentTreeTreeNode.right != null)
					queue.add(presentTreeTreeNode.right);
			}
			System.out.println("\n------------------");
		}
		System.out.println();
	}
}
