package Problem_Solving.SlidingWindow;

import java.util.Arrays;

public class FreqOfMostFrequentElement {

	public static void main(String[] args) {
		int nums[] = {1,2,4}, k = 5;
		maxFrequency(nums, k);
	}

	public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);  
        long currSum = 0;    
		int left = 0, res = 1, right = 0;

		while(right < nums.length) {		// target = right 
			currSum += nums[right];
			long targetSum = (long) (right-left+1) * nums[right];
			long noOfOperarions = targetSum - currSum;
			
			// While window is invalid, shrink from left
			while (noOfOperarions > k && left < right) {
				currSum -= nums[left];
				left++;
				targetSum = (long) (right - left + 1) * nums[right];
				noOfOperarions = targetSum - currSum;
			}
			res = Math.max(res, right-left+1);
            right++;
		}
		return res;
    }

}
