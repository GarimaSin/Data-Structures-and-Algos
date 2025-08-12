package test.src.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class frogProb {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		int allowedHops=1;
		Scanner sc=new Scanner(new FileInputStream("frog.txt"));
        int T=sc.nextInt();
        System.out.println(T);
        for(int t=1;t<=T;t++) {
        	allowedHops=1;
        	int hopSize=sc.nextInt();
			int size=sc.nextInt();
			int[] arr = new int[size];
			for(int i=0;i<size;i++){
				arr[i] = sc.nextInt();
			}
			
			int startingPos = arr[0];
			Arrays.sort(arr);
			int index = Arrays.binarySearch(arr,startingPos);
			for(int i=index; i<size-1;i++){
				if(arr[i+1]-arr[i] <= hopSize){
					allowedHops++;
				} else
					break;
			}
			for(int i=index; i>0;i--){
				if(Math.abs(arr[i-1]-arr[i]) <= hopSize){
					allowedHops++;
				} else
					break;
			}
			System.out.println("#"+t+" "+allowedHops);
        }
	}
}