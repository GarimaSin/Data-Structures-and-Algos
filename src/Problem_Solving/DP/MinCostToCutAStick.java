package Problem_Solving.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinCostToCutAStick {

	
	// https://www.youtube.com/watch?v=HYKVPfFGpiE
	public static void main(String[] args) {
		int n = 9;
		int[] cuts = {5,6,1,4,2};
		System.out.println(minCost(n, cuts));
	}

	
	// TLE - 8/101
	public static int minCost1(int n, int[] cuts) {
		ArrayList<rodCuts> list = new ArrayList<>();
		list.add(new rodCuts(0, n));
		
		boolean[] vis = new boolean[cuts.length];
		return getMinCuttingCost1(cuts, 0, 0, list, vis);
	}
	
	static int min = 999999;
	static int getMinCuttingCost1(int[] cuts, int count, int sum, List<rodCuts> list, boolean[] vis) {
		if(count > cuts.length)
			return 999999;

		if(count == cuts.length) {
			min = Math.min(min, sum);
			return sum;
		}
		
		for(int idx =0; idx<cuts.length; idx++) {
			if(!vis[idx]) {

				int i = -1;
				for(rodCuts c: list) {
					i++;
					if(cuts[idx] >= c.start && cuts[idx] < c.end) 
						break;
				}

				rodCuts before = list.get(i);
				int end = before.end;
				int len = end-before.start;

				list.set(i, new rodCuts(before.start, cuts[idx])); 
				list.add(i+1, new rodCuts(cuts[idx], end));	
				vis[idx] = true;
				getMinCuttingCost1(cuts, count+1, sum+len, list, vis);
				list.remove(i+1);
				list.set(i, before);
				vis[idx] = false;
			}
		}
		return min;
	}
	
	
	
	//MLE - 77/101
	public static int minCost2(int n, int[] cuts) {
		Integer dp[][] = new Integer[n+1][n+1];
		int[] cut = new int[cuts.length+2];
		cut[0] = 0;
		int j = 1;
		for(int i: cuts) {
			cut[j] = i;
			j++;
		}
		cut[j] = n;
		Arrays.sort(cut);
		return getMinCuttingCost2(n, cuts, 0, n, dp);
	}
	
	
	static int getMinCuttingCost2(int n, int[] cuts, int i, int j, Integer[][] dp) {
		if(i < 0 || j > n || i>j)
			return 0;
		
		int mini = 999999;
		
		if(dp[i][j] != null)
			return dp[i][j];
		
		for(int idx =0; idx<cuts.length; idx++) {
			int cut = cuts[idx];
			if(cut > i && cut < j) {
				int a = getMinCuttingCost2(n, cuts, i, cut, dp);
				int b = getMinCuttingCost2(n, cuts, cut, j, dp);
				int ans = a+b+(j-i); 
				mini = Math.min(mini, ans);
			}
		}
		return dp[i][j] = mini == 999999 ? 0: mini;
	}
	
	
	// Working
	public static int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m+2];
        arr[0] = 0;
        arr[m+1] = n;
        
        for (int i=0; i<m; i++) 
        	arr[i+1] = cuts[i];
        
        Arrays.sort(arr);
        Integer[][] dp = new Integer[m+2][m+2];
        return getMinCuttingCost(arr, 0, m+1, dp);
    }
	
	static int getMinCuttingCost(int[] arr, int i, int j, Integer[][] dp) {
        if (i+1 >= j) 
            return 0;
        
        if (dp[i][j] != null) 
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i+1; k<j; k++) {
            int a = getMinCuttingCost(arr, i, k, dp);
            int b = getMinCuttingCost(arr, k, j, dp);
            int cost = arr[j] - arr[i] + a+b;
            min = Math.min(min, cost);
        }
        return dp[i][j] = (min == Integer.MAX_VALUE ? 0 : min);
    }
}

class rodCuts {
	int start;
	int end;

	public rodCuts(int s, int e) {
		this.start = s;
		this.end = e;
	}
}
