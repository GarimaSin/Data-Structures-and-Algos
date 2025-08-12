package Problem_Solving.Stack;

import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {
		System.out.println(isValid("(]"));
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			char newChar = chars[i];
			if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
				stack.push(chars[i]);
			} else {
				if (newChar == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') 
						stack.pop();
					else
						return false;

				} else if (newChar == '}') {
					if (!stack.isEmpty() && stack.peek() == '{') 
						stack.pop();
					else
						return false;
				} else if (newChar == ']') {
					if (!stack.isEmpty() && stack.peek() == '[') 
						stack.pop();
					else
						return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
