package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

	public int val;
	public int level;
	public TreeNode left, right;
	
	public TreeNode(int item)    {
		val = item;
		left = right = null;
	}

	void setLevel(int level) {
		this.level = level;
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
}
