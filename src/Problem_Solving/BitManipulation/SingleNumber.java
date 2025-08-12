package Problem_Solving.BitManipulation;

public class SingleNumber {

	public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }
	
	public static void main(String[] args) {
		int nums[] = {4,1,2,1,2};
		int ans = singleNumber(nums);
		System.out.println(ans);
	}
}
