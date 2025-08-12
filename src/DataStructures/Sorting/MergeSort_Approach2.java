package DataStructures.Sorting;

import java.util.Arrays;

/**
 * 
 * Diff b/w the 2 approaches (MergeSort and MergeSort_Approach2):
 * 	Either take an aux array for the output (here since we are operating on the original array hence i and k = low and not 0)
 * 	Or make the copy of original array's left and right parts in new array and then can initialize the indexes i and k with 0 
 *
 */
public class MergeSort_Approach2 {

	public static void merge(int[] arr, int[] aux, int low, int mid, int high) {
        int k = low, i = low, j = mid + 1;			/** k = low not 0 since we are starting the sorting from index = "low" not from 0 **/
        											/** here i = low not 0 since we are working on original array = arr instead of 
        											 * copied array like left/right in other example **/
 
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            }
            else {
                aux[k++] = arr[j++];
//                inversionCount += (mid - i + 1);    // NOTE		// here only mid -i wud suffice (since i is already 
                													// starting from low (i= low + no of increments)) 
            }
        }
 
        while (i <= mid)
            aux[k++] = arr[i++];
 
        for (i = low; i <= high; i++) {
            arr[i] = aux[i];
        }
    }
 
    public static void mergeSort(int[] arr, int[] aux, int low, int high) {
        if (high == low) {    // if run size == 1
            return;
        }
        int mid = (low + ((high - low) >> 1));
 
        mergeSort(arr, aux, low, mid);
        mergeSort(arr, aux, mid + 1, high);
        merge(arr, aux, low, mid, high);
    }
 
    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1};
        int[] aux = Arrays.copyOf(arr, arr.length);
 
//        System.out.println("Inversion count is " +
                        mergeSort(arr, aux, 0, arr.length - 1);
        for(int i=0; i<aux.length; i++)
        	System.out.print(aux[i]);
    }
}
