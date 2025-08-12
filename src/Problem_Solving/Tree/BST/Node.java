package Problem_Solving.Tree.BT;


public class Node {

	int val;
	int level;
	Node left, right;
	
	Node(int item)    {
		val = item;
		left = right = null;
	}

	void setLevel(int level) {
		this.level = level;
	}
}
