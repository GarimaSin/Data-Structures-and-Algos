package Problem_Solving.Leetcode.Backtracking;

import java.util.ArrayList;


//Logic is correct but getting incorrect answer from XOR
// LC - 1863. Sum of All Subset XOR Totals
public class SubsetXORSum {

	public static void main(String[] args) {
		int[] nums = {5,1,6};
		ArrayList<Integer> list = new ArrayList<Integer>();
		findXORSum(nums, list, nums.length, 0, "");
		System.out.println(sum+"------------------");
	}


	static int sum = 0;
	static void findXORSum(int[] nums, ArrayList<Integer> list, int count, int idx, String ans) {
		if(idx == nums.length) {
//			if(count == 0) {
//			System.out.println(ans);
			if(ans.length() == 1)	{
				list.add(Integer.parseInt(ans));
				System.out.println(ans);
				sum = sum + Integer.parseInt(ans);
			}
			else if(ans.length() > 1){
				int tmp = ans.charAt(0) - '0';
				for(int i=1; i< ans.length(); i++) {
					System.out.println(ans+" = ans  " +(tmp^(ans.charAt(i) - '0'))+"...............................");
					sum = sum + (tmp^(ans.charAt(i) - '0'));
				}
			}
//			}
			return;
		}
		findXORSum(nums, list, count-1, idx+1, ans+nums[idx]);
		findXORSum(nums, list, count, idx+1, ans);
	}
}
