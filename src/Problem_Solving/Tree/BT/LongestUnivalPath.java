package Problem_Solving.Tree.BT;

public class LongestUnivalPath {

	
	//My code
	public static void main(String[] args) {
		TreeNode root = null;
		Integer[] a1 = {4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
		ConstructTreeFromAnArray tree = new ConstructTreeFromAnArray();
		root = tree.contstructTree(a1, root);
		tree.levelOrder(root);
		LongestUnivalPath o = new LongestUnivalPath();
		o.longestUnivaluePath(root);
		System.out.println(max-1);

	}
	
	public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
            return 0;
       
        longestUnivalPath(root);
        //if(max == 1) return 1;
        return max-1;
    }

    static int max = -1;
    Path longestUnivalPath(TreeNode root) {

        if(root == null)
            return new Path(0, 0);
        
        if(root.left == null && root.right == null)
            return new Path(1, 1);

        Path left = longestUnivalPath(root.left);
        Path right = longestUnivalPath(root.right);

        int u = 1, strt = 1;
        if(root.left != null && root.right != null) {
            if(root.val == root.left.val && root.val == root.right.val) {
                u = 1 + left.straight + right.straight;
            }
        }
        
        int s1 = 1, s2 = 1;
        if((root.left != null && root.val == root.left.val)) 
        	s1 = left.straight + 1;
        
        if (root.right != null && root.val == root.right.val) 
        	s2 = right.straight + 1;
        
        strt = Math.max(s1, s2);

        int t1 = Math.max(left.straight, right.straight);
        int t2 = Math.max(left.upath, right.upath);
        int t3 = Math.max(1, Math.max(u, strt));
        int t4 = Math.max(t3, Math.max(t1, t2));
        max = Math.max(t4, max);

        return new Path(strt, u);
    }

    class Path {
        int straight;
        int upath;

        Path(int s, int u) {
            this.straight = s;
            this.upath = u;
        }
    }

}
