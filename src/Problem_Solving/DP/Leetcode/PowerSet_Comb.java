package Problem_Solving.DP.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PowerSet_Comb {
	public static void main(String[] args) {
		PowerSet_Comb powerSet = new PowerSet_Comb();
		int nums[] = {1,2,3,4};
		List<List<Integer>> answer = powerSet.subsets(nums);
		for(int i=0; i<answer.size(); i++) {
			for(int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		subsetsHelper(list, new ArrayList<>(), nums, 0);
		return list;
	}
 
	private void subsetsHelper(List<List<Integer>> list , List<Integer> resultList, int [] nums, int start){
		list.add(new ArrayList<>(resultList));
		for(int i = start; i < nums.length; i++){
			resultList.add(nums[i]);
			subsetsHelper(list, resultList, nums, i + 1);
			resultList.remove(resultList.size() - 1);
		}
	}
} 
