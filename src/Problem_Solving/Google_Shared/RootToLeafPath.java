package Problem_Solving.Google_Shared;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RootToLeafPath {

	public static void printPathRecursive(Node2 curr, Map<Node2, Node2> map)
	{
		// base case : curr is root node (parent of root node is null)
		if (curr == null) {
			return;
		}

		// recursively call parent node
		printPathRecursive(map.get(curr), map);
		System.out.print(curr.data + (isLeaf(curr) ? "\n" : " -> "));
	}

	static void printPathsRecur(Node2 node, int path[], int pathLen)  
	{ 
		if (node == null) 
			return; 

		/* append this node to the path array */
		path[pathLen] = node.data; 
		pathLen++; 

		/* it's a leaf, so print the path that led to here  */
		if (node.left == null && node.right == null) 
			printPath(path, pathLen); 
		else 
		{ 
			/* otherwise try both subtrees */
			printPathsRecur(node.left, path, pathLen); 
			printPathsRecur(node.right, path, pathLen); 
		} 
	}


	public static void printPathRecursiveMine1(Node2 curr, String res, List<Node2> ans) {
		if (curr == null) {
			for(Node2 n: ans)
				if(n != null)
					System.out.print(n.data + "  ");
			System.out.println("_______");
			return;
		}

		ans.add(curr.left);
		printPathRecursiveMine1(curr.left, res+curr.data, ans);
		ans.remove(ans.size()-1);
		ans.add(curr.right);
		printPathRecursiveMine1(curr.right, res+curr.data, ans);
		ans.remove(ans.size()-1);
	}


	private static void printPath(int[] path, int len) {
		for(int i=len-1; i>0; i--) {
			System.out.print(path[i] + " ");
		}
	}

	public static boolean isLeaf(Node2 node) {
		return (node.left == null && node.right == null);
	}

	public static void main(String[] args)
	{
		/* Construct below tree
		           1
		         /   \
		        /     \
		       /       \
		      2         3
		     / \       / \
		    /   \     /   \
		   4     5   6     7
		            / \
		           /   \
		          8     9
		 */

		Node2 root = new Node2(1);
		root.left = new Node2(2);
		root.right = new Node2(3);
		root.left.left = new Node2(4);
		root.left.right = new Node2(5);
		root.right.left = new Node2(6);
		root.right.right = new Node2(7);
		root.right.left.left = new Node2(8);
		root.right.left.right  = new Node2(9);

		//		printPathRecursiveMine(root, new int[6], -1, "");
		//		printPathsRecur(root, new int[5], 0); 
		List<Node2> ans = new ArrayList<>();
		ans.add(root);
		printPathRecursiveMine1(root, "", ans);
		//		postorderIterative(root);
	}
}

class Node2
{
	int data;
	Node2 left = null, right = null;

	Node2(int data) {
		this.data = data;
	}
}
