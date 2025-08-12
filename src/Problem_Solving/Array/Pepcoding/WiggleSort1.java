package Problem_Solving.Array.Pepcoding;

public class WiggleSort1 {

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void wiggleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (i % 2 == 0) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			} else {
				if (arr[i] < arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}
	
	// for arr = {1,2,3,4,5,6,7}, o/p = 1 7 3 6 4 5 2 
	//Different prob
	public static void wiggleSort1() {
		int[] arr = {1,2,3,4,5,6,7};
		int j = 1;
		int i = arr.length-1;
		while(j < arr.length && i >= 0) {
			if (j % 2 != 0) {
				swap(arr, i, j);
				j = j+2;
				i--;
			}
		}
		for(int k: arr)
			System.out.print(k+" ");
	}


	// ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
	public static void main(String[] args) {
		int[] arr = {3, 5, 2, 1, 6, 4};

		//		wiggleSort(arr);
		wiggleSort1();
		//		for (int val : arr) {
		//			System.out.print(val + " ");
		//		}
		//		System.out.println();
	}
}
