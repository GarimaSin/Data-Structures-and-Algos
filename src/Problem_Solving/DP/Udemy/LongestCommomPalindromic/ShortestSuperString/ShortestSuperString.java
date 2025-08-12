package Problem_Solving.DP.Udemy.LongestCommomPalindromic.ShortestSuperString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Find shortest superstring using Greedy 

public class ShortestSuperString {


	//Working
	private static String merge(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		int overlapped1 = 0, overlapped2 = 0;

		for (int len = 1; len1 - len >= 0 && len <= len2; len++) {
			// substring(begin)
			// substring(begin, end)
			if (s1.substring(len1 - len).equals(s2.substring(0, len))) {
				overlapped1 = len;
			}
		}

		for (int len = 1; len2 - len >= 0 && len <= len1; len++) {
			if (s2.substring(len2 - len).equals(s1.substring(0, len))) {
				overlapped2 = len;
			}
		}

		if (overlapped1 >= overlapped2) {
			return s1.substring(0, len1 - overlapped1) + s2;
		} else {
			return s2.substring(0, len2 - overlapped2) + s1;
		}
	}

	public String shortestSuperstring(String[] A) {
		List<String> list = new ArrayList<>(Arrays.asList(A));

		while (true) {
			if (list.size() == 1) break;

			int n = list.size();
			int max = -1;
			int index1 = 0, index2 = 0;
			String newStr = "";
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					String s1 = list.get(i);
					String s2 = list.get(j);
					String merged = merge(s1, s2);

					int savedLen = s1.length() + s2.length() - merged.length();

					if (savedLen > max) {
						max = savedLen;
						index1 = i;
						index2 = j;
						newStr = merged;
					}
				}
			}

			String str1 = list.get(index1);
			String str2 = list.get(index2);
			list.remove(str1);
			list.remove(str2);
			list.add(newStr);
		}

		return list.get(0);
	}

	//	static String str; 
	//
	//	// Utility function to calculate minimum of two numbers 
	//	static int min(int a, int b) { 
	//		return (a < b) ? a : b; 
	//	} 
	//
		//Working
	//	// Function to calculate maximum overlap in two given strings 
	//	static int findOverlappingPair(String str1, String str2) { 
	//
	//		// max will store maximum overlap i.e maximum length of the matching prefix and suffix 
	//		int max = Integer.MIN_VALUE; 
	//		int len1 = str1.length(); 
	//		int len2 = str2.length(); 
	//
	//		// check suffix of str1 matches with prefix of str2 
	//		for (int i = 1; i <= min(len1, len2); i++) { 
	//
	//			// compare last i characters in str1 with first i characters in str2 
	//			if (str1.substring(len1 - i).compareTo(str2.substring(0, i)) == 0) { 
	//				if (max < i) { 
	//					max = i; 
	//					str = str1 + str2.substring(i); 
	//				} 
	//			} 
	//		} 
	//
	//		// check prefix of str1 matches with suffix of str2 
	//		for (int i = 1; i <= min(len1, len2); i++) { 
	//
	//			// compare first i characters in str1 with last i characters in str2 
	//			if (str1.substring(0, i).compareTo(str2.substring(len2 - i)) == 0) { 
	//				if (max < i) { 
	//					max = i; 
	//					str = str2 + str1.substring(i); 
	//				} 
	//			} 
	//		} 
	//		return max; 
	//	} 
	//
	//	// Function to calculate smallest string that contains 
	//	// each string in the given set as substring. 
	//	static String findShortestSuperstring(String arr[], int len) { 
	//
	//		// run len-1 times to consider every pair 
	//		/** Coz in  every run only 2 strings will concatenate into 1. Hence shud run for  **/
	//		while (len != 1) { 
	//			int max = Integer.MIN_VALUE; 	// to store maximum overlap 
	//			int l = 0, r = 0; 				// to store array index of strings 
	//
	//			// involved in maximum overlap 
	//
	//			String resStr = ""; // to store resultant string after maximum overlap 
	//
	//			for (int i = 0; i < len; i++) { 
	//				for (int j = i + 1; j < len; j++) { 
	//
	//					// res will store maximum length of the matching 
	//					// prefix and suffix str is passed by reference and 
	//					// will store the resultant string after maximum 
	//					// overlap of arr[i] and arr[j], if any. 
	//					int res = findOverlappingPair(arr[i], arr[j]); 
	//
	//					// check for maximum overlap 
	//					if (max < res) { 
	//						max = res; 
	//						resStr = str; 
	//						l = i; 			
	//						r = j; 
	//					} 
	//				} 
	//			} 
	//
	//			len--; // ignore last element in next cycle 
	//
	//			// if no overlap, append arr[len] to arr[0] 
	//			if (max == Integer.MIN_VALUE) 
	//				arr[0] += arr[len]; 	/** will append every word from len-1 to 1, to arr[0]. Hence, when there is a no match, final rst will be all words added **/ 
	//			else { 
	//				arr[l] = resStr; // copy resultant string to index l 			/** l and r iterates as: l=0, r=4; l=1, r=3 **/
	//				arr[r] = arr[len]; // copy string at last index to index r 
	//			} 
	//		} 
	//		return arr[0]; 
	//	} 

	public static void main(String[] args) { 
		String[] arr = { "catgc", "ctaagt", "gcta", "ttca", "atgcatc" }; 
		int len = arr.length; 

		System.out.println("The Shortest Superstring is " + 
//				findShortestSuperstring(arr, len)); 
				merge("", ""));
		
	} 
} 

