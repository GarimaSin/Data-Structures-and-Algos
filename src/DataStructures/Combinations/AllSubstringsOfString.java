package DataStructures.Combinations;

/**
 * Time = O(n^2)
 * There are potentially O(n^2) substrings for a given string, 
 * so printing them out cannot be done faster than that.
 * 
 * Same as subarray code.
 */

public class AllSubstringsOfString {

	public static void main(String[] args) {
		String str="abcd";
		printAllSubstring(str);
	}

	static void printAllSubstring(String str){
		System.out.println("All substring of abcd are:");
		for (int i = 0; i < str.length(); i++) 
			for (int j = i+1; j <= str.length(); j++) {
//					System.out.println(str.substring(0,i)+" "+str.substring(i,j)+" "+str.substring(j));
					System.out.println(str.substring(i,j));
			}
	}

	//
//	static void printAllSubstring1(String str){
//		for (int i = 1; i <= str.length(); i++) {
//			System.out.println(str.substring(0, i));
//			System.out.println(str.substring(i)) ;
//			printAllSubstring1(str.substring(i));
//		}
//	}

}
