package Problem_Solving.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RussianDollEnvelopes {

	public static void main(String[] args) {
		int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(maxEnvelopes(envelopes));
	}

	public static int maxEnvelopes(int[][] envelopes) {
		//        Arrays.sort(envelopes, (a,b)-> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
		//        return getMaxEnvelopes(envelopes, 0, -1);

		Arrays.sort(envelopes, (a,b)-> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
		return getMaxEnvelopesUsingPatienceSort(envelopes);
	}


	// TLE - 85/87
	static int getMaxEnvelopes(int[][] envelopes, int r, int lastIdx) {
		if(r == envelopes.length)
			return 0;

		int take = 0;
		if(lastIdx == -1 || 
				(envelopes[r][0] > envelopes[lastIdx][0] && envelopes[r][1] > envelopes[lastIdx][1])) {
			take = 1 + getMaxEnvelopes(envelopes, r+1, r);
		}
		int notTake = getMaxEnvelopes(envelopes, r+1, lastIdx);

		return Math.max(take, notTake);
	}

	// Working
	static int getMaxEnvelopesUsingPatienceSort(int[][] envelopes) {
		List<Integer> piles = new ArrayList<>();

		for (int i=0; i<envelopes.length; i++) {
			int num = envelopes[i][1];
			int idx = Collections.binarySearch(piles, num);

			if (idx<0) 
				idx = -(idx + 1); // Find insertion point

				if (idx == piles.size()) {
					piles.add(num); // New pile
				} else {
					piles.set(idx, num); // Replace pile top
				}
		}
		return piles.size();
	}
}
