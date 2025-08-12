package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_Mine {

	static List<List<Integer>> answer = new ArrayList<List<Integer>>();
	
	public static void main(String[] args) {
		CombinationSum_Mine comb = new CombinationSum_Mine();
		comb.combinationSum(new int[]{2,3,6,7}, 7);
		for(int i=0; i<answer.size(); i++) {
			for(int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		return combine("",candidates, target, new ArrayList<List<Integer>>(), new ArrayList<Integer>(), 0);
	}
	
	private List<List<Integer>> combine(String s, int[] candidates, int sum, List<List<Integer>> ans, ArrayList<Integer> list, int start) {
		if(sum < 0 || start>=candidates.length)
			return answer;

		if(sum == 0) {
			answer.add(new ArrayList<Integer>(list));
//			System.out.println(s);
		}	
		
		for(int j=start; j<candidates.length; j++) {
			list.add(candidates[j]);
			combine(s+candidates[j], candidates, sum-candidates[j], ans, list, j);
			list.remove(list.size()-1);
		}
		return answer;
	}
}
