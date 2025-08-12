package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;


public class SumOfAllLeftLeaves {

	Node root;
	int sum = 0;
	static int ans = 0;
	public static void main(String args[]) { 
		SumOfAllLeftLeaves tree = new SumOfAllLeftLeaves(); 
        tree.root = new Node(6); 
        tree.root.left = new Node(3); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(2); 
        tree.root.left.right = new Node(5); 
        tree.root.left.right.left = new Node(7); 
        tree.root.left.right.right = new Node(4); 
        tree.root.right.right = new Node(4);
        tree.levelOrder(tree.root);
        System.out.println(tree.leftLeavesSum(tree.root));
        tree.leftLeavesSumMine1(tree.root);
        System.out.println("--------" + ans);
        System.out.println();
    } 
	
	void leftLeavesSumMine2(Node node, boolean isleft, Sum summ) {
        if (node == null)
            return;
  
        // Check whether this node is a leaf node and is left.
        if (node.left == null && node.right == null && isleft)
            summ.sum = summ.sum + node.data;
  
        // Pass true for left and false for right
        leftLeavesSumMine2(node.left, true, summ);
        leftLeavesSumMine2(node.right, false, summ);
    }
	
	int leftLeavesSumMine1(Node node) {
        if (node == null)
            return 0;
  
        // Check whether this node is a leaf node and is left.
        if (node.left == null && node.right == null)
            return node.data;
  
        // Pass true for left and false for right
        int left = leftLeavesSumMine1(node.left);
        leftLeavesSumMine1(node.right);
        if(left != 0)
        	ans = ans + left;
        return 0;
    }
  
    // A wrapper over above recursive function
    int leftLeavesSum(Node node)  {
        Sum suum = new Sum();
         
        // use the above recursive function to evaluate sum
        leftLeavesSumMine2(node, false, suum);
  
        return suum.sum;
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
	
	static class Sum {
	    int sum = 0;
	}
}
