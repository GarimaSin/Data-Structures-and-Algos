package DataStructures.Combinations;

import java.util.ArrayList;
import java.util.List;

public class AllSubarrayOfArray {

	/**
	 * Approach: We use two pointers start and end to maintain the starting and ending point of the array and follow the steps given below:
     *
     *  Stop if we have reached the end of the array
	 *	Increment the end index if start has become greater than end
	 *	Print the subarray from index start to end and increment the starting index
	 * 
	 */
	
	static void printSubArraysRecursion(int []arr, int start, int end) {
	     
		// Stop if we have reached the end of the array      
		if (end == arr.length)  
			return; 

		// Increment the end point and start from 0  
		else if (start > end)  
			printSubArraysRecursion(arr, 0, end + 1); 			/** this **/

		// Print the subarray and increment the starting point  
		else { 
			System.out.print("["); 
			for (int i = start; i < end; i++){ 
				System.out.print(arr[i]+", "); 
			} 

			System.out.println(arr[end]+"]"); 
			printSubArraysRecursion(arr, start + 1, end); 
		} 

		return; 
	} 

	static void subArrayIterative(int arr[], int n) { 
		List<String> list = new ArrayList<String>();
		// Pick starting point 
		for (int i=0; i <n; i++) {
			String ans = "";
			
			// Pick ending point 
			for (int j=i; j<n; j++) { 
				ans = ans +arr[j];
				list.add(ans);
				
				// Print subarray between current starting and ending points 
//				for (int k=i; k<=j; k++) 
//					System.out.print(arr[k]+" "); 
			} 
		} 
		for(String s: list)
			System.out.println(s);
	} 

	public static void main(String args[]) { 
		int []arr = {1, 2, 3, 4}; 
//		printSubArraysRecursion(arr, 0, 0); 
		subArrayIterative(arr, arr.length);
	}
}