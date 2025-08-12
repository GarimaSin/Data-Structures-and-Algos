package Problem_Solving.Stack;

//Java program to sort a Stack using recursion
//Note that here predefined Stack class is used
//for stack operation

import java.util.ListIterator;
import java.util.Stack;

public class SortAStackUsingRecursion {
	
	static void sortedInsert(Stack<Integer> s, int x) {
		if (s.isEmpty() || x > s.peek()) {
			s.push(x);
			return;
		}

		// If top is greater, remove the top item and recur
		int temp = s.pop();
		sortedInsert(s, x);

		// Put back the top item removed earlier
		s.push(temp);
	}

	static void sortStack(Stack<Integer> s) {
		if (!s.isEmpty()) {
			int x = s.pop();

			sortStack(s);

			sortedInsert(s, x);
		}
	}

	static void printStack(Stack<Integer> s) {
		ListIterator<Integer> lt = s.listIterator();

		// forwarding
		while (lt.hasNext())
			lt.next();

		// printing from top to bottom
		while (lt.hasPrevious())
			System.out.print(lt.previous() + " ");
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(30);
		s.push(-5);
		s.push(18);
		s.push(14);
		s.push(-3);

		System.out.println(
			"Stack elements before sorting: ");
		printStack(s);

//		sortStack(s);

		System.out.println(
			" \n\nStack elements after sorting:");
		printStack(s);
	}
}
