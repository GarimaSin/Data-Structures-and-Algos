package PracticeProb.src.Recursion;

import java.util.Scanner;

public class TugOfWar {
	static int Answer;
	static int arr[];
	static boolean[] visitedArray;
	static int numCount = 0;
	static int min = 10000000;
	static int globalSum = 0;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		// Scanner sc = new Scanner(new FileInputStream("TugOfWar.txt"));

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {

			numCount = sc.nextInt();
			min = 10000000;
			arr = new int[numCount];
			visitedArray = new boolean[numCount];

			for (int i = 0; i < numCount; i++) {
				arr[i] = sc.nextInt();
				visitedArray[i] = false;
				globalSum = globalSum + arr[i];
			}

			getSolution(0);

			System.out.println("Case #" + (test_case + 1));
			System.out.println(min);
		}
	}

	private static void getSolution(int i) {

		int setCount = 0;
		for (int j = 0; j < numCount; j++) {
			if (visitedArray[j]) {
				setCount++;
			}
		}

		if (setCount == numCount / 2) {

			int set1 = 0;
			int set2 = 0;
			int diff = 0;

			for (int l = 0; l < numCount; l++) {
				if (visitedArray[l])
					set1 += arr[l];
				else
					set2 += arr[l];
			}

			diff = Math.abs(set2 - set1);
			if (diff < min) {
				min = diff;
			}
		}

		if (i >= numCount) {
			return;
		}

		visitedArray[i] = true;
		getSolution(i + 1);

		visitedArray[i] = false;
		getSolution(i + 1);

	}
}

/*Case #1
0

Case #2
1*/

