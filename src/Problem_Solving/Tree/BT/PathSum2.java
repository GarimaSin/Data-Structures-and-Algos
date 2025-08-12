package Problem_Solving.Tree.BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//Answer correct with string and list, formatting issue with LC
public class PathSum2 {

	Node root;

	//Working = O(n)
	private static void findSumPath(Node node, int sum, int target, List<Integer> list, List<List<Integer>> ans,String s) {
		if(node == null)
			return;

		if(sum == target) {
			ans.add(new ArrayList<>(list));
			System.out.println(s);
		}
		
		if(node.left == null && node.right == null)
			return;

		if(node.left != null) {
			list.add(node.left.data);
			findSumPath(node.left, sum + node.left.data, target, list, ans, s+node.left.data);
			list.remove(list.size() -1);
		}
		if(node.right != null)	{
			list.add(node.right.data);
			findSumPath(node.right,  sum + node.right.data, target, list, ans, s+node.right.data);
			list.remove(list.size() -1);
		}
	}
	

	public static void main(String args[]) { 
		PathSum2 tree = new PathSum2(); 
		tree.root = new Node(5); 
		tree.root.left = new Node(4); 
		tree.root.right = new Node(8); 
		tree.root.left.left = new Node(11); 
		tree.root.left.left.left = new Node(7); 
		tree.root.left.left.right = new Node(2);
		tree.root.right.right = new Node(4);
		tree.root.right.left = new Node(13); 
		tree.root.right.right.left = new Node(5); 
		tree.root.right.right.right = new Node(1); 
		
		tree.levelOrder(tree.root);
		System.out.println();
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new  ArrayList<Integer>();
        list.add(tree.root.data);
		findSumPath(tree.root, tree.root.data, 22, list, ans, ""+tree.root.data);
		System.out.println(ans);
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
