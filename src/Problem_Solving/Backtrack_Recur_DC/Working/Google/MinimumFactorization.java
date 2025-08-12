package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working.Google;


/**
 * 
 * Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.
	If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.
	Input: 15
	Output:35
	
	Sol: 
	We can start putting the numbers from 9 to 2 at the ones position and keep on proceeding towards more significant places. For every 
	number currently generated, we can check if the product of its digits exceeds the given number aa.
	Thus, we start with trying with the largest possible factor 99, obtain as many such counts of this factor as possible in res 
	and place such factors obtained at its least significant positions. Then, we go on decrementing the number currently considered as 
	the possible factor and if it is a factor, we keep on placing it at relatively more significant positions in res.
	
	Time complexity : O(8loga). Outer loop will iterate only 8 times, while inner loop takes O(logi) for particular i.
	Space complexity : O(1). Constant space is used.
 *
 */

public class MinimumFactorization {

	public static void main(String[] args) {
		MinimumFactorization minFact = new MinimumFactorization();
		System.out.println(minFact.smallestFactorization(48));
	}
	
	public int smallestFactorization(int a) {
		if (a < 2)
            return a;
        long res = 0, mul = 1;
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                a = a/i;
                res = mul * i + res;
                mul =mul * 10;
            }
        }
        return a < 2 && res <= Integer.MAX_VALUE ? (int)res : 0;
	}
	
	

}
