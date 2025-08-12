package Problem_Solving.Graph.Pepcoding;

import java.util.Arrays;

public class MinNoOfSwapsToSortAnArray {
	public static void main(String[] args)  {
		int[] arr = {4, 5, 2, 1, 5};
		System.out.println(minSwaps(arr));
	}

	public static int minSwaps(int[] arr1) {
		int n = arr1.length;
		Pair[]arr = new Pair[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Pair(arr1[i], i);
		}
		Arrays.sort(arr);
		int ans = 0;
		// To keep track of visited elements.
		boolean[]vis = new boolean[n];
		for (int i = 0; i < n; i++) {
			// already swapped and corrected or
            // already present at correct pos
			if (vis[i] == true || arr[i].idx == i) {
				continue;
			}
			int cycleSize  = 0;			
			int j = i;
			while (vis[j] == false) {
				vis[j] = true;
				cycleSize++;
				j = arr[j].idx;
			}
			ans += (cycleSize - 1);
		}
		return ans;
	}

	private static class Pair implements Comparable< Pair> {
		int val;
		int idx;

		Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}

		@Override
		public int compareTo(Pair o) {
			return this.val - o.val;
		}
	}
}
