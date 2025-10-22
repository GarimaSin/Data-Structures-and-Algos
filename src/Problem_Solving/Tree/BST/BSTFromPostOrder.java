package Problem_Solving.Tree.BST;

import java.util.LinkedList;

//Java program to construct BST from given postOrder traversal
public class BSTFromPostOrder {

	
	// Working
	static Node constructTree(int[] postOrder, int si, int ei) {
		if (si > ei) 
            return null;
    
        int val = postOrder[ei];          // root is last element
        Node root = new Node(val);
    
        if (si == ei) 
            return root;
    
        int idx = ei;					// initialize idx = ei
        for (int j = si; j <= ei-1; j++) {  // exclude root at ei
            if (postOrder[j] > val) {
                idx = j;
                break;
            }
        }
        root.left = constructTree(postOrder, si, idx - 1);
        root.right = constructTree(postOrder, idx, ei-1);
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