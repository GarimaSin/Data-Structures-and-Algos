package PracticeProb.src.ServerGoup;

import java.util.Scanner;

class PaintAGraph {
	static int Answer,node,flag=0,count,nodespainted;
	public static int[] colourarray,visited;
	public static int[][] adj;

	public static boolean check(int row,int col){
		if(nodespainted==node) return false;

		for(int i=1;i<=node;i++){
			if(adj[row][i]==1){

				if(visited[i]==1 && colourarray[i]!=~col){
					flag=1;
					break;
				}

				if(visited[i]!=1){
					colourarray[i]=~col;
					nodespainted++;
					visited[i]=1;
					if(col==~1) count++;
					check(i,~col);

					if(flag==1) return false;

				}

			}
		}
		return false;
	}
	public static void main(String args[]) throws Exception	{

		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			flag=0;
			count=0;
			nodespainted=0;
			node=sc.nextInt();
			int edge=sc.nextInt();
			colourarray=new int[node+1];
			visited=new int[node+1];
			adj=new int[node+1][node+1];
			for(int i=0;i<edge;i++){
				int temp1=sc.nextInt();
				int temp2=sc.nextInt();
				adj[temp1][temp2]=1;
				adj[temp2][temp1]=1;
			}
			int colour=1;
			colourarray[1]=~colour;
			visited[1]=1;
			nodespainted=1;
			check(1,~colour);
			if(flag==1){
				System.out.print("Case #"+(test_case+1)+" ");
				System.out.print(-1);
			}
			else{
				System.out.print("Case #"+(test_case+1)+" "+count+" ");

				for(int v=1;v<=node;v++){
					if(colourarray[v]==1)
						System.out.print(v+" ");
				}
			}
			System.out.println();
		}
	}
}


/*Case #1 2 2 4

Case #2 -1*/
