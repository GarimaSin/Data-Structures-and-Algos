package Problem_Solving.Tree.Pepcoding.Binary_Tree;

public class LongestUnivalPath {
	
	public int longestUnivaluePath(TreeNode node) {
		helper(node);
		return ans-1;
	}
	
	int ans = 0;
	TreeNode root;
	
	public pair helper(TreeNode node) {
		if(node == null)
			return new pair(Integer.MAX_VALUE, 0);
		
		pair left = helper(node.left);
		pair right = helper(node.right);
		pair res = new pair(node.val);
		
		if(node.val == left.data && node.val == right.data) { 
			ans = Math.max(ans, left.height + right.height+1);
			res.height = Math.max(1, Math.max(left.height, right.height)+1);			//update node's height
			return res;
		} else if(node.val != left.data && node.val != right.data) {
			ans = Math.max(ans, 1);
			return res;
		} else if(node.val == left.data) {
			res.height += left.height;
			ans = Math.max(ans, Math.max(res.height, right.height));	
			return res;
		} else if(res.data == right.data) {
			res.height += right.height;
			ans = Math.max(ans, Math.max(res.height, left.height));	
			return res;
		}
		return null;
	}
	
	class pair {
		int data;
		int height;
		pair(int data) {
			this.data = data;
			this.height = 1;
		}
		
		pair(int data, int height) {
			this.data = data;
			this.height = height;
		}
	}
	public static void main(String[] args) {
		LongestUnivalPath tree = new LongestUnivalPath();
		tree.root = new TreeNode(1); 
		tree.root.left = new TreeNode(4); 
		tree.root.right = new TreeNode(5); 
		tree.root.left.left = new TreeNode(4); 
		tree.root.left.right = new TreeNode(4); 
//		tree.root.left.left.left = new TreeNode(12); 
//		tree.root.left.right.left = new TreeNode(7); 
//		tree.root.left.right.right = new TreeNode(4);
//		tree.root.right.left = new TreeNode(7);
		tree.root.right.right = new TreeNode(5);
//		tree.root.right.left.left = new TreeNode(6);
//		tree.root.right.right.right = new TreeNode(2);
		System.out.println(tree.longestUnivaluePath(tree.root));
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
