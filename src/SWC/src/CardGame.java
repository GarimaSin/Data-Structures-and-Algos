package Samsung_SWC.src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CardGame {

	static int temp = 0;
	static int count = 0;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("CardGame.txt"));
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
        	int num = sc.nextInt();
        	count =0;
        	int ans = calculateSteps(num);
        	System.out.println(ans);
        }
	}
	
	private static int calculateSteps(Integer num) {
		int a =0, b=0;
		int div =10;
		if(num.toString().length() == 1) {
			if(temp < count)
				temp = count;
			count= count-1;
			return temp;
		}
		for(int i=1; i<num.toString().length(); i++){
			div = (int) Math.pow(10, i);
			count++;
			a = num/div;
			b = num%div;
			calculateSteps(a*b);
		}
		count--;
		return temp;
	}
}
