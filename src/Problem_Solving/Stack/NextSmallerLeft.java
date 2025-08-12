package Problem_Solving.Stack;

import java.util.Stack;

public class NextSmallerLeft {

	public static int[] nextSmallerElement(int[] nums) {
		Stack<Integer> st = new Stack<>();
		int len = nums.length;
		int nsl[] = new int[len];
		
		for(int i=0; i<nums.length; i++) {
			while(!st.isEmpty() && st.peek()>nums[i]) {
				st.pop();
			}
			if(st.isEmpty())
				nsl[i] = -1;
			else
				nsl[i] = st.peek();
			st.push(nums[i]);
		}
		return nsl;
	}

	public static void main(String[] args) {
		int nums[] = {18, 19, 29, 15, 16};
		int ans[] = nextSmallerElement(nums);
		for(int i: ans)
			System.out.print(i+" ");
	}
}
