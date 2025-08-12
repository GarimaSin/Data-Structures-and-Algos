package DataStructures.Udemy.Queue.Array.CircularQueue;

/**
 * 
 * Checkout Line nos. - 31, 73
 *
 */
public class CircularQueueByArray{
	
	int[] arr;
	int rear;
	int size;
	int front;

	
	public CircularQueueByArray(int size) {
		this.arr = new int[size];
		this.size = size;
		this.rear = -1;
		front = -1;
		System.out.println("Successfully created an empty queue of size: "+size);
	}//end of method


	public void enQueue(int value) {
		if(arr==null) {
			System.out.println("Array is not yet created. Please create one first.");
		}else if (isQueueFull()) {
			System.out.println("\nQueue overflow error!!");
		}else {
			initializefrontOfArray();				/** Imp. **/
			if (rear+1 == size) { //if top is already at last cell of array, then reset it to first cell
				rear=0;
			}else {
				rear++;
			}
			arr[rear] = value;
			System.out.println("\nSuccessfully inserted "+value+" in the queue");
		}
	}//end of method

	
	public void initializefrontOfArray() {
		if (front == -1) { 
			front = 0;
		}
	}//end of method
	
	
	public void deQueue() {
		if (isQueueEmpty()) {
			System.out.println("Queue underflow error!!");
		} else {
			System.out.println("\n---------------------------------------------");
			System.out.println("Before Dequeue..");printArray();
			System.out.println("\nDequeing value from Queue...");
			System.out.println("Dequeued: "+arr[front]+" from queue");
			arr[front] = 0; //initialize the unused cell to 0
			if (front == rear) { //if there is only 1 element in Queue
				front = rear = -1;
			}else if (front+1 == size) { //if front has reached end of array, then front again from 0
				front=0;
			}else {
				front++;
			}
		}
		System.out.println("After Dequeue..");printArray();
		System.out.println("---------------------------------------------");
	}//end of method

	
	public boolean isQueueEmpty() {
		if (rear == -1)				/** Imp. **/
			return true;
		else
			return false;
	}//end of method

	
	public boolean isQueueFull() {
		if (rear+1 == front) { //If we have completed a circle, then we can say that Queue is full
			return true;
		}else if ((front==0) && (rear+1 == size)) { //Trivial case of Queue being full
			return true;
		}else {
			return false;
		}
	}//end of method

	
	public void peekOperation() {
		//if stack is not empty, return the value on top of stack
		if (!isQueueEmpty()) {
			System.out.println("\nPeeking value from queue...");
			System.out.println(arr[front]); 
		}else {
			System.out.println("The queue is empty!!");
		}
	}//end of method

	
	public void deleteStack() {
		System.out.println("\n\nDeleting the entire Queue...");
		arr = null;
		System.out.println("Queue is successfully deleted !");
	}//end of method
	
	
	//Print entire array
	public void printArray() {
		System.out.println("Array now...");
		for(int i=0; i<size; i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println("\nfront = " + front);
		System.out.println("End = "+ rear);
	}//end of method

}//end of class
