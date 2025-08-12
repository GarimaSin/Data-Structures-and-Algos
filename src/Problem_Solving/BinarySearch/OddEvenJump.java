package Problem_Solving.BinarySearch;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {

	public static void main(String[] args) {
		int[] arr = {10,13,12,14,15};
		int ans = oddEvenJumps(arr);
		System.out.println(ans);
	}

	public static int oddEvenJumps(int[] arr) {
		int n = arr.length;
		int ans = 0;
		boolean[] oddJumps = new boolean[n];
        boolean[] evenJumps = new boolean[n];

        oddJumps[n-1] = true;
        evenJumps[n-1] = true;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(arr[n-1], n-1);

        for (int i=n-2; i>=0; i--) {
            Map.Entry<Integer, Integer> highVal = treeMap.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> lowVal = treeMap.floorEntry(arr[i]);
            
            if(evenJumps[highVal.getValue()])
            	oddJumps[i] = true;
            else
            	oddJumps[i] = false;
            
            if(oddJumps[lowVal.getValue()])
            	evenJumps[i] = true;
            else
            	evenJumps[i] = false;
            
            
            if (oddJumps[i]) {
                ans++;
            }
            treeMap.put(arr[i], i);
        }
		return ans;
	}

}
