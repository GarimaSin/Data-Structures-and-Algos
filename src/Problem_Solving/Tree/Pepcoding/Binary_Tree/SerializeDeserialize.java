package Problem_Solving.Tree.Pepcoding.Binary_Tree;

public class SerializeDeserialize {

	StringBuilder sb = new StringBuilder();
	public String serialize(TreeNode root) {
		preorderTraversal(root);
		return sb.toString();
	}

	void preorderTraversal(TreeNode root){
		if(root==null){
			sb.append("n ");
			return;
		}
		sb.append(root.val+" ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}



	// Decodes your encoded data to tree.
	int index = 0;
	public TreeNode deserialize(String data) {
		String[] ss = data.split(" ");
		return prebuild(ss);
	}
	
	TreeNode prebuild(String[] ss){
		if(index>=ss.length)
			return null;
		
		if(ss[index].equals("n"))
			return null;
		
		TreeNode node = new TreeNode(Integer.parseInt(ss[index]));
		index++;
		node.left=prebuild(ss);
		index++;
		node.right=prebuild(ss);
		return node;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
