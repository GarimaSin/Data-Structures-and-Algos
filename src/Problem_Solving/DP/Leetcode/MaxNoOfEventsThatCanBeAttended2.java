package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class MaxNoOfEventsThatCanBeAttended2 {

	public static void main(String[] args) {
		int[][] events = {{1,2,4},{3,4,3},{2,3,1}};
		int k = 2;
		System.out.println(maxValue(events, k));
	}

	public static int maxValue(int[][] events, int k) {

		Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));
		return getMaxValue(events, k, 0, 0, -1);
	}

	static int getMaxValue(int[][] events, int k, int i, int count) {
		if(i >= events.length)
			return -999999;

		int take = -999999;
		if(count+1 <= k) {
			int j = i+1;
			for(; j<events.length; j++) {
				if(events[i][1] < events[j][0])
					break;
			}
			take = events[i][2] + getMaxValue(events, k, i+1, count+1);
		}
		int skip = getMaxValue(events, k, i+1, count);
		return Math.max(take, skip);
	}

	static int getMaxValue(int[][] events, int k, int i, int count, int prev) {
		if(i >= events.length)
			return -999999;

		int take = -999999;
		if(count+1 <= k && (prev ==-1 || events[prev][1] < events[i][0]))
			take = events[i][2] + getMaxValue(events, k, i+1, count+1, i);
		int skip = getMaxValue(events, k, i+1, count, prev);

		return Math.max(take, skip);
	}


	// ================================================================================================


	// Working - TLE - 69/70
	// Each unique i can cost O(n) in scanning → overall O(n² · k).
	public int maxValue2(int[][] events, int k) {
		int[][] dp = new int[events.length+1][k+1];
		for(int[] i: dp)
			Arrays.fill(i, -1);
		Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));
		return getMaxValue(events, k, 0, dp);
	}

	int getMaxValue(int[][] events, int k, int i, int[][] dp) {
		if(i >= events.length || k==0)
			return 0;

		if(dp[i][k] != -1) 
			return dp[i][k];

		int take = 0;
		if(k > 0) {
			int j = i+1;
			for(; j<events.length; j++) {
				if(events[i][1] < events[j][0])
					break;
			}
			take = events[i][2] + getMaxValue(events, k-1, j, dp);
		}
		int skip = getMaxValue(events, k, i+1, dp);
		return dp[i][k] = Math.max(take, skip);
	}


	// ================================================================================================

	
	// Precomputation: O(n log n) for sorting + O(n log n) for nextIndex via binary search.
	// DP recursion: O(n · k) states × O(1) transition = O(n · k) total.
	// Overall: O(nlogn + n · k)
	// Working
	public int maxValue3(int[][] events, int k) {
		Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

		int n = events.length;
		int[][] dp = new int[n][k+1];
		for (int[] row : dp) Arrays.fill(row, -1);

		// Precompute next index for each event using binary search
		int[] nextIndex = new int[n];
		int[] starts = new int[n];
		for (int i = 0; i < n; i++) 
			starts[i] = events[i][0];
		for (int i = 0; i < n; i++) {
			int endTime = events[i][1];
			int lo = i + 1, hi = n;
			while (lo < hi) {
				int mid = (lo + hi) / 2;
				if (events[mid][0] > endTime) hi = mid;
				else lo = mid + 1;
			}
			nextIndex[i] = lo; // could be n (no next event)
		}
		return dfs(0, k, events, dp, nextIndex);
	}

	int dfs(int i, int k, int[][] events, int[][] dp, int[] nextIndex) {
		if (i >= events.length || k == 0) return 0;
		if (dp[i][k] != -1) return dp[i][k];

		int take = events[i][2] + dfs(nextIndex[i], k-1, events, dp, nextIndex);
		int skip = dfs(i+1, k, events, dp, nextIndex);

		return dp[i][k] = Math.max(take, skip);
	}
}
