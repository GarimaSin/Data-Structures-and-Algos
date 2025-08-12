package Problem_Solving.DP.Pepcoding;

public class ClimbStairsWithMinSteps {
	public static void main(String[] args) {
		int steps[] = {1,1,1,4,9,8,1,1,10,1};
		int dp[] = new int[steps.length+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 9000000;
		}
		countMinSteps(steps, 0, 0);
		System.out.println(min);
		System.out.println(countMinStepsDPMine(steps, 0, 0, dp));
	}

	static int min = Integer.MAX_VALUE;

	//Working - Recursion
	public static void countMinSteps(int steps[], int idx, int count) {
		//			System.out.println("idx "+idx+" count: "+count);
		if(idx >= steps.length-1) {
			min = Math.min(min, count);
			return;
		}

		if(steps[idx] == 0)
			return;

		for (int i = 1; i <= steps[idx]; i++) {
			countMinSteps(steps, idx+i, count+1);
		}
		//		countMinSteps(steps, idx+1, count+1);
	}


	//working
	public static int countMinStepsDPMine(int steps[], int idx, int count, int[] dp) {
		if(idx >= steps.length-1) {
			return 0;
		}

		if(steps[idx] == 0)
			return 9999999;					//Cannot return Integer.MAX_VALUE, coz at line no. 1, v r doing +1 to the returned val 
		// and adding 1 to MAX_VALUE = Integer.MIN_VALUE

		if(dp[idx] != 9000000) {
			return dp[idx];
		}
		else {
			for (int i = 1; i <= steps[idx]; i++) {
				int i1 = 1+ countMinStepsDPMine(steps, idx+i, count+1, dp);			//Line# 1
				dp[idx] =Math.min(dp[idx], i1);
			}
			return dp[idx]; 
		}
	}

	// Working
	public static int countMinStepsDPTab(int steps[], int idx, int count, Integer[] dp, int n) {
		for (int i = n - 1; i >= 0; i--) {
			if (steps[i] == 0)
				continue;
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= steps[i] && i + j < dp.length; j++) {
				if (dp[i + j] != null) {
					min = Math.min(min, dp[i + j]);
				}
			}
			if (min != Integer.MAX_VALUE)
				dp[i] = min + 1;
		}
		return dp[0];
	}
}