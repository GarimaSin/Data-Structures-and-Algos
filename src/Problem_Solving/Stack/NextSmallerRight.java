package Problem_Solving.Stack;

import java.util.Stack;

public class NextSmallerRight {

	public static int[] nextSmallerElement(int[] nums) {
		Stack<Integer> st = new Stack<>();
		int len = nums.length;
		int nsr[] = new int[len];
		
		for(int i=len-1; i>= 0; i--) {
			while(!st.isEmpty() && st.peek()>nums[i]) {
				st.pop();
			}
			if(st.isEmpty())
				nsr[i] = -1;
			else
				nsr[i] = st.peek();
			st.push(nums[i]);
		}
		return nsr;
	}

	public static void main(String[] args) {
		int nums[] = {6, 8, 0, 1, 3};
		int ans[] = nextSmallerElement(nums);
		for(int i: ans)
			System.out.print(i+" ");
	}
}
