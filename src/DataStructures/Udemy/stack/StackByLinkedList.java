package DataStructures.Udemy.stack;

import DataStructures.Udemy.LinkedList.SingleLinkedList;

/**
 * 
 * To implement Stack from LL, its better to insert at beginning (head) and remove from head
 * that way the complexity will be less (as in pop() we have to traverse till end of the list)
 *
 */
public class StackByLinkedList {

	SingleLinkedList list;

	
	//constructor
	public  StackByLinkedList() {
		list = new SingleLinkedList();
	}//end of method

	
	public void push(int value) {
		if(list.getHead()== null) {
			list.createSingleLinkedList(value);
		}else {
			list.insertInLinkedList(value, list.getSize());	
		}
		System.out.println("Inserted " + value + " in Stack !");
	}//end of method

	
	public int pop() {
		int value = -1;
		if (isEmpty()) {
			System.out.println("Stack underflow error!!");
		} else {
			value = list.getTail().getValue();
			list.deletionOfNode(list.getSize());
		}
		return value;
	}// end of method

	
	public boolean isEmpty() {
		if (list.getHead() == null)
			return true;
		else
			return false;
	}// end of method

	
	public int peek() {
		if (!isEmpty())
			return list.getTail().getValue();
		else {
			System.out.println("The stack is empty!!");
			return -1;
		}
	}// end of method
	

	public void deleteStack() {
		list.setHead(null);
	}//end of method
	
}//end of method
