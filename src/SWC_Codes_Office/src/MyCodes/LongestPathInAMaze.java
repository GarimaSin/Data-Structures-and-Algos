package SWC_Codes_Office.src.MyCodes;

//Working
// Finds the longest path in a maze, starting and end points are not fixed

import java.io.FileInputStream;
import java.util.Scanner;

public class LongestPathInAMaze {
    static int mat[][];
    static int N;
    static int len;
    static int visited[][];
    static int max;

    public static void findPath(int m, int n,int len){
        if(max<len){
            max = len;
        }

        if((m+1)<N &&  mat[m+1][n]==1 && visited[m+1][n]==0) {
            visited[m+1][n]=1;
            findPath(m+1,n,len+1);
            visited[m+1][n]=0;
        }
        if((n+1)<N && mat[m][n+1]==1 && visited[m][n+1]==0) {
            visited[m][n+1]=1;
            findPath(m,n+1,len+1);
            visited[m][n+1]=0;

        }
        if((m-1)>=0 && mat[m-1][n]==1 && visited[m-1][n]==0){
            visited[m-1][n]=1;
            findPath(m-1,n,len+1);
            visited[m-1][n]=0;
        }
        if((n-1)>=0 && mat[m][n-1]==1 && visited[m][n-1]==0){
            visited[m][n-1]=1;
            findPath(m,n-1,len+1);
            visited[m][n-1]=0;
        }

    }

    @SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
    	Scanner sc = new Scanner(new FileInputStream("LongestPath.txt"));
        int T = sc.nextInt();

        for(int test_case=0;test_case<T;test_case++){
            N = sc.nextInt();
            mat = new int[N][N];
            visited = new int[N][N];
            max=0;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    mat[i][j] = sc.nextInt();
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(mat[i][j]==1){
                        visited[i][j]=1;
                        findPath(i,j,1);
                        visited[i][j]=0;
                    }
                }
            }
            System.out.println("Case #"+(test_case+1));    
            System.out.println(max);
        }
    }
}