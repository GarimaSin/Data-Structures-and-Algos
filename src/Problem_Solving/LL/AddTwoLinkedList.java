package Problem_Solving.LL;

//LC - 2.
public class AddTwoLinkedList {

	//From head
	public static void main(String[] args) {
		int nums[] = {9,9,9,9,9};
		ListNode l1 = createList(nums);
		int nums1[] = {9,9,9};
		ListNode l2 = createList(nums1);
		ListNode tmp = addTwoNumbers(l1, l2);
		while(tmp != null) {
			System.out.print(tmp.val+"  ");
			tmp = tmp.next;
		}
	}

	static int carry = 0;
	static ListNode head = new ListNode();
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		addNum(l1, l2);
		return head;
	}

	public static ListNode addNum(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null)
			return null;
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;


		ListNode prev = null;
		while(l1 != null && l2 != null) {
			ListNode ans = new ListNode();
			int val = l1.val + l2.val + carry;
			ans.val = val % 10;
			carry = val/10;
			if(prev == null)
				head = ans;
			else {
				prev.next = ans;
				prev = ans;
			}
			prev = ans;
			l1 = l1.next;
			l2 = l2.next;
		}

		while(l1 != null) {
			ListNode ans = new ListNode();
			int val = l1.val + carry;
			ans.val = val%10;
			carry = val/10;
			l1 = l1.next;
			prev.next = ans;
			prev = ans;
		}

		while(l2 != null) {
			ListNode ans = new ListNode();
			int val = l2.val + carry;
			ans.val = val%10;
			carry = val/10;
			l2 = l2.next;
			prev.next = ans;
			prev = ans;
		}
		
		if(carry != 0) {
			ListNode ans = new ListNode();
			ans.val = carry;
			prev.next = ans;
			prev = ans;
		}
		return head;
	}

	public static ListNode createList(int nums[]) {
		ListNode head = new ListNode();
		ListNode tmp = new ListNode();
		ListNode prev = new ListNode();
		tmp.val = nums[0];
		head = tmp;
		prev = tmp;
		for (int i = 1; i < nums.length; i++) {
			tmp = new ListNode();
			tmp.val = nums[i];
			prev.next = tmp;
			prev = tmp;
		}
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { 
		this.val = val; 
	}
	ListNode(int val, ListNode next) { 
		this.val = val; this.next = next; 
	}
}
