package PracticeProb.src.Recursion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MetalStick {

	static int Answer,stick,flag=0,temp,start,mainstart;
	static int[] external,internal,visited,series;
	public static boolean check(int counttemp,int ext,int intern){

		if(counttemp==stick){
			Answer=counttemp;
			mainstart=start;
			flag=1;
			return false;

		}
		if(Answer<counttemp){
			mainstart=start;
			Answer=counttemp;
		}
		for(int i=0;i<stick;i++){
			if(counttemp==0){
				intern=internal[i];
				ext=external[i];
				visited[i]=1;
				counttemp++;
				start=temp;
				series[temp++]=i;
				check(counttemp,external[i],internal[i]);
				visited[i]=0;
				counttemp--;
				if(flag==1) break;
			}
			if(intern==external[i] && visited[i]!=1){
				visited[i]=1;
				counttemp++;
				series[temp++]=i;
				check(counttemp,external[i],internal[i]);
				visited[i]=0;
				counttemp--;
				if(flag==1) break;
			}

		}

		return false;
	}
	public static void main(String args[]) throws Exception	{

//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("metalStick.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			stick=sc.nextInt();
			int count=0;
			flag=0;
			temp=0;
			Answer=0;
			external=new int[stick];
			internal=new int[stick];
			visited=new int[stick];
			series=new int[500];
			for(int i=0;i<stick;i++){
				external[i]=sc.nextInt();
				internal[i]=sc.nextInt();
			}
			//visited[0]=1;
			check(count,-1,-1);
			//System.out.println(Answer);
			System.out.print("Case #"+(test_case+1)+" ");

			for(int i=mainstart;i<mainstart+Answer;i++){
				System.out.print(external[series[i]]+" "+internal[series[i]]+" ");
			}
			System.out.println();
		}
	}
}

//Case #1 2 3 3 4 4 5
//
//Case #2 5 1 1 2 2 4 4 3


