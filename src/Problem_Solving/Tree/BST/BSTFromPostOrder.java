package Problem_Solving.Tree.BST;

import java.util.LinkedList;

//Java program to construct BST from given postOrder traversal
public class BSTFromPostOrder {

	
	// Not - Working
	public static Node constructTree(int[] postOrder, int si, int ei) {
		if(si > ei)					//breaking condition
			return null;

		int val = postOrder[ei];
		Node root = new Node(val);
		ei--;
		
		if(si == ei)				//breaking condition
			return root;

		int i = 0;
		for(i = si; i <= ei; i++) {
			if(postOrder[i] > val) {
				break;
			}
		}
		root.left = constructTree(postOrder, si, i - 1);
		root.right = constructTree(postOrder, i, ei);
		return root;
	}

	public static void main(String[] args) {
		BSTFromPostOrder tree = new BSTFromPostOrder();
		int post[] = new int[] {15,10,23, 25,20,35,42,39,30};
		Node root = BSTFromPostOrder.constructTree(post, 0, post.length-1);
		System.out.println("Level order traversal of the constructed tree is ");
//		tree.printInorder(root);
		tree.printLevelorder(root);
	}


//	void printInorder(Node node) {
//		if (node == null) {
//			return;
//		}
//		printInorder(node.left);
//		System.out.print(node.data + " ");
//		printInorder(node.right);
//	}

	void printLevelorder(Node root) {
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		System.out.println("");
		while(!queue.isEmpty()) {
			Node temp = queue.remove();
			System.out.print(temp.data +" ");
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
		}
	}
	
	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}
}