package DataStructures.Udemy.LinkedList;

import DataStructures.Udemy.Node.DoubleNode;
/**
 *  1) Location here (for insertion/deletion) starts with 0
 *  2) (index < location - 1) loop will iterate from 0 to location-2 TIMES but ideally we need to stop at position = location-1
 *  	The loop (index < location-1) will stop at location-1 coz even if the loop iterates for location-2 times only
 *  	we have already iterated once, currentNode = head, b4 the iteration starts. 
 *  	Hence tot. no. of iterations = 1 (currentNode = head part, which comes b4 iteration starts) + (location-2) = location -1.
 *  3)  To insert at end 	-> location = size
 *  4)  To delete from last -> location = size-1 
 */

/** 
 * Points:
 * 1)	createSingleLinkedList - ensures that if we are inserting at 0, we wouldn't encounter a case where we wont have 
 * 		any node (checked thru existsLinkedList), if so then 1st create a LL.
 * 2)	To insert/delete at position:  ---  while (index < location - 1) 
 * 3) 	To delete the last node				while (index < size - 2) 		 since doesn't start from '0'
 * 4)   After deletion, check if this was the only node = size of list, NOW = 0
 * 5)	Traverse in reverse order
 * 
 * 6) 	All locations here (used in insertion/deletion) start from '0'.
 * 
 * **/
public class DoubleLinkedList {
	DoubleNode head;
	DoubleNode tail;
	int size;//denotes size of list
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	DoubleNode createDoubleLinkedList(int nodeValue) {
		head = new DoubleNode();
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		node.setNext(null);				
		node.setPrev(null);
		head = node;
		tail = node;
		size=1;// size =1
		return head;
	}
	
	
	
	void insertInLinkedList(int nodeValue, int location) {
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return; // Linked List does not exists
		} else if (location == 0) {// insert at first position
			node.setNext(head);
			node.setPrev(null);
			head.setPrev(node);
			head = node;
		} else if (location >= size) {// insert at last position
			node.setNext(null);
			tail.setNext(node);
			node.setPrev(tail);
			tail = node; // to keep track of last node
		} else {// insert at specified location
			DoubleNode tempNode = head;
			int index = 0;
			while (index < location - 1) {// loop till we reach specified node
				tempNode = tempNode.getNext();
				
				index++;
			}
			node.setPrev(tempNode);
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
			node.getNext().setPrev(node);
		}
		size++;
	}
	
	
	public boolean existsLinkedList() {
		//if head is not null return true otherwise return false
		return head!=null;
	}
	
	
	
	//Traverse the linked list from head to last
	void traverseLinkedList() {
		if(existsLinkedList()) {
			//System.out.println("Linked List now: ");
			DoubleNode tempNode=head;
			for(int i =0; i<size;i++) {
				
				System.out.print(tempNode.getValue());
				if(i!=size-1) {
					System.out.print(" -> ");
				}
				tempNode=tempNode.getNext();
			}
		}else {
			System.out.println("Linked List does not exists");
		}
		System.out.println("\n");
	}
	
	
	// Traverse the linked list from head to last
	void traverseLinkedListInReverseOrder() {
		if (existsLinkedList()) {
			DoubleNode tempNode = tail;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.getValue());
				if (i != size-1) {
					System.out.print(" <- ");
				}
				tempNode = tempNode.getPrev();
			}
		} else {
			System.out.println("Linked List does not exists");
		}
		System.out.println("\n");
	}
	
	//delete whole linked list
	void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		DoubleNode tempNode = head;
		for (int i = 0; i < size; i++) {
			tempNode.setPrev(null);
			tempNode = tempNode.getNext();
		}
		
		head = null;
		tail = null;
		System.out.println("Linked List deleted successfully !");
	 }
	
	
	//Search for a node in linked list 
	boolean searchNode(int nodeValue) {
		if(existsLinkedList()) {
			DoubleNode tempNode=head;
			for(int i =0; i<size;i++) {
				if(tempNode.getValue()==nodeValue) {
					System.out.print("Found the node at locaiton: " + i);
					return true;
				}
				tempNode=tempNode.getNext();
			}
		}
		System.out.print("Node not found!! ");
		return false;
	}
	
	
	// Deletes a node having a given value
	public void deletionOfNode(int location) {
		if(location >= getSize() || location < 0) {
			System.out.println("Index greater than list size, hence cannot delete item from "+location);
			return;
		}
		if (getSize() == 1) { // if this is the only node in this list
			head = tail = null;
			setSize(getSize() - 1);
			return;
		}
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");// Linked List does not exists
			return;
		} else if (location == 0) { // we want to delete first element
			head = head.getNext();
			head.setPrev(null);
			setSize(getSize() - 1);
		} else if (location == getSize()-1) { // If location is not in range or equal, then delete last node
			DoubleNode tempNode = tail.getPrev(); // temp node points to 2nd last node
			/*
			 * if (tempNode == head) { // if this is the only element in the list tail =
			 * head = null; setSize(getSize() - 1); return; }
			 */
			tempNode.setNext(null);
			tail = tempNode;
			setSize(getSize() - 1);

		} else { // if any inside node is to be deleted
			DoubleNode tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the location
			}
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			tempNode.getNext().setPrev(tempNode);
			setSize(getSize() - 1);
		} // end of else

	}// end of method

}//end of class
