package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
	public static void main(String[] args) {
		Subsets2 sub = new Subsets2();
		int nums[] = {1,2,2};
//		Arrays.sort(nums);
		List<List<Integer>> answer = sub.subsetsWithDup(nums);
		for(int i=0; i<answer.size(); i++) {
			for(int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		subsetsHelper(list, new ArrayList<>(), nums, 0, new boolean[nums.length]);
		return list;
	}
	
	private void subsetsHelper(List<List<Integer>> list , List<Integer> resultList, int [] nums, 
			int start, boolean[] vis){
		list.add(new ArrayList<>(resultList));
		for(int i = start; i < nums.length; i++){
			if(i>0 && nums[i] == nums[i-1] && !vis[i-1])
				continue;
			resultList.add(nums[i]);
			vis[i] = true;
			subsetsHelper(list, resultList, nums, i + 1, vis);
			resultList.remove(resultList.size() - 1);
			vis[i] = false;
		}
	}
}
