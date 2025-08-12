package Problem_Solving.Recursion.Pepcoding;

public class PermutationsPep {

	public static void main(String[] args) {
		printPermutations("abc", "");
	}
	
	static void printPermutations(String inp, String ans) {
		if(inp.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		for(int i=0; i<inp.length(); i++) {
			String left = inp.substring(0, i);
			String right = inp.substring(i+1);
			printPermutations(left+right, ans+inp.charAt(i));
		}
	}
}