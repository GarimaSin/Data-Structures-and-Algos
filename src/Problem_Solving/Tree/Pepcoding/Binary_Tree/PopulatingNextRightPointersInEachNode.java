package Problem_Solving.Tree.Pepcoding.Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;


public class PopulatingNextRightPointersInEachNode {

	//	public Node connect(Node root) {
	//        Node tmp = root;
	//        while(tmp != null && tmp.left != null) {
	//            Node n = tmp;
	//            while(true) {
	//                n.left.next = n.right;
	//                if(n.next == null)
	//                    break;
	//                n.right.next = n.next.left;
	//                n = n.left;
	//            }
	//            tmp = tmp.left;
	//        }
	//        return root;
	//    }

	public Node connect(Node root) {
		if(root == null) 
			return null;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			int size = queue.size();
			Queue<Node> temp = new LinkedList<>(queue);
			for(int i = 1; i <= size; i++) {
				Node front = temp.poll();
				front.next = temp.peek();
			}
			for(int i = 1; i <= size; i++) {
				Node front = queue.poll();
				if(front.left != null) 
					queue.add(front.left);
				if(front.right != null) 
					queue.add(front.right);
			}
		}
		return root;
	}

	//Sol 2: faster
	public Node connectNodes(Node root) {
        if(root == null || root.right == null) {
            return root;
        }
        if(root.next != null) {
            root.right.next = root.next.left;
        }    
        root.left.next = root.right;        
        connectNodes(root.left);
        connectNodes(root.right);    
        return root;
    }
	
	Node root;
	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode tree = new PopulatingNextRightPointersInEachNode(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		//		tree.root.left.right.left = new Node(7); 
		//		tree.root.left.right.right = new Node(4);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.levelOrder(tree.root);
		tree.connect(tree.root);
	}

	void levelOrder(Node root) {
		// make a queue for level order. Queue is Interface and LinkedList is class
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			System.out.print(presentNode.val + " ");
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null)
				queue.add(presentNode.right);
		}
		System.out.println();
	}


	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}
}
