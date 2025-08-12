package Problem_Solving.Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

	public static void main(String[] args) {
		String num = "123";
		int target = 6;
		addOperators(num, target);
		System.out.println(res);
	}
	
	public static List<String> res = new ArrayList<>();
    public static List<String> addOperators(String num, int target) {
        backtracking(num, 0, target, "", 0, 0);
        return res;
    }
    
    public static void backtracking(String num, int ind, long target, String temp, long tot, long pre) {
        if (ind == num.length() && tot == target) {
            res.add(temp);
            return;
        }
        long cur = 0;
        
        for (int end = ind; end < num.length(); end++) {
            if (end > ind && num.charAt(ind) == '0') 
            	return;
            cur = cur * 10 + num.charAt(end) - '0';
            String sub = num.substring(ind, end + 1);
            if (ind == 0) {
                backtracking(num, end + 1, target, sub, cur, cur);
                continue;
            }
            backtracking(num, end + 1, target, temp + "+" + sub, tot + cur, cur);
            backtracking(num, end + 1, target, temp + "-" + sub, tot - cur, -cur);
            backtracking(num, end + 1, target, temp + "*" + sub, tot - pre + (cur * pre), cur * pre);
        }
    }
}