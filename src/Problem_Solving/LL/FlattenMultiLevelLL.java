package Problem_Solving.LL;

class Node1 {
	Node1 next;
	Node1 child;
	int data;
}

class LinkedListApp {
	public Node1 createNewNode(int i) {
		Node1 a = new Node1();
		a.data = i;
		a.next = null;
		a.child = null;
		return a;
	}

	public Node1 insert(Node1 node, int i) {
		if (node == null) {
			return createNewNode(i);
		}
		node.next = insert(node.next, i);
		return node;
	}

	public Node1 createList(int arr[]) {
		Node1 node = null;

		for (int i = 0; i < arr.length; i++) {
			node = insert(node, arr[i]);
		}
		return node;
	}


	public Node1 flattenEasy(Node1 node) {
		if (node == null) {
			return node;
		}

		Node1 start, end;
		start = end = node;

		while (end.next != null) {
			end = end.next;
		}

		while (start != null) {
			if (start.child != null) {
				end.next = start.child;
				end = end.next;

				while (end.next != null) {
					end = end.next;
				}
			}
			start = start.next;
		}
		return node;
	}

	public void printList(Node1 node) {
		if(node == null) {
			return;
		}

		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}

public class FlattenMultiLevelLL {

	public static void main(String[] args) {

		LinkedListApp a = new LinkedListApp();

		Node1 root1, root2, root3, root4, root5;

		int arr1[] = new int[] { 1, 2, 3, 4, 5 };
		int arr2[] = new int[] { 6, 7, 8 };
		int arr3[] = new int[] { 9, 10 };
		int arr4[] = new int[] { 11 };
		int arr5[] = new int[] { 12 };

		root1 = a.createList(arr1);
		root2 = a.createList(arr2);
		root3 = a.createList(arr3);
		root4 = a.createList(arr4);
		root5 = a.createList(arr5);

		root1.child = root2;
		root1.next.next.next.child = root3;
		root2.next.child = root4;
		root3.child = root5;

		root1 = a.flattenEasy(root1);
		a.printList(root1);
	}
}
