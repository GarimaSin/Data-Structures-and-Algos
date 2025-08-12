package SWC_Codes_Office.src.test.src.Advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class stringRotation {
	public static void main(String args[]) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileInputStream("rotation.txt"));
		int T=sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			int len = sc.nextInt();
			String s1 = sc.next();
			String s2 = sc.next();
			int answer = -1;
			String temp = s1+s1;
			if(temp.indexOf(s2) != -1) {
				answer = temp.indexOf(s2);
				System.out.println("Case #"+test_case);
				System.out.println(answer-1);
			} else {
				System.out.println("Case #"+test_case);
				System.out.println(-1);
			}
		}
	}

}
