package Problem_Solving.Google_Shared;

import java.util.Arrays;

// Take pivot as 0 ( since have seperate +ve and -ve nos.)
public class SegregatePosAndNeg {

	public static void partition(int[] a, int start, int end) {
		int pIndex = start;

		// each time we find a negative number, pIndex is incremented
		// and that element would be placed before the pivot
		for (int i = start; i <= end; i++)	{
			if (a[i] < 0) {  		// pivot is 0 
				swap(a, i, pIndex);
				pIndex++;
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 9, -3, 5, -2, -8, -6, 1, 3 };

		partition(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
		partition2();
	}
	
	//Approach 2 - Easy - Take a separate o/p array
	static void partition2() {
		
		int[] input = {9, -3, 5, -2, -8, -6, 1, 3};
		int[] output = new int[input.length];
		
		int negativeIdx = 0;
		int positiveIdx = input.length - 1;				//Check this
		for (int i = 0; i < input.length ; i++) {
			if (input[i] < 0) {
				output[negativeIdx++] = input[i];
			} else {
				output[positiveIdx--] = input[i];
			}
		}
		System.out.println(Arrays.toString(output));
	}
}
