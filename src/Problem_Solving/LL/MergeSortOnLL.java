package Problem_Solving.LL;

public class MergeSortOnLL {
	node head = null; 
	node tail = null;

	static class node { 
		int val; 
		node next; 

		public node(int val) {
			this.val = val; 
		} 
	} 


	node mergeTwoSortedLists(node one, node two) {
		MergeSortOnLL sortedlist = new MergeSortOnLL();			//create a new sorted list
		if (one == null) 
			return two; 
		if (two == null) 
			return one; 

		while (one != null && two != null) {
			if (one.val < two.val) {
				sortedlist.append(one.val);
				one = one.next;
			} else if (one.val > two.val) {
				sortedlist.append(two.val);
				two = two.next;
			} else {
				sortedlist.append(one.val);			//For union (to remove duplicates), append the value in o/p list only once
				one = one.next;
				two = two.next;
			}
		}

		while (one != null) {
			sortedlist.append(one.val);
			one = one.next;
		}

		while (two != null) {
			sortedlist.append(two.val);
			two = two.next;
		}
		return sortedlist.head; 
	} 

	node mergeSort(node head, node tail) {
		if (head == tail) { 
			MergeSortOnLL list = new MergeSortOnLL();
			node tmp = new node(head.val);
			list.append(tmp.val);
			list.head = tmp;
			return tmp; 
		} 

		// get the middle of the list 
		node mid = getMiddleOfLL(head, tail); 


		// Apply mergeSort on left and right lists 
		node left = mergeSort(head, mid); 		
		node right = mergeSort(mid.next, tail); 						// call merge on left and right, and not on head or tail

		node sortedlist = mergeTwoSortedLists(left, right); 		// Faith = if we get left and right lists sorted, we can get the sorted list by merging both (Pepcoding) 
		return sortedlist; 
	} 

	public static node getMiddleOfLL(node head, node tail) {
		if (head == null) 
			return head; 

		node slow = head, fast = head; 

		while (fast != tail && fast.next != tail) { 				/** && not ||,         Also fast != tail (and not fast.next != null)	**/
			slow = slow.next; 
			fast = fast.next.next; 
		} 
		return slow; 
	} 

	void append(int new_data) {
		node new_node = new node(new_data); 
		if(head == null) {
			head = new_node;
			tail = new_node;
			new_node.next = null;
			return;
		}
		tail.next = new_node; 
		tail = new_node;
		new_node.next = null;
	}

	void printList(node headref) {
		while (headref != null) { 
			System.out.print(headref.val + " "); 
			headref = headref.next; 
		} 
	} 

	public static void main(String[] args) {
		MergeSortOnLL linkedlist = new MergeSortOnLL(); 
		linkedlist.append(10); 
		linkedlist.append(15);
		linkedlist.append(4); 
		linkedlist.append(20); 
		//		linkedlist.append(3); 
		//		linkedlist.append(2); 


		MergeSortOnLL linkedlist2 = new MergeSortOnLL(); 	//For union of 2 lists
		linkedlist2.append(10); 
		linkedlist2.append(2);
		linkedlist2.append(4);
		linkedlist2.append(8); 

		linkedlist.tail.next = linkedlist2.head;
		linkedlist.tail = linkedlist2.tail;
		linkedlist.tail.next = null;

		// Apply merge Sort 
		System.out.print("Original Linked List : \n"); 
		linkedlist.printList(linkedlist.head); 
		System.out.println("\n" + linkedlist.tail.val);

		linkedlist.head = linkedlist.mergeSort(linkedlist.head, linkedlist.tail); 
		System.out.print("\nSorted Linked List is: \n"); 
		linkedlist.printList(linkedlist.head); 
	} 
}