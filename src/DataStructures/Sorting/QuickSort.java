package DataStructures.Sorting;

/**
 * For partition(),  
 * 		i = start-1, 
 * 		loop of j = start to end
 * 		after the loop ends, swap i+1 and end
 * 		Return i+1
 * 
 * 		In every step, compare j and pivot, if j<pivot, i++ and swap i and j
 * 		after the while, swap i+1 and end.
 * 
 * For Sort():
 * 		recurse on (start, p-1) to (p+1, end) - dont include p since p is at right position	
 */
class QuickSort { 

	/* This function takes last element as pivot, places the pivot element at its correct 
       position in sorted array, and places all smaller (smaller than pivot) to left of 
       pivot and all greater elements to right of pivot 

	 *
	 * IMP:  	i is positioning all the elements smaller than pivot and 
	 *  		   	j is positioning all the elements greater than pivot
	 *  
	 *  Concept: we compare j with pivot, if j < pivot means we have to shift j after i since all elems greater than j 
	 *  shud come after i and pivot
	 *  
	 *   https://www.youtube.com/watch?v=7h1s2SojIRw 
	 *  */
	int partition(int arr[], int start, int end) { 

		int pivot = arr[end];  
		int i = (start-1); // index of smaller element 
		for (int j=start; j<end; j++)  { 
			if (arr[j] < pivot)   { 
				i++; 

				// swap arr[i] and arr[j] 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		// swap arr[i+1] and arr[end] (or pivot) 
		int temp = arr[i+1]; 
		arr[i+1] = arr[end]; 
		arr[end] = temp; 

		return i+1; 								/** return i+1 **/
	} 

	/* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      start  --> Starting index, 
      end  --> Ending index */
	void sort(int arr[], int start, int end) { 
		if (start < end) { 
			/* pi is partitioning index, arr[pi] is now at right place */
			int pi = partition(arr, start, end); 

			// Recursively sort elements before partition and after partition 
			sort(arr, start, pi-1); 
			sort(arr, pi+1, end); 
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(int arr[]) { 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

	public static void main(String args[]) { 
		int arr[] = {10, 7, 8, 9, 1, 5}; 
		int n = arr.length; 

		QuickSort ob = new QuickSort(); 
		ob.sort(arr, 0, n-1); 

		System.out.println("sorted array"); 
		printArray(arr); 
	} 
}