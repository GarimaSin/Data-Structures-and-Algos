package Problem_Solving.Sorting;

public class SegregatePosAndNeg  {

	//https://youtu.be/if40LxQ8_Xo 
	static int partitionArray(int arr[], int pivot) { 
		// 0 to j-1  --> <= pivot
		// j to i-1  -->  > pivot
		// i to end  --> 	unknown
		// Also, since  
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
		partitionArray(arr, 0);
		for(int i: arr)
			System.out.print(i+" ");
	}

}
