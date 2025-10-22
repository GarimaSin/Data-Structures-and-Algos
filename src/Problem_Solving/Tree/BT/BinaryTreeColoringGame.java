package Problem_Solving.Tree.BT;

public class BinaryTreeColoringGame {

	//Working LC - 1145
	public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
		count(root, x);
		int nodesInParentExcludindX = n - (lc+rc+1); 			// I - tot no of nodes - tot no of nodes covered by opponent
		int max = Math.max(nodesInParentExcludindX, Math.max(lc, rc));
		return max > (n/2);
	}
	
	int lc = 0, rc = 0;
	public int count(TreeNode root, int x) {
		if(root == null)
			return 0;
		
		int left = count(root.left, x);
		int right = count(root.right, x);
		if(root.val == x) {
			lc = left;
			rc = right;
		}
		return left+right+1;
	}
	
	
	public static void main(String[] args) {
		
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
