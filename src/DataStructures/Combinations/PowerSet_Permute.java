package DataStructures.Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Powerset code works only for Perm WO rep
 *
 */
public class PowerSet_Permute {

	static boolean vis[];
	public static void main(String[] args) {
		PowerSet_Permute powerSet = new PowerSet_Permute();
		String inp = "123";
		vis = new boolean[inp.length()];
		List<List<String>> answer = powerSet.subsets(inp);
//		for(int i=0; i<answer.size(); i++) {
//			for(int j=0; j<answer.get(i).size(); j++) {
//				System.out.print(answer.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}
	}
	
	public List<List<String>> subsets(String nums) {
		List<List<String>> list = new ArrayList<>();
		subsetsHelper(list, new ArrayList<>(), nums, "");
		return list;
	}
 
	private void subsetsHelper(List<List<String>> list , List<String> resultList, String inp, String ans){
		
		System.out.println(ans);
		
		for(int i = 0; i < inp.length(); i++){
			if(!vis[i]){
        		vis[i] = true;
				subsetsHelper(list, resultList, inp, ans+inp.charAt(i));
				vis[i] = false;
			}
		}
	}
}
