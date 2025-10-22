package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;


public class BTFromPreAndPostOrder {

	static int preStIdx = 0;
	static Node createTree(int[] pre, int[] post, int postStartIdx, int postEndIdx) {
		if(preStIdx >= pre.length ||  postStartIdx>postEndIdx) 
			return null;

		Node root = new Node(pre[preStIdx]);
		preStIdx++;

		if(postStartIdx == postEndIdx || preStIdx >= pre.length){
			return root;
		}

		int i;
		for(i=postStartIdx; i<=postEndIdx; i++){
			if(post[i] == pre[preStIdx]){
				break;
			}
		}
		
		root.left = createTree(pre, post, postStartIdx, i);
		root.right = createTree(pre, post, i+1, postEndIdx-1);
		return root;
	}

	public static void main(String[] args) {
		int pre[] = new int[] {1,2,4,5,3,6,7}; 
		int post[] = new int[] {4, 5, 2, 6, 7, 3, 1}; 
		int n = pre.length; 
		Node root = createTree(pre, post, 0, n-1);
		levelOrder(root);	
	}

	static void levelOrder(Node root) {
		// make a queue for level order. Queue is Interface and LinkedList is class
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			System.out.print(presentNode.data + " ");
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null)
				queue.add(presentNode.right);
		}
		System.out.println();
	}

	static class Node { 
		int data; 
		Node left, right; 

		public Node(int data) {
			this.data = data; 
			left = right = null; 
		} 
	} 
}
