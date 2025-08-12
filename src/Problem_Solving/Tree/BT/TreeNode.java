package Problem_Solving.Tree.BT;


public class TreeNode {

	public int val;
	public int level;
	public TreeNode left, right;
	
	public TreeNode(int item)    {
		val = item;
		left = right = null;
	}

	void setLevel(int level) {
		this.level = level;
	}
}
