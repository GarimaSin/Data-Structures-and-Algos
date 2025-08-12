package searches;

public class myQueue {
	static private int capacity = 2;
	static int queueArr[] = new int[capacity];
	static int front = 0;
	static int rear = -1;
	static int currentSize = 0;

    
    public void enqueue(int item) {
    	if(rear+1 == capacity){
    		increaseSize();
    	}
//    	System.out.println("Adding " + item);
    	rear++;
    	queueArr[rear] = item;
    	currentSize++;
    }
     
	private void increaseSize() {
//		System.out.println("Queue is full, increase capacity...");
		int size = capacity*2;
		int temp[] = new int[size];
		for(int i=0; i< capacity; i++){
			temp[i] = queueArr[i];
		}
		queueArr = temp;
		capacity = size;
	}
	
	public int dequeue() {
		int element = queueArr[front];
		if(currentSize == 0) {
//			System.out.println("Underflow ! Unable to remove element from Queue");
			return -99999999;
		}  
		else if(currentSize == queueArr.length){		//front and currentSize are at same position
			front = 0;
			currentSize = 0;
			rear = -1;
//			System.out.println("Element removed");
			return element;
		} else {
			front++;
			currentSize--;
//			System.out.println("Element removed");
			return element;
		}
	}
	
	public static void printQueue(){
		int temp = front;
    	for(int i=0; i<currentSize; i++){
    		System.out.print(queueArr[temp]+" ");
    		temp++;
    	}
//    	System.out.println(".........");
    }
	
	public boolean isEmpty(){
		if(currentSize == 0)
			return true;
		return false;
	}

//	public static void main(String[] args) {
//		myQueue queue = new myQueue();
//        queue.enqueue(4);
////        printQueue();
//        queue.dequeue();
//        printQueue();
//        queue.enqueue(56);
//        printQueue();
//        queue.enqueue(2);
//        printQueue();
//        queue.enqueue(67);
//        printQueue();
//        queue.dequeue();
//        printQueue();
//        queue.enqueue(24);
//        printQueue();
//        queue.enqueue(98);
//        printQueue();
//        queue.dequeue();
//        printQueue();
//        queue.dequeue();
//        printQueue();
//        queue.dequeue();
//        printQueue();
//        queue.enqueue(435);
//        printQueue();
//        queue.dequeue();
//        printQueue();
//        queue.dequeue();
//        printQueue();
//        queue.dequeue();
//	}
}
