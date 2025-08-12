package Problem_Solving.Greedy;

import java.util.Arrays;
import java.util.HashMap;

public class GetTheMaxScore {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4,5}, nums2 = {6,7,8,9,10};
		System.out.println(maxSum(nums1, nums2));
	}
	
	
	// Time = O(n + m), Space = O(1)
	public int maxSum2(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;
        long sum1 = 0, sum2 = 0;
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j];
                j++;
            } else {
                // Intersection point: pick max of two paths
                long maxSum = Math.max(sum1, sum2) + nums1[i];
                sum1 = maxSum;
                sum2 = maxSum;
                i++;
                j++;
            }
        }
        // Add remaining elements
        while (i < n) sum1 += nums1[i++];
        while (j < m) sum2 += nums2[j++];
        return (int) (Math.max(sum1, sum2) % MOD);
    }
	
	

	// ========================================================================================

	// Working - 5%, // Time = O(n + m), Space = O(n)
	public int maxSum1(int[] nums1, int[] nums2) {
		HashMap<Integer, nums1State> map1 = new HashMap<>();
		
		long sum1=0, prev1=0, prev2=0, ans=0;
		boolean found = false;
		for(int i=0; i<nums1.length; i++) {
			sum1 = sum1 + nums1[i];
			map1.put(nums1[i], new nums1State(sum1, i));
		}
		
		long sum2 = 0;
		for(int i=0; i<nums2.length; i++) {
			sum2 = sum2 + nums2[i];
			if(map1.get(nums2[i]) != null) {
				long currentPrefix1 = map1.get(nums2[i]).prefSum;
				long s1 = currentPrefix1 - prev1;
				long s2 = sum2 - prev2;
				ans = ans + Math.max(s1, s2);
				prev1 = currentPrefix1;
				prev2 = sum2;
				found = true;
			}
		}
		if(!found)
			return (int) (Math.max(sum1, sum2) % MOD);
		long tail1 = sum1 - prev1;
		long tail2 = sum2 - prev2;
	    ans = (ans + Math.max(tail1, tail2)) % MOD;
		return (int)ans;
	}

	
	// ==================================================================================
	
	// Working - 5%, Time = O(n + m), Space = O(n + m)
	private static final int MOD = 1_000_000_007;
	public static int maxSum(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map1 = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		int maxIdx = Math.max(nums1.length, nums2.length);
		
		for(int i=0; i<nums1.length; i++)
			map1.put(nums1[i], i);
		
		for(int i=0; i<nums2.length; i++)
			map2.put(nums2[i], i);
		
		long[][] dp = new long[maxIdx+1][2];
		for(long[] i: dp)
			Arrays.fill(i, -1);
		
		long score1 = getMaxScore(nums1, nums2, 0, 1, map1, map2, dp);
		long score2 = getMaxScore(nums1, nums2, 0, 0, map1, map2, dp);
		long ans = (Math.max(score1, score2))%MOD;
		return (int)ans;
	}

	static long getMaxScore(int[] nums1, int[] nums2, int i, int isnums1, HashMap<Integer, Integer> map1, 
			HashMap<Integer, Integer> map2, long[][] dp) {
		
		if(isnums1 == 1 && i >= nums1.length) 
			return 0;
		
		if(isnums1 == 0 && i >= nums2.length) 
			return 0;
		
		if(dp[i][isnums1] != -1)
			return dp[i][isnums1];
		
		long switchArr = 0;
		int tmp = isnums1 == 1? nums1[i] : nums2[i];
		long skip = tmp + getMaxScore(nums1, nums2, i+1, isnums1, map1, map2, dp);
		
		if(isnums1 == 1) {
			if(map2.get(tmp) != null) 
				switchArr = nums1[i] + getMaxScore(nums1, nums2, map2.get(tmp)+1, 0, map1, map2, dp);
		} else {
			if(map1.get(tmp) != null) 
				switchArr = nums2[i] + getMaxScore(nums1, nums2, map1.get(tmp)+1, 1, map1, map2, dp);
		}
		long ans = Math.max(switchArr, skip);
		
		return dp[i][isnums1] = ans;
	}

}

class nums1State{
    long prefSum = 0;
    int idx = 0;
    
    nums1State(long i, int j) {
        this.prefSum = i;
        this.idx = j;
    }
}
