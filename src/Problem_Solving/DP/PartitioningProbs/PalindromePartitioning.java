package Problem_Solving.DP.PartitioningProbs;

import java.util.ArrayList;
import java.util.List;

/**
 * Can use Longest Palindromic Substring 
 * 
 * Get all palindromic subarray = continuous subset
 * 131. Palindrome Partitioning - Leetcode
 * 
 * Decomposition code
 */

public class PalindromePartitioning {

	public static void main(String[] args) {
		String s = "abcd";

		List<List<String>> ans = new ArrayList<>();
		generatePalindromePartitions(s, new ArrayList<>(), ans);
		for(List<String> l: ans)
			System.out.println(l.toString());
	}

	// Working
	static void generatePalindromePartitions(String inp, ArrayList<String> list, List<List<String>> ans) {
		if(inp.length() == 0) {
			ans.add(new ArrayList<>(list));
			return;
		}

		for (int i=0; i<inp.length(); i++) {
			String left = inp.substring(0, i+1);
			String right = inp.substring(i+1);

			if(isPalindrome(left)) {	//If left is a palindrome, then only right partition shud b checked for palindrome
                list.add(left);
				generatePalindromePartitions(right, list, ans);
                list.remove(list.size()-1);
			}
		}
	}
	
	
	// Printing partitions
	static void generatePalindromePartitions(String inp, String ans) {
		if(inp.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		for (int i = 0; i < inp.length(); i++) {
			String left = inp.substring(0, i+1);
			String right = inp.substring(i+1);
			if(isPalindrome(left)) {
				generatePalindromePartitions(right, ans+"("+left+") ");
			}
		}
	}

	static boolean isPalindrome(String s) {
		int i = 0, j = s.length()-1;

		while(i <= j) {
			if(i == j)
				return true;

			if(s.charAt(i) != s.charAt(j))
				return false;
			j--;
			i++;
		}
		return true;
	}
}
