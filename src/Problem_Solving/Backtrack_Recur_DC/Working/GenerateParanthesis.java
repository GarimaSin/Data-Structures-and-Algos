package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.List;

/** 
 * Impose a condition where 1 element cannot be > than other
 * **/
public class GenerateParanthesis {

//}
	public static void main(String[] args) {
		GenerateParanthesis g = new GenerateParanthesis();
		g.generateParenthesis(3);
	}

//class Solution {
    private List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            System.out.print(cur +" ");
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)													// check this
            backtrack(ans, cur+")", open, close+1, max);
    }
}