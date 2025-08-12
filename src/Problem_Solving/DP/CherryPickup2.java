package Problem_Solving.DP;

public class CherryPickup2 {

	public static int cherryPickup(int[][] grid) {
		int m = grid.length;
        int n = grid[0].length;

        int dp[][][] = new int[m+1][n+1][n+1];
        int ans = cherrypick2DP(0, 0, n-1, grid, dp);
        if(ans == -999999)  
            return 0;
        return ans;
    }
	
	//Working - TLE
	static int dir[] = {-1, 0, 1};
	public static int cherrypick2(int r, int c1, int c2, int[][] arr, int[][][] dp) {
	    if(r>= arr.length || c2>=arr[0].length || c1>=arr[0].length || r<0 || c1<0 || c2<0) { 
	        return -999999;
	    }
	    //if p1 or p2 reach destination
	    if(r == arr.length - 1) {
            if(c1 == c2)
                return arr[r][c1];
	        return arr[r][c1] + arr[r][c2];
	    }
	    
	    int max = -999999;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                int cherries = 0; 
            	cherries += cherrypick2DP(r+1, c1+dir[i], c2+dir[j], arr, dp); 
    	        if(c1 == c2){
    	            cherries += arr[r][c1];
    	        } else {
    	            cherries += arr[r][c1] + arr[r][c2];
    	        }
                max = Math.max(max, cherries);
            }
        }    
	    return max;
    }


	//Working DP
	public static int cherrypick2DP(int r, int c1, int c2, int[][] arr, int[][][] dp) {
	    if(r>=arr.length || c2>=arr[0].length || c1>=arr[0].length || r<0 || c1<0 || c2<0) { 
	        return -999999;
	    }
	    //if p1 or p2 reach destination
	    if(r == arr.length - 1) {
            if(c1 == c2)
                return arr[r][c1];
	        return arr[r][c1] + arr[r][c2];
	    }
	    
	    if(dp[r][c1][c2] != -1)
	    	return dp[r][c1][c2];
	    
	    int max = -999999;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                int cherries = 0; 
            	cherries += cherrypick2DP(r+1, c1+dir[i], c2+dir[j], arr, dp); 
    	        if(c1 == c2){
    	            cherries += arr[r][c1];
    	        } else {
    	            cherries += arr[r][c1] + arr[r][c2];
    	        }
                max = Math.max(max, cherries);
            }
        }  
        
        dp[r][c1][c2] = max;
	    return max;
	}
	
	
    
	public static void main(String[] args) {
		int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
//		int[][] grid = {{0,1,-1},{1,0,-1},{1,1,1}};
		System.out.println(cherryPickup(grid)+"....");
//		System.out.println(max);
	}
}