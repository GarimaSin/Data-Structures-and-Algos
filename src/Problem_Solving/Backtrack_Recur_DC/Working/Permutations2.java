package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

	public static void main(String[] args) {
		int nums[] = {3,3,0,3};
		Arrays.sort(nums);
		Permutations2 comb = new Permutations2();
		List<List<Integer>> answer = comb.permuteUnique(nums);
		for(int i=0; i<answer.size(); i++) {
			for(int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		return permute(nums, new ArrayList<Integer>(), new ArrayList<List<Integer>>(), new boolean[nums.length]);
	} 	
	
	public List<List<Integer>> permute(int nums[], List<Integer> list, List<List<Integer>> ans, boolean vis[]) {
		if(list.size() > nums.length)
			return null;
		if(list.size() == nums.length) {
			ans.add(new ArrayList<>(list));
		}
		
		for(int i=0; i<nums.length; i++) {
			if(i>0 && !vis[i-1] && nums[i] == nums[i-1])
				continue;
			if(!vis[i]) {
				vis[i] = true;
				list.add(nums[i]);
				permute(nums, list, ans, vis);
				vis[i] = false;
				list.remove(list.size()-1);
			}
		}
		return ans;
	}

}
