package Problem_Solving.DP.PracticeProb;
/**
 * 
 * The maximum path is sum of all elements from first row to last row where you are allowed to move only 
 *              -----------------  down or diagonally to left or right.  --------------------- 
 *
 *	Time Complexity: O(N*M)
 */
public class MaxSumPath  {
	
    public static int N = 4, M = 6; 
    static int max = 0;
      
    // Function to calculate max path in matrix 
    static int findMaxPath(int mat[][]) {
    	
        // To find max val in first row 
        int res = -1; 
//        for (int i = 0; i < M; i++) 
//            res = Math.max(res, mat[0][i]); 
  
        for (int i = 1; i < N; i++)  
        { 
            res = -1; 
            for (int j = 0; j < M; j++)  
            { 
                // When all paths are possible 
                if (j > 0 && j < M - 1) 
                    mat[i][j] += Math.max(mat[i - 1][j], 
                                 Math.max(mat[i - 1][j - 1],  
                                    mat[i - 1][j + 1])); 
  
                // When diagonal right is not possible 
                else if (j > 0) 
                    mat[i][j] += Math.max(mat[i - 1][j], 
                                    mat[i - 1][j - 1]);
  
                // When diagonal left is not possible 
                else if (j < M - 1) 
                    mat[i][j] += Math.max(mat[i - 1][j], 
                                mat[i - 1][j + 1]); 
  
                // Store max path sum 
                res = Math.max(mat[i][j], res); 
            } 
        } 
        return res; 
    } 
      

    public static void main (String[] args)  {
    
        int mat[][] = {{2,2},
        		{2,2}};
  
        int N = mat.length;
//        System.out.println(findMaxPath(mat)); 
        
        int ans = 0, ans1=0;
        boolean vis[][] = new boolean[N][N];
        if(N == 1)
        	System.out.println(mat[0][0]);
        for(int i=0; i<N; i++) {
            int sum = findMaxPath1(mat, N, 0, i, vis, mat[0][i]); 
            int sum1 = findMaxPath2(mat, N, 0, i, vis, mat[0][i]); 
//            System.out.println(sum); 
            ans = Math.max(sum, ans);
            ans1 = Math.max(sum1, ans1);
        }
        System.out.println(ans); 
        System.out.println(ans1); 
    } 
    
    //Partial
    static int findMaxPath1(int[][] maze, int N, int row, int col, boolean vis[][], int sum) {
        if(row == N-1) {
//          return 0; 
        }
        
        if(row<0 || col<0 || row>=N || col>=N)
            return Integer.MIN_VALUE;
        
//        if(row>=N || col>=N)
//            return firstRow;
        
        int a =0, b=0, c=0;
        
        
        if(isSafe(row+1, col, N, vis)) {
        	vis[row+1][col] = true;
            a = sum + maze[row+1][col] + findMaxPath1(maze, N, row+1, col, vis, sum);
            vis[row+1][col] = false;
        }
        
        if(isSafe(row+1, col+1, N, vis)) {
        	vis[row+1][col+1] = true;
            b = sum + maze[row+1][col+1] + findMaxPath1(maze, N, row+1, col+1, vis, sum);
            vis[row+1][col+1] = true;
        }
        
        if(isSafe(row+1, col-1, N, vis)) {
        	vis[row+1][col-1] = true;
            c = sum + maze[row+1][col-1] + findMaxPath1(maze, N, row+1, col-1, vis, sum);
            vis[row+1][col-1] = true;
        }
        
        return Math.max(a,Math.max(b,c));
    }
    
    //Not
    static int findMaxPath2(int[][] maze, int N, int row, int col, boolean vis[][], int sum) {
        if(row == N-1) {
        	max = Math.max(sum,max);
        }
        
        if(isSafe(row+1, col, N, vis)) {
        	vis[row+1][col] = true;
            findMaxPath2(maze, N, row+1, col, vis, sum+ maze[row+1][col]);
            vis[row+1][col] = false;
        }
        
        if(isSafe(row+1, col+1, N, vis)) {
        	vis[row+1][col+1] = true;
            findMaxPath2(maze, N, row+1, col+1, vis, sum+ maze[row+1][col+1]);
            vis[row+1][col+1] = true;
        }
        
        if(isSafe(row+1, col-1, N, vis)) {
        	vis[row+1][col-1] = true;
            findMaxPath2(maze, N, row+1, col-1, vis, sum+ maze[row+1][col-1]);
            vis[row+1][col-1] = true;
        }
        
        return max;
    }
    
    static boolean isSafe(int r, int c, int N, boolean[][] vis) {
    	if(r>=0 && r<N && c>=0 && c<N)
    		if(!vis[r][c])
    			return true;
        return false;
    }
} 