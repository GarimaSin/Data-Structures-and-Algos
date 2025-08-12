package Problem_Solving.Recursion.Pepcoding;

import java.util.ArrayList;

public class Subsequences {

	// gss(abc) = for every string in gss(bc), add 'a' and ' '.  
	public static ArrayList<String> getSubseq(String str) {
		if(str.length() == 0) {
			ArrayList<String> bres = new ArrayList<String>();
			bres.add("");
			return bres;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rres = getSubseq(ros);

		ArrayList<String> mres = new ArrayList<String>();
		for(String rstr: rres) {
			mres.add("" + rstr);
			mres.add(ch + rstr);
		}
		return mres;
	}
	
	public static void getSubseq1(String str, String ans, int i, int count) {
		if(i >= str.length()) {
			if(count == str.length())
				System.out.println(ans);
			return;
		}

		getSubseq1(str, ans+str.charAt(i), i+1, count+1);
		getSubseq1(str, ans, i+1, count+1);
		return;
	}


	public static void printSubseq(String str, String ans) {
		if(str.length() == 0) {
			System.out.print(", "+ans);		
			return;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		printSubseq(ros, ans + ch);
		printSubseq(ros, ans + "");
	}

	public static void main(String[] args) {
//		ArrayList<String> ans = getSubseq("abc");
//		for(String s : ans)
//			System.out.print(s + ", ");
//		
//		System.out.println("");
//		printSubseq("abc", "");
		getSubseq1("abc", "", 0, 0);
	}
	
}
