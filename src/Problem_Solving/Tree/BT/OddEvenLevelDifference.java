package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;

public class OddEvenLevelDifference {

	Node root;	

	int getLevelDiff(Node root)	{
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int oddLevel =0, evenLevel = 0;
		
		while(!q.isEmpty()) {
			Node tmp = q.remove();
			if(tmp.level%2 == 0)
				evenLevel += tmp.data;
			else 
				oddLevel += tmp.data;
			
			if(tmp.left != null) {
				tmp.left.setLevel(tmp.level+1);
				q.add(tmp.left);
			}
			if(tmp.right != null) {
				tmp.right.setLevel(tmp.level+1);
				q.add(tmp.right);
			}
		}
		return oddLevel - evenLevel;
	}
	
	public static void main(String args[]) { 
		OddEvenLevelDifference tree = new OddEvenLevelDifference(); 
		/* Constructed binary tree is 
                1 
              /   \ 
             2     3 
            /  \   / 
           4    5 8  
		 */
		tree.root = new Node(1); 
		tree.root.level = 0;
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
//		tree.root.left.left = new Node(40); 
//		tree.root.left.right = new Node(60); 
//		tree.root.right.left = new Node(8); 

		System.out.println(tree.getLevelDiff(tree.root));
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
}
