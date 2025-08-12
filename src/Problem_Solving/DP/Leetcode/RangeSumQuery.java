package Problem_Solving.DP.Leetcode;

public class RangeSumQuery {

	private int[] sum;
	
	public static void main(String[] args) {
		int nums[] = {-2, 0, 3, -5, 2, -1};
		RangeSumQuery rs = new RangeSumQuery(nums);
		System.out.println(rs.sumRange(2, 5));
	}

	public RangeSumQuery(int[] nums) {
	    sum = new int[nums.length + 1];
	    for (int i = 0; i < nums.length; i++) {
	        sum[i + 1] = sum[i] + nums[i];
	    }
	}

	public int sumRange(int i, int j) {
	    return sum[j + 1] - sum[i];
	}

}
