package Problem_Solving.Stack;

import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {
		String[] tokens = {"4","13","5","/","+"};
		int ans = evalRPN(tokens);
		System.out.println(ans);
	}
	
	public static int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        int ans = 0;
         for(int i = 0; i < tokens.length; i++){
             String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int i2 = Integer.parseInt(st.pop());
                int i1 = Integer.parseInt(st.pop());
                if(s.equals("+")) {
                    ans = i1+i2;
                    st.push(ans+"");
                } else if(s.equals("-")) {
                    ans = i1-i2;
                    st.push(ans+"");
                } else if(s.equals("*")) {
                    ans = i1*i2;
                    st.push(ans+"");
                } else if(s.equals("/")) {
                    ans = i1/i2;
                    st.push(ans+"");
                }
            }
            else {
                st.push(s);
            }  
         }
        return Integer.parseInt(st.pop());
    }
}
