package Problem_Solving.Array.Pepcoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoSumUniqueTarget {
	// ~~~~~~~~~~~~User Section~~~~~~~~~~~~
	public static List<List<Integer>> twoSum(int[] arr, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int left = 0;
		int right = arr.length - 1;
		Arrays.sort(arr);
		while (left < right) {
			if (left != 0 && arr[left] == arr[left - 1]) {
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

	// ~~~~~~~~~~Input Management~~~~~~~~~~
	public static void main(String[] args) {
		int[] arr ={10, 10, 30, 40, 50, 20};
		int target = 60;
		List<List<Integer>> res = twoSum(arr, target);
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
