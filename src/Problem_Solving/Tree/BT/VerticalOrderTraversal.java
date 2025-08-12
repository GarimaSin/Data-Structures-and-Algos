package Problem_Solving.Tree.BT;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalOrderTraversal {

	static Node root;	
	void printTreeVertically(Node root) {
		HashMap<Integer,LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
		Queue<vPair> que = new LinkedList<>(); 
		que.add(new vPair(0, root));
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(root.data);
		map.put(0, l);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;


		while(!que.isEmpty()) {
			vPair p = que.remove();
			min = Math.min(min, p.hd);
			max = Math.max(max, p.hd);

			if(p.node.left != null) {
				vPair tmp = new vPair(p.hd-1, p.node.left);
				map.putIfAbsent(p.hd-1, new LinkedList<Integer>());
				LinkedList<Integer> list = map.get(p.hd-1);
				list.add(p.node.left.data);
				map.put(p.hd-1, list);
				que.add(tmp);
			} 
			if(p.node.right != null) {
				vPair tmp = new vPair(p.hd+1, p.node.right);
				map.putIfAbsent(p.hd+1, new LinkedList<Integer>());
				LinkedList<Integer> list = map.get(p.hd+1);
				list.add(p.node.right.data);
				map.put(p.hd+1, list);
				que.add(tmp);
			} 
		}
		for (int i = min; i <= max; i++) {
			System.out.print(map.get(i)+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		VerticalOrderTraversal tree = new VerticalOrderTraversal();
		root = new Node(3); 
		root.left = new Node(9); 
		root.right = new Node(20); 
		//	    root.left.left = new Node(4); 
		//		root.left.right = new Node(5); 
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		//		root.right.right.left = new Node(2);
		tree.printTreeVertically(root);
	}

	static class vPair{
		int hd;
		Node node;
		vPair() {}

		vPair(int hd, Node n) {
			this.node = n;
			this.hd = hd;
		}
	}

	static class Node {
		int data;
		Node left, right;
		Node(int item)    {
			data = item;
			left = right = null;
		}
	}
}