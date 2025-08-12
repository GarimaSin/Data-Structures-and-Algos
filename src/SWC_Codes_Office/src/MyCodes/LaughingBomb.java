package SWC_Codes_Office.src.MyCodes;


//Working

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class LaughingBomb {

    static int city[][];
    static int r =0;
    static int c =0;
    static Queu q = new Queu(20);
    static boolean flag = false;
    static int cc=0;
    
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("Laughingbomb.txt"));
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            c = sc.nextInt();
            r = sc.nextInt();
            city = new int[r][c];
            cc =1;
            flag = false;
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    city[i][j]=sc.nextInt();
                }
            }
            int y = sc.nextInt();
            int x = sc.nextInt();
            x--;y--;
            Node n = new Node(x,y,2);
            getDestTime(n);
            flag = true;
//            printCity();
            while(!q.isEmpty()){
                Node n2 = q.deQueue();
                getDestTime(n2);
//                printCity();
            }
            System.out.println("Case #"+(test_case+1));
            System.out.println(cc);
        }
    }

	private static void getDestTime(Node n1) {
		
		Node n;
        int temp = 0;
        if(flag == false) {
            temp = 2;
            city[n1.x][n1.y] = -1;
        }
        
        if(isSafe((n1.x)+1, n1.y) ) {
        	if(flag == true)
        		temp = n1.level+1;
        	n = new Node((n1.x)+1, n1.y, temp);
            city[(n1.x)+1][n1.y] = temp;
            q.enQueue(n);
        }
        if(isSafe(n1.x,(n1.y)+1) ) {
        	if(flag == true)
        		temp = n1.level+1;
            n = new Node(n1.x, (n1.y)+1, temp);
            city[n1.x][(n1.y)+1] = temp;
            q.enQueue(n);
        }
        if(isSafe((n1.x)-1,n1.y)) {
        	if(flag == true)
        		temp = n1.level+1;
            city[(n1.x)-1][n1.y] = temp;
            n = new Node((n1.x) - 1, n1.y, temp);
            q.enQueue(n);
        }
        if(isSafe(n1.x,(n1.y)-1) ) {
        	if(flag == true)
        		temp = n1.level+1;
            city[n1.x][(n1.y)-1] = temp;
            n = new Node(n1.x, (n1.y) - 1, temp);
            q.enQueue(n);
        }
        if(cc < temp)
        	cc = temp;
        return;
    }

    private static boolean isSafe(int x, int y) {
        if(x>=0 && x<r && y>=0 && y<c && city[x][y] == 1)
            return true;
        return false;
    }
    
    private static void printCity() {
    	for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(city[i][j]+"     ");
            }
            System.out.println();
        }
    	System.out.println("..............");
	}
}

class Node{
    int x;
    int y;
    int level;
    Node(int x,int y,int level){
        this.x=x;
        this.y=y;
        this.level=level;
    }
}