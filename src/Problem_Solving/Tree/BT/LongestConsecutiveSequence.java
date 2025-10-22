package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;



public class LongestConsecutiveSequence {

	TreeNode root;
	public static void main(String args[]) { 
		LongestConsecutiveSequence tree = new LongestConsecutiveSequence(); 
        tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
//        tree.root.left.left = new TreeNode(3); 
        tree.root.right = new TreeNode(3); 
        tree.root.right.left = new TreeNode(4); 
        tree.root.right.left.right = new TreeNode(5);
        tree.root.right.left.right.left = new TreeNode(7);
        tree.root.right.right = new TreeNode(6);
		System.out.println(LongestConsecutiveSeq(tree.root));
		System.out.println("..................");
		System.out.println(LongestConsecutiveSeq1(tree.root));
		System.out.println("..................");
		levelOrder(tree.root);
	}
	
	
	// Not correct according to Chatgpt
	private static int longestStreak = 0;
	private static int LongestConsecutiveSeq(TreeNode root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		int l = LongestConsecutiveSeq(root.left);
		int r = LongestConsecutiveSeq(root.right);
		if(root.left != null && root.val + 1 == root.left.val)
			l++;
		if(root.right != null && root.val + 1 == root.right.val)
			r++;
		
		// The maximum length of the consecutive sequence at the current node
        int currentMax = Math.max(l, r);
      
        // Update the longest streak if the current max is greater
        longestStreak = Math.max(longestStreak, currentMax);
      
        return currentMax;
	}
	
	
	// ==========================================================================================
	
	// Working - According to ChatGPT
	private static int longestStreak1 = 0;
	private static int LongestConsecutiveSeq1(TreeNode root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		int l = LongestConsecutiveSeq1(root.left);
		int r = LongestConsecutiveSeq1(root.right);
		
		// The maximum length of the consecutive sequence at the current node
		if(root.left != null && root.val + 1 == root.left.val) 
			l++;
		if(root.right != null && root.val + 1 == root.right.val) 
			r++;
        
		int currentMax = Math.max(l, r);
        
        
		if(root.left != null && root.val + 1 != root.left.val)
			l = 1;
		if(root.right != null && root.val + 1 != root.right.val)
			r = 1;
		
        // Update the longest streak if the current max is greater
		longestStreak1 = Math.max(longestStreak1, currentMax);
      
        return Math.max(l, r);
	}
	
	
    static void levelOrder(TreeNode root) {
		// Make a queue for level order. Queue is Interface and LinkedList is class
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int i = queue.size();
			while(i-->0) {
				TreeNode presentTreeNode = queue.remove();
				System.out.print(presentTreeNode.val + " ");
				if (presentTreeNode.left != null) {
					queue.add(presentTreeNode.left);
				}
				if (presentTreeNode.right != null)
					queue.add(presentTreeNode.right);
			}
			System.out.println("\n------------------");
		}
		System.out.println();
	}
    
    static class TreeNode {
		int val;
		TreeNode left, right;
		int level;
		TreeNode(int item)    {
			val = item;
			left = right = null;
		}

		void setLevel(int level) {
			this.level = level;
		}
    }
    
    static class Result {
    	int len;
    	int l;
    }
}
