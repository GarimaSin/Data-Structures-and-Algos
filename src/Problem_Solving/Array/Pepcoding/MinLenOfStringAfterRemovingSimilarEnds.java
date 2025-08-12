package Problem_Solving.Array.Pepcoding;

public class MinLenOfStringAfterRemovingSimilarEnds {

	public static int minLen(String s) {
		int l = 0, r = s.length() - 1;
		while (l < r && s.charAt(l) == s.charAt(r)) {
			char ch = s.charAt(l);
			while (l < r && ch == s.charAt(l)) {
				l++;
			}
			while (l <= r && ch == s.charAt(r)) {
				r--;
			}
		}
		return r - l + 1;
	}
	
	
	public static void main(String[] args) {
		String inp = "aabccabba";
		int len = minLen(inp);
		System.out.println(len);
	}
}
