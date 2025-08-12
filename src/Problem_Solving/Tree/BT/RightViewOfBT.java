package Problem_Solving.Tree.BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class RightViewOfBT {

	Node root;
	public static List<Integer> rightSideView(Node root) {
		if(root == null)
            return null;
        
        Queue<Node> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int count = q.size();
            // int i = count;
            while(count--> 0) {
                Node tmp = q.remove();
                if(tmp.left != null)
                    q.add(tmp.left);
                if(tmp.right != null) {
                    q.add(tmp.right);
                }
                if(count == 0)
                    ans.add(tmp.val);
            }
        }
        return ans;
	}
	
	public static void main(String[] args) {
		RightViewOfBT tree = new RightViewOfBT();
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
//		tree.root.right = new Node(3); 
//		tree.root.left.left = new Node(5); 
//		tree.root.left.right = new Node(5); 
//		tree.root.left.left.left = new Node(9); 
//		tree.root.left.left.right = new Node(10); 
//		tree.root.left.right.right = new Node(14); 
//		tree.root.right.left = new Node(7); 
//		tree.root.right.right = new Node(4); 
		List<Integer> ans = rightSideView(tree.root);
		System.out.println(ans);
	}
	
	static class Node  { 
		int val; 
		Node left, right; 

		Node(int item)  {
			val = item; 
			left = right = null; 
		} 
	}
}

