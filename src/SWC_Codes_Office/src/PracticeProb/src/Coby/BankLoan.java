package PracticeProb.src.Coby;

//Working
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankLoan {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("BankLoan.txt"));	
		int T = sc.nextInt();
		for(int t=1; t<=T; t++){
			int b[] = new int[10000];
			int n = sc.nextInt();
			int c =1;
			 if(n==0)
				  break;
			 
			int sum = 0;
		        for(int i=0;i<n;i++)
		        	b[i] = 0;
		        for(int i=0;i<n;i++){
		         for(int j=0;j<n;j++){
		            int z = sc.nextInt();
		            if(z!=0){
		                b[j]+=z;
		                b[i]-=z;
		                sum+=z;
		             }
		            }
		        }
		        int ans = 0;
		        for(int i=0;i<n;i++){
		        	if(b[i] > 0)
		        		ans += b[i];
		        }
		        System.out.println(t+". "+sum+" "+ans);
		        c++;
		    }
		}
}
