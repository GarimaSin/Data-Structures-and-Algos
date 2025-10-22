package Problem_Solving.BitManipulation;

public class Divide2Integers {

	public static void main(String[] args) {

	}
	
	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
		
        if (dividend == divisor)
            return 1;

        boolean sign = (dividend >= 0) == (divisor >= 0);
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int ans = 0;

        while (n >= d) {
            int count = 0;
            //V stop shifting b4 v hit 64 bits (since 'long'), so d value never wraps around.
            while ((count+1) < 63 && n >= (d << (count+1))) {	// = d * 2^(count+1)
                count++;
            }
            ans += 1 << count;		// ans = ans + 2^(count)
            n = n - (d * (1 << count));   		// d * 2^count
        }

        return sign ? ans : -ans;
    }

}
