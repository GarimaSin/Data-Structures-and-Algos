package DataStructures.Udemy.BinaryTree;

import java.util.*;
import DataStructures.Udemy.Node.BinaryNode;
/**
 * Deepest node = last node in the Level Order Traversal'
 * I/D/Search, all use Queue = LOT
 */

public class BinaryTreeByLinkedList {
	BinaryNode root;

	//Constructor for creating a blank Binary Tree
	BinaryTreeByLinkedList(){
		this.root = null;
	}

	// inserts a new node at deepest place in Tree
	void insert(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		if (root == null) {
			root = node;
			System.out.println("Successfully inserted new node at Root !");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (presentNode.getLeft() == null) {		/** left is placed before right **/
				presentNode.setLeft(node);
				System.out.println("Successfully inserted new node !");
				break;
			}else if (presentNode.getRight() == null) {
				presentNode.setRight(node);
				System.out.println("Successfully inserted new node !");
				break;
			} else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight());
			}//end of else-if
		}//end of loop
	}//end of method


	// Search for a given value in binary tree
	void search(int value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (presentNode.getValue() == value) {
				System.out.println("Value-"+value+" is found in Tree !");
				return;
			}else {
				if (presentNode.getLeft()!=null)
					queue.add(presentNode.getLeft());
				if (presentNode.getRight()!=null)
					queue.add(presentNode.getRight());
			}
		}//end of loop	
		System.out.println("Value-"+value+" is not found in Tree !");
	}//end of method


	// delete node from binary tree
	void deleteNodeOfBinaryTree(int value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			// if node is found then copy deepest node here and delete deepest node.
			if (presentNode.getValue() == value) {
				presentNode.setValue(getDeepestNode().getValue());
				DeleteDeepestNode();
				System.out.println("Deleted the node !!");
				return;
			} else {
				if (presentNode.getLeft() != null)
					queue.add(presentNode.getLeft());
				if (presentNode.getRight() != null)
					queue.add(presentNode.getRight());
			}
		}//end of while loop
		System.out.println("Did not find the node!!");
	}


	//Delete deepest node - previousNode = node that comes b4 presentNode in LOT (since Q is used)
	public void DeleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode previousNode, presentNode = null;
		while (!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				previousNode.setRight(null);
				return;
			}else if ((presentNode.getRight() == null)) {
				presentNode.setLeft(null);
				return;
			}
			queue.add(presentNode.getLeft());
			queue.add(presentNode.getRight());
		}//end of while loop
	}//end of method



	// get last node of last level of binary tree
	public BinaryNode getDeepestNode() {
		// make an empty queue. Queue is Interface and LinkedList is class
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
		return presentNode;
	}//end of method


	// pre-order traversal of binary tree
	void preOrder(BinaryNode node) {
		if (node == null)
			return;
		System.out.print(node.getValue() + " ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}//end of method

	public void preorderIterative(BinaryNode root) {
		if (root == null) {
			return;
		}

		Stack<BinaryNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.empty()) {
			// pop a node from the stack and print it
			BinaryNode curr = stack.pop();

			System.out.print(curr.getValue() + " ");

			if (curr.getRight() != null) 
				stack.push(curr.getRight());

			if (curr.getLeft() != null) 
				stack.push(curr.getLeft());
			// important note - right child is pushed first so that left child
			// is processed first (FIFO order)
		} 
	}


	// post-order traversal of binary tree
	void postOrder(BinaryNode node) {
		if (node == null)
			return;
		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.print(node.getValue() + " ");
	}//end of method

	public void postorderIterative(BinaryNode root) {
		// create an empty stack and push root node
		Stack<BinaryNode> stack = new Stack<>();
		stack.push(root);

		// create another stack to store post-order traversal
		Stack<Integer> out = new Stack<>();

		while (!stack.empty()) {
			BinaryNode curr = stack.pop();
			out.push(curr.getValue());

			if (curr.getLeft() != null) 
				stack.push(curr.getLeft());

			if (curr.getRight() != null) 
				stack.push(curr.getRight());
		}

		// print post-order traversal
		while (!out.empty()) {
			System.out.print(out.pop() + " ");
		}
	}

	// in-order traversal of binary tree
	void inOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.getLeft());
		System.out.print(node.getValue() + " ");
		inOrder(node.getRight());
	}//end of method

	void inorderIterative() { 
		if (root == null) 
			return; 

		Stack<BinaryNode> s = new Stack<BinaryNode>(); 
		BinaryNode curr = root; 

		while (curr != null || s.size() > 0) { 
			while (curr !=  null) { 
				s.push(curr); 
				curr = curr.getLeft(); 
			} 
			curr = s.pop(); 

			System.out.print(curr.getValue() + " "); 
			curr = curr.getRight(); 
		} 
	} 
	
	BinaryNode mirror(BinaryNode node)  { 
        if (node == null) 
            return node; 				/** return node and not null **/
  
        /* do the subtrees */
        BinaryNode left = mirror(node.getLeft()); 
        BinaryNode right = mirror(node.getRight()); 
  
        /* swap the left and right pointers */
        node.setLeft(right); 
        node.setRight(left); 
  
        return node; 
    } 
	
	boolean printAncestors(BinaryNode node, int target)  { 
        if (node == null) 
            return false; 
   
        if (node.getValue() == target) 
            return true; 
   
        /* If target is present in either left or right subtree of this node, then print this node */
        if (printAncestors(node.getLeft(), target) || printAncestors(node.getRight(), target))  { 
            System.out.print(node.getValue() + " "); 
            return true; 
        } 
        return false; 				/** return false **/
    } 

	//Calculate the height of the tree
	int getHeight(BinaryNode node) {
		if(node == null)
			return 0;
		int left = 1 + getHeight(node.getLeft());
		int right = 1 + getHeight(node.getRight());
		
		return Math.max(left, right);
	}
	
	public void spiralWithTwoStack(BinaryNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryNode> s1 = new Stack<>();
        Stack<BinaryNode> s2 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                root = s1.pop();
                System.out.print(root.getValue() + " ");
                if (root.getLeft() != null) {
                    s2.push(root.getLeft());				//s2.push
                }
                if (root.getRight() != null) {
                    s2.push(root.getRight());
                }
            }
            while (!s2.isEmpty()) {
                root = s2.pop();
                System.out.print(root.getValue() + " ");
                if (root.getRight() != null) {
                    s1.push(root.getRight());				//s1.push
                }
                if (root.getLeft() != null) {
                    s1.push(root.getLeft());
                }
            }
        }
    }


	// level order traversal of binary tree
	void levelOrder() {
		// make a queue for level order. Queue is Interface and LinkedList is class
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeft() != null) {
				queue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
	}// end of method


	// Delete Tree
	void deleteTree() {
		root = null;
		System.out.println("Binary Tree has been deleted successfully");
	}
	
	String rightView(BinaryNode root)	{
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(root);
		String rightView = root.getValue()+" ";
		int maxLevel = 0;
		
		while(!q.isEmpty()) {
			BinaryNode tmp = q.remove();
			if(maxLevel < tmp.level) {
				rightView = rightView + tmp.getValue()+" ";
				maxLevel = tmp.level;
			}
			
			if(tmp.getRight() != null) {
				tmp.getRight().setLevel(tmp.level+1);
				q.add(tmp.getRight());
			}
			if(tmp.getLeft() != null) {
				tmp.getLeft().setLevel(tmp.level+1);
				q.add(tmp.getLeft());
			}
		}
		return rightView;
	}
}