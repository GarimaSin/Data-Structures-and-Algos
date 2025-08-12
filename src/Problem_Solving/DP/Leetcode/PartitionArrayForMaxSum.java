package Problem_Solving.DP.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PartitionArrayForMaxSum {

	public static void main(String[] args) {
		int inp[] = {20779,436849,274670,543359,569973,280711,252931,424084,361618,430777,136519,749292,933277,477067,502755,695743,413274,168693,368216,677201,198089,927218,633399,427645,317246,403380,908594,854847,157024,719715,336407,933488,599856,948361,765131,335089,522119,403981,866323,519161,109154,349141,764950,558613,692211};
		int k = 26;
		System.out.println(maxSumAfterPartitioning(inp, k));
		System.out.println(maxSumAfterPartitioning1(inp, k));
	}

	//Working
	public static int maxSumAfterPartitioning(int[] arr, int k) {
		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);
		return backtrack1(arr, 0, k, dp);
	}

	static int backtrack1(int[] arr, int start, int k, int[] dp) {
		if (start >= arr.length) 
			return 0;

		if(dp[start] != -1)
			return dp[start];

		int MAX = 0, cu_max = 0;;
		for (int i=start; i<arr.length && i-start+1 <=k; i++) {
			cu_max = Math.max(cu_max, arr[i]);
			int s1 = backtrack1(arr, i+1, k, dp);
			MAX = Math.max(MAX, (cu_max*(i-start+1)) + s1);
		}
		return dp[start] = MAX;
	}


	//Working - TLE
	public static int maxSumAfterPartitioning1(int[] arr, int k) {
		HashMap<String, Integer> dp = new HashMap<>();
		return backtrack1(arr, 0, k, new ArrayList<>(), new ArrayList<>(), dp);
	}

	static int backtrack1(int[] arr, int start, int k, List<Integer> maxList, 
			List<List<Integer>> currentPartition, HashMap<String, Integer> dp) {
		
		if (start == arr.length) {
			int sum = 0, count = 0;
			for(List<Integer> i: currentPartition) {
				sum = sum + (maxList.get(count) * i.size());
				count++;
			}
			return sum;
		}

		String key = start+","+currentPartition;
		 if(dp.get(key) != null)
		     return dp.get(key);

		int MAX = 0, max = 0;;
		List<Integer> part = new ArrayList<>();		
		
		for (int i=start; i<arr.length; i++) {
			if(part.size() < k) {
				
				max = Math.max(max, arr[i]);
				part.add(arr[i]);  						
				currentPartition.add(part);
				maxList.add(max);
				
				int s1 = backtrack1(arr, i+1, k, maxList, currentPartition, dp);
				
				maxList.remove(maxList.size()-1);
				currentPartition.remove(currentPartition.size() - 1);
				part = new ArrayList<>(part);
				MAX = Math.max(MAX, s1);
			}
		}
		dp.put(key, MAX);
		return MAX;
	}
}
