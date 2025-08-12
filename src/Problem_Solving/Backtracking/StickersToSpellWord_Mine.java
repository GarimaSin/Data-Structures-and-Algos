package Problem_Solving.Leetcode.Backtracking;

import java.util.HashMap;

//TLE
public class StickersToSpellWord_Mine {

	public static int minStickers(String[] stickers, String target) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String s: target.split("")) {
			if(map.get(s) == null)
				map.put(s,1);
			else
				map.put(s,map.get(s)+1);
		}
		helper(stickers, target, map, 0, "", 0);
		System.out.println(min+"___________");
		return min;
	}
	
	private static void helper(String[] stickers, String target, HashMap<String, Integer> map, int idx, String ans, int count) {
		if(count >= min)
            return;
		
		if(map.size() == 0) {
			min = Math.min(min, count);
			System.out.println(ans);
			return;
		}
		
		for (int i = idx; i < stickers.length; i++) {
			boolean found = false;
			HashMap<String, Integer> tmp = new HashMap<String, Integer>();
			tmp.putAll(map);
			for(String s: stickers[i].split("")) {
				if(map.get(s) != null && !map.get(s).equals(0)) {
					if(map.get(s)-1 == 0)
						map.remove(s);
					else
						map.put(s, map.get(s)-1);
					found = true;
					continue;
				}
			}
			if(found) {
				helper(stickers, target, map, i, ans+stickers[i]+" ", count+1);
				map.putAll(tmp);
			} else {
				helper(stickers, target, map, i+1, ans, count);
			}
		}
	}

	static int min = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) {
		String[] stickers = {"with","example","science"};
		String target = "thehat";
		minStickers(stickers, target);
	}

}
