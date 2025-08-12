package Problem_Solving.Array;

import java.util.Arrays;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		int n = nums.length;
		int i;
		for (i = n-1; i>0; i--)
			if (nums[i] > nums[i - 1])
				break;

		if(i != 0) {
			int x = nums[i - 1], min = i;

			for (int j = i + 1; j < n; j++)
				if (nums[j] > x && nums[j] < nums[min])
					min = j;

			swap(nums, i-1, min);
			Arrays.sort(nums, i, n);
		} else {
			Arrays.sort(nums);		//for i/p = 321 ans = 123.
		}
	}

	void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
