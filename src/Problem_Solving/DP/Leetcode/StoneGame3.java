package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class StoneGame3 {

	public static void main(String[] args) {
		int[] stoneValue = {-1, -2, -3};
		System.out.println(stoneGameIII(stoneValue));
	}


	// Working - 6%
	public static String stoneGameIII(int[] stoneValue) {
		score[][] dp = new score[stoneValue.length+1][2];
        score ans = findWinner(stoneValue, 0, 0, dp);
        if(ans.aliceScore > ans.bobScore)
		    return "Alice";
        else if (ans.aliceScore < ans.bobScore)
            return "Bob";
        else
            return "Tie";
	}

	// Maximise both Alice and Bob's score
	static score findWinner(int[] stones, int idx, int turn, score[][] dp) {
		if(idx >= stones.length) 
			return new score(0, 0);

		score best = null;
		int val = 0;

        if(dp[idx][turn] != null)
            return dp[idx][turn];

		for(int x=1; x <= 3 && idx+x <= stones.length; x++) {
			val += stones[idx+x-1];
			score next = findWinner(stones, idx+x, 1-turn, dp);		// Toggle b/w 2 values

			int a, b;
			if(turn == 0) { 			// Alice's turn
				a = val + next.aliceScore;
				b = next.bobScore;
			} else {        			// Bob's turn
				a = next.aliceScore;
				b = val + next.bobScore;
			}

			if(best == null || 
			   (turn == 0 && a-b > best.aliceScore - best.bobScore) ||		// Maximise Alice's score
			   (turn == 1 && b-a > best.bobScore - best.aliceScore)) {		// Maximise Bob's score
				best = new score(a, b);
			}
		}
		return dp[idx][turn] = best;
	}
	
	
	// ================================================================================================
	
	
	// Working - 52%
	public String stoneGame3(int[] stoneValue) {
        int[] dp = new int[stoneValue.length+1];
        Arrays.fill(dp, -1);
        int result = findWinner(stoneValue, 0, dp);
		if(result>0)
			return "Alice";
		else if (result<0)
			return "Bob";
		else
			return "Tie";
    }

    int findWinner(int[] stones, int idx, int[] dp) {
		if(idx >= stones.length) 
			return 0;

        if(dp[idx] != -1)
            return dp[idx];
		int val = 0, sum = -999999;
		for(int x=1; x <= 3 && idx+x <= stones.length; x++) {
			val += stones[idx+x-1];
			int opponent = findWinner(stones, idx+x, dp);
			sum = Math.max(sum, val - opponent);
		}
		return dp[idx] = sum;
	}


	static class score {
		int aliceScore;
		int bobScore;

		score(int a, int b) {
			this.aliceScore = a;
			this.bobScore = b;
		}
	}
}
