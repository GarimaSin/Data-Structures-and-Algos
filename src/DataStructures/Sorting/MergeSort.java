package DataStructures.Sorting;

import java.util.Arrays;

/**
 * Points:
 * SortAndMerge:
 * 	For copying left and right arrays in new:
 * 		n1 = m-l (+ 1)    		----- +1
 * 		Line 37 - m+j (+ 1)		----- +1
 *		Line 45 - while( && ) --------- && (coz if any of the array is exhausted, code inside while will throw OutOfIndex error
 *			OR
 *		just use int[] L = Arrays.copyOfRange(l, m+1)			m+1
 *			int[] R = Arrays.copyOfRange(l, m+1)				r+1
 *
 * Divide:
 * 		No explicit loop, looped thru mid = (l+r)/2
 * 
 * 
 * 
 * 
 * Diff b/w the 2 approaches (MergeSort and MergeSort_Approach2):
 * 	Either take an aux array for the output (here since we are operating on the original array hence i and k = low and not 0)
 * 	Or make the copy of original array's left and right parts in new array and then can initialize the indexes i and k with 0 
 */

public class MergeSort {
	public static void main(String[] args) {
		int arr[] = {30, 10, 50, 20, 60, 40};
		MergeSort m = new MergeSort();
		m.divide(arr, 0, 5);
//		m.mergeSort(arr,6);
		m.printArray(arr);

	}

	public void divide(int a[], int l, int r) {		/** 1st divide then when arr reduces to small size, merge **/
		if (l<r) {
			int mid = (l+r)/2;
			//	System.out.println(s +"===========  "+l + " = l, "+mid+" mid, "+r+" r");
			divide(a, l, mid);
			divide(a, mid+1, r);
			sortAndMerge(a, l, mid, r);	// Faith = if we get left and right lists sorted, we can get the sorted list by merging both (Pepcoding)
		}
	}

	void sortAndMerge(int arr[], int l, int m, int r) {		/** put the sorted array in original input array only **/
		int[] L = Arrays.copyOfRange(arr, l, m+1); 			/** wont work w/o m+1 **/ 
		int[] R = Arrays.copyOfRange(arr, m+1, r+1); 		/** We are making copy as sorted nos. are pushed in the original array **/
		int n1 = L.length;
		int n2 = R.length;

		int i = 0, j = 0; 

		// Merge the 2 sorted arrays
		//Find the smallest of the 2: L[i], R[j] and put it in arr[k]
		int k = l; 								/** k = l not 0  ====> since we need to start inserting from l in the array and not from 0 always  **/ 
		while (i < n1 && j < n2) { 				/** AND **/
			if (L[i] <= R[j]) { 
				arr[k++] = L[i]; 				
				i++; 
			} 
			else { 
				arr[k++] = R[j]; 
				j++; 
			} 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) { 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2)  { 
			arr[k] = R[j]; 
			j++; 
			k++; 
		}  
	}
	
	void printArray(int arr[])  { 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

	public void mergesortIterative(int[] A) {
		int low = 0;
		int high = A.length - 1;

		// sort array A[] using temporary array temp
		//		int[] temp = Arrays.copyOf(A, A.length);

		// divide the array into blocks of size m
		// m = [1, 2, 4, 8, 16...]
		for (int m = 1; m <= high - low; m = 2*m) {
			// for m = 1, i = 0, 2, 4, 6, 8...
			// for m = 2, i = 0, 4, 8, 12...
			// for m = 4, i = 0, 8, 16...
			// ...
			for (int i = low; i < high; i += 2*m) {
				int from = i;
				int mid = i + m - 1;
				int to = Integer.min(i + 2 * m - 1, high);

				sortAndMerge(A, from, mid, to);
			}
		}
	}
}