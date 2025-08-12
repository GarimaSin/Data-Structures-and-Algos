package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class InvalidParenthesis {

	public static void getParenthesis(String str, int minRemoval, HashSet<String> ans) {
		if(minRemoval == 0) {
			int count = getMin(str);
			if(count ==0) {
				if(!ans.contains(str)) {
//					System.out.println(str);
					ans.add(str);
				}
			}
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String left = str.substring(0,i);			
			String right = str.substring(i+1);					//char removed b/w left and right 
			getParenthesis(left+right, minRemoval-1, ans);			//removed 1 char
		}
	}

	public static int getMin(String str){
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(') {
				st.push(ch);
			} else if(ch == ')') {
				if(st.size() == 0)
					st.push(ch);
				else if(st.peek() == ')') {
					st.push(ch);
				} else if(st.peek() == '(')
					st.pop();
			}
		}
		return st.size();
	}

	public static void main(String[] args) {
		String str = "()((((((()l(";
		HashSet<String> ans = new HashSet<String>();
		getParenthesis(str, getMin(str), ans);
		LinkedList<String> res = new LinkedList<String>();
		for(String s: ans)
			res.add(s);
		System.out.println(res);
	}
}
