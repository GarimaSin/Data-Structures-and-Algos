package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class StoneGame2 {
	public static void main(String[] args) {
		int[] piles = {2,7,9,4,4};
		System.out.println(stoneGameII(piles));
	}

	// Working - 10%
	public static int stoneGameII(int[] piles) {
		int[][][] dp = new int[piles.length+1][piles.length+1*2][2];
		for(int[][] i: dp)
			for(int[] j: i)
				Arrays.fill(j, -1);

		int[][] dp1 = new int[piles.length+1][piles.length+1];
		for(int[] i: dp1)
			Arrays.fill(i, -1);
		//        return stoneGameII(piles, 1, 0, 0, dp);
		return stoneGameII(piles, 1, 0, dp1);
	}

	// AliceTurn = 0 means its Alice's turn.
	static int stoneGameII(int[] piles, int M, int AliceTurn, int idx, int[][][] dp) {
		if (idx >= piles.length)
			return 0;

		if(dp[idx][M][AliceTurn] != -1)
			return dp[idx][M][AliceTurn];

		int res = AliceTurn == 0 ? 0 : Integer.MAX_VALUE;
		int sum = 0;

		for (int X=1; X <= 2*M && idx+X <= piles.length; X++) {
			sum += piles[idx + X-1];

			if (AliceTurn == 0) {
				int ans = sum + stoneGameII(piles, Math.max(M, X), 1, idx+X, dp);
				res = Math.max(res, ans);
			} else {
				// not adding sum since v r calculating min, hence adding sum to recursive ans doesnt make sense
				// and also v dont hv 2 calulate bob's score exactly
				int ans = stoneGameII(piles, Math.max(M, X), 0, idx+X, dp);
				res = Math.min(res, ans);
			}
		}
		return dp[idx][M][AliceTurn] = res;
	}


	// ================================================================================================

	// Working - 55%
	public int stoneGame2(int[] piles) {
		int[][] dp = new int[101][101];
		for(int[] j: dp)
			Arrays.fill(j, -1);
		int diff = stoneGameII(piles, 1, 0, dp);
		// Convert net advantage to Alice's actual stones
		int total = 0;
		for (int p : piles) 
			total += p;
		return (total + diff) /2;
	}

	static int stoneGameII(int[] piles, int M, int idx, int[][] dp) {
		if (idx >= piles.length)
			return 0;

		if(dp[idx][M] != -1)
            return dp[idx][M];
		
		int sum = 0, res = -999999;

		for (int X=1; X <= 2*M && idx+X <= piles.length; X++) {
			sum += piles[idx + X-1];
			int ans = sum - stoneGameII(piles, Math.max(M, X), idx+X, dp);
			res = Math.max(res, ans);
		}
		return dp[idx][M] = res;
	}
}
