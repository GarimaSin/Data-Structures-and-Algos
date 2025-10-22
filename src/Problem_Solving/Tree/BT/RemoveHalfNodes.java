package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveHalfNodes {

	Node root;
	
	//Working
	private Node findHalfNodes(Node node) {
		if(node.left == null && node.right == null) 
			return node;
		
		if(node.left != null && node.right != null) {
			Node tmp = null;
			tmp = findHalfNodes(node.left);
			node.left = tmp;													// above 3 steps can be  reduced to:   node.left = findHalfNodes(node.left);
			
			node.right = findHalfNodes(node.right);
			return node;
		}
		if(node.left != null)  
			return removeHalfNodes(node);
		else 
			return removeHalfNodes(node);
	}

	private Node removeHalfNodes(Node node) {
		if(node.left != null && node.right != null)
			return node;
		if(node.left == null && node.right == null) 
			return node;
		if(node.left != null)
			node = removeHalfNodes(node.left);					// returned node contains the node which has both child as null or both child != null
		else
			node = removeHalfNodes(node.right);
		return node;
	}
	
	
	//Working - have to modify the tree after the calls are made or in post-order of the calls o/w whole tree will not be processed.
	private Node removeHalfNodes1(Node node) {
		if(node == null)
			return null;
		
		node.left = removeHalfNodes1(node.left);	// returned node contains the node which has both child as null or both child != null
		node.right = removeHalfNodes1(node.right);
		
		if(node.left == null && node.right == null)
			return node;
		if(node.left == null)
			return node.right;
		if(node.right == null) 
			return node.left;
		return node;
	}
	
	
	//Working - verified GFG
	public static Node removeHalfNodesMine(Node root)
    {
        if(root == null)
            return null;
        
        if(root.left == null && root.right == null)
            return root;
        
        Node l =  removeHalfNodesMine(root.left);
        Node r =  removeHalfNodesMine(root.right);
        if(l != null && r != null) {
            root.left = l;
            root.right = r;
            return root;
        }
        
        if(l == null)
            return r;
        else if (r == null)
            return l;
        
        return root;
    }

	public static void main(String[] args) {
		RemoveHalfNodes tree = new RemoveHalfNodes(); 
        tree.root = new Node(0); 
        tree.root.left = new Node(1); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.left.left = new Node(5); 
        tree.root.right.left = new Node(4); 
        tree.root.right.left.right = new Node(7); 
        tree.root.right.left.left = new Node(6); 
   
        System.out.println("the inorder traversal of tree is "); 
        tree.levelOrder(tree.root);
        System.out.println("*************");
        
        Node ans = tree.removeHalfNodes1(tree.root); 
        tree.levelOrder(ans);
        System.out.println("____________________");
        tree.levelOrder(tree.root);
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
	}
	
	static class Node  { 
	    int data; 
	    Node left, right; 
	   
	    Node(int item)  {
	        data = item; 
	        left = right = null; 
	    } 
	}
}
