package Problem_Solving.Hash;

import java.util.HashMap;

public class CountPairsWithGivenSum {

	public static void main(String[] args) {
		int N = 4, K = 6;
		int arr[] = {1, 5, 7, 1};
		int ans = getPairsCount(arr, N, K);
		System.out.println(ans);
	}
	
	static int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i: arr) {
            if(map.containsKey(k-i)) {
                ans = ans + map.get(k-i);
            }
            int tmp = map.getOrDefault(i, 0);
            map.put(i, tmp+1);
        }
        return ans;
    }

}
