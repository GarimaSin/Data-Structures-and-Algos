package Problem_Solving.Tree.BT;

public class DistanceBetween2Nodes {
	Node root;
	static int d1 = -1;
	static int d2 = -1;
	static int dist = 0;
	static Node findDistUtil(Node root, int n1, int n2, int lvl){ 
		if (root == null) 
			return null; 

		if (root.val == n1){ 
			d1 = lvl; 		//distance = cu. level
			return root; 
		} 
		if (root.val == n2) {
			d2 = lvl; 
			return root; 
		} 

		Node left_lca = findDistUtil(root.left, n1, n2,  lvl + 1); 
		Node right_lca = findDistUtil(root.right, n1, n2,  lvl + 1); 

		if (left_lca != null && right_lca != null) {
			dist = (d1 + d2) - 2*lvl; 
			return root; 
		} 
		return (left_lca != null)? left_lca : right_lca;     
	} 
	
	//Mine - Working
	static int ans = 0;
	static boolean ifFound = false;
	static int findDistUtilMine(Node root, int n1, int n2){ 
		if (root == null) 
			return -1; 
		if (root.val == n1)
			return 1; 
		if (root.val == n2) 
			return 1; 

		int left = findDistUtilMine(root.left, n1, n2); 
		int right = findDistUtilMine(root.right, n1, n2); 

		if (left != -1 && right != -1) {
			if(!ifFound) {
				ifFound = true;
				ans = ans + left + right;
			}
			return ans; 
		}  else if(left != -1)
			return left+1;
		else if(right != -1)
			return right+1;
		
		return -1;
	} 

	public static void main(String[] args) {
		DistanceBetween2Nodes tree = new DistanceBetween2Nodes(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(4); 
		tree.root.left.left = new Node(5); 
		tree.root.left.right = new Node(6); 
		tree.root.left.left.left = new Node(9); 
		tree.root.left.left.right = new Node(10); 
		//			tree.root.left.right.right = new Node(14); 
		tree.root.right.left = new Node(7); 
		tree.root.right.right = new Node(8); 
		tree.root.right.left.right = new Node(12); 
		tree.root.right.left.left = new Node(11); 
		findDistUtil(tree.root, 11, 8, 0);
		findDistUtilMine(tree.root, 11, 8);
		System.out.println(dist);
		System.out.println(ans+"........");
//		System.out.println("the inorder traversal of tree is "); 
		//		tree.levelOrder(tree.root);
	}

	static class Node  { 
		int val; 
		Node left, right; 
		Node(int item)  {
			val = item; 
			left = right = null; 
		} 
	}
}