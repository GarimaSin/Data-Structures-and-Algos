package Problem_Solving.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

	public static int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int dp[][] = new int[m+1][n+1];
        for(int[] rows: dp)
            Arrays.fill(rows, -1);
        return minimumTotal(triangle, 0, 0, m, dp);
    }

    public static int minimumTotal(List<List<Integer>> triangle, int r, int c, int m, int[][] dp) {
        if(r == m-1)
            return triangle.get(r).get(c);
        
        if(r<0 || c<0 || r>=m || c>=triangle.get(r).size())
            return 9999999;

        if(dp[r][c] != -1)
            return dp[r][c];

        int a = triangle.get(r).get(c) + minimumTotal(triangle, r+1, c, m, dp);
        int b = triangle.get(r).get(c) + minimumTotal(triangle, r+1, c+1, m, dp);
        int min = Math.min(a,b);
        dp[r][c] = min;
        return min;
    }
    
    public static void main(String[] args) {
    	List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    	//[[2],[3,4],[6,5,7],[4,1,8,3]];
    	ArrayList<Integer> singleList = new ArrayList<Integer>();
    	singleList.add(2);
    	triangle.add(singleList);
    	
    	singleList = new ArrayList<Integer>();
    	singleList.add(3);
    	singleList.add(4);
    	triangle.add(singleList);
    	
    	singleList = new ArrayList<Integer>();
    	singleList.add(6);
    	singleList.add(5);
    	singleList.add(7);
    	triangle.add(singleList);
    	
    	singleList = new ArrayList<Integer>();
    	singleList.add(4);
    	singleList.add(1);
    	singleList.add(8);
    	singleList.add(3);
    	triangle.add(singleList);

    	System.out.println(minimumTotal(triangle));
	}
       
}
