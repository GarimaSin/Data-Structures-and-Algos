package Problem_Solving.Tree.BT;


public class EvaluationOfExpressionTree {

	public static boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}

	public static int process(String op, int x, int y) {
		if (op == "+") { return x + y; }
		if (op == "-") { return x - y; }
		if (op == "*") { return x * y; }
		if (op == "/") { return x / y; }

		return 0;
	}

	public static int evaluate(Node root) {
		if (root == null) {
			return 0;
		}
		if (isLeaf(root)) {
			return Integer.valueOf(root.data);
		}
		int x = evaluate(root.left);
		int y = evaluate(root.right);

		return process(root.data, x, y);
	}

	public static void main(String[] args) {
		Node root = new Node("+");
		root.left = new Node("*");
		root.right = new Node("/");
		root.left.left = new Node("-");
		root.left.right = new Node("5");
		root.right.left = new Node("21");
		root.right.right = new Node("7");
		root.left.left.left = new Node("10");
		root.left.left.right = new Node("5");
		System.out.println("The value of the expression tree is " + evaluate(root));
	}
	
	
	static class Node { 
		String data; 
		Node left, right; 

		Node(String data) {
			this.data = data; 
			left = right = null; 
		} 
	}
}

