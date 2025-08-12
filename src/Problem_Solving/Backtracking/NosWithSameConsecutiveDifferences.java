package Problem_Solving.Leetcode.Backtracking;

import java.util.ArrayList;

public class NosWithSameConsecutiveDifferences {

	public static void main(String[] args) {
		int n = 3;
		int k = 7;
		int[] ans = numsSameConsecDiff(n, k);
		for(int i: ans)
			System.out.println(i +" ");
	}
	
	static public int[] numsSameConsecDiff(int N, int K) {
		
        if (N == 1)
            return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int num = 1; num < 10; ++num)
            dfs(N , K, num, 0, num, res);
        int ans[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
        return ans;
    }

	private static void dfs(int n, int k, int curr, int i, int prev, ArrayList<Integer> res) {
		if(i == n-1) {
			res.add(curr);
			return;
		}
		
		int next = prev+k;
		if(next < 10) {
			dfs(n, k, (curr*10)+next, i+1, next, res);
		}
		next = prev-k;
		if(k !=0 && next >= 0)
			dfs(n, k, (curr*10)+next, i+1, next, res);
	}
}
