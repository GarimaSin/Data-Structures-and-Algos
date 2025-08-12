package PracticeProb.src.ServerGoup;

import java.util.Scanner;

public class FireDrill {

		static int Answer;

		public static void main(String args[]) throws Exception {
			Scanner sc = new Scanner(System.in);
			// Scanner sc = new Scanner(new FileInputStream("FireDrill.txt"));

			int T = sc.nextInt();
			for (int test_case = 0; test_case < T; test_case++) {

				int employeeCount = sc.nextInt();
				int frendRelCount = sc.nextInt();

				int arr[][] = new int[frendRelCount][2];
				int set[] = new int[employeeCount + 1];

				for (int k = 0; k <= employeeCount; k++) {
					set[k] = k;
				}

				for (int i = 0; i < frendRelCount; i++) {
					arr[i][0] = sc.nextInt();
					arr[i][1] = sc.nextInt();
				}

				for (int i = 0; i < arr.length; i++) {
					int min = Math.min(set[arr[i][0]], set[arr[i][1]]);
					int max = Math.max(set[arr[i][0]], set[arr[i][1]]);

					for (int j = 1; j < set.length; j++) {
						if (set[j] == max) {
							set[j] = min;
						}
					}
				}

				int countArr[] = new int[set.length];

				for (int k = 1; k < set.length; k++) {
					countArr[set[k]] = countArr[set[k]] + 1;
				}
				int count = 0;
				int a = 1;
				for (int h = 0; h < countArr.length; h++) {
					if (countArr[h] != 0) {
						count++;
						a = a * countArr[h];
					}
				}

				System.out.println("Case #" + (test_case + 1)+":");
				System.out.println(count + " " + a);
			}
		}
	}

/*Case #1:
2 3
Case #2:
3 3
Case #3:
3 8*/
