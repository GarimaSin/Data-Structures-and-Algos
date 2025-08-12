package Problem_Solving.Recursion;

import java.util.ArrayList;
import java.util.List;

// LC - 241. Different Ways to Add Parentheses
public class DiffWaysToAddParanthesis {

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (isOperator(c)) {

				String a = input.substring(0, i);
				String b = input.substring(i+1);

				List<Integer> left = diffWaysToCompute(a);
				List<Integer> right = diffWaysToCompute(b);

				for (int num1 : left) {
					for (int num2 : right) {
						int val = calculate(num1, num2, c);
						result.add(val);
					}
				}
			}
		}

		// only contains one number
		if (result.isEmpty()) {
			result.add(Integer.parseInt(input));
		}

		return result;
	}

	private int calculate(int num1, int num2, char operator) {
		int result = 0;

		switch(operator) {
		case '+' : result = num1 + num2;
		break;

		case '-' : result = num1 - num2;
		break;

		case '*' : result = num1 * num2;
		break;
		}
		return result;
	}
	private boolean isOperator(char operator) {
		return (operator == '+') || (operator == '-') || (operator == '*');
	}
}
