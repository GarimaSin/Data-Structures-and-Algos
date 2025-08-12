package PracticeProb.src.ServerGoup;

import java.util.Scanner;

class Algorithm {
		static long Answer;
	static int time[];
	static long n;
	static int b;
	static int barber;
	static int pos,t;
	static boolean found;

	static int gcd(int a,int b){
		if(b==0)
			return a;
		if(b>a)
			return gcd(b,a);
		return gcd(b,a%b);
	}
	static int lcm(int a,int b){
		return ((a*b)/gcd(a,b));
	}
	static void getDiv(int t){
		for(int i=0;i<b;i++){
			if(t%time[i]==0){
				if(pos==n){
					barber=i;
					found=true;
					break;
				}
				pos++;
			}
		}
	}
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("HairCut.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			int i,k,totalDiv=0;

			b=sc.nextInt();
			n=sc.nextLong();
			time=new int[b];
			boolean allsame=true;
			int bb = 0;
			for(i=0;i<b;i++){
				time[i]=sc.nextInt();
				if(i==0)
					bb=time[i];
				else if(time[i]!=bb)
					allsame=false;
			}
			i=b;
			barber=0;
			found=false;
			k=time[0];

			if(n<=b)
				Answer=n;
			else if(allsame){
				Answer=n%b;
				if(Answer==0)
					Answer=b;
			}
			else{
				while(i>=1){
					k=lcm(k,time[--i]);
				}
				int sum=0;
				for(int j=0;j<b;j++){
					sum+=k/time[j];
				}
				n=n%sum;
				if(n==0)
					Answer=b;
				else if(n<=b)
					Answer=n;
				else{
					pos=b+1;
					t=1;
					while(!found && pos<=n){
						getDiv(t);
						t++;
					}
					Answer=barber+1;
				}
			}
			System.out.println("Case #"+(test_case+1)+": "+Answer);
		}
	}
}

/*Case #1: 1
Case #2: 3
Case #3: 1*/