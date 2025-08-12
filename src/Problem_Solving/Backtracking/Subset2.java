package Problem_Solving.Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Subset2 {

	public static void main(String[] args) {
		System.out.println("--------------");
		int nums[] = {1,2,2}; 
		subsetsWithDup(nums);
	}

	static public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		List<Integer> unique = new ArrayList<Integer>();
		for(Integer n: nums) {
			if(map.containsKey(n))
				map.put(n, map.get(n)+1);
			else {
				map.put(n, 1);
				unique.add(n);
			}
		}
		subsetsHelper(list, new ArrayList<>(), 0, map, unique, "");
		return list;              
	}

	private static void subsetsHelper(List<List<Integer>> list , List<Integer> resultList, int start, 
			HashMap<Integer,Integer> map, List<Integer> unique, String ans){

		if(start >= unique.size())
			return; 
		
		System.out.println(ans);
		list.add(new ArrayList<>(resultList));
		for(int i = start; i < unique.size(); i++){
			Integer tmp = unique.get(i);
			if(map.get(tmp) > 0) {
				map.put(tmp, map.get(tmp)-1);        
				resultList.add(tmp);
				subsetsHelper(list, resultList, i, map, unique, ans+tmp);
				resultList.remove(resultList.size() - 1);
				map.put(tmp, map.get(tmp)+1);
			}
		}
	}
}
