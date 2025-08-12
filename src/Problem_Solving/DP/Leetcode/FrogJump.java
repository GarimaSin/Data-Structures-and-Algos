package Problem_Solving.DP.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FrogJump {

	public static void main(String[] args) {
		int[] stones = {0, 1, 2, 5, 6};
		System.out.println(canCross(stones));
	}

	
	// Working
	public static boolean canCross(int[] stones) {
		if(stones[1] != 1)
			return false;
		int max = 0;
		HashSet<Integer> map = new HashSet<>();
		for(int i: stones) {
			map.add(i);
			max = Math.max(max, i);
		}
		Map<String, Boolean> memo = new HashMap<>();
		return canCross(stones, 1, 1, map, max, memo);		// Start 4m index 1
	}

	static boolean canCross(int[] stones, int pos, int step, HashSet<Integer> map, int max, Map<String, Boolean> memo) {
		if(pos == max)
			return true;
		
		if(pos > max || step <= 0 || !map.contains(pos))
			return false;
		
		String key = pos + "," + step;
	    if (memo.containsKey(key)) 
	    	return memo.get(key);
		boolean s1 = canCross(stones, pos+(step-1), step-1, map, max, memo);
		if(s1) 
			return true;
		boolean s2 = canCross(stones, pos+(step), step, map, max, memo);
		if(s2) 
			return true;
		boolean s3 = canCross(stones, pos+(step+1), step+1, map, max, memo);
		boolean result = s1 || s2 || s3;
		memo.put(key, result);
		return result;
	}

}
