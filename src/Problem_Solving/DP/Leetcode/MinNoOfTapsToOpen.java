package Problem_Solving.DP.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinNoOfTapsToOpen {

	public static void main(String[] args) {
		int n = 7; 
		int ranges[] = {1,2,1,0,2,1,0,1};
		System.out.println(minTaps3(n, ranges));
	}


	// Working
	public static int minTaps3(int n, int[] ranges) {
		int intervals[][] = new int[ranges.length][2];
		int maxRanges[] = new int[ranges.length];

		for(int i=0; i<ranges.length; i++) {

			int start = Math.max(0, i-ranges[i]);
			int end = Math.min(n, i+ranges[i]);

			intervals[i][0] = start;
			intervals[i][1] = end;

			maxRanges[start] = Math.max(maxRanges[start], end);
		}

		int maxReachable = 0;
		int openedTaps = 0;
		int currTap = 0;

		for(int i=0; i<=n; i++) {
			if(i > maxReachable)
				return -1;

			if(currTap < i) {
				openedTaps++;
				currTap = maxReachable; 
			}
			maxReachable = Math.max(maxReachable, maxRanges[i]);
		}
		return openedTaps;
	}




// =================================================================================


	private static final int INF = (int)1e9;

	// Working - Memo and Interval logic
	static int solve(int i, int N, int maxEnd, int[][] ranges, Map<String, Integer> memo) {
		if (i >= ranges.length) 
			return maxEnd >= N ? 0 : INF;

			int start = ranges[i][0];
			int end   = ranges[i][1];
			if (start > maxEnd) 
				return INF;

			String key = i+"," +maxEnd;
			if (memo.containsKey(key)) 
				return memo.get(key);


			int skip = solve(i+1, N, maxEnd, ranges, memo);
			int take = 1 + solve(i+1, N, Math.max(maxEnd, end), ranges, memo);

			int res = Math.min(skip, take);
			memo.put(key, res);
			return res;
	}

	public static int minTaps2(int n, int[] rangesArr) {
		int[][] ranges = new int[n+1][2];
		for (int i=0; i < rangesArr.length; i++) {
			int r = rangesArr[i];
			int start = Math.max(0, i-r);
			int end   = Math.min(n, i+r);
			ranges[i][0] = start; 
			ranges[i][1] = end; 
		}
		Arrays.sort(ranges, (a, b) -> Integer.compare(a[0], b[0]));

		Map<String, Integer> memo = new HashMap<>();
		int ans = solve(0, n, 0, ranges, memo);
		return ans >= INF ? -1 : ans;
	}


// =================================================================================


	// Mem LE - my logic
	public static int minTaps1(int n, int[] ranges) {
		Integer[][] memo = new Integer[n + 1][1 << (n + 1)];
		int watered = 0;
		int res = getMinTap1(n, ranges, 0, watered, memo);
		return res >= 999999 ? -1 : res; 
	}

	static int getMinTap1(int n, int[] ranges, int i, int watered, Integer[][] memo) {
		// All positions from 0 to n must be watered
		int allWatered = (1 << (n+1)) - 1;

		if ((watered & allWatered) == allWatered)
			return 0;

		if (i > n)
			return 999999;

		if (memo[i][watered] != null)
			return memo[i][watered];

		int notWater = getMinTap1(n, ranges, i + 1, watered, memo);
		int water = 999999;

		if(ranges[i] != 0) {
			int left = Math.max(0, i - ranges[i]);
			int right = Math.min(n, i + ranges[i]);
			int newWatered = watered;

			for (int j=left; j <= right; j++) 
				newWatered |= (1 << j);

			water = 1 + getMinTap1(n, ranges, i + 1, newWatered, memo);
		}
		return memo[i][watered] = Math.min(water, notWater);
	}
}
