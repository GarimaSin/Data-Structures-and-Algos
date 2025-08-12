package Problem_Solving.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Continuous subarray
 * Subarray Sum Equals K - leetcode
 * 
 * Sol 1 = print all subarrays count -  map.put:   key = currsum, value = count 
 * Sol 2 = print max len subarray 	-  map.put:      key = sum, value = index 
 * Sol 3 = print all subarrays 		-  map.put:      key = sum, value = index 
 * Sol 4 = print max len subarray with equal no. of 0s and 1s 		-  map.put:      key = sum, value = index
 */
public class KSumContinuousSubrrays {


	//Sol 1
	public static int subarraySum(int[] nums, int k) {
		int count = 0, currSum = 0;
		HashMap <Integer, Integer> map = new HashMap < > ();
		map.put(0, 1);												/** it will handle the case: currSum = k 
																	coz in that case currSum-k =0 and map.get(0) == 1, hence seen**/ 

		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if (map.containsKey(currSum - k))			//contains - currSum - k and put currSum
				count += map.get(currSum - k);

			map.put(currSum, map.getOrDefault(currSum, 0) + 1);		//V. Imp, first get the ans (here, get the count) then put the currSum in map.
		}
		return count;
	}
	
	
	//Sol. 4
	public static void subarraySumZero(int[] A, int k) {
		for(int i: A) {
			A[i] = -A[i];
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int currSum = 0;
		int len = 0;
		int ending_index = -1;
		for (int i = 0; i < A.length; i++) {
			currSum += A[i];		// sum of elements so far
			if (!map.containsKey(currSum))
				map.put(currSum, i);
			if (map.containsKey(currSum - k) && len < i - map.get(currSum - k)) {
				len =  i - map.get(currSum - k);
				ending_index = i;
			}
		}
		System.out.println("Max length array with equal no. of 0 and 1 = [" + (ending_index - len + 1) + ", " + ending_index + "]");
	}


	public static void main(String []args){ 
		//        int arr[] = { 10, 2, -2, -20, 10 };
		//    	  int sum = -10;
		//        int arr[] = { 7, 3, 5, 12, 2, 1, 5, 3, 8, 4, 6, 4 };
		//        int sum = 12;  
		//    	int[] arr = { 5, 6, -5, 5, 3, 5, 3, -2, 0 };
		int arr[] = {10,3,2,5,5,2};
		int arr1[] = {1, 0, 0, 1, 0, 1, 1};
		int sum = 13; 
		System.out.println(subarraySum(arr, sum) +"---"); 
		printallSubarrays(arr, sum); 
		maxLengthSubArray(arr, sum);
		subarraySumZero(arr1, 0);
	}

	private static<K,V> void insert(Map<K, List<V>> hashMap, K key, V value)	{
		// if the key is seen for the first time, initialize the list
		if (!hashMap.containsKey(key)) {
			hashMap.put(key, new ArrayList<>());
		}
		hashMap.get(key).add(value);
	}

	// Sol 3
	//Function to print all sub-arrays with 0 sum present in the given array
	public static void printallSubarrays(int[] A, int S)	{
		Map<Integer, List<Integer>> hashMap = new HashMap<>();

		// insert (0, -1) pair into the map to handle the case when sub-array with 0 sum starts from index 0
		insert(hashMap, 0, -1);
		int currSum = 0;

		for (int i = 0; i < A.length; i++)	{
			currSum += A[i];
			if (hashMap.containsKey(currSum - S)) {
				List<Integer> list = hashMap.get(currSum - S);
				for (Integer value: list) {
					System.out.println("Subarray [" + (value + 1) + ".." +i + "]");
				}
			}
			insert(hashMap, currSum, i);
		}
	}

	//Sol 2 - not working 
	public static void maxLengthSubArray(int[] A, int S)	{
		// create an empty Hash Map to store ending index of first sub-array having some sum
		Map<Integer, Integer> map = new HashMap<>();

		// insert (0, -1) pair into the set to handle the case when sub-array with sum S starts from index 0
		map.put(0, -1);
		int currSum = 0;
		// len stores the maximum length of sub-array with sum S
		int len = 0;

		// stores ending index of maximum length sub-array having sum S
		int ending_index = -1;

		for (int i = 0; i < A.length; i++) {
			currSum += A[i];		// sum of elements so far
			if (!map.containsKey(currSum))
				map.put(currSum, i);
			// update length and ending index of maximum length sub-array having sum S
			if (map.containsKey(currSum - S) && len < i - map.get(currSum - S)) {
				len =  i - map.get(currSum - S);
				ending_index = i;
			}
		}
		System.out.println("Max length array = [" + (ending_index - len + 1) + ", " + ending_index + "]");
	}
}	