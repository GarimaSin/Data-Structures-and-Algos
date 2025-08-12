package Advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TwoButtons {

	static int src;
	static int dest;
	static int min;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("TwoButtons.txt"));
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
        	min = Integer.MAX_VALUE;
        	src = sc.nextInt();
        	dest = sc.nextInt();
        	
        	if(dest < src){
        		min = src - dest;
        	} 
        	else
        		findMinimum(0, src, 0);
    		System.out.println(min + "   ");
        }
	}
	
	private static void findMinimum(int count, int tot, int start) {
		if(tot == dest) {
			if(min > count)
				min = count;
			return;
		}
		
		if(tot <= 0)
			return;
		if(tot > (2*dest))
			return;
		
		for(int i=0; i<2; i++){
			boolean isProduct = false;
			if(i==0){
				tot = tot -1;
			} else {
				isProduct = true;
				tot = tot * 2;
			}
			findMinimum(count+1, tot, i);
			if(isProduct)
				tot = tot/2;
			else
				tot = tot+1;
		}
	}

}
