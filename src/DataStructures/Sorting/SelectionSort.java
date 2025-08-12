package DataStructures.Sorting;

public class SelectionSort {

	/** 
	 * Time = O(n2)
	 * Space = O(1) since it is in-place sorting
	 * After each iteration, Smallest at the beginning
	 * We put the min elmnt in sorted array (at the beginning) ie we bring the sorted elmnt
	 * unlike insertion, where we pick 1st elnmt 4m unsorted and place it in sorted array after sorting 
	 **/

	public static void main(String[] args) {
		int arr[] = {30, 10, 50, 20, 60, 40};
		SelectionSort s = new SelectionSort();
		s.selectionSort(arr);
		s.printArray(arr);
	}

	public void selectionSort(int a[]) {
		int len = a.length;
		for(int i=0; i<len; i++) {									//O(n)
			int minIndex = i;
			for(int j=i+1; j<len; j++) {	//since the sorted elmnts r present at starting, hence loop = j=i+1 	- O(n)
				if(a[minIndex] > a[j]) {
					minIndex = j;
				}
			}
			if(minIndex != i) {		/** Very good step for optimization, We dont swap for every elmnt, 
									rather note the index of least elmnt, and swap at last **/
				int temp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}
		}
	}
	
	public void printArray(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

}
