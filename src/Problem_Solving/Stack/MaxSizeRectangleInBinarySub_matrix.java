package Problem_Solving.Stack;

import java.util.Stack;

public class MaxSizeRectangleInBinarySub_matrix {

	public static int maximalRectangle(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		if(m==1 && n==1 && matrix[0][0]==1) 
			return 1;

		int[] heights = new int[n];
		int area =0;

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j]==1)
					heights[j]++;
				else
					heights[j]=0;
			}
			area = Math.max(area, largestRectangleArea(heights));
		}
		return area;
	}

	public static int largestRectangleArea(int[] heights) {
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

	public static void main(String[] args)	{
		int R = 4;
		int C = 4;

		int A[][] = {{0, 1, 1, 0},
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{1, 1, 0, 0}};
		System.out.print("Area of maximum rectangle is "
				+ maximalRectangle(A));
	}
}