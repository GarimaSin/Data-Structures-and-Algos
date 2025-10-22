package Problem_Solving.Tree.BT;

import java.util.ArrayList;

public class BurningTreePrintAllNodes {

	//Same logic as NodesAtKDistance
	static int burningTree(Node node, int target, ArrayList<ArrayList<Integer>> ans)    { 
		if (node == null) 
			return -1; 

		// If target is same as root.  
		if (node.val == target)		{ 
			burnTree(node, 0, null, ans); 		//Use the downward function to print all nodes at distance k in subtree rooted with target or root
			return 1; 
		} 

		int leftTime = burningTree(node.left, target, ans); 
		if(leftTime != -1) {
			burnTree(node, leftTime, node.left, ans);
			return leftTime+1;
		}

		int rightTime = burningTree(node.right, target, ans); 
		if(rightTime != -1) {
			burnTree(node, rightTime, node.right, ans);
			return rightTime+1;
		}
		return -1; 
	}

	static int maxTime = 0;

	static void burnTree(Node node, int time, Node blocker, ArrayList<ArrayList<Integer>> ans)	{ 
		if (node == null || node == blocker) 
			return; 

		if(time == ans.size())
			ans.add(new ArrayList<Integer>());
		ans.get(time).add(node.val);

		maxTime = Math.max(maxTime, time);
		burnTree(node.left, time+ 1, blocker, ans); 
		burnTree(node.right, time+ 1, blocker, ans); 
	}

	public static void main(String[] args)	{

		/*   12
             /   \
          13   10
         /     /     \
      16    14    15
             /  \    /  \
          21 24 22 23	*/

		Node root = new Node(12);
		root.left = new Node(13);
		root.left.left = new Node(16);
		root.right = new Node(10);
		root.right.left = new Node(14);
		root.right.right = new Node(15);
		Node left = root.right.left;
		Node right = root.right.right;
		left.left = new Node(21);
		left.right = new Node(24);
		right.left = new Node(22);
		right.right = new Node(23);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		burningTree(root, 14, ans);
		System.out.println(maxTime);
		for(ArrayList<Integer> list: ans) {
			System.out.println(list);
		}
	}

	static class Node {
		int val;
		Node left, right;
		Node(int item)    {
			val = item;
			left = right = null;
		}
	}
}