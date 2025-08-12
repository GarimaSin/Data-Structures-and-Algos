package Problem_Solving.DP.Leetcode;

/**
 * 
 * UNDERSTAND THE RECURSION TREE
 *
 */

public class CombinationIncExcTest {

	static int min = Integer.MAX_VALUE;
	static void combinationUtil(int arr[], int data[], int i, String s, String callFrom, int tmp)  { 
//		if (s.length() == arr.length-1) { 
//			System.out.println(s); 
//			return; 
//		} 
//		System.out.println("i = "+i+" from "+ callFrom);
		if(i> arr.length) 
			return;

		if(i == arr.length) {
			if(min > tmp)
				min = tmp;
			System.out.println(s);
			return; 
		}
//		if(i == -1) {
//			combinationUtil(arr, data, i+1, s, "1st");
//			combinationUtil(arr, data, i+2, s, "2nd");
//		} else {
			combinationUtil(arr, data, i+2, s+arr[i], "1st", tmp+arr[i]);
			combinationUtil(arr, data, i+1, s, "2nd", tmp);
//		}
	} 

	static void printCombination(int arr[], int n, int r)  { 
		int data[]=new int[r]; 
		combinationUtil(arr, data, 0, "", "main", 0); 
		System.out.println(min);
//		combinationUtil(arr, data, 1, "", "main"); 
//		combinationUtil(arr, data, 2, "", "main"); 
//		combinationUtil(arr, data, 3, "", "main"); 
	} 

	public static void main (String[] args) { 
		int arr[] = {10, 15, 20}; 
		int r = 3; 
		int n = arr.length; 
		printCombination(arr, n, r); 
	} 
}
