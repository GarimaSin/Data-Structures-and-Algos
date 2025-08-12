package SWC_Codes_Office.src.test.src.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class magnetProblem {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("inp.txt"));

		for(int total=1; total<=10; total++){
			int Tcase = sc.nextInt();
			int[][] table = new int[Tcase][Tcase];
			for(int i=0; i<Tcase; i++){
				for(int j=0; j<Tcase; j++){
					int t = sc.nextInt();
					table[i][j] = t;
				}
			}

			int status = 0, still = 0;
			boolean found = false;
			for(int col=0; col<Tcase; col++){
				for(int row=0; row<Tcase; row++){
					int mag = table[row][col];
					if(mag == 1 && status != 2){
						if(found == false)
							found = true;
						status = 2;
					} else if(mag == 2 && found != false && status == 2){
						still++;
						status = 1;
					}
				}
				status = 0;
			}
			System.out.println("#"+total+" "+still);
		}
	}
}