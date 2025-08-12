package Problem_Solving.Array.Pepcoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSumUniqueTarget {
	// ~~~~~~~~~~~~User Section~~~~~~~~~~~~
	public static List<List<Integer>> twoSum(int[] arr, int si, int ei, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int left = si;
		int right = ei;

		while (left < right) {
			if (left != si && arr[left] == arr[left - 1]) {				//Check for unique pair
				left++;
				continue;
			}

			int sum = arr[left] + arr[right];
			if (sum == target) {
				List<Integer> list = new ArrayList<>();
				list.add(arr[left]);
				list.add(arr[right]);
				res.add(list);

				left++;
				right--;
			} else if (sum > target) {
				right--;
			} else {
				left++;
			}
		}
		return res;
	}


	public static List<List<Integer>> threeSum(int[] nums, int targ) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length < 3) {
			return res;
		}

		Arrays.sort(nums);
		for (int i = 0; i <= nums.length - 3; i++) {
			if (i != 0 && nums[i - 1] == nums[i]) 					//Check for unique pair
				continue;

			int val1 = nums[i];
			int target = targ - val1;
			List<List<Integer>> subRes = twoSum(nums, i + 1, nums.length - 1, target);

			for (List<Integer> val : subRes) {
				val.add(val1);
				res.add(val);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = {-1, 0, 1, 2, -1, -4};
		int target = 0;
		List<List<Integer>> res = threeSum(arr, target);
		ArrayList<String> finalResult = new ArrayList<>();
		for (List<Integer> list : res) {
			Collections.sort(list);
			String ans = "";
			for (int val : list) {
				ans += val + " ";
			}
			finalResult.add(ans);
		}
		Collections.sort(finalResult);
		for (String str : finalResult) {
			System.out.println(str);
		}
	}
}
