package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
	public static void main(String[] args) {
		CombinationSum3 comb = new CombinationSum3();
		int n = 7;
		int k = 3;
		List<List<Integer>> answer = comb.combinationSum3(n, k);
		for(int i=0; i<answer.size(); i++) {
			for(int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
        return CombinationSum(1, n, 0, k, new boolean[10], new ArrayList<Integer>(), 
        		new ArrayList<List<Integer>>());
    }
    
    public List<List<Integer>> CombinationSum(int start, int target, int sum, int targetLen, boolean vis[], 
			ArrayList<Integer> list, ArrayList<List<Integer>> ans)  { 
        if (sum == target && list.size() == targetLen) { 
            ans.add(new ArrayList<>(list));
        return ans; 
        }
        
        if(list.size() > targetLen)
			return ans;
  
        for(int j=start; j<10; j++) {
        	if(!vis[j]) {
    			list.add(j);
        		vis[j] = true;
        		CombinationSum(j, target, sum+j, targetLen, vis, list, ans); 
     	        list.remove(list.size()-1);
     	        vis[j] = false;
        	}
        }
        return ans;
    } 
}
