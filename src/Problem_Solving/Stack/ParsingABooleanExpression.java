package Problem_Solving.Stack;

import java.util.Stack;

public class ParsingABooleanExpression {

	public static void main(String[] args) {
		System.out.println(parseBoolExpr("!(&(!(&(f)),&(t),|(f,f,t)))"));
	}

	public static boolean parseBoolExpr(String expression) {
        Stack<String> operands = new Stack<>();
        Stack<String> operator = new Stack<>();
        
        for(String s: expression.split("")) {
        	if(s.equals(","))
        		continue;
        	
        	if(s.equals("!") || s.equals("&") || s.equals("|")) {
        		operator.push(s);
        		continue;
        	}
        	
        	if(s.equals(")")) {
        		String first = operands.pop();
        		if(operands.peek().equals("(")) {
        			s = evaluate(first, null, operator.peek());
        		}
        		else {
        			while(!operands.isEmpty() && !operands.peek().equals("(")) {
            			String sec = operands.pop();
            			first = evaluate(first, sec, operator.peek()) ;
            		}
            		s = first;
        		}
        		operator.pop();
        		operands.pop();
        	}
        	operands.push(s);
        }
        return getBooleanVal(operands.peek());
    }
	
	
	static boolean getBooleanVal(String s) {
		return s.equals("t") ? true : false;
	}
	
	static String getStringVal(boolean s) {
		return s == true ? "t" : "f";
	}


	static String evaluate(String first, String sec, String lastOperator) {
		if(sec == null) {
			if(lastOperator.equals("!"))
				return getStringVal(!getBooleanVal(first));
			return first;
		}
		if(lastOperator.equals("&"))
			return getStringVal(getBooleanVal(first) & getBooleanVal(sec));
		if(lastOperator.equals("|"))
			return getStringVal(getBooleanVal(first) | getBooleanVal(sec));
		return null;
	}
}
