package Problem_Solving.Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public int largestRectangleArea(int[] heights) {
		Stack<Integer> st = new Stack<>();
		int[] nsl = new int[heights.length];
		int[] nsr = new int[heights.length];
		int[] width = new int[heights.length];
		int len = heights.length;

		for(int i=0; i<heights.length; i++) {
			while(!st.isEmpty() && heights[st.peek()] >= heights[i])
				st.pop();
			if(st.isEmpty())
				nsl[i] = -1;
			else 
				nsl[i] = st.peek();
			st.push(i);
		}
		
		st = new Stack<>();
		for(int i=heights.length-1; i >= 0; i--) {
			while(!st.isEmpty() && heights[st.peek()] >= heights[i])
				st.pop();
			if(st.isEmpty())
				nsr[i] = len;
			else 
				nsr[i] = st.peek();
			st.push(i);
		}

		int max = 0;
		for(int i=0; i<heights.length; i++) {
			width[i] = (nsr[i] - nsl[i] - 1) * heights[i];
			max = Math.max(max, width[i]);
		}
		return max;
	}
}
