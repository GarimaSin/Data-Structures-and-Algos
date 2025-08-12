package Problem_Solving.DP;

import java.util.Arrays;
import java.util.HashMap;

public class TargetSum {

	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1};
		int target = 3;
		System.out.println("__________________");
//		findSum(nums, 1, 0, 0);
//		System.out.println(count);
		System.out.println(findTargetSumWays(nums, target));
	}

	static int count = 0;
	static void findSum(int[] nums, int target, int idx, int sum) {
		if(idx == nums.length) {
            if (sum == target) 
                count++;
			return;
		}

		findSum(nums, target, idx+1, sum+nums[idx]);
		findSum(nums, target, idx+1, sum-nums[idx]);
	}
	
	
	// Working
	public static int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 0)
            return 0;

        int dp[][] = new int[nums.length+1][target+1];
        for(int i[]: dp)
            Arrays.fill(i, -1);
        int ans = countWays(nums, target, 0, 0, dp);
        return ans;
    }

	
    public static int countWays(int[] nums, int target, int sum, int idx, int[][] dp) {
        if(idx > nums.length)
            return 0;
        
        if(idx == nums.length) {
            if(sum == target)
                return 1;
            return 0;
        }

        int i1 = countWays(nums, target, sum+nums[idx], idx+1, dp);
        int i2 = countWays(nums, target, sum-nums[idx], idx+1, dp);
        return i1+i2;
    }
    
    
    // Working
    public int findTargetSumWays1(int[] nums, int target) {
        if(nums.length == 0)
            return 0;

        HashMap<String, Integer> map = new HashMap<>();
        int ans = countWays(nums, target, 0, 0, map);
        return ans;
    }

    public int countWays(int[] nums, int target, int sum, int idx, HashMap<String, Integer> map) {
        if(idx > nums.length)
            return 0;
        
        if(idx == nums.length) {
            if(sum == target)
                return 1;
            return 0;
        }

        String key = idx+","+sum;
        if(map.get(key) != null)
            return map.get(key);

        int i1 = countWays(nums, target, sum+nums[idx], idx+1, map);
        int i2 = countWays(nums, target, sum-nums[idx], idx+1, map);
        int tmp = i1+i2;
        map.put(key, tmp);
        return tmp;
    }
}