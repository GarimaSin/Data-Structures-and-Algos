/**
 * Created by Dev Computer on 9/15/2015.
 */
public class myStack {
    static int top = -1;
    static int capacity = 5;
    static int currentSize = 0;
    static int[] arr = new int[capacity];

    public void push(int item){
        if(top+1 == capacity)
            increaseSize();
        top++;
        arr[top] = item;
        currentSize++;
    }

    private void increaseSize() {
        System.out.println("Increasing Size");
        int size = capacity*2;
        int temp[] = new int[size];
        for(int i=0; i<=top; i++){
            temp[i] = arr[i];
        }
        capacity = size;
        arr = temp;
    }

    public int pop(){
        if(currentSize == 0) {
            System.out.println("Underflow..");
            return -999999;
        }
        int element = arr[top];
        top--;
        currentSize--;
        return element;
    }

    public boolean isEmpty(){
        if(currentSize == 0)
            return true;
        return false;
    }

    public static void main(String a[]){
        myStack ds = new myStack();
        ds.push(2);
        ds.push(5);
        ds.push(7);
        ds.push(1);
        ds.push(6);
        ds.push(8);
        ds.push(0);
        ds.printStack();
        ds.pop();
        ds.printStack();
        ds.push(21);
        ds.printStack();
        ds.pop();
        ds.printStack();
        ds.pop();
        ds.pop();
        ds.pop();
        ds.pop();
        ds.pop();
        ds.pop();
        ds.printStack();
        ds.pop();
    }

    private void printStack() {
        for(int i=0; i<currentSize; i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println("...");
    }
  }
