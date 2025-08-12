package Problem_Solving.DP.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class PaintHouse {

	public static void main(String[] args) {
		int arr[][] = {{17,2,17},{16,16,5},{14,3,19}};
		System.out.println(minCost(arr)); 
	}
	
	public static int minCost(int[][] costs) {
		int memo[][] = new int[costs.length][costs[0].length];
		return findMinCost(costs, 0, 0, memo);
	}

	private static int findMinCost(int[][] costs, int i, int j, int[][] memo) {
		if(i<0 || j<0 || i>= costs.length || j>= costs.length)
			return 0;
		
		if(memo[i][j] > 0) 
			return memo[i][j];
		
		int cost1 = findMinCost(costs, i+1, memo) + costs[i][j];
        int cost2 = findMinCost(costs, i+2, memo) + costs[i][j];
        int cost3 = findMinCost(costs, i+2, memo) + costs[i][j];
	}

	/**
	 * u hv to maintain 3 minimums
		cost(i,b)=min(cost(i-1,g),cost(i-1,r))+cost of painting i as b;
		cost(i,g)=min(cost(i-1,b),cost(i-1,r))+cost of painting i as g;
		cost(i,r)=min(cost(i-1,g),cost(i-1,b))+cost of painting i as r;
		
		finally min(cost(N,b),cost(N,g),cost(N,r)) is the ans
	 * 
	 */
//	public static int minCost(int[][] costs) {
//		if(costs == null || costs.length ==0)
//			return 0;
//		
//		int[][] ans = new int[3][costs.length];
//		for(int i=0; i<costs.length; i++) {
//			if(i==0){
//	            ans[0][i]=costs[i][0];
//	            ans[1][i]=costs[i][1];
//	            ans[2][i]=costs[i][2];
//	        }else{
//	        	ans[0][i]=Math.min(ans[1][i-1], ans[2][i-1])+costs[i][0];
//	            ans[1][i]=Math.min(ans[0][i-1], ans[2][i-1])+costs[i][1];
//	            ans[2][i]=Math.min(ans[0][i-1], ans[1][i-1])+costs[i][2];
//	        }
//		}
//		
//		int len = costs.length-1;
//		int min1 = Math.min(ans[0][len], ans[1][len]);
//		return Math.min(min1, ans[2][len]);
//	}
	
	
	
	//Working
	private int[][] costs;
	public int minCostWorking(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        this.costs = costs;
        return Math.min(paintCost(0, 0), Math.min(paintCost(0, 1), paintCost(0, 2)));
    }

    private int paintCost(int n, int color) {
        int totalCost = costs[n][color];
        if (n == costs.length - 1) {
        } else if (color == 0) { // Red
            totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
        } else if (color == 1) { // Green
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
        } else { // Blue
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
        }        
        return totalCost;
    }
    
    
    //Working Memo:
    private Map<String, Integer> memo;

    public int minCostMemo(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        this.costs = costs;
        this.memo = new HashMap<>();
        return Math.min(paintCost(0, 0), Math.min(paintCost(0, 1), paintCost(0, 2)));
    }

    private int paintCostMemo(int n, int color) {
        if (memo.containsKey(getKey(n, color))) {
            return memo.get(getKey(n, color));   
        }
        int totalCost = costs[n][color];
        if (n == costs.length - 1) {
        } else if (color == 0) { // Red
            totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
        } else if (color == 1) { // Green
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
        } else { // Blue
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
        }        
        memo.put(getKey(n, color), totalCost);

        return totalCost;
    }

    private String getKey(int n, int color) {
        return String.valueOf(n) + " " + String.valueOf(color);
    }
}