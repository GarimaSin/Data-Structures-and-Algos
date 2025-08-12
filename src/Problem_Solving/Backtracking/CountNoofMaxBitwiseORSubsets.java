package Problem_Solving.Leetcode.Backtracking;

public class CountNoofMaxBitwiseORSubsets {

	public static void main(String[] args) {
		int[] nums = {88};
		System.out.println(countMaxOrSubsets(nums));
	}
	
	public static int countMaxOrSubsets(int[] nums) {
        int target = 0;
        for(int i: nums)
            target = target | i;
        helper(nums, "", 0, target);
        return max;
    }
    
    static int max = 0;
    static void helper(int[] nums, String ans, int idx, int target) {
        if(idx >= nums.length) {
            int tmp = 0;
            for(String c: ans.split(",")) {
            	if(!c.equals(""))
            		tmp = tmp | Integer.parseInt(c+""); 
            }
            if(tmp == target)
                max = max+1;
            return;
        }
        
        helper(nums, ans+nums[idx]+",", idx+1, target);
        helper(nums, ans, idx+1, target);
    }
}
