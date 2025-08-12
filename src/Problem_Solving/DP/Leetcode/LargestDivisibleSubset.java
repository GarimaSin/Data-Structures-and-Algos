package Problem_Solving.DP.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

	public static void main(String[] args) {
		int nums[] = {3,4,16,8};
		List<Integer> list = largestDivisibleSubset(nums);
		for(int i: list)
			System.out.print(i+" ");
	}
	
	//Working
	public static List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
        return largestDivisibleSubset(nums, 0, -1);
    }
	
	
	public static List<Integer> largestDivisibleSubset(int[] nums, int i, int prev) {
        if(i == nums.length)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        if (prev == -1 || nums[i]%nums[prev] == 0 || nums[prev]%nums[i] == 0) {
        	ans = largestDivisibleSubset(nums, i+1, i);
        	ans.add(nums[i]);
        }
        List<Integer> notTaken = largestDivisibleSubset(nums, i+1, prev);
    	if(ans.size() < notTaken.size()) 
    		ans = notTaken;
   
        return ans;
    }
	
	
	//Working
	public List<Integer> largestDivisibleSubsetMemo(int[] nums) {
        Arrays.sort(nums);
        List<Integer>[][] dp = new ArrayList[nums.length][nums.length];
        return largestDivisibleSubset(nums, 0, -1, dp);
    }

    public List<Integer> largestDivisibleSubset(int[] nums, int i, int prev, List<Integer>[][] dp) {
        if(i == nums.length)
            return new ArrayList<>();

        if(dp[i][prev+1] == null) {
            List<Integer> take = new ArrayList<>();
            if (prev == -1 || nums[i]%nums[prev] == 0 || nums[prev]%nums[i] == 0) {
                take = largestDivisibleSubset(nums, i+1, i, dp);
                take = new ArrayList<>(take);							// Create a new copy
                take.add(nums[i]);
            }
            List<Integer> notTake = largestDivisibleSubset(nums, i+1, prev, dp);    
            List<Integer> ans = take.size()>notTake.size() ? take : new ArrayList<>(notTake);	// Create a new copy
            dp[i][prev+1] = ans;
        }
        return new ArrayList<>(dp[i][prev + 1]);		// Return a new copy
    }

}
