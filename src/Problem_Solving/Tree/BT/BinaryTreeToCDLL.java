package Problem_Solving.Tree.BT;

public class BinaryTreeToCDLL {
	Node root;
	static Node head;
	static Node tail;
	static Node prev = null;

	static void convert(Node root)    {
		if (root == null)
			return;
		convert(root.left);
		if (prev == null) 
			head = root;
		else	{
			root.left = prev;
			prev.right = root;
			tail = root;
		}
		prev = root;
		convert(root.right);
	}
	
	//Not working
	static Node convertMine(Node root)    {
		if (root == null)
			return null;
		Node left = convertMine(root.left);
		if (left == null) 
			head = root;
		else	{
			root.left = left;
			left.right = root;
			tail = root;
		}
		Node right = convertMine(root.right);
		if (right == null) 
			root.right = null;
		else	{
			root.right = right;
			right.left = root;
			tail = right;
		}
		return root;
	}

	static void printList(Node node)    {
		head = node;
		System.out.print(node.data + " ");
		node = node.right;
		while (node != head)    {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}

	public static void main(String[] args)    {
		/* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
		 */
		BinaryTreeToCDLL tree = new BinaryTreeToCDLL();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		convert(tree.root);
//		tail.right = head;							// point tail to head and head to tail - for CDLL
//		head.left = tail;
//		System.out.println(head.data);
//		System.out.println(tail.data);
//		printList(head);
//		convertMine(tree.root);
		tail.right = head;							// point tail to head and head to tail - for CDLL
		head.left = tail;
		System.out.println(head.data);
		System.out.println(tail.data);
		printList(head);
	}

	static class Node	{
		int data;
		Node left = null, right = null;

		Node(int data) {
			this.data = data;
		}
	}
}
