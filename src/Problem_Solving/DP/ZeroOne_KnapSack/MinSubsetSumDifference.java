package Problem_Solving.DP.ZeroOne_KnapSack;

import java.util.Arrays;
import java.util.HashMap;

public class MinSubsetSumDifference {

	// Partition nums[] of size 2n into two arrays of length n 
	// to minimize the absolute diff of the sums of the arrays.
	// LC - 2035

	public static int minimumDifference(int[] nums) {
		int sum = 0;
		int MIN = 999999;
		for(int i=0; i<nums.length; i++) {
			sum = sum + nums[i];
			MIN = Math.min(MIN, nums[i]);
		}

		HashMap<String, Integer> map = new HashMap<>();
		int len = nums.length/2;
		int min = dfs(nums, 0, 0, 0, sum, len, map);  
        if(min == 999999)
            return -1;
        return min;
//	    return createPartition(nums, 0, 0, sum, 0, 0, 0, map);
//		return createPartition1(nums, 0, sum, 0, 0, map);
	}
	
	public static int createPartition1(int[] nums, int ss1, int totSum, int idx, int l1, HashMap<String, Integer> map) {
		if(idx > nums.length || l1 > nums.length)
			return 999999;

//		if(idx == nums.length) {
			if(l1 > nums.length/2 || l1 < nums.length/2)
				return 999999;
		
		String key = idx+","+ss1;
		if(map.get(key) != null)
			return map.get(key);
		
		int diff = Math.abs((totSum-ss1)-ss1);

		int d1 = createPartition1(nums, ss1+nums[idx], totSum, idx+1, l1+1, map);
		int d2 = createPartition1(nums, ss1, totSum, idx+1, l1, map);

		int tmp = Math.min(d1, d2);
		map.put(key,tmp);
		return tmp;
	}

	// Working but TLE
	public static int dfs(int[] nums, int idx, int l1, int sum, int target, int len, HashMap<String, Integer> map) {
		if(l1 >= len) 
			return Math.abs(target - 2*sum);

         String key = idx+","+sum;
         if(map.get(key) != null)
             return map.get(key);

        int min = 999999;	
		for(int i=idx; i<nums.length; i++) {
			int tmp = dfs(nums, i+1, l1+1, sum+nums[i], target, len, map);
            min = Math.min(min, tmp);
		}
		map.put(key, min);
        return min;
	}


	// Working but TLE
	public static int createPartition(int[] nums, int ss1, int ss2, int diff, int idx, int l1, int l2, HashMap<String, Integer> map) {
		if(idx > nums.length || l1 > nums.length/2 || l2 > nums.length/2)
			return 999999;

		if(idx == nums.length) {
			if(ss1 == 0 || ss2 == 0)
				return 999999;
			return Math.abs(ss1-ss2);
		}

		String key = idx+","+ss1;
		if(map.get(key) != null)
			return map.get(key);

		int d1 = createPartition(nums, ss1+nums[idx], ss2, diff, idx+1, l1+1, l2, map);
		int d2 = createPartition(nums, ss1, ss2+nums[idx], diff, idx+1, l1, l2+1, map);

		int tmp = Math.min(d1, d2);
		map.put(key,tmp);
		return tmp;
	}
	
	
	// Working - No TLE
	public int minimumDifference1(int[] nums) {
        int n = nums.length;
        if (n == 2) 
        	return Math.abs(nums[1] - nums[0]);  
        
        int[][] lists1 = generate(Arrays.copyOfRange(nums, 0, n/2));
        int[][] lists2 = generate(Arrays.copyOfRange(nums, n/2, n));
        int ans = Integer.MAX_VALUE;
        
        for (int d=0; d <= n/2; d++) {
            int[] arr1 = lists1[d], arr2 = lists2[d];
            int k = arr1.length;
            int i1 = 0, i2 = 0; // v use 2 pointers to find 2 elements in arr1, arr2 with min absolute diff.
            while (i1 < k && i2 < k) {
                int diff = arr1[i1] - arr2[i2];
                ans = Math.min(ans, Math.abs(diff));
                if (diff <= 0) 
                	i1++;
                if (diff >= 0) 
                	i2++;
            }
        }
        return ans;
    }

    private static int[][] generate(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) total += num;
        int[][] ans = new int[n + 1][];
        int[] pos = new int[n + 1];
        for (int i = 0, binomial = 1; i <= n; i++) {
            ans[i] = new int[binomial]; // number of ways to choose i from n = binomial(i,n)
            binomial = binomial * (n - i) / (i + 1);
        }
        int maxValue = 1 << n;
        for (int key = 0; key < maxValue; key++) {
            int sum1 = 0;
            for (int i = 0; i < n; i++) {
                if ((key >> i & 1) == 1) sum1 += nums[i];
            }
            int sum2 = total - sum1;
            int bits = Integer.bitCount(key);
            ans[bits][pos[bits]++] = sum1 - sum2;
        }
        for (int[] arr : ans) 
        	Arrays.sort(arr);
        return ans;
    }


	public static void main(String[] args)
	{
		int[] S = {2,-1,0,4,-2,-9};
		System.out.println(minimumDifference(S)+".....");

		//			System.out.println("The minimum difference is "
		//					+ minPartition(S, S.length - 1, 0, 0));
	}

}