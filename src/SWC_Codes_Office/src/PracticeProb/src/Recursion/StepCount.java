package PracticeProb.src.Recursion;

//Working
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StepCount {

	static int count = 0;
	static String result = "";
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("StepCount.txt"));
		int T = sc.nextInt();
		for(int t=0; t<T; t++){
			int num = sc.nextInt();
			count = 0;
			result = "";
			reduceToOne(num);
			System.out.println(count+" "+result);
		}
	}

	private static int reduceToOne(int num) {
		if(num==1){
			return count;
		}
		if(num%3 == 0){
			num = num/3;
			count++;
			result = result+"?";
			reduceToOne(num);
		} else if(num%2 == 0){
			num = num/2;
			count++;
			result = result+"@";
			reduceToOne(num);
		} else {
			num = num-1;
			count++;
			result = result+"$";
			reduceToOne(num);
		}
		
		return count;
	}

}
