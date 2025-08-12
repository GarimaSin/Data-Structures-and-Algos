package InterviewExperience.VmWare;

import java.util.LinkedList;
import java.util.Queue;

public class NodesAtKDistance {

	Node root;
	public static void main(String[] args) {

		NodesAtKDistance tree = new NodesAtKDistance(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.right.left = new Node(5); 
		tree.root.right.right = new Node(6);
		tree.root.right.left.left = new Node(7); 

		System.out.println("the level order traversal of tree is "); 
		tree.levelOrder(tree.root);
		Node target = tree.root.right.left; 
		tree.printkdistanceNode(tree.root, target.data, 2);
	}

	int printkdistanceNode(Node node, int target, int k)    { 
		if (node == null) 
			return -1; 

		// If target is same as root.  
		if (node.data == target)		{ 
			kdistanceDown(node, k-0, null); 		//Use the downward function to print all nodes at distance k in subtree rooted with target or root
			return 1; 
		} 

		int dl = printkdistanceNode(node.left, target, k); 
		if(dl != -1) {
			kdistanceDown(node, k-dl, node.left);
			return dl+1;
		}

		int dr = printkdistanceNode(node.right, target, k); 
		if(dr != -1) {
			kdistanceDown(node, k-dr, node.right);
			return dr+1;
		}
		return -1; 
	}

	void kdistanceDown(Node node, int k, Node blocker)	{ 
		if (node == null || k < 0 || node == blocker) 
			return; 

		if (k == 0)  { 
			System.out.print(node.data); 
			System.out.println(""); 
			return; 
		} 

		kdistanceDown(node.left, k - 1, blocker); 
		kdistanceDown(node.right, k - 1, blocker); 
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

	static class Node  { 
		int data; 
		Node left, right; 

		Node(int item)  {
			data = item; 
			left = right = null; 
		} 
	}

	//	//Sum is not giving right ans but list holds correct ans
	//	private NodeInfo printAncestorAtKDis(Node node, int k, Node target) {
	//		if(node.val == target.val)	{
	//			return new NodeInfo(0, true);
	//		}
	//		if(node == null)
	//			return new NodeInfo(0, false);
	//		
	//		NodeInfo l = printAncestorAtKDis(node.left, k, target);
	//		if(l.found)
	//			l.dis++;
	//		NodeInfo r = printAncestorAtKDis(node.right, k, target);
	//		if(r.found)
	//			r.dis++;
	//		return sum;
	//	}
}