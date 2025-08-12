package Problem_Solving.Tree.BST;

public class KthSmallestElemInBST {

	//Working
	int count = 0;
    public int kthSmallest(Node root, int k) {
        if(root == null) 
            return -1;
        
        int l = kthSmallest(root.left, k);
        if(l != -1)
            return l;
        
        count++;
        if(count == k)
            return root.data;
        
        int r = kthSmallest(root.right, k);
        if(r != -1)
            return r;
        
        return -1;
    }
    
    public static void main(String[] args) {
		
	}
}
