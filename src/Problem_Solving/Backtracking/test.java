package Problem_Solving.Backtracking;

import java.util.LinkedList;
import java.util.Queue;


public class test {

	TreeNode root;
	public static void main(String args[]) { 
		test tree = new test(); 
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
		levelOrder(tree.root);
	}
	
	int step(int num, int steps) {
        if(num == 0){
            return steps;
        }
        if(num % 2 == 0){
            return step(num/2 , steps+1);
        }
        return step(num -1 ,steps+1);
    }
	

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
	

	private static TreeNode contstructTree(Integer[] a1, TreeNode root) {
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