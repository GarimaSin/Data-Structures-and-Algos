package Problem_Solving.Leetcode.Backtracking;

/**
 * 
 * Write a program to print all the combinations of factors of given number n.
Examples: 

Input : 16
Output :2 2 2 2 
        2 2 4 
        2 8 
        4 4 
 *
 */

public class FactorCombination {

	public static void main(String[] args) {
		findFactorCombs(16, "", 16, 2);
	}
	
	static void findFactorCombs(int n, String ans, int inp, int start) {
		if(n==1) {
			System.out.println(ans);
			return;
		}
		if(n < 1)
			return;
		
		for(int i=start; i<=inp/2; i++) {
			if(n%i == 0) {
				n = n/i;
				findFactorCombs(n, ans+i, inp, i);
				n = n*i;
			}
		}
	}
}
