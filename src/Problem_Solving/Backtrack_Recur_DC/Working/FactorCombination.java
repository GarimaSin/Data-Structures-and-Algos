package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Write a function that takes an integer n and return all possible combinations of its factors.
		Note: 
		Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
		You may assume that n is always positive.
		Factors should be greater than 1 and less than n.
		input: 32
		output:
		[
		  [2, 16],
		  [2, 2, 8],
		  [2, 2, 2, 4],
		  [2, 2, 2, 2, 2],
		  [2, 4, 4],
		  [4, 8]
		]
 *
 */

public class FactorCombination {

	static int factors[];
	public static void main(String[] args) {
		FactorCombination facCom = new FactorCombination();
		int n = 32;
		factors = new int[n];
		List<List<Integer>> result = facCom.getFactors(n);
//		facCom.getFactors(n, factors, 0);
		for(int i=0; i<result.size(); i++) {
			for(int j=0; j<result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		helper(2, 1, n, result, list);
		return result;
	}

	public void helper(int start, int product, int n, List<List<Integer>> result, List<Integer> curr){
		if(start>n || product > n )
			return ;

		if(product==n) {
			ArrayList<Integer> t = new ArrayList<Integer>(curr);
			result.add(t);
			return;
		}   

		for(int i=start; i<n; i++){			//can be optimized by taking the loop from 1 to n/2s
			if(i*product>n)
				break;

			if(n%i==0){
				curr.add(i);
				helper(i, i*product, n, result, curr);
				curr.remove(curr.size()-1);
			}
		}
	}


//	public void getFactors(int n, int[] factors, int count) { 
//		if(n <= 1) 
//			return ;
//
//		for(int i=2; i<=Math.sqrt(n); i++) { 
//			if(n%i == 0) { 
//				factors[count] = i;
//				count++; // getFactors(i, factors, count); 
//				factors[count] = n/i; 
//				count++;
//				if(n/i != n && i > 3) 
//					getFactors(n/i, factors, count); 
//			} 
//		} 
//	}


}
