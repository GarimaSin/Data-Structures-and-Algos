package Problem_Solving.Tree.BT;

/**
 * 
 * https://youtu.be/oAbSNJ35qAs
 *
 */
public class BTFromInAndPre {

	//Working
	public Node buildTree(int[] preorder, int[] inorder) {
		return buildTreeFromPre(preorder, inorder, 0, preorder.length-1);
	}

	int preIdx = 0;
	Node buildTreeFromPre(int[] preorder, int[] inorder, int start, int end) {
		if(start > end)
			return null;

		Node root = new Node(preorder[preIdx]);

		if (start == end) 
			return root; 

		int val = root.data;
		int i = -1;
		for(i=start; i<=end; i++) {
			if(inorder[i] == val)
				break;
		}
		preIdx = preIdx+1;
		root.left = buildTreeFromPre(preorder, inorder, start, i-1);
		root.right = buildTreeFromPre(preorder, inorder, i+1, end);

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
		BTFromInAndPre tree = new BTFromInAndPre(); 
		int in[] = new int[] {9,3,15,20,7}; 
		int pre[] = new int[] {3,9,20,15,7}; 
		Node root = tree.buildTree(in, pre); 
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

	// Class Index created to implement pass by reference of Index 
	class Index { 
		int index; 
	} 
}