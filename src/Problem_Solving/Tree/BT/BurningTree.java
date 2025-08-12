package Problem_Solving.Tree.BT;

public class BurningTree {

	//Same logic as NodesAtKDistance
	static int burningTree(Node node, int target)    { 
		if (node == null) 
			return -1; 

		// If target is same as root.  
		if (node.val == target)		{ 
			burnTree(node, 0, null); 		//Use the downward function to print all nodes at distance k in subtree rooted with target or root
			return 1; 
		} 

		int leftTime = burningTree(node.left, target); 
		if(leftTime != -1) {
			burnTree(node, leftTime, node.left);				//blocker is node.left
			return leftTime+1;
		}

		int rightTime = burningTree(node.right, target); 
		if(rightTime != -1) {
			burnTree(node, rightTime, node.right);		//blocker is node.right
			return rightTime+1;
		}
		return -1; 
	}

	static int maxTime = 0;
	static void burnTree(Node node, int time, Node blocker)	{ 
		if (node == null || node == blocker) 
			return; 

		maxTime = Math.max(maxTime, time);
		burnTree(node.left, time+ 1, blocker); 
		burnTree(node.right, time+ 1, blocker); 
	}

	public static void main(String[] args)	{

	/*   12
    	/   \
 	  13     10
	 /     /    \
   16     14     15
  		 /  \   /  \
 		21  24 22  23	*/

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
		burningTree(root, 14);
		System.out.println(maxTime);
	}
	
	static class Node	{
		int val;
		Node left;
		Node right;
		Node() {}
		Node(int val) { this.val = val; }
		Node(int val, Node left, Node right)	{
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
