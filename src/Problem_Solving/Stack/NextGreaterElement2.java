package Problem_Solving.Stack;

import java.util.Stack;

public class NextGreaterElement2 {

	public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
		int len = nums.length;
		int ngr[] = new int[len];
        findNGE(nums, st, ngr);
        ngr = new int[len];			// this doesnt effect
        findNGE(nums, st, ngr);
		return ngr;
    }
    
    static void findNGE(int[] nums, Stack<Integer> st, int[] ngr) {
        for(int i=nums.length-1; i>= 0; i--) {
            while(!st.isEmpty() && st.peek()<=nums[i]) 
                st.pop();

            if(st.isEmpty())
                ngr[i] = -1;
            else
                ngr[i] = st.peek();
            st.push(nums[i]);
		}
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,2,3,4,3};
    	int ans[] = nextGreaterElements(nums);
    	for(int i: ans)
    		System.out.print(i + " ");
	}
}
