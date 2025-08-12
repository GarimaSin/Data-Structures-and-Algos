package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

public class Abbreviations {

	public static void main(String[] args) {
		String str = "pep";
		findAbbreviations(str,"",0,0);
		System.out.println("_________________");
		printAbbreviations(str,str,0,0);
	}

	private static void findAbbreviations(String inp, String ans, int count, int idx) {
		if(idx == inp.length()) {
			if(count == 0)
				System.out.println(ans);
			else
				System.out.println(ans + count);
			return;
		}

		if(count > 0)
			findAbbreviations(inp, ans+count+inp.charAt(idx), 0, idx+1);
		else
			findAbbreviations(inp, ans+inp.charAt(idx), 0, idx+1);

		findAbbreviations(inp, ans, count+1, idx+1);
	}

	
	//Mine - working
	// 2 options: Either we convert the cu. char to number or leave it as it is
	//Mind it: we are working on "ans" here, not on "inp"
	private static void printAbbreviations(String inp, String ans, int count, int idx) {
		if(idx >= ans.length()) {
			System.out.println(ans);
			return;
		}
		
		/** we convert the char to the number **/
		if(idx > 0) {		
			Character c = ans.charAt(idx-1);
			if(Character.isDigit(c)) {
				int i = c - '0';
				i = i +1;
				String left = ans.substring(0, idx -1);
				String right = ans.substring(idx +1);
				printAbbreviations(ans, left+i+right, 0, idx+1);
			} else {
				String left = ans.substring(0, idx);
				String right = ans.substring(idx +1);
				printAbbreviations(inp, left+1+right, 0, idx+1);
			}
		} else {
			String tmp = ans.substring(1);
			printAbbreviations(inp, 1+tmp, 0, idx+1);
		}
		/** till here we convert the char to the number **/
		printAbbreviations(inp, ans, count+1, idx+1);			/** we leave the char as it is**/
	}
}