package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterTilePossibilities {

	static boolean vis[];
	public static void main(String[] args) {
		LetterTilePossibilities ltp = new LetterTilePossibilities();
		String inp = "CDC";
		vis = new boolean[inp.length()];
		char[] chars = inp.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
		List<List<String>> answer = ltp.subsets(sorted);
		for(int i=0; i<answer.size(); i++) {
			for(int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<String>> subsets(String nums) {
		List<List<String>> list = new ArrayList<>();
		subsetsHelper(list, new ArrayList<>(), nums);
		list.remove(0);
		return list;
	}
 
	private void subsetsHelper(List<List<String>> list , List<String> resultList, String inp){
		list.add(new ArrayList<>(resultList));
		for(int i = 0; i < inp.length(); i++){
			if(i>0 && !vis[i-1] && inp.charAt(i) == inp.charAt(i-1))  
				continue;
			if(!vis[i]){
        		vis[i] = true;
				resultList.add(inp.charAt(i)+"");
				subsetsHelper(list, resultList, inp);
				resultList.remove(resultList.size() - 1);
				vis[i] = false;
			}
		}
	}

}
