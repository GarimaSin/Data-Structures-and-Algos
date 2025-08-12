package Problem_Solving.Google_Shared;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Create 2 queues, Q1 and Q2.
 * Add root.left in Q1 and root.right in Q2
 * while !Q1.isEmpty() {
 * 	pop node from Q1 and print, add all left and right child in Q1
 *	pop node from Q2 and print, add all left and right child in Q2
 *	}
 *
 *	Time = O(n)
 */
class Node1 {
	int key;
	Node1 left = null, right = null;

	Node1(int key) {
		this.key = key;
	}
}

public class PrintNodesInSpecificOrder {

	// Function to print all nodes of a given binary tree in specific
	// order from top to bottom
	public static void printNodes(Node1 root) {
		if (root == null) {
			return;
		}

		// print root node
		System.out.print(root.key + " ");

		// create a two empty queues and enqueue root's left and right child respectively
		Queue<Node1 > Q1 = new ArrayDeque<>(), Q2 = new ArrayDeque<>();
		Q1.add(root.left);
		Q2.add(root.right);

		while (!Q1.isEmpty()) {
			// process every node of current level pop front node from first queue and print it
			Node1 x = Q1.poll();

			System.out.print(x.key + " ");

			// push left and right child of x to first queue
			if (x.left != null) {
				Q1.add(x.left);
			}

			if (x.right != null) {
				Q1.add(x.right);
			}

			// pop front node from second queue and print it
			Node1 y = Q2.poll();

			System.out.print(y.key + " ");

			// push right and left child of y to second queue
			if (y.right != null) {
				Q2.add(y.right);
			}

			if (y.left != null) {
				Q2.add(y.left);
			}
		}
	}

	public static void main(String[] args) 	{
		Node1 root = new Node1(1);
		root.left = new Node1(2);
		root.right = new Node1(3);
		root.left.left = new Node1(4);
		root.left.right = new Node1(5);
		root.right.left = new Node1(6);
		root.right.right = new Node1(7);
		root.left.left.left = new Node1(8);
		root.left.left.right = new Node1(9);
		root.left.right.left = new Node1(10);
		root.left.right.right = new Node1(11);
		root.right.left.left = new Node1(12);
		root.right.left.right = new Node1(13);
		root.right.right.left = new Node1(14);
		root.right.right.right = new Node1(15);

		printNodes(root);
	}
}
