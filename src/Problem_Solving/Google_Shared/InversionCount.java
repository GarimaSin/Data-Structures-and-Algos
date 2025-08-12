package Problem_Solving.Google_Shared;

import java.util.Arrays;

//https://youtu.be/k9RQh21KrH8`	
public class InversionCount {

	private static int mergeAndCount(long[] arr, int l, int m, int r) { 
  
        long[] left = Arrays.copyOfRange(arr, l, m+1); 				// to m+1
        long[] right = Arrays.copyOfRange(arr, m+1, r+1); 			// to r+1
  
        int i = 0, j = 0, k = l, swaps = 0; 
  
        while (i < left.length && j < right.length) { 
            if (left[i] <= right[j]) 
                arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
//                swaps += (m-l-i) +1;			///** Diff than merge sort step **/
                swaps += left.length - i;		// BOTH THE SWAP STATEMENTS ARE CORRECT, check both the approaches of merge sort for better understanding
            } 
        } 
        while (i < left.length) 
            arr[k++] = left[i++]; 
  
        while (j < right.length) 
            arr[k++] = right[j++]; 
  
        return swaps; 
    } 
  
    private static int mergeSortAndCount(long[] arr, int l, int r) { 
        int count = 0; 
        if (l < r) { 
            int m = (l + r) / 2; 
  
            // Total inversion count = left subarray count + right subarray count + merge count 
            count += mergeSortAndCount(arr, l, m); 		/** count +=  **/
            count += mergeSortAndCount(arr, m + 1, r);  /** count +=  **/
            count += mergeAndCount(arr, l, m, r); 		/** count +=  **/
        } 
        return count; 
    } 
  
    public static void main(String[] args) { 
        long[] arr = {2, 4, 1, 3, 5}; 
        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1)); 
    } 
}
