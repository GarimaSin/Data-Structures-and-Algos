package Problem_Solving.BitManipulation;

public class NumberOf1Bits {

	public int hammingWeight(int n) {
		int count = 0;
		while(n != 0) {
			int rsb = n & -n;
			n -= rsb;
			count++;
		}
		return count;
	}
}
