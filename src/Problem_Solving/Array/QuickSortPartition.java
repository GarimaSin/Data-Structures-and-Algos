package Problem_Solving.Array;

public class QuickSortPartition {

	//https://youtu.be/if40LxQ8_Xo 
	static int partitionArray(int arr[], int pivot) { 
		// 0 to j-1  --> <= pivot
		// j to i-1  -->  > pivot
		// i to end  --> 	unknown
		// Also, since lo to j is smaller than pivot, hence j-1 = pivot  
		// Also, since  we swap elems when arr[i] <= pivot. Here �=� is imp. coz that implies 
		// pivot will also be swapped in the end and at last arr[j-1] will hold the pivot elem.
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
	
	public static void main(String[] args) {
		int arr[] = {9, -3, 5, -2, -8, -6, 1, 3};
		partitionArray(arr, 0);				// pivot = 0 to segregate -ve and +ve integers
		for(int i: arr)
			System.out.print(i+" ");
	}
}
