package Problem_Solving.DP;

public class CherryPickup {

	public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer dp[][][][] = new Integer[m+1][n+1][m+1][n+1];
        int ans = cp(0, 0, 0, 0, grid, dp);
//      cherryPickupUpToDown(m, n, 0, 0, grid, 0);
        if(ans < -1)  
            return 0;
        return ans;
    }

	
	//Working
    public static int cp(int r1, int c1, int r2, int c2, int[][] arr, Integer[][][][] dp) {
	    if(r1>= arr.length || r2>=arr.length || c2>=arr[0].length || c1>=arr[0].length || arr[r1][c1]==-1 || arr[r2][c2]==-1) { 
	        return -999999;
	    }
	    //if p1 and p2 reach destination
	    if(r1 == arr.length - 1 && c1 == arr[0].length - 1) {
	        return arr[r1][c1];
	    }

        if(dp[r1][c1][r2][c2] != null)
            return dp[r1][c1][r2][c2];
	        
	    int f1 = cp(r1, c1+1, r2, c2+1, arr, dp); //v,v
	    int f2 = cp(r1, c1+1, r2+1, c2, arr, dp); //v,h
	    int f3 = cp(r1+1, c1, r2, c2+1, arr, dp); //h,v
	    int f4 = cp(r1+1, c1, r2+1, c2, arr, dp); //h,h
	    
	    int cherries = Math.max(Math.max(f1, f2), Math.max(f3, f4)); 
        
	    if(r1 == r2 && c1 == c2)
            cherries += arr[r1][c1];
        else 
            cherries += arr[r1][c1] + arr[r2][c2];
       
        dp[r1][c1][r2][c2] = cherries;
	    return cherries;
	}


	static int max = -999999;
	//Working - TLE
	static void cherryPickupUpToDown(int m, int n, int r, int c, int[][] grid, int sum) {
        if(r>=m || c>=n || grid[r][c] == -1)
            return;
        
        if(r == m-1 && c == n-1) {
            cherryPickupDownToUp(m, n, m-1, n-1, grid, sum);
            return ;
        }
        
        int state = grid[r][c];
        grid[r][c] = 0;
        cherryPickupUpToDown(m, n, r+1, c, grid, sum+state);
        cherryPickupUpToDown(m, n, r, c+1, grid, sum+state);
        grid[r][c] = state;
    }
    
    static void cherryPickupDownToUp(int m, int n, int r, int c, int[][] grid, int sum) {
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c] == -1)
            return;
        
        if(r == 0 && c == 0) {
            max = Math.max(max, sum);
            return;
        }
        int state = grid[r][c];
        grid[r][c] = 0;
        cherryPickupDownToUp(m, n, r-1, c, grid, sum+state);
        cherryPickupDownToUp(m, n, r, c-1, grid, sum+state);
        grid[r][c] = state;
    }
    
    
	public static void main(String[] args) {
		int[][] grid = {{1,1,-1},{1,-1,1},{-1,1,1}};
//		int[][] grid = {{0,1,-1},{1,0,-1},{1,1,1}};
		System.out.println(cherryPickup(grid)+"....");
		System.out.println(max);
	}
}