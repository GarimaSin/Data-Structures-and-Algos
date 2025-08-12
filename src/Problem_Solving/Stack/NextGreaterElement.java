package Problem_Solving.Stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Stack<Integer> st = new Stack<>();
		int len = nums2.length;
		int ngr[] = new int[len];
        int ans[] = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        
		for(int i=len-1; i>= 0; i--) {
            while(!st.isEmpty() && st.peek()<nums2[i]) 
                st.pop();

            if(st.isEmpty())
                ngr[i] = -1;
            else
                ngr[i] = st.peek();
            map.put(nums2[i], ngr[i]);
            st.push(nums2[i]);
		}
        
        for(int i=0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])) {
                ans[i] = map.get(nums1[i]);
            }
        }
		return ans;
	}

	public static void main(String[] args) {
		int nums1[] = {4,1,2}, nums2[] = {1,3,4,2};
		nextGreaterElement(nums1, nums2);
	}
}
