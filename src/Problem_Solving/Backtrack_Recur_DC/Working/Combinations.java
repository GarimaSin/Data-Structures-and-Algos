package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {      
		Combinations comb = new Combinations();
		List<List<Integer>> answer = comb.combine(4, 2);
		for(int i=0; i<answer.size(); i++) {
			for(int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j) + " ");
			}
			System.out.println();
		}
	} 

	public List<List<Integer>> combine(int n, int k) {
		return printAllKLengthRec(n,k,1, new boolean[n+1], new ArrayList<Integer>(), new ArrayList<List<Integer>>());
	}


	static List<List<Integer>> printAllKLengthRec(int n, int k, int start, boolean vis[], List<Integer> list,
			List<List<Integer>> ans) {
		if (list.size() == k) {
			ans.add(new ArrayList<>(list));
			return ans;
		}

		for (int i = start; i <= n; ++i) {
			if(!vis[i]){
				vis[i] = true;
				list.add(i);
				printAllKLengthRec(n, k, i, vis, list, ans);
				vis[i] = false;
				list.remove(list.size()-1);
			}
		}
		return ans;
	}
}
