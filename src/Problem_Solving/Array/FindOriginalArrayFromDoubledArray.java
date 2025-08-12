package Problem_Solving.Array;

import java.util.Arrays;
import java.util.HashMap;

//Not working: Change map to HashMap<Integer, List<Integer>> map to store the indexes of the elems
public class FindOriginalArrayFromDoubledArray {
	public static int[] findOriginalArray(int[] changed) {
		if(changed.length % 2 != 0)
			return new int[0];

		Arrays.sort(changed);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i < changed.length; i++) {
			map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
		}

		int[] ans = new int[changed.length/2];
		int j = 0;
		for(int i: changed) {
			if(i != -1) {
				if(map.containsKey(i*2)) {
					int tmp = map.get(i*2);
					if(tmp == 1) {
						map.remove(i*2);
					} else
						map.put(i*2, tmp-1);
					ans[j] = i;
					j++;
					changed[tmp] = -1;
				} else
					return new int[0];
			} 
		}
		return ans;
	}

	public static void main(String[] args) {
		int changed[] = {0,0,0,0};
		int[] ans = findOriginalArray(changed);
		for(int i: ans)
			System.out.println(i);
	}
}
