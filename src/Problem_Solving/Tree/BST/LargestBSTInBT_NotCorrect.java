package Problem_Solving.Tree.BST;

import java.util.LinkedList;
import java.util.Queue;


// Seems correct, worked for every test but can give error since not included min/max range -
// case (for min and max range, check explanation: Ques = if a tree is BST in Amazon Doc)
public class LargestBSTInBT_NotCorrect {

	Node root;
	static int max = 0;
	public static void main(String[] args) {

		LargestBSTInBT_NotCorrect tree = new LargestBSTInBT_NotCorrect(); 
		tree.root = new Node(10);
		 
		tree.root.left = new Node(15);
		tree.root.right = new Node(8);
 
		tree.root.left.left = new Node(12);
		tree.root.left.right = new Node(20);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(9);
 
		tree.root.left.left.left = new Node(2);
		tree.root.left.left.right = new Node(14);
		tree.root.right.left.left = new Node(4);
		tree.root.right.left.right = new Node(7);
 
		tree.root.right.right.right = new Node(10);
//		tree.root = new Node(6); 
//		tree.root.left = new Node(4); 
//		tree.root.right = new Node(3); 
		//		tree.root.left.left = new Node(5); 
//		tree.root.left.right = new Node(9); 
		//		tree.root.left.left.left = new Node(3); 
		//		tree.root.left.left.right = new Node(10); 
		//		tree.root.left.right.right = new Node(14); 
		//		tree.root.right.left = new Node(2); 
//				tree.root.right.right = new Node(6); 
//				tree.root.right.right.left = new Node(65); 
//				tree.root.right.right.right = new Node(5); 
//				tree.root.right.right.right.right = new Node(3); 
//				tree.root.right.right.right.right.right = new Node(1); 
//				tree.root.right.right.right.right.right.right = new Node(3); 
//				tree.root.right.right.right.right.right.right.right = new Node(8); 
//				tree.root.right.right.right.right.right.right.right.right = new Node(7); 
//				tree.root.right.right.right.right.right.right.right.right.right = new Node(5); 
		//		tree.root.right.left.right = new Node(12); 
		//		tree.root.right.left.left = new Node(11); 

		System.out.println("the inorder traversal of tree is "); 
		tree.levelOrder(tree.root);
		System.out.println(largestBst(tree.root));
		
		
		ConstructTreeFromInOrderPreOrder ctf = new ConstructTreeFromInOrderPreOrder();
		int inorder[]  = {-7,-6,-5,-4,-3,-2,1,2,3,16,6,10,11,12,14};
		int preorder[] = {3,-2,-3,-4,-5,-6,-7,1,2,16,10,6,12,11,14};
		Node root1 = ctf.createTree(inorder, preorder);
		System.out.println("ans..........."+ largestBst(root1));
	}

	static int largestBst(Node root) {
        if(isLeaf(root))
			return 1;
		if(root == null)
			return 0;        
        findLargestBST(root);
        return (max == 0) ? 1 : max;
    }

	//Couldn't find a wrong test case - but couldn't verify in gfg coz getting absurd ans there, while its running fine here for the same test case
   static private bst findLargestBST(Node node) {
		if(node == null) {
			bst ans = new bst(true, 0);
			return ans;
		}

		if(isLeaf(node)) {
			bst ans = new bst(true, 1);
			return ans;
		}

		int tmp = 0, sum =0;
		if(node.left != null && node.right != null) {
			if(node.left.data > node.data  || node.right.data < node.data)
				tmp = 0;
			else 
				tmp = 1;
		} else if((node.left != null && node.left.data < node.data))
			tmp = 1; 
		else if(node.right != null && node.right.data > node.data)
			tmp = 1;

		bst left = findLargestBST(node.left);
		bst right = findLargestBST(node.right);
		if(left.isBST && right.isBST) { 
			if(tmp != 0) {
				sum = left.val + right.val + tmp;
				max = Math.max(max, sum);
				bst ans = new bst(true, sum);
				return ans;
			}
		}
		bst ans = new bst(false, 0);
		return ans;
	}
	
	static boolean isLeaf(Node n) {
		if(n!= null)
			if(n.left == null && n.right == null)
				return true;
		return false;
	}
	
	static class bst {
		boolean isBST = false;
		int val = 0;

		bst(boolean isBST, int val) {
			this.isBST = isBST;
			this.val = val;
		}
		bst(){}
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
		
		Node(){}
		public static Node newNode(int data){
	        Node n = new Node();
	        n.left = null;
	        n.right = null;
	        n.data = data;
	        return n;
	    }
	}
}
