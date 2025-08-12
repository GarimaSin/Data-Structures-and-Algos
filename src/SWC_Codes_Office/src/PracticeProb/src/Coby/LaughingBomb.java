package PracticeProb.src.Coby;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Node{
	int x;
	int y;
	int lavel;
	Node(int x,int y,int lavel){
		this.x=x;
		this.y=y;
		this.lavel=lavel;
	}
}
class Queue{
	int front;
	int rear;
	int capacity;
	int size;
	Node []arr;
	Queue(int capacity){
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
public class LaughingBomb {

	static int Answer;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("Laughingbomb.txt"));
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			int m=sc.nextInt();
			int n=sc.nextInt();
			int [][] arr = new int[n][m];

			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					arr[i][j]=sc.nextInt();
				}
			}
			
			int srcy=sc.nextInt()-1;
			int srcx=sc.nextInt()-1;

			Answer = foo(arr,new Node(srcx,srcy,1),n,m);
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);

		}

	}

	private static int foo(int[][] arr,Node src, int n, int m) {
		int ans=0;
		int dx[]={0,-1,0,1};
		int dy[]={1,0,-1,0};
		boolean vis[][] = new boolean[n][m];
		
		Queue queue = new Queue(n*m);
		queue.enQueue(src);
		vis[src.x][src.y]=true;
		
		while(!queue.isEmpty()){
			Node temp = queue.deQueue();
			if(ans<temp.lavel){
				ans=temp.lavel;
			}
			int x = temp.x;
			int y = temp.y;
			int newlavel=temp.lavel+1;
			
			for(int i=0;i<4;i++){
				int newx=x+dx[i];
				int newy=y+dy[i];
				if(isSafe(newx,newy,n,m)){
					if(arr[newx][newy]==1 && vis[newx][newy]==false){
						queue.enQueue(new Node(newx,newy,newlavel));
						vis[newx][newy]=true;
					}
				}
			}
		}
		return ans;
	}

	private static boolean isSafe(int x, int y, int n, int m) {
		if(x>=0 && x<n && y>=0 && y<m){
			return true;
		}
		return false;
	}
}

/*Case #1
8
Case #2
21*/


