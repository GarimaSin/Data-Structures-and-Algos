package Problem_Solving.String;

import java.util.Stack;

public class ValidParanthesisString {

	public boolean checkValidString(String s) {
		Stack<Integer> open = new Stack<>();
		Stack<Integer> star = new Stack<>();
		int len = s.length();

		for(int i=0; i<len; i++) {
			if(s.charAt(i) == '(')
					open.push(i);
			else if(s.charAt(i) == '*')
				star.push(i);
			else {
				if(!open.empty())
					open.pop();
				else if(!star.empty())
					star.pop();
				else
					return false;
			}
		}

		//Now process leftover opening brackets
		while(!open.empty()) {
			if(star.empty())
				return false;
			else if(open.peek() < star.peek()) {
				open.pop();
				star.pop();
			}
			else    //CASE: open.top() > star.top() = *(
				return false;
		}
		return true;
	}
}
