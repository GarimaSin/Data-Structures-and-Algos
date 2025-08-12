package Problem_Solving.DP.Udemy.LongestCommomPalindromic.AllConsistentCode;

/**
 * 
 * Time = O(2^n)
 *
 */
public class LRepeatedSubseq {

	public static void main(String[] args) {
		String X = "aabebcdd";
		int m = X.length();
		int[][] memo = new int[m][m];
		System.out.println("Length of Longest Repeating Subsequence is........ " +
				LRSLength(X, m, m));
		System.out.println("Length of Longest Repeating Subsequence is " +
				LRSLength(X, m-1, m-1, memo));
	}

	//wkg
	public static int LRSLength(String X, int m, int n) {
		if (m == 0 || n == 0) {									// return if we have reached the end of either string
			return 0;
		}
		int c3 =0;
		if (X.charAt(m-1) == X.charAt(n-1) && m != n) {			// if characters at index m and n matches and index is different
			c3= LRSLength(X, m-1, n-1) + 1;
		}
		
		int c1 =LRSLength(X, m, n-1); 
		int c2 =LRSLength(X, m-1, n);

		// else if characters at index m and n don't match
		return Integer.max(c3,Integer.max(c1,c2));
	}
	
	//Memo - not wkg
	public static int LRSLength(String X, int m, int n, int[][] memo) {
		// return if we have reached the end of either string
		if (m == 0 || n == 0) {
			return 0;
		}

		int c1 =0, c2=0;
		if(memo[m][n] == 0) {
			// if characters at index m and n matches and index is different
			if (X.charAt(m - 1) == X.charAt(n - 1) && m != n) {
				c1 = 1 + LRSLength(X, m - 1, n - 1);
			} else {
				c2 = Integer.max(LRSLength(X, m, n - 1), LRSLength(X, m - 1, n));  // else if characters at index m and n don't match
			}
			
			memo[m][n] = Math.max(c1, c2);
		}
		return memo[m][n];
	}

}
