package Problem_Solving.Stack;

import java.util.Stack;

public class NextGreaterRight {

	public static int[] nextGreaterElement(int[] nums) {
		Stack<Integer> st = new Stack<>();
		int len = nums.length;
		int ngr[] = new int[len];
		
		for(int i=len-1; i>= 0; i--) {
			while(!st.isEmpty() && st.peek()<nums[i]) {
				st.pop();
			}
			if(st.isEmpty())
				ngr[i] = -1;
			else
				ngr[i] = st.peek();
			st.push(nums[i]);
		}
		return ngr;
	}
	
	//Code for Daily temperatures, LC - 739
	public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
		int len = temperatures.length;
		int ngr[] = new int[len];
		
		for(int i=len-1; i>= 0; i--) {
			while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
				st.pop();
			}
			if(st.isEmpty())
				ngr[i] = 0;
			else
				ngr[i] = st.peek()-i;
			st.push(i);
		}
		return ngr;
    }

	public static void main(String[] args) {
		int nums[] = {6, 8, 0, 1, 3};
		int ans[] = nextGreaterElement(nums);
		for(int i: ans) {
			System.out.print(i + " ");
		}
	}
}
