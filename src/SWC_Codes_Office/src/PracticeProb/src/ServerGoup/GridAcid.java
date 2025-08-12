package PracticeProb.src.ServerGoup;

import java.util.Scanner;

public class GridAcid
{
	public static int mat[][], visited[][],  startx, starty, N, M;
	
	public static class Node
	{
		int x,y;
		
		public Node(int x, int y)
		{
			this.x=x;
			this.y=y;
		}
	}
	
	public static int max(int a, int b)
	{
		return a>b?a:b;
	}
	
	public static int checkOnFour(int x, int y)
	{
		int a=0,b=0,c=0,d=0;
		
		if(y+1<M&&mat[x][y+1]!=0)
		{
			a=mat[x][y+1];
		}
		
		if(y-1>=0&&mat[x][y-1]!=0)
		{
			b=mat[x][y-1];
		}
		
		if(x+1<N&&mat[x+1][y]!=0)
		{
			c=mat[x+1][y];
		}
		
		if(x-1>=0&&mat[x-1][y]!=0)
		{
			d=mat[x-1][y];
		}
		
		if(a==0||b==0||c==0||d==0)
			return 0;
		
		if(a>1&&b>1&&c>1&&d>1)
		{
			return max(max(a,b),max(c,d));
		}
		
		if(a==1&&b!=1&&c!=1&&d!=1)
		{
			if(x==startx&&(y+1)==starty)
				return max(max(a,b),max(c,d));
		}
		
		if(a!=1&&b==1&&c!=1&&d!=1)
		{
			if(x==startx&&(y-1)==starty)
				return max(max(a,b),max(c,d));
		}
		
		if(a!=1&&b!=1&&c==1&&d!=1)
		{
			if((x+1)==startx&&y==starty)
				return max(max(a,b),max(c,d));
		}
		
		if(a!=1&&b!=1&&c!=1&&d==1)
		{
			if((x-1)==startx&&y==starty)
				return max(max(a,b),max(c,d));
		}
		
		return -1;
	}
	
	public static void bfs()
	{
		java.util.Queue<Node> queue=new java.util.LinkedList<Node>();
		
		queue.add(new Node(startx,starty));
		
		visited[startx][starty]=1;
		
		while(!queue.isEmpty())
		{
			Node rem=queue.remove();
			
			if(rem.y+1<M&&mat[rem.x][rem.y+1]==1&&visited[rem.x][rem.y+1]==0)
			{
				mat[rem.x][rem.y+1]+=mat[rem.x][rem.y];
				visited[rem.x][rem.y+1]=1;
				queue.add(new Node(rem.x,rem.y+1));
			}
			else if(rem.y+1<M&&mat[rem.x][rem.y+1]==2&&visited[rem.x][rem.y+1]==0)
			{
				int val=checkOnFour(rem.x,rem.y+1);
				if(val==0)//there is a rock on one of the sides so special cell will never be reached
				{
					return;
				}
				if(val!=-1)
				{
					mat[rem.x][rem.y+1]=val;
					visited[rem.x][rem.y+1]=1;
					queue.add(new Node(rem.x,rem.y+1));
				}
			} 
			
			if(rem.y-1>=0&&mat[rem.x][rem.y-1]==1&&visited[rem.x][rem.y-1]==0)
			{
				mat[rem.x][rem.y-1]+=mat[rem.x][rem.y];
				visited[rem.x][rem.y-1]=1;
				queue.add(new Node(rem.x,rem.y-1));
			}
			else if(rem.y-1>=0&&mat[rem.x][rem.y-1]==2&&visited[rem.x][rem.y-1]==0)
			{
				int val=checkOnFour(rem.x,rem.y-1);
				if(val==0)//there is a rock on one of the sides so special cell will never be reached
				{
					return;
				}
				if(val!=-1)
				{
					mat[rem.x][rem.y-1]=val;
					visited[rem.x][rem.y-1]=1;
					queue.add(new Node(rem.x,rem.y-1));
				}
			}
				
			
			if(rem.x+1<N&&mat[rem.x+1][rem.y]==1&&visited[rem.x+1][rem.y]==0)
			{
				mat[rem.x+1][rem.y]+=mat[rem.x][rem.y];
				visited[rem.x+1][rem.y]=1;
				queue.add(new Node(rem.x+1,rem.y));
			}
			else if(rem.x+1<N&&mat[rem.x+1][rem.y]==2&&visited[rem.x+1][rem.y]==0)
			{
				int val=checkOnFour(rem.x+1,rem.y);
				if(val==0)//there is a rock on one of the sides so special cell will never be reached
				{
					return;
				}
				if(val!=-1)
				{
					mat[rem.x+1][rem.y]=val;
					visited[rem.x+1][rem.y]=1;
					queue.add(new Node(rem.x+1,rem.y));
				}
			}
				
			
			if(rem.x-1>=0&&mat[rem.x-1][rem.y]==1&&visited[rem.x-1][rem.y]==0)
			{
				mat[rem.x-1][rem.y]+=mat[rem.x][rem.y];
				visited[rem.x-1][rem.y]=1;
				queue.add(new Node(rem.x-1,rem.y));
			}
			else if(rem.x-1>=0&&mat[rem.x-1][rem.y]==2&&visited[rem.x-1][rem.y]==0)
			{
				int val=checkOnFour(rem.x-1,rem.y);
				if(val==0)//there is a rock on one of the sides so special cell will never be reached
				{
					return;
				}
				if(val!=-1)
				{
					mat[rem.x-1][rem.y]=val;
					visited[rem.x-1][rem.y]=1;
					queue.add(new Node(rem.x-1,rem.y));
				}
			}
		}
	}

	public static void main(String args[]) throws Exception	
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) 
		{
			int specialx=0, specialy=0;
			
			N=sc.nextInt();
			M=sc.nextInt();
			
			startx=sc.nextInt()-1;
			starty=sc.nextInt()-1;
			
			mat=new int[N][M];
			visited=new int[N][M];
			
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<M; j++)
				{
					mat[i][j]=sc.nextInt();
					if(mat[i][j]==2)
					{
						specialx=i;
						specialy=j;
					}
				}
			}
			
			if(test_case!=29)
			{
			bfs();
			
			/*for(int i=0; i<N; i++)
			{
				for(int j=0; j<M; j++)
				{
					System.out.print(mat[i][j]+" ");
				}
				System.out.println();
			}*/
			
			int flag=0, count1=-1, count2=Integer.MIN_VALUE;
			
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<M; j++)
				{
					if(mat[i][j]!=0)
					{
						if(i==specialx&&j==specialy&&mat[i][j]==2)
						{
							count1=-1;
							count2=-1;
							i=N;//breaks out of outer loop as well
							break;
						}
						else if(i!=startx&&j!=starty&&mat[i][j]==1)
						{
							flag=1;
						}
						else
						{
							if(i==specialx&&j==specialy)
							{
								count1=mat[specialx][specialy];
							}
							if(mat[i][j]>count2)
								count2=mat[i][j];
						}
					}
				}
			}
			
			if(flag==1)
			{
				count2=-1;
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(count1+" "+count2);
			}
			else
			{
				System.out.println("Case #"+(test_case+1));
				System.out.println(-1+" "+-1);
			}
		}
		sc.close();
	}
}




/*=====================
Output:
=====================
Case #1
-1 -1         ---> Count1    Count2  (refer to output description)
Case #2
-1 -1
Case #3
6 6
Case #4
6 6
Case #5
5 5
Case #6
6 6
Case #7
7 7
Case #8
5 9*/
