package Problem_Solving.Array;

public class MaxContinuousCircularSum {

	public static void main(String[] args) {
		int arr[] = {2, 1, -5, 4, -3, 1, -3, 4, -1};
		findMax(arr);
	}

	private static void findMax(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -arr[i];
		}
		int ans = 0;
		Pair p = kadane(arr);
		for (int i = 0; i < arr.length; i++) {
			if(p.start>i || i>p.end)
				ans += arr[i];
		}
		System.out.println(-ans);
	}
	
	static Pair kadane(int[] arr) {
		int currSum = arr[0];
		int maxSum = arr[0];
		Pair p = new Pair();
		for (int i = 1; i < arr.length; i++) {
			if(currSum >= 0) {					//if previous sum > 0 then add the current val to prev
				currSum += arr[i];
			}
			else	{									// else leave the prev value and start a new subarray from this index.
				currSum = arr[i];
				p.start = i;
			}
			if(currSum > maxSum)	{
				p.end = i;
				maxSum = currSum;
			}
		}
		System.out.println(maxSum + "  start = "+p.start+" end = "+p.end);
		return p;
	}
	
	static class Pair {
		int start = 0;
		int end = 0;
	}
}
