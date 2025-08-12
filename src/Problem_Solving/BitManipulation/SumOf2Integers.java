package Problem_Solving.BitManipulation;

public class SumOf2Integers {

	public int getSum(int a, int b) {
        while(b != 0) {
            int carry = ((a&b) << 1);
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
