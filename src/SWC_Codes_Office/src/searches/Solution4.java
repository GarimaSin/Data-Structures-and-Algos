package searches;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution4 {
	static int arra[][];
	static int visited[][];
	static int valid = 0;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		// int test = sc.nextInt();
		int i = 0;
		while (i < 10) {
			try {
				i++;
				// System.out.println("prinitngi:::" +  );
				int testNumber = sc.nextInt();
				int maxConnected = sc.nextInt();
				arra = new int[100][100];
				visited = new int[100][100];
				for (int j = 0; j < maxConnected; j++) {
					int firstNumber = sc.nextInt();
					int secNumber = sc.nextInt();
					arra[firstNumber][secNumber] = 1;
				}
				valid = 0;
				// System.out.println(Arrays.deepToString(arra));
				 System.out.println("testNumber:::" + (testNumber));
				 System.out.println("maxConnected:::" + (maxConnected));
				for (int j = 0; j < 100; j++) {
					if (valid == 0) {
						for (int k = 0; k < 100; k++) {
							if (arra[j][k] == 1 && visited[j][k] == 0) {
								transverseMatrix(arra, j, k);
							}
						}
					}
				}
				System.out.print("#" + (testNumber) + " " + (valid));
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void transverseMatrix(int[][] arra2, int j, int k) {

		visited[j][k] = 1;
		if (visited[j][k] == 1 && k == 99) {
			valid = 1;

		}
		if (k + 1 < 100 && arra[j][k + 1] == 1 && visited[j][k + 1] == 0) {
			transverseMatrix(arra, j, k + 1);
		}
		if (j - 1 >= 0 && arra[j - 1][k] == 1 && visited[j - 1][k] == 0) {
			transverseMatrix(arra, j - 1, k);
		}
		if (k - 1 >= 0 && arra[j][k - 1] == 1 && visited[j][k - 1] == 0) {
			transverseMatrix(arra, j, k - 1);
		}
		if (j + 1 < 100 && arra[j + 1][k] == 1 && visited[j + 1][k] == 0) {
			transverseMatrix(arra, j + 1, k);
		}

	}
}