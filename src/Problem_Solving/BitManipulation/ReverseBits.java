package Problem_Solving.BitManipulation;

public class ReverseBits {

	public int reverseBits(int n) {
		int mask = 1;
		// Update the first number
        int num = 0;
		// the length is guaranteed to be 32 -> 32 iteration
        for(int i = 1; i <= 32; i++){
            // this will return the last digit of the binary representation Ex: 101 & 1 -> 1, 100 & 1 -> 0
			int d = n & mask;
			// this will remove the last digit in the binary string. Ex: 100 >>= 1 -> 10, 1101  >>= 1 -> 1101
            n >>=1;
			// this will add 1 zero into the result. Ex: 1 <<=1 -> 10; 11101 <<= 1 -> 111010
            num <<= 1;
			// add the digit
            num += d;
        }
        return num;
    }
}
