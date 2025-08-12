package Problem_Solving.DP;

import java.util.Arrays;


/** 
 * V. IMP------------------------------
 * Imp. return 0 will not work in checks where final condition is not met
 * Either dont put such checks OR (if the check is needed for OOB conditions) then
 * Return initialized value for min/max variable in checks where final condition is not met
 * = return Integer.MIN_VALUE/Integer.MAX_VALUE
 * 
 * **/
public class RodCutting {

	static int max = Integer.MIN_VALUE;

	public static void main(String args[]) 
	{ 
		//		int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
		//		int size = arr.length;
		int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
		int size = 4;
		cutRodInclude(arr, size, 0, 0);
		System.out.println(max);
		System.out.println(cutRodMine(arr, 0, size));
//		max = Integer.MIN_VALUE;
//		cutRodRecrsn(arr, size, 0, 0);
//		System.out.println(max);
//		System.out.println(cutRod(arr, size));
		int[][] memo = new int[arr.length+1][size+1];
		for(int[] a: memo)
			Arrays.fill(a, Integer.MIN_VALUE);
		System.out.println("memo "+cutRodMemo(arr, 0, size, memo));
	}

	//Working
	private static void cutRodInclude(int[] arr, int length, int i, int sum) {

		if(length <0 || i >=arr.length)
			return ;
		if(length == 0 && max < sum) {
			max = sum;
			return ;
		}

		cutRodInclude(arr, length-1-i, i, sum+arr[i]);
		cutRodInclude(arr, length, i+1, sum);
		return ;
	} 

	//Working
	static int cutRodMine(int[] arr, int i, int length) {
		int maxVal = Integer.MIN_VALUE;			/** declare local max_val **/
		if(length == 0) {
			return 0;
		}

		if(length <0 || i >=arr.length)
			return Integer.MIN_VALUE;				/** Imp. return 0 will not work **/

		int include = arr[i]+ cutRodMine(arr, i, length-i-1);
		int exclude = cutRodMine(arr, i+1, length);
		maxVal = Math.max(include, exclude);
		return maxVal;
	}


	//not Working
	static int cutRodMemo(int[] arr, int i, int length, int memo[][]) {
//		int maxVal = Integer.MIN_VALUE;
		if(length == 0) {
			return 0;
		}

		if(length <0 || i >=arr.length)
			return Integer.MIN_VALUE;

		if(memo[i][length] == Integer.MIN_VALUE) {
			int include = arr[i]+ cutRodMemo(arr, i, length-i-1, memo);
			int exclude = cutRodMemo(arr, i+1, length, memo);
			memo[i][length] = Math.max(include, exclude);
		}
		return memo[i][length];
	}

	//Working
	static int cutRod(int price[], int n) {  
		if (n <= 0) 
			return 0; 
		int max_val = Integer.MIN_VALUE; 

		for (int i = 0; i<n; i++) 
			max_val = Math.max(max_val, price[i] + cutRod(price, n-i-1)); 

		return max_val; 
	} 


	//Working
	private static void cutRodRecrsn(int[] arr, int length, int start, int sum) {
		if(length ==0) {
			if(max < sum)
				max = sum;
			return;
		}

		if(start >=arr.length || length <0)
			return;

		for(int i=start; i<arr.length; i++) {
			cutRodRecrsn(arr, length-i-1, i, sum+arr[i]);
		}
	} 
}
