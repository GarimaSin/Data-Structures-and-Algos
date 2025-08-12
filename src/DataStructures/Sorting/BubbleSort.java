package DataStructures.Sorting;

public class BubbleSort {
	
	/** 
	 * Time = O(n2)
	 * Space = O(1) since it is in-place sorting
	 * In an optimized version of Bubble Sort   ----  Line# 22, 24, 30, 34, 35
	 * 
	 * After each iteration, Largest at the end
	 **/

	public static void main(String[] args) {
		int arr[] = {30, 10, 50, 20, 60, 40};
		BubbleSort b = new BubbleSort();
		b.bubbleSort(arr);
		b.printArray(arr);
	}

	public void bubbleSort(int a[]) {
		int len = a.length;
		boolean swapped; 
		for(int i=0; i<len; i++) {									//O(n)
			swapped = false; 
			for(int j=0; j<len-i-1; j++) {		//((len-1) -i) -i coz have to subtract 0,1,2,3 = i everytime		O(n)
				if(a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					swapped = true; 
				}
			}
			// IF no two elements were swapped by inner loop, then break 
            if (swapped == false) 
                break;
		}
	}
	
	public void printArray(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
