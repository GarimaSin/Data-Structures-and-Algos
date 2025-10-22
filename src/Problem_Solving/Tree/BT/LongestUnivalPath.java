package Problem_Solving.Tree.BT;

public class LongestUnivalPath {
	
	
	// Working - My sol - 96%
	public int longestUnivaluePath1(TreeNode root) {
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
            return 0;
       
        longestUnivalPath(root);
        //if(max == 1) return 1;
        return max-1;
    }

    int max = -1;
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
        
        if (root.right != null && root.val == root.right.val) {
        	s2 = right.straight + 1;
        }
        strt = Math.max(s1, s2);

        int t1 = Math.max(left.upath, right.upath);
        int t2 = Math.max(1, Math.max(u, strt));
        max = Math.max(t1, Math.max(t2, max));

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
	
	
    
 // =================================================================================
	
	
    
    // Working - My - 96%
    private int maxPath = 0;

    public int longestUnivaluePath2(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftLen = dfs(node.left);
        int rightLen = dfs(node.right);

        int leftPath = 0, rightPath = 0;

        if (node.left != null && node.left.val == node.val) {
            leftPath = leftLen + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            rightPath = rightLen + 1;
        }

        // update global max (sum of left+right gives path thru dis node)
        maxPath = Math.max(maxPath, leftPath + rightPath);

        // return the longest one-side path for recursion
        return Math.max(leftPath, rightPath);
    }
    
    
    // =================================================================================
    
	
	// Working - 14%
	public int longestUnivaluePath(TreeNode node) {
		if(root == null)
            return 0;
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
