package Problem_Solving.LL;

public class SwapNodesInPairLL {


	//Recursive Sol
	public ListNode swapPairs(ListNode head) {
		if (head==null || head.next==null) 
			return head;
		ListNode temp = new ListNode(head.next.val);
		head.next = head.next.next;
		temp.next = head;                           //these steps points: 2 --> 1 --> 3 --> 4
		temp.next.next = swapPairs(temp.next.next); //these steps points: 2 --> 1 --> 4 --> 3
		return temp;  
	}


	//Iterative sol
	public static Node rearrange(Node head)	{
		if (head == null || head.next == null) {
			return head;
		}

		Node curr = head, prev = null;

		// consider two nodes at a time and swap their links
		while (curr != null && curr.next != null)	{
			Node temp = curr.next;
			curr.next = temp.next;
			temp.next = curr;
			if (prev == null) {
				head = temp;
			}
			else {
				prev.next = temp;
			}
			prev = curr;
			curr = curr.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head =new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		SwapNodesInPairLL ll = new SwapNodesInPairLL();
		ListNode result = ll.swapPairs(head);
		while(result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}

