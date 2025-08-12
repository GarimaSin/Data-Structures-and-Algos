package DataStructures.Sorting;

public class QuickSortPepcoding {

	static void quickSort(int[] arr, int lo, int hi) {
		if(lo > hi)
			return;
		
		int pivot = arr[hi];
		int pi = partitionArray(arr, pivot, lo, hi);
		quickSort(arr, lo, pi-1);
		quickSort(arr, pi+1, hi);
	}

	//https://youtu.be/if40LxQ8_Xo 
	static int partitionArray(int arr[], int pivot, int lo, int hi) { 
		// lo to j-1  --> all nos. which are <= pivot
		// j to i-1  -->  all nos. which are > pivot
		// i to hi  --> 	unknown
		// Also, since lo to j is smaller than pivot, hence j-1 = pivot  
		// Also, since  we swap elems when arr[i] <= pivot. Here “=” is imp. coz that implies 
		// pivot will also be swapped in the end and at last arr[j-1] will hold the pivot elem.
		int i = lo;
		int j = lo;
		while(i <= hi) {
			if(arr[i] > pivot)
				i++;
			else {
				swap(arr, i, j);
				i++;
				j++;
			}
		}
		System.out.println("pivot index -> "+(j-1));
		return j-1;
	}

	//https://youtu.be/if40LxQ8_Xo 
	int partitionArray(int arr[], int pivot) { 
		// 0 to j-1  --> <= pivot
		// j to i-1  -->  > pivot
		// i to end  --> 	unknown
		// Also, since 0 to j is smaller than pivot, hence j-1 = pivot  
		int i = 0;
		int j = 0;
		while(i < arr.length) {
			if(arr[i] > pivot)
				i++;
			else {
				swap(arr, i, j);
				i++;
				j++;
			}
		}
		System.out.println("pivot index -> "+(j-1));
		return j-1;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	} 
	
	public static void main(String args[]) { 
		int arr[] = {10, 7, 8, 9, 1, 5}; 
		int n = arr.length; 

		quickSort(arr, 0, n-1); 

		System.out.println("sorted array"); 
		for(int i: arr)
			System.out.print(i+" ");
	} 
}