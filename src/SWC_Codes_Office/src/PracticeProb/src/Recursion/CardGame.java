package PracticeProb.src.Recursion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


//Working
public class CardGame {

	static int temp = 1;
	static int count = 0;
	public static void main(String[] args) throws FileNotFoundException {
		 Scanner sc = new Scanner(new FileInputStream("CardGame.txt"));
	        int T=sc.nextInt();
	        for(int t=1;t<=T;t++) {
	        	 count = 0;
	        	 temp = 0;
	        	int num = sc.nextInt();
	        	int temp = calculateSum(num);
	        	System.out.println(temp);
	        }
	}

	private static int calculateSum(Integer num) {
		if(num.toString().length() == 1 ) {
			if(temp<count)
			temp = count;
			count--;
			return temp;
		}
		int div = 10;
		for(int i=1; i<=Integer.toString(num).length(); i++){
			count++;
			div = (int) Math.pow(10, i);
			int a = num % div;
			int b = num/div;
			calculateSum(a*b);
		}
		count--;
		return temp;
	}

}
