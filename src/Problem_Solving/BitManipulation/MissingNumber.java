package Problem_Solving.BitManipulation;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		int ans = 0;
		for(int i = 0 ; i < nums.length ; i++)
			ans = ans ^ i ^ nums[i];

		return ans ^ nums.length;
	}
}
