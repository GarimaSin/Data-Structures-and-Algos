package test.src.test;

import java.util.Scanner;

public class greatestSumInArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		for(int T=1; T <=cases; T++){
			int size = sc.nextInt();
			int A[] = new int[size];
			int newsum=A[0];
		    int max=A[0];
		    for(int i=0; i<size; i++){
		    	A[i] = sc.nextInt();
		    }
		    for(int j=1; j<=size; j++){
	           newsum=Math.max(newsum+A[j],A[j]);
	           max= Math.max(max, newsum);
	        }
			System.out.println(max);
		}
	}
}