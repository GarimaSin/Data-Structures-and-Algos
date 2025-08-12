package Problem_Solving.Blind75.DP;

//Working
public class CombinationSum4 {

	public static void main(String[] args) {
		int nums[] = {1,2,3};
		int target = 4;
		int dp[] = new int[target+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
//		int ans = getCombCount(nums, target, 0, 0, dp, "");
//		System.out.println(ans);
		getCombCount(nums, target, 0, "");
		int ans = getCombCount(nums, target, 0, dp, "");
		System.out.println(ans);
		System.out.println(count);
	}

	static int count = 0;
	//Working - Recursion
	public static void getCombCount(int[] nums, int target, int sum, String ans) {
		if(sum > target)
			return;
		if(sum == target) {
			count++;
			System.out.println(ans + "...."+count);
			return;
		}

		for (int j = 0; j < nums.length; j++) {
			getCombCount(nums, target, sum+nums[j], ans+nums[j]);
		}
	}

	//Working - Memo
	public static int getCombCount(int[] nums, int target, int sum, int[] dp, String ans) {
		if(sum > target)
			return 0;

		if(sum == target) {
			return 1;
		}

		int tmp = 0;
		if(dp[sum] != -1)
			return dp[sum];
		else {
			for (int j = 0; j < nums.length; j++) {
				tmp += getCombCount(nums, target, sum+nums[j], dp, ans+nums[j]);
				dp[sum] = tmp;
			}
			return dp[sum];
		}
	}

	//Working - Tab
	public int combinationSum4(int[] nums, int target) {
		int[] table = new int[target + 1];
		table[0] = 1;

		for (int remain = 1; remain <= target; remain++) {
			int ans = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] > remain)
					continue;

				ans += table[remain - nums[i]];
			}
			table[remain] = ans;
		}
		return table[target];
	}
}