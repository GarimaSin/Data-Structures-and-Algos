package Problem_Solving.DP;

import java.util.Arrays;

public class CountNoOfBalancedPermutations {

	public static void main(String[] args) {
		String num = "123";
		System.out.println(countBalancedPermutations1(num));
	}

	private static final int MOD = 1_000_000_007;
	public static int countBalancedPermutations1(String num) {
		int len = num.length();
		int maxVis = 1 << len; 
		int maxSum = len * 9;

		int[][][] dp = new int[len + 1][maxVis][2 * maxSum + 1];
		for (int[][] d1 : dp)
			for (int[] d2 : d1)    
				Arrays.fill(d2, -1);

		int[] nums = new int[len];
		for (int i = 0; i < len; i++)
			nums[i] = num.charAt(i) - '0';

		Arrays.sort(nums);
		return solve(nums, 0, 0, 0, 0, dp, maxSum);
	}

	static int solve(int[] nums, int len, int evenSum, int oddSum, int vis, int[][][] dp, int offset) {
		if (len == nums.length)
			return evenSum == oddSum ? 1 : 0;

		int diff = evenSum - oddSum + offset;
		if (dp[len][vis][diff] != -1)
			return dp[len][vis][diff];

		int ans = 0;
		for (int i=0; i<nums.length; i++) {
			int bit = 1 << i;

			// Skip used
			if ((vis & bit) != 0)
				continue;

			// Skip duplicates unless previous duplicate is used
			if (i > 0 && nums[i] == nums[i-1] && (vis & (1 << (i-1))) == 0)
				continue;

			vis = vis | bit;

			if (len % 2 == 0)
				ans = (ans + solve(nums, len+1, evenSum + nums[i], oddSum, vis, dp, offset))%MOD;
			else
				ans = (ans + solve(nums, len+1, evenSum, oddSum + nums[i], vis, dp, offset))%MOD;
			vis = vis & ~(bit);
		}
		return dp[len][vis][diff] = ans;
	}



	// -------------------------------------------------------------------------------------------

	private int n;
	private int totalDigitSum;
	private long totalPermPossible;

	public int countBalancedPermutations(String num) {
		n = num.length();
		totalDigitSum = 0;

		int[] freq = new int[10];
		for (char c : num.toCharArray()) {
			int d = c-'0';
			totalDigitSum += d;
			freq[d]++;
		}

		if (totalDigitSum%2 != 0) {
			return 0;
		}

		// Precompute factorial and inverse factorial using Fermat's Little Theorem
		long[] fact = new long[n+1];
		long[] invFact = new long[n+1];
		fact[0] = invFact[0] = 1;
		
		for (int i=1; i <= n; i++) 
			fact[i] = (fact[i-1] * i) % MOD;
		
		for (int i=0; i <= n; i++) 
			invFact[i] = modPow(fact[i], MOD-2);	// Inverse factorial - (1/x)% M
		

		totalPermPossible = (fact[(n+1) / 2] * fact[n/2]) % MOD;

		// 3D DP table
		int[][][] dp = new int[10][(n+1) /2 +1][totalDigitSum+1];
		for (int[][] mat : dp) {
			for (int[] row : mat) {
				Arrays.fill(row, -1);
			}
		}
		return solve(0, 0, 0, freq, invFact, dp);
	}

	int solve(int digit, int evenCount, int currSum, int[] freq, long[] invFact, int[][][] dp) {
		if (digit == 10) {
			if (currSum == totalDigitSum / 2 && evenCount == (n+1) / 2) {
				return (int) totalPermPossible;
			}
			return 0;
		}

		if (dp[digit][evenCount][currSum] != -1) {
			return dp[digit][evenCount][currSum];
		}

		long ways = 0;
		
		// We can’t assign more than: 
		// 		availableEvenSlots = (n+1)/2 - evenCount
		//		freq[digit]
		int maxUse = Math.min(freq[digit], (n+1)/2 - evenCount);
		
		for (int count = 0; count <= maxUse; count++) {
			int evenUse = count;
			int oddUse = freq[digit] - count;

			// Divide by factorials of counts
			long divisor = (invFact[evenUse] * invFact[oddUse]) % MOD; // 1/f1! * 1/f2!

			int result = solve(digit + 1, evenCount+evenUse, currSum+ digit*count, freq, invFact, dp);
			ways = (ways + result * divisor % MOD) % MOD;
		}
		dp[digit][evenCount][currSum] = (int) ways;
		return (int) ways;
	}

	// Modular exponentiation (binary exponentiation)
	long modPow(long base, long exp) {
		long result = 1;
		base = base % MOD;

		while (exp > 0) {
			if ((exp & 1) != 0) {
				result = (result * base) % MOD;
			}
			base = (base * base) % MOD;
			exp >>= 1;
		}

		return result;
	}
	
	

}
