package Problem_Solving.Recursion.Pepcoding;

import java.util.ArrayList;

/**
 * 
 * Storing and printing the combinations both are different
 *
 */
public class LetterCombinationsPhoneNumberPepCoding {
	static String[] codes = {"abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz"};
	
	//Storing the combinations
	public static ArrayList<String> getCombinations(String str) {
		if(str.length() == 0) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");																		//When we don't have any char, ans will be blank
			return list;
		}
		
		char ch = str.charAt(0);
		String right = str.substring(1);
		ArrayList<String> res = getCombinations(right);
		ArrayList<String> mres = new ArrayList<String>();
		
		String codeforch = codes[ch - '0'];
		for(int i=0; i<codeforch.length(); i++) {
			char chcode = codeforch.charAt(i);
			for(String rstr: res) {
				mres.add(chcode + rstr);
			}
		}
		return mres;
	}
	
	
	//Print the combinations
	public static void printCombinations(String inp, String ans) {
		if(inp.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		
		char ch = inp.charAt(0);
		String right = inp.substring(1);
		
		String codeforch = codes[ch - '0'];
		for(int i=0; i<codeforch.length(); i++) { 
			char chcode = codeforch.charAt(i);
			printCombinations(right, ans+chcode);
		}
	}


	public static void main(String[] args) {
		String str = "138";
		ArrayList<String> words = getCombinations(str);
		for(String t: words)
			System.out.print(t+ " ");
		System.out.println();
		
		printCombinations(str, "");
	}
}