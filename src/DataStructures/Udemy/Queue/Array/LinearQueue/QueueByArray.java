package DataStructures.Udemy.Queue.Array.LinearQueue;

/**
 * Check out Lines - 67, 57 
 */
public class QueueByArray{
	
	int[] arr;
	int rear;
	int front;

	
	public QueueByArray(int size) {
		this.arr = new int[size];
		this.rear = -1;
		this.front = -1;
		System.out.println("Successfully created an empty queue of size: "+size);
	}//end of method


	public void enQueue(int value) {
		if (isQueueFull()) {
			System.out.println("Queue overflow error!!");
		}else if (isQueueEmpty()) { //If the queue is empty then we need to initialize beginning index 
			front=0;
			rear++;
			arr[rear] = value;
			System.out.println("Successfully inserted "+value+" in the queue");
		}else { //if the queue already has some elements in it then no need to initialize beginning index
			rear++;
			arr[rear] = value;
			System.out.println("Successfully inserted "+value+" in the queue");
		}
		printQueue();
	}//end of method
	
		
	public void printQueue() {
		if(!isQueueEmpty()) {
			System.out.println("Queue now ...");
			for(int i=front; i<=rear; i++) {
				System.out.println(arr[i] + "   ");
			}
			System.out.println();
		}else {
			System.out.println("Queue is empty !");
		}
	}
	
	public void deQueue() {
		if (isQueueEmpty()) {
			System.out.println("Queue underflow error!!");
		} else {
			System.out.println("Dequeing value from Queue...");
			System.out.println("Dequeued: "+arr[front]+" from queue");
			front++;
			if(front > rear) { //If last element in the Queue is Dequeued
				front = rear = -1;
			}
		}
		printQueue();
		System.out.println();
	}//end of method

	
	public boolean isQueueEmpty() {
		if ((front == -1) || (front == arr.length))
			return true;
		else
			return false;
	}//end of method

	
	public boolean isQueueFull() {
		if (rear == arr.length-1) {
			return true;
		}
		else {
			return false;
		}
			
	}//end of method

	
	public void peekOperation() {
		if (!isQueueEmpty()) {
			System.out.println(arr[front]); 
		}else {
			System.out.println("The queue is empty!!");
		}
	}//end of method

	
	public void deleteQueue() {
		arr = null;
		System.out.println("Queue is successfully deleted !");
	}//end of method

}//end of class
