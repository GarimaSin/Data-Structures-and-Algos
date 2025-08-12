package InterviewExperience.Microsoft;

import java.util.Stack;

public class LongestValidParanthesisSubstring {

	public static void main(String[] args) {
		//		String str = "((()()";
		//		String str = "()())((((())))";
		//		str = "()(()))))";

		String str = "()((())()";
		//		String str = ")()())";
//		System.out.println(getLongestSubstring(str));

//		str = "()())((((())))";
//		System.out.println(findMaxLen(str));
		str = "())";
		System.out.println(findMaxLen(str));
	}

	// Working
	static int findMaxLen(String str)	{
		int n = str.length();
		// Create a stack and push -1 as initial index to it.
		Stack<Integer> stk = new Stack<>();
		stk.push(-1);
		int result = 0;
		for (int i = 0; i < n; i++)	{
			if (str.charAt(i) == '(')
				stk.push(i);
			
			else	{
				// Pop the previous opening bracket's index
				if(!stk.empty())
					stk.pop();
				// Check if this len formed with base of current valid substring is more than max so far
				if (!stk.empty())
					result = Math.max(result, i - stk.peek());
				// If stack is empty. push current index as base for next valid substring (if any)
				else
					stk.push(i);
			}
		}
		return result;
	}

	// Working
	private static int getLongestSubstring(String inp) {
		int max = 0;
		int len = inp.length();
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < inp.length(); i++) {
			if(inp.charAt(i) == '(') 
				st.push(i);
			else {
				if(!st.isEmpty() && inp.charAt(st.peek()) == '(')
					st.pop();
				else
					st.push(i);
			}
		}

		if(st.size() == 0)
			return inp.length();

		if(st.size() == 1 && st.peek() != 0) {
			max = Math.max(max, st.peek());						// for case = )()
			max = Math.max(max, inp.length() - st.pop()-1);		// for case = ())
			return max;
		}

		int prev = 0;
		if(st.peek() != len-1)
			prev = len;
		else
			prev = st.pop();

		while(!st.isEmpty()) {
			int l = st.pop();
			max = Math.max(max, prev-l-1);
			prev = l;
		}
		if(prev != 0)
			max = Math.max(max, prev);
		return max;
	}
}