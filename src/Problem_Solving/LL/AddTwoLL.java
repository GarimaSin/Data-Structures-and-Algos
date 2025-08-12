package Problem_Solving.LL;

public class AddTwoLL {
	// Helper function to push a new node at the beginning of the linked list
	
	static Node head = null;
	public static Node push(Node head, int data)
	{
		Node node = new Node(data);
		node.next = head;

		head = node;
		return head;
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
	public static Node addDigit(Node head1, Node head2) {
		return head;
	}
	
	static Node findLeastSignificantDigit(Node head1, int val) {
		if(head1.next == null)
			return head1;
		Node tmp = findLeastSignificantDigit(head1.next, val);
		int sum = tmp.data + val;
		int data = sum%10;
		int carry = sum/10;
		Node tmp1 = new Node(data);
		head.next = tmp1;
		tmp1.next = null;
		return tmp;
	}

	public static void main(String[] args)
	{
		int[] number1 = { 9, 9, 9, 9, 3 };
		Node head1 = null;
		for (int i = 0; i <=number1.length - 1; i++) {
			head1 = push(head1, number1[i]);
		}
		
		int[] number2 = { 1,5,7 };
		Node head2 = null;
		for (int i = 0; i <=number2.length - 1; i++) {
			head2 = push(head2, number2[i]);
		}
		
		printList(" Original Linked List: ", head1);
		
		Node head = addDigit(head1, head2);
		printList("Resultant Linked List: ", head);
	}
	

	public static void printList(String msg, Node head) {
		System.out.print(msg);
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.println("null");
	}
}
