package SWC_Codes_Office.src.MyCodes;


//Working

import java.io.FileInputStream;
import java.util.Scanner;

public class GridAcid {

	static int grid[][];
    static Qu q = new Qu(20);
    static boolean flag = false;
    static boolean empty = false;
    static int cc=0;
    static int r =0;
    static int c =0;
    static int emptyX = 0;
    static int emptyY = 0;
    static int count = 0;
    static int emptyCount = -1;
    
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("GridAcid.txt"));
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
        	r = sc.nextInt();
            c = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            grid = new int[r][c];
            cc =1; flag = false; empty = false;
            emptyX = 0; emptyY = 0;
            count = 0; emptyCount = -1;
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                	int temp = sc.nextInt();
                	if(temp == 2){
                		grid[i][j]=-2;
                		emptyX = i;
                		emptyY = j;
                	}
                	grid[i][j] = temp;
                }
            }
            x--;y--;
            Cell n = new Cell(x,y,2);
            getTime(n);
            flag = true;
            while(!q.isEmpty()){
                Cell n2 = q.dqu();
                getTime(n2);
            }
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                	if(grid[i][j] == 1){
                		cc = -1;
                		break;
                	}
                }
                if(cc == -1)
            		break;
            }
            System.out.println("Case #"+(test_case+1));
            System.out.println(emptyCount+" "+cc);
        }
	}

    private static void getTime(Cell n1) {

        Cell n;
        int temp = 0;
        if(flag == false) {
            temp = 2;
            fillEmpty(n1.x, n1.y);
            grid[n1.x][n1.y] = -1;
        }

        if(isSafe((n1.x)+1, n1.y) ) {
            if(flag == true)
                temp = n1.level+1;
            n = new Cell((n1.x)+1, n1.y, temp);
            grid[(n1.x)+1][n1.y] = temp;
            q.enq(n);
        }
        if(isSafe(n1.x,(n1.y)+1) ) {
            if(flag == true)
                temp = n1.level+1;
            n = new Cell(n1.x, (n1.y)+1, temp);
            grid[n1.x][(n1.y)+1] = temp;
            q.enq(n);
        }
        if(isSafe((n1.x)-1,n1.y)) {
            if(flag == true)
                temp = n1.level+1;
            grid[(n1.x)-1][n1.y] = temp;
            n = new Cell((n1.x) - 1, n1.y, temp);
            q.enq(n);
        }
        if(isSafe(n1.x,(n1.y)-1) ) {
            if(flag == true)
                temp = n1.level+1;
            grid[n1.x][(n1.y)-1] = temp;
            n = new Cell(n1.x, (n1.y) - 1, temp);
            q.enq(n);
        }
        if(cc < temp)
            cc = temp;
        if(count == 4 && empty == false){
        	empty = true;
        	emptyCount = temp;
        }
        return;
    }

    private static boolean isSafe(int x, int y) {
        if(x>=0 && x<r && y>=0 && y<c && grid[x][y] == 1){
        	fillEmpty(x,y);
            return true;
        }
        return false;
    }

	private static void fillEmpty(int x, int y) {
		if(x == emptyX-1 && y == emptyY)
    		count++;
    	else if(x == emptyX+1 && y == emptyY)
			count++;
    	else if(x == emptyX && y == emptyY+1)
			count++;
    	else if(x == emptyX && y == emptyY-1)
			count++;
	}
}

class Cell{
    int x;
    int y;
    int level;
    Cell(int x,int y,int level){
        this.x=x;
        this.y=y;
        this.level=level;
    }
}

class Qu{
	static int front =0;
	static int rear = 0;
	static int capacity = 10;
	static int cuSize = 0;
	static Cell[] c = new Cell[capacity]; 
	Qu(int cap){
		
		// Very Imp. to initialize all static members with 0.
		capacity = cap;
		c = new Cell[cap];
		front = 0;
		rear = 0;
		cuSize = 0;
	}
	
	public boolean isEmpty(){
        return (cuSize==0);
    }
	
	void enq(Cell c1){
		if(rear == capacity) {
			increaseCap();
		}
		c[rear] = c1;
		rear++;
		cuSize++;
	}
	
	private void increaseCap() {
		int tempSize = capacity*2;
		Cell temp[] = new Cell[tempSize];
		for(int i=0; i<capacity; i++){
			temp[i] = c[i];
		}
		c = temp;
		temp = null;
		capacity = tempSize;
	}

	Cell dqu() throws Exception{
		if(cuSize == 0)
			throw new Exception();
		Cell c2 = c[front];
		front++;
		cuSize--;
		return c2;
	}
}