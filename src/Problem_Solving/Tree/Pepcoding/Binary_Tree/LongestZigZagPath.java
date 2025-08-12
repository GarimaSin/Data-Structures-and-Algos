package Problem_Solving.Tree.Pepcoding.Binary_Tree;

public class LongestZigZagPath {

	public int longestZigZag(TreeNode root) {
		pair sol = longestZigZag_(root);
		return sol.maxLen;
	}

	public static class pair{
		int forwardSlope = -1;
		int backwardSlope = -1;
		int maxLen = 0;
	}

	public static pair longestZigZag_(TreeNode root){
		if(root == null) 
			return new pair();

		pair left = longestZigZag_(root.left);
		pair right = longestZigZag_(root.right);

		pair sol = new pair();
		int tmp1 = Math.max(left.maxLen, right.maxLen);    //check whether left/right has largest zigzag path ==> excluding this node
		int tmp2 = Math.max(left.backwardSlope, right.forwardSlope) + 1;		//including this node
		sol.maxLen = Math.max(tmp1, tmp2); 				//find max of both including and excluding cu node.

		sol.forwardSlope = left.backwardSlope + 1;	
		sol.backwardSlope = right.forwardSlope + 1;

		return sol;
	}
	
	
	public static void main(String[] args) {
		
	}
	
	class TreeNode {
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