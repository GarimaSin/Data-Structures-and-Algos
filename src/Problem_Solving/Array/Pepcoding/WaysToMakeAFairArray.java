package Problem_Solving.Array.Pepcoding;

public class WaysToMakeAFairArray {

	static public int waysToMakeFair(int[] nums) {
		int n = nums.length;
		int[] odd = new int[n];
		int[] even = new int[n];

		int oddSum = 0;
		int evenSum = 0;

		if(nums.length == 1)
			return 1;
		if(nums.length == 2)
			return 0;

		for(int i = 0; i < n; i++) {
			if(i % 2 == 0)
				evenSum += nums[i];
			else
				oddSum += nums[i];
			odd[i] = oddSum;
			even[i] = evenSum;
		}

		int ans = 0;

		for(int i = 0; i < n; i++){
			if(i == 0) {
				int nOddSum = even[n-1] - nums[0];
				int nEvenSum = odd[n-1];

				if(nOddSum == nEvenSum)
					ans++;
				continue;
			} 
			int nOddSum = odd[i-1] + even[n-1] - even[i];
			int nEvenSum = even[i-1] + odd[n-1] - odd[i];

			if(nOddSum == nEvenSum)
				ans++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {1,1,1};
		int n = waysToMakeFair(nums);
		System.out.println(n);
	}
}
