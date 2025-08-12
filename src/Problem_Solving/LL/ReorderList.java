package Problem_Solving.LL;

public class ReorderList {

	public static ListNode reorderList(ListNode head) {
		if(head == null || head.next == null)
			return head;

		ListNode fast = new ListNode();
		ListNode slow = new ListNode();
		ListNode sHead = new ListNode();
		ListNode HEAD = new ListNode();
		fast = head; slow = head; sHead = head; HEAD = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		sHead = slow.next;
		slow.next = null;
		
		sHead = reverseList(sHead);

		while(head != null && sHead != null) {
			ListNode tmp1 = null;
			ListNode tmp2 = null;
			tmp2 = head.next;
			if(sHead.next != null) {
				tmp1 = sHead.next;
			}
			head.next = sHead;
			sHead.next = tmp2;
			sHead = tmp1;
			head = tmp2;
		}
		return HEAD;
	}


	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(6);
//		head.next.next.next.next.next.next = new ListNode(7);
		ListNode ans = reorderList(head);
		while(ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}