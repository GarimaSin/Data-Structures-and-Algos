package Problem_Solving.DP.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindTheOriginalTypedStringII {

	private static final long MOD = 1_000_000_007;
	public static List<String> generate(String word, int k) {
		List<Integer> runs = new ArrayList<>();
		List<Character> chars = new ArrayList<>();

		// Build run-length encoding: chars and their run lengths
		char[] w = word.toCharArray();
		char prev = w[0];
		int cnt = 1;
		for (int i=1; i<w.length; i++) {
			if (w[i] == prev) 
				cnt++;
			else {
				chars.add(prev);
				runs.add(cnt);
				prev = w[i];
				cnt = 1;
			}
		}
		chars.add(prev);
		runs.add(cnt);

		List<String> res = new ArrayList<>();
		int R = runs.size();
		int[] picks = new int[R];
		System.out.println(backtrack1(chars, runs, 0, picks, "", k));
		return res;
	}

	// Working but TLE - 708/846
	static int backtrack1(List<Character> chars, List<Integer> runs, int idx, int[] picks, String res, int k) {
		if(idx >= chars.size()) {
			if(res.length() >= k)
				return 1;
			//				System.out.println(res);
			return 0;
		}

		int ans = 0;
		for(int i=1; i<=runs.get(idx); i++) {
			String tmp = res;
			String c = chars.get(idx)+"";
			res = res + c.repeat(i);
			int a = backtrack1(chars, runs, idx+1, picks, res, k);
			ans = ans + a;
			res = tmp;
		}
		return ans;
	}


	// Working but TLE -- Faster than above
	static int backtrack2(List<Character> chars, List<Integer> runs, int idx, int[] picks, int k) {
		if (idx == chars.size()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < runs.size(); i++) {
				for (int c = 0; c < picks[i]; c++)
					sb.append(chars.get(i));
			}
			if(sb.length() >= k)
				return 1;
			return 0;
		}
		int ans = 0;
		for (int take = 1; take <= runs.get(idx); take++) {
			picks[idx] = take;
			int res = backtrack2(chars, runs, idx + 1, picks, k);
			ans = ans + res;
		}
		return ans;
	}


	// Working but TLE - 813/846
	long backtrack3(List<Character> chars, List<Integer> runs, int idx, int currLen, int k, HashMap<String, Long> memo) {
		if (idx >= chars.size()) {
			return currLen >= k ? 1 : 0;
		}

		// Memoization key: idx and current length
		String key = idx + ":" + currLen;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}

		long ans = 0;
		// Try all possible counts for the current character
		for (int i = 1; i <= runs.get(idx); i++) {
			ans = (ans + backtrack3(chars, runs, idx+1, currLen+i, k, memo)) % MOD;
		}

		memo.put(key, ans);
		return ans;
	}




	//////////////////////////////////////////////////////////////////////
	private int[][] memo;


	//Working - TLE - 830/846
	int solve(int i, int count, List<Integer> freq, int k) {
		if (i >= freq.size()) {
			return count < k ? 1 : 0;
		}

		if (memo[i][count] != -1) {
			return memo[i][count];
		}

		long result = 0;
		int maxTake = freq.get(i);
		for (int take = 1; take <= maxTake; take++) {
			if (count + take < k) {
				result = (result + solve(i + 1, count + take, freq, k)) % MOD;
			} else {
				break;
			}
		}

		return memo[i][count] = (int) result;
	}

	int possibleStringCount(String word, int k) {
		if (k > word.length()) 
			return 0;

		List<Integer> freq = new ArrayList<>();
		int count = 1;
		for (int i = 1; i < word.length(); i++) {
			if (word.charAt(i) == word.charAt(i - 1)) {
				count++;
			} else {
				freq.add(count);
				count = 1;
			}
		}
		freq.add(count);  // Add the last group

		long total = 1;
		for (int f : freq) {
			total = (total * f) % MOD;
		}

		if (freq.size() >= k) 
			return (int) total;

		int n = freq.size();
		memo = new int[n + 1][k + 1];
		for (int[] row : memo) 
			Arrays.fill(row, -1);

		long invalid = solve(0, 0, freq, k);
		return (int) ((total - invalid + MOD) % MOD);
	}
	
	
	
	
	// Working - Didnt understand the code
	private static final int MODULO = 1_000_000_007;
    public int possibleStringCount1(String word, int k) {
		if (k > word.length()) 
            return 0;

        // Run-length encoding
        List<Integer> freq = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                freq.add(count);
                count = 1;
            }
        }
        freq.add(count); // Add the last group

        // Total possible combinations
        long total = 1;
        for (int f : freq) {
            total = (total * f) % MODULO;
        }

        if (freq.size() >= k) 
            return (int) total;

        int n = freq.size();
        int[][] dp = new int[n + 1][k + 1];

        // Base case: when we've considered all runs
        for (int c = k - 1; c >= 0; c--) {
            dp[n][c] = 1;
        }

        // Bottom-up DP
        for (int i = n - 1; i >= 0; i--) {
            int[] prefix = new int[k + 2]; // +2 to avoid index issues with r+1

            for (int h = 1; h <= k; h++) {
                prefix[h] = (prefix[h - 1] + dp[i + 1][h - 1]) % MODULO;
            }

            for (int c = k - 1; c >= 0; c--) {
                int l = c + 1;
                int r = c + freq.get(i);

                if (r + 1 > k) {
                    r = k - 1;
                }

                if (l <= r) {
                    dp[i][c] = (prefix[r + 1] - prefix[l] + MODULO) % MODULO;
                }
            }
        }
        long invalid = dp[0][0];
        return (int) ((total - invalid + MODULO) % MODULO);
	}
	
	

	public static void main(String[] args) {
		String word = "aaabbb";
		int k = 3;
		System.out.println(generate(word, k));
		// → [abc, aabc, abbc, abcc, aabbc, aabcc, abbcc, aabbcc]

		word = "scssx";
		k = 4;
		System.out.println(generate(word, k));
		// → [scsx, scssx]
	}


}
