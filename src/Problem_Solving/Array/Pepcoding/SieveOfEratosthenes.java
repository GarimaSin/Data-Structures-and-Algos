package Problem_Solving.Array.Pepcoding;

import java.util.Arrays;

public class SieveOfEratosthenes {

	static void calculatePrime(int n) {
		boolean isPrime[] = new boolean[n+1];
		Arrays.fill(isPrime, true);
		for (int i = 2; i*i <= isPrime.length; i++) {
			if(isPrime[i]) {
				for (int j = i+i; j < isPrime.length; j += i) {
					isPrime[j] = false;
				}
			}
		}
		for (int i = 2; i < isPrime.length; i++) {
			if(isPrime[i])
				System.out.print(i+"  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		calculatePrime(50);
	}
}