package test.src.Advanced;

import java.io.FileInputStream;
import java.util.Scanner;

public class paintG_Alt {
	static int nodes = 0;
	static int edges = 0;
	static int grp[][];
	static int temp[];
	static int temp2[];
	static boolean[] visited;
	public static void main(String a[]) throws Exception{
		 Scanner sc = new Scanner(new FileInputStream("paint.txt"));
	        int T=sc.nextInt();
	        for(int t=1;t<=T;t++) {
	        	nodes = sc.nextInt();
	        	edges = sc.nextInt();
	        	grp = new int[nodes+1][edges+1];
	        	int count = edges * 2;
	        	temp = new int[count];
	        	temp2 = new int[nodes+1];
	        	visited = new boolean[edges];
	        	int c = 0;
	        	intialize();
	        	for(int i=0; i<edges; i++){
	        		int t1 = sc.nextInt();
	        		int t2 = sc.nextInt();
	        		if(t1 < t2){
	        			if(c > count)
	        				throw new Exception();
	        			grp[t1][temp2[t1]] = t1;
	        			temp[c] = t1;
	        			c++;
	        			grp[t1][temp2[t1]+1] = t2;
	        			temp[c] = t2;
	        			c++;
	        			temp2[t1] = temp2[t1]+2;
	        		} else {
	        			if(c > count)
	        				throw new Exception();
	        			grp[t2][temp2[t2]] = t2;
	        			temp[c] = t2;
	        			c++;
	        			grp[t2][temp2[t2]+1] = t1;
	        			temp[c] = t1;
	        			c++;
	        			temp2[t2] = temp2[t2]+2;
	        		}
	        	}
	        	System.out.println("....");
	        	printGrp();
	        	c = 0;
	        	int i = 0;
	        	while(i<count){
	        		int j = 0;
	        		int fir = temp[i];
	        		int sec = temp[i+1];
	        		if(fir > sec) {
	        			int tt = fir;
	        			fir = sec;
	        			sec = tt;
	        		}
	        		
        			if(grp[i][j] != -1 && !visited[i]){
//	        				temp[c] = grp[i][j+1];
        				fill(j);
        			}
        			j++;
	        	}
	        }
		}
	
	private static void fill(int pos) {
		
	}
	private static void intialize() {
		for(int i=0; i<nodes+1; i++){
			for(int j=0; j<edges+1; j++){
				grp[i][j] = -1;
			}
			temp[i] = -1;
//			temp2[i] = 1;
		}
	}
	
	private static void printGrp() {
		for(int i=0; i<nodes+1; i++){
			for(int j=0; j<edges+1; j++){
				System.out.print(grp[i][j]+"   ");
			}
			System.out.println("");
		}
	}

}
