package Problem_Solving.Tree.BT;

public class DiameterOfATree {

	Node root;
	public static void main(String[] args) {
		DiameterOfATree tree = new DiameterOfATree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        // Function Call
        System.out.println("The diameter of given binary tree is : "+ tree.diameter(tree.root).dia);
	}
	
	
	private DiaPair diameter(Node node) {
		if(node == null) {
			DiaPair d = new DiaPair();
			d.height = -1;
			d.dia = 0;
			return d;
		}
		
		DiaPair dLeft = diameter(node.left);
		DiaPair dRight = diameter(node.right);
		
		
		DiaPair mp = new DiaPair();
		mp.height = Math.max(dLeft.height, dRight.height) + 1;
		
		int dia = dLeft.height + dRight.height + 2;
		mp.dia = Math.max(dia, Math.max(dLeft.dia, dRight.dia));
		
		return mp;
	}

	class DiaPair {
		int height;
		int dia;
	}
	
	static class Node {
	    int data;
	    Node left, right;
	 
	    public Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
}
