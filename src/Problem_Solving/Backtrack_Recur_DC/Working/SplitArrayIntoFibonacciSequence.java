package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Easy and understandable code - SplitArrayIntoFibonacciSequence_Slower
 *
 */
public class SplitArrayIntoFibonacciSequence {

	boolean isPossible = false;
	public static void main(String[] args) {
		SplitArrayIntoFibonacciSequence split = new SplitArrayIntoFibonacciSequence();
		String s = "112358130";
		List<Integer> answer = split.splitIntoFibonacci(s);
		for(int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}


	int max = Integer.MAX_VALUE;
	private List<Integer> splitIntoFibonacci(String S) {

		List<Integer> res = new ArrayList<>();
		for (int d = 1; d < S.length(); d++) {
			if (S.charAt(0) == '0' && d > 1) break;
			long num1 = Long.parseLong(S.substring(0, d));
			if (num1 > max) break;

			// add the first value
			res.add((int)num1);
			for (int i = d; i < S.length(); i++) {
				if (S.charAt(d) == '0' && i > d) break;
				long num2 = Long.parseLong(S.substring(d, i+1));
				if (num2 > max) break;

				//add the second value
				res.add((int)num2);
				if (dfs(S, i+1, (int)num1, (int)num2, res)) {
					return res;
				}
				res.remove(1);
			}
			res.remove(0);
		}
		return res;
	}

	private boolean dfs(String s, int k, int num1, int num2, List<Integer> res) {
		if (k == s.length()) {
			if (res.size() > 2)
				return true;
			else 
				return false;
		}

		for (int i = k; i < s.length(); i++) {

			if (s.charAt(k) == '0' && i > k) break;
			long tmp = Long.parseLong(s.substring(k, i+1));
			if (tmp > max) return false;

			// value equals the sum of last two values
			if (tmp == num1+num2) {
				res.add((int)tmp);
				if (dfs(s, i+1, (int)num2, (int)tmp, res)) return true;
				res.remove(res.size()-1);
			} else if (tmp > num1+num2) return false;
		}
		return false;
	}
}




//public List<Integer> splitIntoFibonacci(String s) {
//	SplitFibonacci(s);
//	System.out.println(isPossible);
//	return null;
//}
//
//public void SplitFibonacci(String inp) {
//	int limit = inp.length()/3;
//	for(int j=1; j<=limit; j++) {
//		String one = inp.substring(0, j);
//		String two = inp.substring(j, j+j);
//		//			String three = inp.substring(j+j, j+j+j);
//		int f1 = Integer.parseInt(one);
//		int f2 = Integer.parseInt(two);
//		int f3 = f1+f2;
//		String res = new Integer(f3).toString();
//		int resLen = res.length();
//		if(inp.substring(j+j, j+j+resLen).equals(res))
//			if (findFibSequence(f2, f3, j+j+resLen, inp))
//				break;
//		else 
//			continue;
//		System.out.println("1 = "+one+", 2 = "+two);
//	}
//}
//
//private boolean findFibSequence(int f1, int f2, int index, String inp) {
//	if(index >= inp.length()) {
//		isPossible = true;
//		return true;
//	}
//	
//	int f3 = f1+f2;
//	String res = new Integer(f3).toString();
//	int resLen = res.length();
//	if(index+resLen >= inp.length()) 
//		return false;
//	if(inp.substring(index, index+resLen).equals(res))
//		findFibSequence(f2, f3, index+resLen, inp);
//	else
//		return false;
//	
//	return false;
//}