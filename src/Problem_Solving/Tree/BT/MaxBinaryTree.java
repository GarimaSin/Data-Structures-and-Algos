package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;


// https://leetcode.com/problems/maximum-binary-tree/
public class MaxBinaryTree {

	TreeNode root;
	public static void main(String args[]) { 
		int nums[] = {3,2,1,6,0,5};
		TreeNode n = constructMaximumBinaryTree(nums, 0, nums.length-1);
		levelOrder(n);
	}
	

    public static TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
    	
        if(l < 0 || r >= nums.length || l > r)
            return null;
        
        if(l == r) {
    		return new TreeNode(nums[l]);
    	}
        
        int max = -1;
        int idx = -1;
        for(int i=l; i<=r; i++) {
            if(nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }

        TreeNode root = new TreeNode(nums[idx]);
        TreeNode left = constructMaximumBinaryTree(nums, l, idx-1);
        TreeNode right = constructMaximumBinaryTree(nums, idx+1, r);
        root.left = left;
        root.right = right;
        return root;
    }
    
    static void levelOrder(TreeNode root) {
		// Make a queue for level order. Queue is Interface and LinkedList is class
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
