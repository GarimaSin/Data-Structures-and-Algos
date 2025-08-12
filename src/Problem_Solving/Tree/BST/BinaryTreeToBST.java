package Problem_Solving.Tree.BST;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class BinaryTreeToBST {
	
	boolean isIsomorphic(Node n1, Node n2)  { 
        if (n1 == null && n2 == null) 
            return true; 
   
        if (n1 == null || n2 == null) 
            return false; 
   
        if (n1.data != n2.data) 
            return false; 
   
        // There are two possible cases for n1 and n2 to be isomorphic 
        // Case 1: The subtrees rooted at these nodes have NOT been  "Flipped".  
        // Both of these subtrees have to be isomorphic. 
        // Case 2: The subtrees rooted at these nodes have been "Flipped" 
        return (isIsomorphic(n1.left, n2.left) &&  isIsomorphic(n1.right, n2.right)) 
        || (isIsomorphic(n1.left, n2.right) &&  isIsomorphic(n1.right, n2.left)); 
    } 
	
	public static void inorder(Node root)    {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
    // Function to traverse the binary tree and store its keys in a set
    public static void extractKeys(Node root, Set<Integer> set)    {
        if (root == null) {
            return;
        }
 
        extractKeys(root.left, set);
        set.add(root.data);						// Since it is treeSet hence sorted
        extractKeys(root.right, set);
    }
 
    // Function to put keys back into a set in their correct order in the BST by doing inorder traversal
    public static void convertToBST(Node root, Iterator<Integer> it)    {
        if (root == null) {
            return;
        }
 
        convertToBST(root.left, it);
        root.data = it.next();
        convertToBST(root.right, it);
    }
 
    public static void main(String[] args)    {
        /* Construct the following tree
                   8
                 /   \
                /     \
               3       5
              / \     / \
             /   \   /   \
            10    2 4     6
        */
 
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(10);
        root.left.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
 
        // traverse the binary tree and store its keys in a set - in sorted order
        Set<Integer> set = new TreeSet<>();
        extractKeys(root, set);
 
        // put back keys present in the set to their correct order in the BST
        Iterator<Integer> it = set.iterator();
        convertToBST(root, it);
 
        // print the BST
        inorder(root);
    }
    
    static class Node	{
        int data;
        Node left = null, right = null;
     
        Node(int data) {
            this.data = data;
        }
    }
}