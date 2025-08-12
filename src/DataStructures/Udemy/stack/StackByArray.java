package DataStructures.Udemy.stack;

/**
 * 1)	initialize 	top = -1
 * 2)	isFullStack 	=> 	top == arr.length-1
 * 3)	isEmptyStack	=>  top == -1
 */
public class StackByArray {
	
	int[] arr;
	int top;

	
	public StackByArray(int size) {
		this.arr = new int[size];
		this.top = -1;
		System.out.println("Successfully created an empty Stack of Size: "+size);
	}

	
	public void push(int value) {
		//if array is full, show stack overflow error
		if (isFullStack()) {
			System.out.println("Stack overflow error!!");
		} else {
			top++;
			arr[top] = value;
			System.out.println("Successfully inserted " + value + " in the stack");
		}
	}//end of method
	
	
	public void pop() {
		//if array is empty, show stack underflow error		
		if (isEmptyStack()) {
			System.out.println("Stack underflow error!!");
		} else {
			System.out.println("Poping value from Stack: " + arr[top] + "...");
			top--;
		}
	}//end of method

	
	public boolean isEmptyStack() {
		//if top pointer is zero, the stack is empty
		if (top == -1)
			return true;
		else
			return false;
	}//end of method
	
	
	public boolean isFullStack() {
		if (top == arr.length-1) {
			System.out.println("Stack is full !");
			return true;
		}else {
			return false;
		}
	}//end of method
		

	public void peekOperation() {
		if (!isEmptyStack())
			System.out.println("Top of Stack: " + arr[top]);
		else {
			System.out.println("The stack is empty!!");
		}
		System.out.println();System.out.println();
	}//end of method

	
	public void deleteStack() {
		arr = null;
		System.out.println("Stack is successfully deleted");
	}//end of method

}//end of class
