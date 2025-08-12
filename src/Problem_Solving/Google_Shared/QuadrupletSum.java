package Problem_Solving.Google_Shared;

import java.util.Arrays;

public class QuadrupletSum {

	// Function to print all Quadruplet present in an array with given sum
		public static void quadTuple(int[] A, int sum) {
			// sort the array in ascending order
			Arrays.sort(A);

			// check if Quadruplet is formed by A[i], A[j] and a pair from sub-array A[j+1..n)
			for (int i = 0; i <= A.length - 4; i++) {
				for (int j = i + 1; j <= A.length - 3; j++) {
					// k stores remaining sum
					int k = sum - (A[i] + A[j]);

					// check for sum k in sub-array A[j+1..n)
					int low = j + 1, high = A.length - 1;

					while (low < high) {
						if (A[low] + A[high] < k) 
							low++;
						else if (A[low] + A[high] > k) 
							high--;
						// Quadruplet with given sum found
						else {
							System.out.println("(" + A[i] + " " + A[j] + " " +
											A[low] + " " + A[high] + ")");
							low++;
							high--;
						}
					}
				}
			}
		}

		// main function
		public static void main(String[] args) {
			int[] A = { 2, 7, 4, 0, 9, 5, 1, 3 };
			int sum = 20;

			quadTuple(A, sum);
		}
}
