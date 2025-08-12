package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CombinationSum2 {
	public static void main(String[] args) {
		CombinationSum2 comb = new CombinationSum2();
		int candidates[] = {2,1,3,1};
		Arrays.sort(candidates);
		int target = 3;
		comb.combinationSum2(candidates, target);
		List<List<Integer>> answer = comb.combinationSum2(candidates, target);
		for(int i=0; i<answer.size(); i++) {
			for(int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
		answer = null;
		System.out.println("\nBetter Sol (Removed sorting time): ");
		answer = comb.combinationSumOptimised(candidates, target);
		for(int i=0; i<answer.size(); i++) {
			for(int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return UniqueCombinationSum(candidates, target, 0, 0, new boolean[candidates.length], new ArrayList<Integer>(), 
        		new ArrayList<List<Integer>>());
    }

	public List<List<Integer>> UniqueCombinationSum(int candidates[], int target, int sum, int start, boolean vis[], 
			ArrayList<Integer> list, ArrayList<List<Integer>> List1)  { 
        if (sum == target) { 
        	String temp = "";
            for (int j=0; j<list.size(); j++) 
                temp = temp+list.get(j);
//            System.out.println(temp); 
            List1.add(new ArrayList<>(list));
        return List1; 
        }
        
        if(sum > target)
			return List1;
  
        for(int j=start; j<candidates.length; j++) {
        	if(j >0 && candidates[j] == candidates[j-1] && !vis[j-1])  // If cu. no. is visited previously at (j-1)th position, add this also. If cu. no. is skipped previously, skip this also.
    			continue;
        	if(!vis[j]) {
    			list.add(candidates[j]);
        		vis[j] = true;
     	        UniqueCombinationSum(candidates, target, sum+candidates[j], j+1, vis, list, List1); 
     	        list.remove(list.size()-1);
     	        vis[j] = false;
        	}
        }
        return List1;
    } 
	
	
	//Better sol - Sorting time is removed
	public List<List<Integer>> combinationSumOptimised(int[] candidates, int target) {
        ArrayList<Integer> inp = new ArrayList<Integer>();
		HashMap<Integer, Integer> unique = new HashMap<Integer, Integer>();
		for(Integer i: candidates) {
			if(unique.containsKey(i))
				unique.put(i, unique.get(i)+1);
			else {
				unique.put(i, 1);
				inp.add(i);
			}
		}
		return printSelections(inp, unique, 0, target, 0, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
    }
	
	public ArrayList<List<Integer>> printSelections(ArrayList<Integer> inp, HashMap<Integer, Integer> unique, int sum, int target, int lastIdx, 
			ArrayList<Integer> list, ArrayList<List<Integer>> List1) {
		if(sum == target) {
			List1.add(new ArrayList<>(list));
			return  List1;
		}

		if(sum > target)
			return List1;

		for(int i = lastIdx; i<inp.size(); i++) {
			int tmp = inp.get(i);
			if(unique.get(tmp) > 0) {
				unique.put(tmp, unique.get(tmp) -1);
				list.add(tmp);
				printSelections(inp, unique, sum+tmp, target, i, list, List1);
				list.remove(list.size()-1);
				unique.put(tmp, unique.get(tmp) +1);
			}
		}
		return List1;
	}
//    list.add(candidates[i]);
//    UniqueCombinationSum(candidates, target, sum+candidates[i], index+1, data, i+1, list, List1); 
//    list.remove(list.size()-1);
//    UniqueCombinationSum(candidates, target, sum, index, data, i+1, list, List1); 
}
