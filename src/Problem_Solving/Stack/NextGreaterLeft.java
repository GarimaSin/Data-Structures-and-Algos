package Problem_Solving.Stack;

import java.util.Stack;

public class NextGreaterLeft {
	public static int[] nextGreaterElement(int[] nums) {
		Stack<Integer> st = new Stack<>();
		int len = nums.length;
		int ngl[] = new int[len];
		
		for(int i=0; i<nums.length; i++) {
			while(!st.isEmpty() && st.peek()<nums[i]) {
				st.pop();
			}
			if(st.isEmpty())
				ngl[i] = -1;
			else
				ngl[i] = st.peek();
			st.push(nums[i]);
		}
		return ngl;
	}

	public static void main(String[] args) {
		int nums2[] = {6, 8, 0, 1, 3};
		int ans[] = nextGreaterElement(nums2);
		for(int i: ans)
			System.out.print(i + " ");
	}
}