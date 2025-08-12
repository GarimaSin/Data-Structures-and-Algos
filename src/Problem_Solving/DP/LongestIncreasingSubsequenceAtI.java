package Problem_Solving.DP;

import java.util.Arrays;

public class LongestIncreasingSubsequenceAtI {

	public static void main(String[] args) {
		int nums[] = {1,3,5,4,7};
		
        int[] lisAtEach = allLisEndingAt(nums);
        System.out.println(Arrays.toString(lisAtEach));
	}
	
	
	public static void lisEndingAt(int[] nums, int i, int[] ans) {
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
            	ans[i] = Math.max(ans[i], 1 + ans[j]);
            }
        }
    }

    public static int[] allLisEndingAt(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = 1; i < n; i++) {
            lisEndingAt(nums, i, ans);
        }
        return ans;
    }
    
}
