package Problem_Solving.Array.Pepcoding;

import java.util.HashSet;

public class ConsecutiveNumbersSum {

	public static int consecutiveNumbersSum(int n) {
        int[] arr = new int[n+1];
        int count = 0;
        HashSet<Integer> map = new HashSet<>();
        arr[0] = 0;
        arr[1] = 1;
        map.add(0);
        map.add(1);
        for(int i=2; i<=n; i++) {
            int currSum = i + arr[i-1];
            arr[i] = currSum;
            map.add(currSum);
            if(map.contains(currSum - n))
                count++;
        }
        return count;
    }
	
	
	public static void main(String[] args) {
		System.out.println(consecutiveNumbersSum(855204));
	}
}
