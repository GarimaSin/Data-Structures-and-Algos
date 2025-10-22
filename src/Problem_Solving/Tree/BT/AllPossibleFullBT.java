package Problem_Solving.Tree.BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Working: LC - 894. All Possible Full Binary Trees
public class AllPossibleFullBT {

	static List<Node> helper(int n) {
		if(n == 1) {									//Base case for only 1 node 
			ArrayList<Node> base = new ArrayList<Node>();
			base.add(new Node(0));
			return base;
		}
		List<Node> ans = new ArrayList<Node>();
		for (int i=1; i<n; i+=2) {							// I - i will increase by 2 since only odd numbered indexes can be root
			List<Node> left = helper(i);
			List<Node> right = helper(n-i-1);
			for(Node l : left) {
				for(Node r : right) { 
					Node root = new Node(0);
					root.left = l;
					root.right = r;
					ans.add(root);
				}
			}
		}
		return ans;
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

	public static void main(String[] args) {
		List<Node> ans = helper(5);
		for(Node root: ans)
			levelOrder(root);
	}

	static class Node {
		int data;
		Node left, right;

		public Node(int item)   {
			data = item;
			left = right = null;
		}
	}
}