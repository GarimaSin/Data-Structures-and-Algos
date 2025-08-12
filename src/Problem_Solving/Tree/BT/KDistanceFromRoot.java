package Problem_Solving.Tree.BT;

import java.util.ArrayList;

public class KDistanceFromRoot {

	Node root;	
	static ArrayList<Integer> ans = new ArrayList<>();
	
	//storing answer in string and a list both. Can remove any one. Redundant.
	String Kdistance(Node root, int k, int dis)	{
		if(root == null)
			return "";
		if(dis == k) {
			ans.add(root.data);
			return root.data+"";
		}
		String a = Kdistance(root.left, k, dis +1);
		String b = Kdistance(root.right, k, dis+1);
		return a+"-"+b;
    }
	
	public static void main(String args[]) { 
		KDistanceFromRoot tree = new KDistanceFromRoot(); 
          
        /* Constructed binary tree is 
                1 
              /   \ 
             2     3 
            /  \   / 
           4    5 8  
        */
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(8); 
   
        System.out.println(tree.Kdistance(tree.root, 3, 1));
        for(int n: ans) {
        	System.out.print(n +" ");
        }
    } 
	
	static class Node {
	    int data;
	    Node left, right;
	   Node(int item)    {
	        data = item;
	        left = right = null;
	    }
	}
}
