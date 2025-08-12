package Problem_Solving.Stack;

import java.util.Stack;

public class DecodeString {

	public static String decodeString(String str) {
		Stack<Character> stack = new Stack<>();
		String result = "";

		// Traversing the string
		for (int k = 0; k < str.length(); k++)  {

			if (str.charAt(k) == ']')   {
				String tmp = "";
				while(stack.peek() != '[') {
					tmp = stack.pop() + tmp ;
				}

				stack.pop();

				String num = "";
				while(!stack.isEmpty() && Character.isDigit(stack.peek())) {		//for multiple digit nos.
					num = stack.pop() + num;
				}
				
				if(num != "") {
					int n = Integer.parseInt(num);
					String tmpVal = tmp;
					for (int i = 1; i < n; i++)  {
						tmp = tmp + tmpVal;
					}
				}

				char[] temp = tmp.toCharArray();
				for (int i = 0; i < tmp.length(); i++)  {  
					stack.push(temp[i]);
				} 

			}
			else {
				stack.push(str.charAt(k));
			}
		}

		while(!stack.isEmpty()) {
			result =  stack.pop() + result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(decodeString("10[s-]"));
	}
}
