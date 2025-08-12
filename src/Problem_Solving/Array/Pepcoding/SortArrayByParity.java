package Problem_Solving.Array.Pepcoding;

public class SortArrayByParity {
	public static void sortArrayByParity(int[] nums) {
		int i = 0;
		int j = 0;
		while(i < nums.length) {
			if(nums[i]%2 != 0)
				i++; 
			else {
				swap(nums, i, j);
				i++;
				j++;
			}
		}
		System.out.println("pivot index -> "+(j-1));
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	} 

	//// ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
	public static void main(String[] args) {
		int[] arr = {9, 3, 8, 7, 6, 2, 3};
		sortArrayByParity(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
