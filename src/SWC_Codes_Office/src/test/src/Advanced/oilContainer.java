package test.src.Advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class oilContainer {
	static int a = 0;
	static int b = 0;
	static int c = 0;
	static int Ans = 0;
	public static void main(String[] args) throws FileNotFoundException { 
		Scanner sc = new Scanner(new FileInputStream("container.txt"));
		int T=sc.nextInt();
		for(int t=0;t<T;t++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			Ans = 0;
			
	        if(a < b)
	        {
	            int temp = a;
	            a = b;
	            b = temp;
	        }
	        if(c > a && c > b)
	        {
	            Ans=-1;
	            System.out.println("Case #"+t);
	            System.out.println(Ans);
	            continue;
	        }
	        if(a == c || b == c)
	        {
	            Ans=1;
	            System.out.println("Case #"+t);
	            System.out.println(Ans);
	            continue;
	        }
	        if(c == 0)
	        {
	            Ans=0;
	            System.out.println("Case #"+t);
	            System.out.println(Ans);
	            continue;
	        }
	        int g = fillBucket(a,b);
	        if(c % g != 0)
	        {
	            Ans=-1;
	            System.out.println("Case #"+t);
	            System.out.println(Ans);
	            continue;
	        }
	        int count = 0, altCount = 0;
	        int firstBucket = 0, secondBucket = 0;
	        int altFirstBucket = 0, altSecondBucket = 0;
	        while(firstBucket != c && secondBucket != c && altFirstBucket != c && altSecondBucket != c)
	        {
	            if(altFirstBucket == 0)
	            {
	                altFirstBucket = b;
	                altCount++;
	            }
	            else if(altSecondBucket == a)
	            {
	                altSecondBucket = 0;
	                altCount++;
	            }
	            else
	            {
	                int rem = a - altSecondBucket;
	                altFirstBucket -= rem;
	                altSecondBucket = a;
	                if(altFirstBucket < 0)
	                {
	                    altSecondBucket += altFirstBucket;
	                    altFirstBucket = 0;
	                }
	                altCount++;
	            }
	            if(firstBucket == 0)
	            {
	                firstBucket = a;
	                count++;
	            }
	            else if(secondBucket == b)
	            {
	                secondBucket = 0;
	                count++;
	            }
	            else
	            {
	                int rem = b - secondBucket;
	                firstBucket -= rem;
	                secondBucket = b;
	                if(firstBucket < 0)
	                {
	                    secondBucket += firstBucket;
	                    firstBucket = 0;
	                }
	                count++;
	            }
	        }
	        Ans=count;
	        System.out.println("Case #"+t+1);
	        System.out.println(Ans);
		}
	}
	
	private static int fillBucket(int a, int b) {
		while(b != 0)
	    {
	        int res= a% b;
	        a = b;
	        b = res;
	    }
	    return a;
	}
	
}


