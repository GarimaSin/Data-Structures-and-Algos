package Problem_Solving.Tree.BT;

public class MinDepthOfBT {

	Node root;	
	
	int minDepth(Node root)	{
		if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if(l == 0 && r == 0)
            return 1+Math.min(l, r);
        if(l == 0)
            return 1+r;
        if(r == 0)
            return 1+l;
        return 1+Math.min(l, r);
	}
	
	int height(Node root)	{
	    if(root == null)
			return 0;
		int left = 1 + height(root.left);
		int right = 1 + height(root.right);
		
		return Math.max(left, right);
	}

	public static void main(String args[]) { 
		MinDepthOfBT tree = new MinDepthOfBT(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(20); 
        tree.root.right = new Node(3); 
//        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.right = new Node(8);
        tree.root.right.right.left = new Node(2);
        System.out.println(tree.minDepth(tree.root));
        System.out.println(tree.height(tree.root));
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