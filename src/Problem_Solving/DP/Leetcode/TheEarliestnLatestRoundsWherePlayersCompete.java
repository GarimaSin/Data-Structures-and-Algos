package Problem_Solving.DP.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheEarliestnLatestRoundsWherePlayersCompete {

	public static void main(String[] args) {
		int n = 27, firstPlayer = 12, secondPlayer = 13;
		int ans[] = earliestAndLatest(n, firstPlayer, secondPlayer);
		System.out.println(Arrays.toString(ans));
	}

	private static final int INF = 1_000_000;
	private static final int NEG_INF = -1_000_000;
	private Map<Long, int[]> memo = new HashMap<>();


	public static int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
		int arr1[] = new int[n];
		for (int i = 0; i < n; i++)
			arr1[i] = i+1;
			
		int[] ans = new int[(arr1.length+1) / 2];
		return findEarliestnLatest(n, firstPlayer, secondPlayer, arr1, ans, 0, 1);
	}
	
	
	// Working - My sol - 138/139
	static int[] findEarliestnLatest(int n, int best1, int best2, int[] arr, int[] ans, int idx, int round) {
		if (arr.length == 2) {
			if ((arr[0] == best1 && arr[1] == best2) || (arr[0] == best2 && arr[1] == best1))
				return new int[] {round, round};
			return new int[] {INF, NEG_INF}; // impossible branch
		}

		if (idx >= ans.length) {
			int[] winners = Arrays.stream(ans).filter(x -> x != 0).toArray();
			Arrays.sort(winners); // winners lined in ascending order per problem statement
			int[] newArr = Arrays.copyOf(winners, winners.length);
			int[] newAns = new int[(newArr.length + 1) / 2];
			int[] res = findEarliestnLatest(n, best1, best2, newArr, newAns, 0, round + 1);
			return res;
		}

		int opponent = arr[arr.length-1 - idx];

		if ((arr[idx] == best1 && opponent == best2) || (arr[idx] == best2 && opponent == best1))
			return new int[] {round, round};

		int[] r1 = {INF, NEG_INF}, r2 = {INF, NEG_INF};

		if (arr[idx] == best1 || opponent == best1) {
			ans[idx] = best1;
			r1 = findEarliestnLatest(n, best1, best2, arr, ans, idx+1, round);
		} else if (arr[idx] == best2 || opponent == best2) {
			ans[idx] = best2;
			r1 = findEarliestnLatest(n, best1, best2, arr, ans, idx+1, round);
		} else {
			ans[idx] = arr[idx];
			r1 = findEarliestnLatest(n, best1, best2, arr, ans, idx+1, round);

			ans[idx] = opponent;
			r2 = findEarliestnLatest(n, best1, best2, arr, ans, idx+1, round);
		}
		ans[idx] = 0;
		return new int[]{Math.min(r1[0], r2[0]), Math.max(r1[1], r2[1])};
	}
	
	
	// =======================================================================================================================
	
	
	// Working
	private int[] dfs(int mask, int n, int p1, int p2, int round) {
        long key = ((long) mask << 6) | round; // compress mask+round
        if (memo.containsKey(key)) 
        	return memo.get(key);

        List<Integer> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) 
            	players.add(i);
        }

        int m = players.size();

        // Base case: only two players left, and they are p1/p2
        if (m == 2 && ((players.get(0) == p1 && players.get(1) == p2) ||
                       (players.get(0) == p2 && players.get(1) == p1))) {
            int[] res = {round, round};
            memo.put(key, res);
            return res;
        }

        // reset best trackers for this dfs
        int[] best = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        backtrack(players, 0, new ArrayList<>(), n, p1, p2, round, best);

        memo.put(key, best);
        return best;
    }

    private void backtrack(List<Integer> players, int idx, List<Integer> next, int n, int p1, int p2, int round, int[] best) {
        int m = players.size();

        if (idx >= m / 2) {
            // carry middle player if odd
            if (m % 2 == 1) 
            	next.add(players.get(m / 2));

            // build new mask
            int newMask = 0;
            for (int x : next) 
            	newMask |= (1 << x);

            int[] res = dfs(newMask, n, p1, p2, round + 1);

            best[0] = Math.min(best[0], res[0]);
            best[1] = Math.max(best[1], res[1]);

            if (m % 2 == 1) 
            	next.remove(next.size() - 1);
            return;
        }

        int a = players.get(idx), b = players.get(m - 1 - idx);

        if ((a == p1 && b == p2) || (a == p2 && b == p1)) {
            best[0] = Math.min(best[0], round);
            best[1] = Math.max(best[1], round);
            return;
        }

        if (a == p1 || a == p2 || b == p1 || b == p2) {
            int keep = (a == p1 || a == p2) ? a : b;
            next.add(keep);
            backtrack(players, idx + 1, next, n, p1, p2, round, best);
            next.remove(next.size() - 1);
        } else {
            next.add(a);
            backtrack(players, idx + 1, next, n, p1, p2, round, best);
            next.remove(next.size() - 1);

            next.add(b);
            backtrack(players, idx + 1, next, n, p1, p2, round, best);
            next.remove(next.size() - 1);
        }
    }


}
