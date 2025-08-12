package Problem_Solving.Recursion.Pepcoding;

import java.util.HashMap;

public class PrintEncodings {

	static HashMap<Integer, String> map = new HashMap<>();
	public static void main(String[] args) {
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(5, "e");
		map.put(6, "f");
		map.put(9, "i");
		map.put(10, "j");
		map.put(11, "k");
		map.put(12, "l");
		map.put(13, "m");
		map.put(19, "s");
		map.put(21, "u");
		map.put(23, "w");
		String inp = "655196";
		printEncodings1(inp, "");
		System.out.println("____________");
		printEncodings(inp, "");
	}
	
	
	//Mine - working (better)
	static void printEncodings1(String inp, String ans) {
		if(inp.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		for (int i = 1; i <= 2 && i<=inp.length(); i++) {
			String first = inp.substring(0, i);
			Integer firInt = Integer.parseInt(first);
			if(first.startsWith("0"))
				continue;
			String ros = inp.substring(i);
			if(map.get(firInt) != null)
				printEncodings1(ros, ans+map.get(firInt));
			else
				continue;
		}
	}
	

	static void printEncodings(String inp, String ans) {
		if(inp.length() == 0) {
			System.out.println(ans);
			return;
		} else if(inp.length() == 1) {
			char ch = inp.charAt(0);
			if(ch == '0')
				return;
			else {
				int chv = ch - '0';
				char code = (char) ('a' + chv -1);
				ans = ans + code;
				System.out.println(ans);
			} 
		}	else {
			char ch = inp.charAt(0);
			String roq = inp.substring(1);
			if(ch == '0')
				return;
			else {
				int chv = ch - '0';
				char code = (char) ('a' + chv -1);
				printEncodings(roq, ans+code);
			} 

			String ch12 = inp.substring(0, 2);
			String roq12 = inp.substring(2);

			int ch12v = Integer.parseInt(ch12);
			if(ch12v <= 26) {
				char code = (char) ('a' + ch12v -1);
				printEncodings(roq12, ans+code);
			}
		}
	}
}
