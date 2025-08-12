package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;


public class RootToLeafSum {

	Node root;

	private int findSumNotWorking(Node node, int sum) {
		if(node == null)
			return 0;

		if(node.left == null && node.right == null) 
			System.out.println(sum+node.data);

		int s = node.data+findSumNotWorking(node.left, sum);
		int s1 = node.data+findSumNotWorking(node.right, sum);
		sum = s+s1;
		return sum;
	}

	//Working = O(n), all root to leaf sum
	private void findSum(Node node, int sum) {
		if(node == null)
			return;
		if(node.left == null && node.right == null) 
			System.out.println(sum+node.data + " findSum");

		findSum(node.left, sum+ node.data);
		findSum(node.right, sum+ node.data);
	}

	//Working = O(n), all root to leaf sum
	private void findSum2(Node node, int sum) {
		if(node == null)
			return;

		sum = sum + node.data;

		if(node.left == null && node.right == null) 
			System.out.println(sum+"  from findSum2");

		findSum2(node.left, sum);
		findSum2(node.right, sum);
	}

	//Working = O(n), root to leaf sum = target
	//find why we dont need to use backtracking condition as in findSum3
	private static void findSumPath(Node node, int sum, String ans, int target) {
		if(node == null)
			return;

		sum = sum + node.data;
		ans = ans + node.data;

		if(sum == target) {
			System.out.println(ans+" findSumPath");
			return;
		}

		findSumPath(node.left, sum, ans, target);
		findSumPath(node.right, sum, ans, target);
	}

	//Working = O(n), root to leaf sum = target, giving only 1 path
	private static void findSum3(Node node, String ans, int target) {
		if(node == null)
			return;

		if(node.left == null && node.right == null) {
			target = target - node.data;
			if(target == 0) {
				System.out.println(ans+node.data+" findSum3.........");
			}
			return;
		}
		String tmp = ans;
		ans = ans + node.data;
		target = target - node.data;
		findSum3(node.left, ans, target);
		findSum3(node.right, ans, target);
		ans = tmp;
		target = target + node.data;
	}

	public static void main(String args[]) { 
		RootToLeafSum tree = new RootToLeafSum(); 
		tree.root = new Node(6); 
		tree.root.left = new Node(3); 
		tree.root.right = new Node(5); 
		tree.root.left.left = new Node(2); 
		tree.root.left.right = new Node(5); 
		tree.root.left.right.left = new Node(7); 
		tree.root.left.right.right = new Node(4); 
		tree.root.right.right = new Node(4);
		tree.levelOrder(tree.root);
		tree.findSum(tree.root, 0);
		tree.findSum2(tree.root, 0);
		System.out.println();

		findSumPath(tree.root, 0, "", 11);
		findSum3(tree.root, "", 11);
	} 

	void levelOrder(Node root) {
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
		int level;
		Node(int item)    {
			data = item;
			left = right = null;
		}

		void setLevel(int level) {
			this.level = level;
		}
	}
}