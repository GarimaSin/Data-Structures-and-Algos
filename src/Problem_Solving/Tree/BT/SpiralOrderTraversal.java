package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class SpiralOrderTraversal {

	Node root;
	public static void main(String args[]) { 
		SpiralOrderTraversal tree = new SpiralOrderTraversal(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		//		tree.root.left.right.left = new Node(7); 
		//		tree.root.left.right.right = new Node(4);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.left.right = new Node(9);
		tree.levelOrder(tree.root);
		System.out.println();
		tree.findSpiral(tree.root);
	} 

	private void findSpiral(Node node) {
		Queue<Node> qu = new LinkedList<Node>();
		Stack<Integer> st = new Stack<Integer>();
		node.setLevel(1);
		qu.add(node);

		while(!qu.isEmpty()) {
			int count = qu.size();

			while(count != 0) {
				Node tmp = qu.peek();
				if(tmp.level%2 ==0) {
					tmp = qu.remove();
					System.out.print(tmp.value + " ");
					if(tmp.left != null) {
						tmp.left.setLevel(tmp.level+1);
						qu.add(tmp.left);
					}
					if(tmp.right != null) {
						tmp.right.setLevel(tmp.level+1);
						qu.add(tmp.right);
					}
				} else {
					tmp = qu.remove();
					st.push(tmp.value);
					if(tmp.left != null) {
						tmp.left.setLevel(tmp.level+1);
						qu.add(tmp.left);
					}
					if(tmp.right != null) {
						tmp.right.setLevel(tmp.level+1);
						qu.add(tmp.right);
					}
				}
				count--;
			}
			while(!st.isEmpty())
				System.out.print(st.pop()+" ");
		}
	}

	void levelOrder(Node root) {
		// make a queue for level order. Queue is Interface and LinkedList is class
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			System.out.print(presentNode.value + " ");
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null)
				queue.add(presentNode.right);
		}
		System.out.println();
	}


	static class Node {
		int value;
		Node left, right;
		int level;
		Node(int item)    {
			value = item;
			left = right = null;
		}

		void setLevel(int level) {
			this.level = level;
		}
	}
}
