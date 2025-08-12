package searches;

public class myStack {
	static private int capacity = 6;
    static int stackArr[] = new int[capacity];
    static int top = -1;
    static int currentSize = 0;

    
    public void push(int item) {
    	if(top+1 == capacity){
    		increaseSize();
    	}
    	top++;
    	stackArr[top] = item;
    	currentSize++;
//    	System.out.println("Element added");
    }
    
    private void increaseSize() {
    	int size = capacity*2;
    	int temp[] = new int[size];
    	for(int i=0; i<capacity; i++){
    		temp[i] = stackArr[i];
    	}
    	stackArr = temp;
    	capacity = size;
	}

	public int pop() {
		int element = stackArr[top];
    	if(top == -1)
    		System.out.println("No elements to remove");
    	else {
    		top--;
    		currentSize--;
//        	System.out.println("Element removed");
    	}
    	return element;
    }
    
    public void printStack(){
    	for(int i=0; i<=top; i++){
    		System.out.println(stackArr[i]);
    	}
//    	System.out.println("......"+top);
    }
    
    public boolean isEmpty(){
		if(currentSize == 0)
			return true;
		return false;
	}

    
    public static void main(String a[]){
//    	myStack ds = new myStack();
//    	ds.push(2);
//    	ds.push(5);
//    	ds.push(7);
//    	ds.push(1);
//    	ds.push(6);
//    	ds.push(8);
//    	ds.push(0);
//    	ds.printStack();
//    	ds.pop();
//    	ds.push(21);
//    	ds.printStack();
//    	ds.pop();
//    	ds.printStack();
//    	ds.pop();
//    	ds.pop();
//    	ds.pop();
//    	ds.pop();
//    	ds.pop();
//    	ds.pop();
//    	ds.printStack();
//    	ds.pop();
    }
    
}
