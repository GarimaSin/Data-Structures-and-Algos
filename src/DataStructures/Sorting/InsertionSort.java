package DataStructures.Sorting;

public class InsertionSort {
	/** 
	 * Time = O(n2)
	 * Space = O(1) since it is in-place sorting
	 **/

	public static void main(String[] args) {
		int arr[] = {30, 10, 50, 20, 60, 40};
		int arr2[] = {6,5,4,3,2,1};
		int arr1[] = {4, 3, 2, 10, 12, 1, 5, 6};
		InsertionSort i = new InsertionSort();
		i.insertionSort_Mine(arr);
		i.insertionSort_Mine(arr1);
		i.insertionSort_Mine(arr2);
//		i.insertionSort(arr);
//		i.printArray(arr1);
	}

	public void insertionSort_Mine(int a[]) {
		int len = a.length;
		for(int i=0; i<len; i++) {									//O(n)
			for(int j=i; j>0; j--) {								//O(n)
				if(a[j] < a[j-1]) {
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				} else 
					break;		// exit from the loop when it encounters 1st element which is smaller (since it is already sorted)
			}
//			printArray(a);
		}
		printArray(a);
	}
	
	public void insertionSort(int arr[]) {
		int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        }
        printArray(arr);
        System.out.println("Copied Insertion Sort");
	}
	
	public void printArray(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

}
