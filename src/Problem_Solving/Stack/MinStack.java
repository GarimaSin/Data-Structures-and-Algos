package Problem_Solving.Stack;

import java.util.Stack;

public class MinStack {
	Stack<Integer> min;
	Stack<Integer> st;

	public MinStack() {
		st = new Stack<>();
		min = new Stack<>();
	}

	public void push(int val) {
		st.push(val);
		if(min.isEmpty() || min.peek() >= val)
			min.push(val);
		return;
	}

	public void pop() {
		if(st.size() == 0)
			return;
		int top = st.peek();
		st.pop();
		if(min.peek() == top)
			min.pop();
	}

	public int top() {
		return st.peek();
	}

	public int getMin() {
		return min.peek();
	}

	public static void main(String[] args) {
		MinStack minst = new MinStack();
		minst.push(-2);
		minst.push(0);
		minst.push(-3);
		System.out.println(minst.getMin());
		minst.pop();
		System.out.println(minst.top());
		System.out.println(minst.getMin());
	}
}