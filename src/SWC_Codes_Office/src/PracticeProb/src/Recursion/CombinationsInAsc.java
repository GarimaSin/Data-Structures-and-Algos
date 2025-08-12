package PracticeProb.src.Recursion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CombinationsInAsc {

	static int size = 0;
	static int[] num;
	static int ans[];
	static int resultSize = 6;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("AllCombinationsInAsc.txt"));
		int T = sc.nextInt();
		for(int t=0; t<T; t++){
			size = sc.nextInt();
			num = new int[size];
			ans = new int[size];
			for(int i=0; i<size; i++){
				num[i] = sc.nextInt();
			}
			getCombinations(0,0);
			printSolution(ans);
			System.out.println("...............");
		}
	}
	private static void getCombinations(int selected, int index) {
		if(selected == resultSize)
			printSolution(num);
		int out_left = size - selected;
		int in_left = resultSize - index;
		int end = index + in_left - out_left;
		for(int i=index; i<=resultSize; i++){
			ans[selected] = num[i];
			getCombinations(selected+1, i+1);
		}
				
	}
	private static void printSolution(int[] num2) {
		for(int i=0; i<resultSize; i++){
			System.out.print(ans[i]+" ");
		}
		System.out.println(" ");
	}

}
