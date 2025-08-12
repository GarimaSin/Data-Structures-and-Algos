package Problem_Solving.Tree.Pepcoding.Binary_Tree;

import Problem_Solving.Tree.BT.ConstructTreeFromAnArray;
import Problem_Solving.Tree.BT.TreeNode;

public class MaxPathSumBetweenTwoNodes {

	
	//Working
	public static int ans = -(int) 1e9;
	static int findMaxPath(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = findMaxPath(root.left);
        int right = findMaxPath(root.right);
        
        int tmp1 = Math.max(left, right) + root.val;	//ans cud b passing thru this node including left OR rigth subtree
        int tmp2 = Math.max(tmp1, root.val);				// ans cud start 4m this node itself - valid in case of -ve node values.
        																			// tmp2 = max of  left/right/root.val
        ans = Math.max(ans, Math.max(tmp2, left+right+root.val));
        
        return tmp2;
    }

	public static int maxPathSum(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;

		findMaxPath(root);
		return ans;
	}

	static TreeNode root = null;
	static int res = Integer.MIN_VALUE;
	public static void main(String[] args) {

		MaxPathSumBetweenTwoNodes o = new MaxPathSumBetweenTwoNodes(); 
		Integer[] a1 = {1,5,null,4,null,null,2,-4};
		ConstructTreeFromAnArray tree = new ConstructTreeFromAnArray();
		root = tree.contstructTree(a1, root);
		tree.levelOrder(root);
		o.maxPathSumMine(root);
		System.out.println("Max pathSum of the given binary tree is " + o.max);
	}
	
	public int maxPathSumMine(TreeNode root) {
        if(root == null)
            return -1;

        if(root.left == null && root.right == null)
            return root.val;
        maxPathMine(root);
        return max;
    }

	
	//Working
    int max = -999999;
    public NodeStatus maxPathMine(TreeNode root) {        
	    if(root == null)
	        return new NodeStatus(-999999, -999999);
	
	    if(root.left == null && root.right == null)
	        return new NodeStatus(root.val, root.val);
	
	    NodeStatus left = maxPathMine(root.left);
	    NodeStatus right = maxPathMine(root.right);
	
	    int st = -999999;
        int u = left.straight + right.straight + root.val;
        int tmp = Math.max(left.straight, right.straight);
        
        st = Math.max(tmp + root.val, root.val) ;
        u = Math.max(u, Math.max(left.upath, right.upath));
	
	    int t1 = Math.max(st, u);
	    int t2 = Math.max(left.upath, right.upath);
	    max = Math.max(max, Math.max(t1, t2));
	
	    return new NodeStatus(st, u);
    }


    class NodeStatus {
        int straight;
        int upath;

        NodeStatus(int s, int u) {
            this.straight = s;
            this.upath = u;
        }

        NodeStatus(){};
    }
}