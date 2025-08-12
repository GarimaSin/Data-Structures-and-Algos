package Problem_Solving.Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequence {

	public static void main(String[] args) {
//		int nums[] = {1,2,1};
		int nums[] = {4,6,7,7};
		List<List<Integer>> ans = findSubsequences(nums);
		for(List<Integer> list: ans) {
			for(Integer i: list) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}


	private static Set<List<Integer>> set = new HashSet<>();

	public static List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		printSelections(0, nums, ans, list, set);
		return ans;
	}

	static void printSelections(int start, int[] nums, List<List<Integer>> ans, List<Integer> list, Set<List<Integer>> set) {
		if(list.size() > 1 && set.add(new ArrayList<>(list)))				//Don't want single digits in answer 
			ans.add(new ArrayList<Integer>(list));
		
		if(start >= nums.length) 
			return;

		for(int i=start; i<nums.length; i++) {
			Integer tmp = nums[i];

			if(!list.isEmpty() && list.get(list.size()-1) <= tmp) {
				list.add(tmp);
				printSelections(i+1, nums, ans, list, set);
				list.remove(list.size()-1);
			} else if(list.isEmpty()) {
				list.add(tmp);
				printSelections(i+1, nums, ans, list, set);
				list.remove(list.size()-1);
			}
		}
	}
}