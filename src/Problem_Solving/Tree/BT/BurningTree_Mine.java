package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;

/**Didn't work for a very long test case in GFG

First search the target node in a binary tree recursively. After finding the target node print it and save its left child(if exist) and right child(if exist) 
in a queue. and return. Now, get the size of the queue and run while loop. Print elements in the queue.

Mine
**/
public class BurningTree_Mine {

	Node root;
	static Queue<Node> q = new LinkedList<>();
	public static void main(String[] args) {
		BurningTree_Mine tree = new BurningTree_Mine();
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.left.left.left = new Node(8); 
		tree.root.left.right.left = new Node(9); 
		tree.root.left.right.right = new Node(10); 
		tree.root.left.right.left.left = new Node(11);

		System.out.println("the level order traversal of tree is "); 
		tree.levelOrder(tree.root);
		Node target = tree.root.left.right.left.left; 
		int time = tree.findBurningTime(tree.root, target);

		while(!q.isEmpty()) {
			int size = q.size();
			time++;
			if(size > 0) {
				System.out.println("time: "+ time);
				while(size != 0) {
					Node tmp = q.remove();
					System.out.println(tmp.data+" ");
					if(tmp.left != null)
						q.add(tmp.left);
					else if (tmp.right != null)
						q.add(tmp.right);
					size--;
				}
			}
		}
	}


	private int findBurningTime(Node node, Node target) {
		if(node == null)
			return -1;

		if(node == target) {
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
			System.out.println("Target found "+ node.data);
			return 0;
		}

		int left = findBurningTime(node.left, target);
		if(left > -1) {
			int size = q.size();
			System.out.println("time: "+(left+1));
			System.out.println(node.data);					//print current node
			while(size != 0) {
				Node tmp = q.remove();
				System.out.println(tmp.data);
				if(tmp.left != null)
					q.add(tmp.left);
				if(tmp.right != null)
					q.add(tmp.right);
				size--;
			}
			if(node.right != null)
				q.add(node.right);							//add current node's child
			return left+1;
		}
		int right = findBurningTime(node.right, target);
		if(right > -1) {
			//			q.add(node);
			int size = q.size();
			System.out.println("time: "+(right+1));
			System.out.println(node.data);
			while(size != 0) {
				Node tmp = q.remove();
				System.out.println(tmp.data);
				if(tmp.left != null)
					q.add(tmp.left);
				if(tmp.right != null)
					q.add(tmp.right);
				size--;
			}
			if(node.left != null)
				q.add(node.left);
			return right+1;
		}
		return -1;
	}




	void levelOrder(Node root) {
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


	static class nodeInfo {
		Node node;
		boolean isLeft;
		public nodeInfo(Node node, boolean isLeft) {
			this.node = node;
			this.isLeft = isLeft;
		}
	}
	static class Node  { 
		int data; 
		Node left, right; 

		Node(int item)  {
			data = item; 
			left = right = null; 
		} 
	}
}
