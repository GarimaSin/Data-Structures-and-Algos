package Problem_Solving.LL;

/**
 * 
 * Here we are adding the lists from beginning
 * eg. list1 = 1,2,3 and a number = 456 
 * Ans list = 5,7,9
 */

//Data Structure to store a linked list node
class Node
{
	int data;
	Node next = null;

	Node(int data) {
		this.data = data;
	}
}

public class AddANumberToLL {
	// Helper function to push a new node at the beginning of the linked list
	public static Node push(Node head, int data)
	{
		Node node = new Node(data);
		node.next = head;

		head = node;
		return head;
	}

	// Helper function to print given linked list
	public static void printList(String msg, Node head)
	{
		System.out.print(msg);
		while (head != null)
		{
			System.out.print(head.data + " -> ");
			head = head.next;
		}

		System.out.println("null");
	}

	// Recursive function to add a given digit to the linked list representing a number.
	public static int add(Node head, int digit)
	{
		// base case: end of the linked list is reached
		if (head == null) {
			return digit;
		}

		// store carry returned by the recursive call of the next node
		int carry = add(head.next, digit);

		// optimization: terminate the recursion if carry is 0 at any point
		if (carry == 0) {
			return 0;
		}

		// get sum of the current node and the carry
		int sum = head.data + carry;

		head.data = sum % 10;	// update value of the current node
		return sum/10;			// return carry
	}

	// Function to add a single-digit number to a singly linked list
	// whose nodes represents digits of a number
	public static Node addDigit(Node head, int digit)
	{
		// Add given digit to the linked list using recursion
		int carry = add(head, digit);

		// if there is any carry left, add a new node at the beginning of the list
		if (carry > 0) {
			head = push(head, carry);
		}

		return head;
	}

	public static void main(String[] args)
	{
		int[] number = { 9, 9, 9, 9, 3 };

		Node head = null;
		for (int i = number.length - 1; i >= 0; i--) {
			head = push(head, number[i]);
		}

		int digit = 517;

		printList(" Original Linked List: ", head);
		head = addDigit(head, digit);
		printList("Resultant Linked List: ", head);
	}
}
