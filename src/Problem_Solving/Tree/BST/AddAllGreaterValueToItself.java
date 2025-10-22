package Problem_Solving.Tree.BST;

public class AddAllGreaterValueToItself {

	public static void main(String[] args) {
		
	}
	
	
	// Working
	
    public Node modify(Node root) {
        modifyBST(root);
        return root;
    }
    
    int sum = 0;
    public void modifyBST(Node root) {
        if(root == null)
            return;
        
        modifyBST(root.right);
        sum = sum + root.val;
        root.val = sum;
        modifyBST(root.left);
    }
}
