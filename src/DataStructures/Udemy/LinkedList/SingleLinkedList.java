package DataStructures.Udemy.LinkedList;

import DataStructures.Udemy.Node.SingleNode;
/**
 *  1) Location here (for insertion/deletion) starts with 0
 *  2) (index < location - 1) loop will iterate from 0 to location-2 TIMES but ideally we need to stop at position = location-1
 *  	The loop (index < location-1) will stop at location-1 coz even if the loop iterates for location-2 times only
 *  	we have already iterated once, currentNode = head, b4 the iteration starts. 
 *  	Hence tot. no. of iterations = 1 (currentNode = head part, which comes b4 iteration starts) + (location-2) = location -1.
 *  3)  To insert at end 	-> location = size
 *  4)  To delete from last -> location = size-1 
 *  
 *  5)  TO REPRESENT A LIST AS A WHOLE, WE HAVE TO TAKE AN OBJ OF SINGLENODE = HEAD, coz that will have rfrnc to the whole list 
 */


/** 
 * Points:
 * 1)	createSingleLinkedList - ensures that if we are inserting at 0, we wouldn't encounter a case where we wont have 
 * 		any node (checked thru existsLinkedList), if so then 1st create a LL.
 * 2)	To insert/delete at position:  ---  while (index < location - 1) 
 * 3) 	To delete the last node				while (index < size - 2) 		 since doesn't start from '0'
 * 4)   After deletion, check if this was the only node = size of list, NOW size = 0
 * 
 * 5) 	All locations here (used in insertion/deletion) start from '0'. Hence insert at 0, means insert at start and insert at 
 * 		1 means insert at 2nd pos.
 * 
 * **/

public class SingleLinkedList {
	private SingleNode head;
	private SingleNode tail;
	private int size;// denotes size of list


	public SingleNode createSingleLinkedList(int nodeValue) {
		head = new SingleNode();
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		node.setNext(null);
		head = node;
		tail = node;
		size = 1;// size =1
		return head;
	}

	public SingleNode getHead() {
		return head;
	}

	public void setHead(SingleNode head) {
		this.head = head;
	}

	public SingleNode getTail() {
		return tail;
	}

	public void setTail(SingleNode tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/** here, location starts from 0 **/
	public void insertInLinkedList(int nodeValue, int location) {
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		if (!existsLinkedList()) { // Linked List does not exists
			System.out.println("The linked list does not exist, creating list!!");
			createSingleLinkedList(nodeValue);
			return; 
		} else if (location == 0) {// insert at first position
			node.setNext(head);
			head = node;
		} else if (location >= size) {// insert at last position
			node.setNext(null);
			tail.setNext(node);
			tail = node; 
		} else {// insert at specified location
			SingleNode tempNode = head;
			int index = 0;
			while (index < location - 1) {						// TODO - MIND IT
				tempNode = tempNode.getNext();
				index++;
			}//tempNode currently references to node after which we should insert new node
			SingleNode nextNode = tempNode.getNext(); //this is the immediate next node after new node
			tempNode.setNext(node);//update reference of tempNode to reference to new node
			node.setNext(nextNode);//update newly added nodes' next.
		}
		setSize(getSize()+1);
	}

	public void append(int nodeValue) {
		 insertInLinkedList(nodeValue, getSize());
	}

	public boolean existsLinkedList() {
		return head != null;				/** not tail **/
	}


	//Traverses Linked List
	public void traverseLinkedList() {
		if (existsLinkedList()) {
			SingleNode tempNode = head;
			for (int i = 0; i < getSize(); i++) {
				System.out.print(tempNode.getValue());
				if (i != getSize() - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		}else {
			System.out.println("Linked List does not exists !");
		}
		System.out.println("\n");
	}


	//Deletes entire Linked List
	void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		head = null;
		tail = null;
		System.out.println("Linked List deleted successfully !");
	}


	//Searches a node with given value
	boolean searchNode(int nodeValue) {
		if (existsLinkedList()) {
			SingleNode tempNode = head;
			for (int i = 0; i < getSize(); i++) {
				if (tempNode.getValue() == nodeValue) {
					System.out.print("Found the node at location: "+i+"\n");
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.print("Node not found!! \n");
		return false;
	}

	public void deleteNodeMine(int location) {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");// Linked List does not exists
			return;
		}
		if(location > getSize()-1) {
			System.out.println("Index greater than list size, hence cannot delete item from "+location);
			return;
		}
		if(location < 0) {
			System.out.println("Index less than list size, hence cannot delete item from "+location);
			return;
		}
		if(getSize() == 1) { // if there are no more nodes in this list
			head = tail = null;
			setSize(getSize()-1);
			return;
		}
		if (location == 0) { 		// we want to delete first element
			head = head.getNext();
			setSize(getSize()-1);
		} else { 					// else last node or any node in b/w
			SingleNode tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); 
			}
			if(location == size-1) {		// if last node
				tempNode.setNext(null); 
				tail= tempNode;
				setSize(getSize()-1);
			}
			else { 						//if any inside node is to be deleted
				tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
				setSize(getSize()-1);
			}
		}
	}


	//Deletes a node having a given value
	public void deletionOfNode(int location) {
		if(location > getSize()) {
			System.out.println("Index greater than list size, hence cannot delete item from "+location);
			return;
		}
		if(getSize() == 1) { // if there are no more nodes in this list
			head = tail = null;
			setSize(getSize()-1);
			return;
		}
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");// Linked List does not exists
			return;
		} else if (location == 0) { // we want to delete first element
			head = head.getNext();
			setSize(getSize()-1);
		}else if (location == getSize()){ //If location is not in range or equal, then delete last node
			SingleNode tempNode = head;
			for (int i = 0; i < size - 2; i++) {
				tempNode = tempNode.getNext(); 
			}
			tempNode.setNext(null); 
			tail= tempNode;
			setSize(getSize()-1);

		}else { //if any inside node is to be deleted
			SingleNode tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the location
			}	
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			setSize(getSize()-1);
		}//end of else	

	}//end of method
	
	//Sort LL
	public void sortList() {  
        //Node current will point to head  
		SingleNode current = head, index = null;  
        int temp;  
          
        if(head == null) {  
            return;  
        }  
        else {  
            while(current != null) {  
                //Node index will point to node next to current  
                index = current.getNext();  
                  
                while(index != null) {  
                    //If current node's data is greater than index's node data, swap the data between them  
                    if(current.getValue() > index.getValue()) {  
                        temp = current.getValue();  
                        current.setValue(index.getValue());  
                        index.setValue(temp);  
                    }  
                    index = index.getNext();  
                }  
                current = current.getNext();  
            }      
        }  
    }  

}// end of class


