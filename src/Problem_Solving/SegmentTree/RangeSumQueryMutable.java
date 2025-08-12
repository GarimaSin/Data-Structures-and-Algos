package Problem_Solving.SegmentTree;

public class RangeSumQueryMutable {

	static int ans[];
	public static void main(String[] args) {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		intiateInputArray(nums);
		sumRange(0,2);
		sumRange(2,5);
		sumRange(0,5);	
	}
	
	
    public static void intiateInputArray(int[] nums) {
        ans = new int[nums.length];
        ans[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            ans[i] = ans[i-1] + nums[i];
        }
    }
    
    public static int sumRange(int i, int j) {
        if(i == 0) {
        	System.out.println(ans[j]);
            return ans[j];
        }
        else {
        	System.out.println(ans[j] - ans[i-1]);
            return ans[j] - ans[i-1];
        }
    }
}
