package Problem_Solving.Tree.BT;

public class LeafToRootPath {

	public static void main(String[] args) {
		/*   12
        	/   \
     	  13     10
    	 /     /    \
       16     14     15
      		 /  \   /  \
     		21  24 22  23	*/
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(13);
		root.left.left = new TreeNode(16);
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(14);
		root.right.right = new TreeNode(15);
		TreeNode left = root.right.left;
		TreeNode right = root.right.right;
		left.left = new TreeNode(21);
		left.right = new TreeNode(24);
		right.left = new TreeNode(22);
		right.right = new TreeNode(23);
		printLeafToRootPath(root, "");
		System.out.println("------------");
		printLeafToRootPath2(root," "+root.val);
		System.out.println("------------");
		printLeafToRootPath3(root, "");
	}
	
	//Not Working
	static void printLeafToRootPath3(TreeNode root, String ans) {
		if(root == null)
			return;
		
		if(root.left == null && root.right == null ) {
			ans = ans+root.val;
			System.out.println(ans+"............");
			return;
		}
		
		
		printLeafToRootPath3(root.left, ans);
		ans = ans+root.val + " ";				//Writing this anywhere except in Preorder format will not work coz 
												//we want to print the TreeNodes in specific order. If the goal was to add the nodes 
												// to a DS and return, then this wud have worked.
		printLeafToRootPath3(root.right, ans);
	}

	
	//Working
	static void printLeafToRootPath(TreeNode root, String ans) {
		if(root == null) {
			return;
		}

		if(root.left == null && root.right == null) {
			ans = root.val+" " +ans;
			System.out.println(ans);
			return;
		}

		ans = root.val + " " +ans;
		printLeafToRootPath(root.left, ans);
		printLeafToRootPath(root.right, ans);
	}

	
	//Working
	static void printLeafToRootPath2(TreeNode root, String ans) {
		if(root == null) 
			return;

		if(root.left == null && root.right == null) {
			System.out.println(ans);
			return;
		}
		String tmp = ans;
		if(root.left != null) {
			ans = " "+root.left.val + ans;			//root.left.val
			printLeafToRootPath2(root.left, ans);
			ans = tmp;
		}

		if(root.right != null) {
			ans = " "+root.right.val + ans;			//root.right.val
			printLeafToRootPath2(root.right, ans);
			ans = tmp;
		}	
//		ans = tmp;						//wont work
	}

}