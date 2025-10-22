package Problem_Solving.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter {

	public static void main(String[] args) {
		
	}
	
	// Working
	TreeNode ROOT;
	TreeNode nip;
    Queue<TreeNode> que;
	public CompleteBinaryTreeInserter(TreeNode root) {
		ROOT=root;
		que = new LinkedList<>();
		que.add(root);
		while(true){
			TreeNode top = que.peek();
			if(top.left!=null){ 
				que.add(top.left);
			} else {
				nip=top;
				break;
			}
			if(top.right!=null){ 
				que.add(top.right);
			} else {
				nip=top;
				break;
			}
			que.poll();
		}
	}

	public int insert(int val) {
		int parent = nip.val;
		TreeNode node = new TreeNode(val);
		if(nip.left == null) {
			nip.left = node;
			que.add(node);
		} else {
			nip.right = node;
			que.add(node);
			que.poll();
			nip = que.peek();
		}
		return parent;
	}

	public TreeNode get_root() {
		return ROOT;
	}


}
