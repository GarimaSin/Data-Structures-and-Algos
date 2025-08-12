package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class CountTheNoOfIdealArrays {

	final int MOD = (int)1e9 + 7;

	int n, maxValue;
	Integer[][] memo;


	// Working - Sol 2 - TLE - 35/47
	public int idealArrays1(int n, int maxValue) {
		this.n = n;
		this.maxValue = maxValue;
		memo = new Integer[n+1][maxValue+1];

		int result = 0;
		// Start from every value x as the last value of the array
		for (int x=1; x <= maxValue; x++) {
			result = (result + count(n, x)) % MOD;
		}
		return result;
	}

	// Count the no. of arrays of length 'len' ending with value 'val'
	int count(int len, int val) {
		if (len == 1) 
			return 1;
		
		if (memo[len][val] != null) 
			return memo[len][val];

		long total = 0;
		// Loop over all divisors of val
		for (int d=1; d*d <= val; d++) {
			if (val % d == 0) {
				int d1=d;
				int d2 = val/d;

				total = (total + count(len-1, d1)) % MOD;
				if (d1 != d2) {
					total = (total + count(len-1, d2)) % MOD;
				}
			}
		}
		return memo[len][val] = (int) total;
	}

	
	
	// Working - TLE - 35/47
    public int idealArrays2(int n, int maxValue) {
        int[][] dp = new int[n+1][maxValue+1];
		for(int i[]: dp)
			Arrays.fill(i, -1);
		return countIdealArrays(n, maxValue, 0, 1, dp);
    }

    int countIdealArrays(int n, int maxValue, int len, int prev, int[][] dp) {
		if(len == n) {
			return 1;
		}
		
		if(dp[len][prev] != -1)
			return dp[len][prev];
		int ans = 0;
		for(int i=1; i<=maxValue; i++) {
			if(i%prev == 0) {
				int c = countIdealArrays(n, maxValue, len+1, i, dp);
				ans = (int) ((ans + c)%MOD);
			}
		}
		return dp[len][prev] = ans;
	}






	// Working - Sol 1 - Didnt understand
	/*
	 * dp[m][len] is the no. of arrays of length len ending in m
	 */

	//To find how many arrays of a given length, ending with no. = val
	void findSets(int val, int[] count, int[][] dp) {
		if (dp[val][1] != 0) {
			return;
		}

		dp[val][1] = 1;
		count[1]++;

		for (int div=2; div<=val; div++) {
			if (val%div == 0) {
				findSets(val/div, count, dp);

				for (int len = 1; len < 15; len++) {
					if (dp[val/div][len] != 0) {
						dp[val][len + 1] += dp[val / div][len];
						count[len + 1] += dp[val / div][len];
					}
				}
			}
		}
	}

	long findPower(long a, long b) {
		if (b == 0)
			return 1;

		long half = findPower(a, b/2);
		long result = (half*half) % MOD;

		if (b % 2 == 1) {
			result = (result*a) % MOD;
		}

		return result;
	}

	int modularnCr(int n, int r, long[] fact) {
		if (r < 0 || r > n)
			return 0;

		long b = (fact[r] * fact[n - r]) % MOD;
		return (int)((fact[n] * findPower(b, MOD - 2)) % MOD);
	}

	public int idealArrays(int n, int maxVal) {
		int[][] dp = new int[maxVal + 1][15];
		int[] count = new int[15];

		// Find sets count
		for (int val=1; val <= maxVal; val++) {
			findSets(val, count, dp);
		}

		// Precompute factorials
		long[] fact = new long[n+1];
		fact[0] = 1;
		for (int i=1; i <= n; i++) {
			fact[i] = (fact[i - 1] * i) % MOD;
		}

		long result = 0;
		for (int len=1; len<15; len++) {
			if (n < len) {
				break;
			}
			if (count[len] != 0) {
				long possibilities = modularnCr(n-1, len-1, fact);
				result = (result + (count[len] * possibilities) % MOD) % MOD;
			}
		}
		return (int) result;
	}
}
