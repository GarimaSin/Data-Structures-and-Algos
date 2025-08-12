package MyCodes;

class queue {

	static int capacity = 10;
	static int front = 0;
	static int rear = 0;
	static int qu[];
	static int currentSize = 0;
	public queue(int capacty) {
		qu = new int[capacty];
		capacity = capacty;
	}

	/*public static void main(String[] args) {
		queue q = new queue(3);
		 q.enque(4);
	     q.deque();
	     printQueue();
	     q.enque(56);
	     printQueue();
	     q.enque(2);
	     printQueue();
	     q.enque(67);
	     printQueue();
	     q.deque();
	     printQueue();
	     q.enque(24);
	     printQueue();
	     q.enque(98);
	     printQueue();
	     q.deque();
	     printQueue();
	     q.deque();
	     printQueue();
	     q.deque();
	     printQueue();
	     q.enque(435);
	     printQueue();
	     q.deque();
	     printQueue();
	     q.deque();
	     printQueue();
	     q.deque();
	}*/

	private int deque() {
		if(currentSize==0)
			return -99999999;
		int temp = qu[front];
		front++;
		currentSize--;
		return temp;
	}


	private void enque(int i) {
		if(rear == capacity){		/// Compare rear with capacity not currentSize as when we are dequeuing we are not removing elements
									/// from array, we are just moving the pointer, so the size may remain bigger.
			increaseCapacity();
		}
		qu[rear] = i;
		rear++;
		currentSize++;
	}

	public static void printQueue(){
		int temp = front;
    	for(int i=0; i<currentSize; i++){
    		System.out.print(qu[temp]+" ");
    		temp++;
    	}
    	System.out.println(".........");
    }

	private void increaseCapacity() {
		int tempSize = capacity*2;
		int temp[] = new int[tempSize];
		for(int i=0; i< capacity; i++){
			temp[i] = qu[i];
		}
		qu = temp;								// Check this
		temp = null;							// Check this
		capacity = tempSize;
	}
	
	private void increaseCapacity(int capacty) {
		int tempSize = capacity+capacty;
		int temp[] = new int[tempSize];
		for(int i=0; i< capacity; i++){
			temp[i] = qu[i];
		}
		qu = temp;								// Check this
		temp = null;							// Check this
		capacity = tempSize;
	}

}
