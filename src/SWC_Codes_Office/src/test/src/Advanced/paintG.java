package SWC_Codes_Office.src.test.src.Advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Grph{
	int edge[] = new int[2];
	boolean visited = false;
	Grph(int t1, int t2){
		edge[0] = t1;
		edge[1] = t2;
	}
}

public class paintG {

	static int nodes = 0;
	static int edges = 0;
	static int gr[][];
	static boolean visited[];
	static int color[];
 	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("paint.txt"));
        int T=sc.nextInt();
        for(int t=1;t<=T;t++) {
        	nodes = sc.nextInt();
        	edges = sc.nextInt();
        	gr = new int[nodes][nodes];
        	color = new int[nodes];
        	visited = new boolean[nodes];
        	for(int i=0; i<edges; i++){
        		int t1 = sc.nextInt();
        		int t2 = sc.nextInt();
        		if(t1 > t2){
        			int temp = t1;
        			t1 = t2;
        			t2 = temp;
        		}
        		gr[t1][t2] = 1;
        	}
        	
        	fillColor();
        }

	}
	private static void fillColor() {
		int arr[] = new int[edges];
		int len = 0;
		int num = 1;
		color[1] = 1;
		visited[num] = true;
		while(len == 0){
			for(int i=0; i<edges; i++){
				if(visited[num] != true && gr[1][i] == 1){
					len++;
//					arr[]
					color[i] = 0;
				}
			}
		}
	}

}