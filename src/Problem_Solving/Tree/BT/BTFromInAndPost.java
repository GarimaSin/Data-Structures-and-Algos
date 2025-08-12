package Problem_Solving.Tree.BT;

/**
 * 
 * https://youtu.be/Lc3RBGtyn7M
 *
 */
public class BTFromInAndPost {

	public Node buildTree(int[] inorder, int[] postorder) {
		postIdx = postorder.length-1;
		return buildUtil(inorder, postorder, 0, postorder.length-1); 
	}

	int postIdx = 0;
	Node buildUtil(int in[], int post[], int inStrt, int inEnd) { 
		if (inStrt > inEnd) 
			return null; 

		Node root = new Node(post[postIdx]); 
		postIdx = postIdx-1; 

		if (inStrt == inEnd) 
			return root; 

		int i; 
		for (i = inStrt; i <= inEnd; i++) 
			if (in[i] == root.data) 
				break; 

		root.right = buildUtil(in, post, i+1, inEnd); 
		root.left = buildUtil(in, post, inStrt, i-1);
		

		return root; 
	} 

	/* This funtcion is here just to test  */
	void preOrder(Node node) { 
		if (node == null) 
			return; 
		System.out.print(node.data + " "); 
		preOrder(node.left); 
		preOrder(node.right); 
	} 

	public static void main(String[] args) { 
		BTFromInAndPost tree = new BTFromInAndPost(); 
		int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 }; 
		int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 }; 
		Node root = tree.buildTree(in, post); 
		System.out.println("Preorder of the constructed tree : "); 
		tree.preOrder(root); 
	} 

	class Node { 
		int data; 
		Node left, right; 

		public Node(int data) {
			this.data = data; 
			left = right = null; 
		} 
	} 
}