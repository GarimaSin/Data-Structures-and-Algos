package Problem_Solving.Tree.BT;

public class SumRootToLeafNumbers {

	static TreeNode root;
	static int sum = 0;
	
	public static void main(String[] args) {
		root = new TreeNode(6); 
		root.left = new TreeNode(3); 
		root.right = new TreeNode(5); 
        root.left.left = new TreeNode(2); 
        root.left.right = new TreeNode(1); 
        root.left.right.left = new TreeNode(7); 
        root.left.right.right = new TreeNode(4); 
        root.right.right = new TreeNode(8);
        levelOrder(root);
//        rootToLeafPath(root, root.val+"");
		sum = 0;
		rootToLeafPath1(root, ""); 
	}

	private static void levelOrder(TreeNode root2) {
		// TODO Auto-generated method stub
		
	}


	//Working - printing the path only, not calculating the sum
	static void rootToLeafPath1(TreeNode root, String val) {
		if(root == null)
			return;
		
		if(isLeaf(root)) {									//Needed, coz for leaf node method will b called twice, 4 left n right child both
			System.out.println(val + root.val);				// and hence same path or ans will b printed twice.
			return ;
		}

		rootToLeafPath1(root.left, val+ root.val);
		rootToLeafPath1(root.right, val+ root.val);
	}



	//Working - submitted in LC
	static void rootToLeafPath(TreeNode root, String val) {
        System.out.print(val);

        if(isLeaf(root)) {
            int tmp = Integer.parseInt(val);
            sum = sum + tmp;
            return ;
        }
       
        if(root.left != null)
            rootToLeafPath(root.left, val+root.left.val);
        if(root.right != null)
            rootToLeafPath(root.right, val+root.right.val);
        
    }

	static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
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

