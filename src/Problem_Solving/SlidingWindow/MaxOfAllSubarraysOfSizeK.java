package Problem_Solving.SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class MaxOfAllSubarraysOfSizeK {

	public static void main(String[] args) {
		int[] nums = {8,5,10,7,9,4,15,12,90,13};
		int k = 4; 
		int[] ans = maxSlidingWindow(nums, k);
		for(int i: ans)
			System.out.print(i+"  ");
	}


	//Working
	public static int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> Qi = new LinkedList<Integer>();
        int[] ans = new int[nums.length-k+1];
		int count = 0;
        int start = 0, end = 0;
        
        while(end < nums.length) {
            while ((!Qi.isEmpty()) && nums[end] >= nums[Qi.peekLast()])
				Qi.removeLast();
			Qi.addLast(end);
            
            if(end >= k-1) {
                ans[count] = nums[Qi.peek()];
                count++;
                while ((!Qi.isEmpty()) && Qi.peek() <= start)			
                    Qi.removeFirst();
                start++;
            }
            end++;
        }
        return ans;
	}


	//Working
	static int[] max_of_subarrays(int nums[], int n, int k) {
		Deque<Integer> Qi = new LinkedList<Integer>();
        int[] ans = new int[nums.length-k+1];
		int count = 0;

		int i;
		for (i = 0; i < k; ++i) {
			while (!Qi.isEmpty() && nums[i] >=	nums[Qi.peekLast()]) {
				Qi.removeLast();
			}
			Qi.addLast(i);			
		}

		
		for (; i < nums.length; ++i) {
            ans[count] = nums[Qi.peek()];
            count++;
			while ((!Qi.isEmpty()) && Qi.peek() <= i - k)			
				Qi.removeFirst();
			while ((!Qi.isEmpty()) && nums[i] >= nums[Qi.peekLast()])
				Qi.removeLast();
			Qi.addLast(i);
		}
        ans[count] = nums[Qi.peek()];
        return ans;
	}
}
