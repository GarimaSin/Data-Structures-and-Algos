package DataStructures.Sorting;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;


// Time = O(n+k), where k is the range of nos. in the i/p array
public class CountingSort {

	// Function to efficiently sort an array with many duplicated values
		public static void customSort(int[] arr) {
			// create an empty TreeMap to store frequency of array elements
			Map<Integer, Integer> freq = new TreeMap<>();

			// store distinct values in the input array as key and
			// their respective counts as values
			for (int i: arr) {
				freq.putIfAbsent(i, 0);
				freq.put(i, freq.get(i) + 1);
			}

			// sort the map according to the natural ordering of its keys

			// since we have used TreeMap instead of HashMap, keys are already sorted by default

			// traverse the sorted map and overwrite the input array with sorted elements
			int i = 0;
			for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
				int val = entry.getValue();
				while (val > 0) {
					arr[i++] = entry.getKey();
					val--;
				}
			}
		}
		
		public static final int RANGE = 100;
		public static void customSort2(int[] arr) {
			// create a new array to store counts of elements in the input array
			int[] freq = new int[RANGE];

			// using value of elements in the input array as index,
			// update their frequencies in the new array
			for (int i: arr) {
				freq[i]++;
			}

			// overwrite the input array with sorted order
			int k = 0;
			for (int i = 0; i < RANGE; i++) {
				while (freq[i] > 0) {
					arr[k++] = i;
					freq[i]--;
				}
			}
		}

		// Efficiently sort an array with many duplicated values
		public static void main(String[] args) {
			int[] arr = { 4, 2, 40, 10, 10, 1, 4, 2, 1, 10, 40 };

			customSort(arr);
			System.out.println(Arrays.toString(arr));
		}
}
