package SWC_Codes_Office.src.MyCodes;

public class Queu{
    int front;
    int rear;
    int capacity;
    int size;
    Node []arr;
    Queu(int capacity){
    	
    	// Very Imp. to initialize all static members with 0.
        this.capacity=capacity;
        arr = new Node[this.capacity];
        this.rear=-1;
        this.front=0;
        this.size=0;
    }
    public boolean isFull(){
        return (this.size==this.capacity);
    }
    public boolean isEmpty(){
        return (this.size==0);
    }
    public void enQueue(Node node){
        if(!isFull()){
            this.rear=(this.rear+1)%this.capacity;
            arr[rear]=node;
            this.size++;
        }else{
            System.out.println("overflow");
        }
    }
    public Node deQueue(){
        if(!isEmpty()){
            Node node=arr[this.front];
            arr[this.front]=null;
            front=(front+1)%this.capacity;
            this.size--;
            return node;
        }else{
            System.out.println("Underflow");
            return null;
        }
    }
}