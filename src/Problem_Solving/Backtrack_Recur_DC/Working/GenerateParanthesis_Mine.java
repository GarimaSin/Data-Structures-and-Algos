package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Time = O(2^n)
 *
 */
public class GenerateParanthesis_Mine {

	public static void main(String[] args) {
		GenerateParanthesis_Mine g = new GenerateParanthesis_Mine();
		List<String> ans = g.generateParenthesis(3);
		for(int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i)+" ");
		}
	}

//class Solution {
    private List<String> generateParenthesis(int n) {
        List<String> ans = backtrack(new ArrayList<String>(), "", 0, 0, n);
        return ans;
    }

	private List<String> backtrack(List<String> ans, String string, int open, int close, int n) {
		if(string.length() > n*2) {
			return null;
		}
		if(close > n || open > n || close>open)
			return null;
		if(string.length() == n*2) {
			ans.add(string);
//			System.out.println(string);
		}
		backtrack(ans, string+ "(", open+1, close, n);
		backtrack(ans, string+ ")", open, close+1, n);
		return ans;
	}

	//better sol
	void backtrack(List<String> res, int open, int close, String cur, int k){
        if( cur.length() == k * 2 ){
            res.add(cur);
            return;
        }
        
        if( open < k ) backtrack(res, open+1, close, cur+"(", k);
        if( close < open ) backtrack(res, open, close+1, cur+")", k);
    }
}
