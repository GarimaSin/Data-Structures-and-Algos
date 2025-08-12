package Problem_Solving.Array;

import java.util.Arrays;

public class LongestIncreasingSubsequenceAtI {

	public static void main(String[] args) {
		int nums[] = {1,4,6,3,5 };
		
        int[] lisAtEach = allLisEndingAt(nums);
        System.out.println(Arrays.toString(lisAtEach));
	}
	
	
	public static void lisEndingAt(int[] nums, int i, int[] lis) {
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
            	lis[i] = Math.max(lis[i], 1 + lis[j]);
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
