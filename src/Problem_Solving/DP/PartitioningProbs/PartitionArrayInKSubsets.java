package Problem_Solving.DP.PartitioningProbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArrayInKSubsets {

	public static void main(String[] args) {
		int nums[] = {1,2,3,4};
		int k = 2;
		splitArray(nums, k);
		System.out.println("----------------");
		splitArray1(nums, k);
		System.out.println();
	}

	public static void splitArray(int[] nums, int k) {
		if(nums.length < k)
			return;
		if(nums.length == k) {
			System.out.println(Arrays.asList(nums).toString());
			return;
		}
		List<List<Integer>> buckets = new ArrayList<>();
		for (int i=0; i<k; i++) 
			buckets.add(new ArrayList<>());
		partitionInKSubsets(nums, 0, buckets);
	}



	public static void splitArray1(int[] nums, int k) {
		if(nums.length < k)
			return;

		if(nums.length == k) {
			System.out.println(Arrays.asList(nums).toString());
			return;
		}

		List<List<Integer>> buckets = new ArrayList<>();
		for (int i = 0; i < k; i++) 
			buckets.add(new ArrayList<>());
		boolean[] vis = new boolean[nums.length];
		backtrack(nums, vis, 0, k, buckets);
	}


	// Working
	// Time = O(kⁿ), Space = O(n)
	static void backtrack(int[] nums, boolean[] vis, int start, int k, List<List<Integer>> buckets) {
		if (start == nums.length) {
			// Check if all buckets are non-empty
			for (List<Integer> b : buckets) {
				if (b.isEmpty()) return;
			}
			System.out.println(buckets);
			return;
		}

		for (int i=start; i<nums.length; i++) {
			int num = nums[i];
			for (int j=0; j<k; j++) {
				buckets.get(j).add(num);
				if(!vis[i]) {
					vis[i] = true;
					backtrack(nums, vis, start+1, k, buckets);
					vis[i] = false;
				}
				buckets.get(j).remove(buckets.get(j).size() - 1);
				if (buckets.get(j).isEmpty()) 
					break;
			}
		}
	}



	/**
	 * [ 1 2 3, null]
		[ 1 2,  3]
		[ 1 3,  2]
		[ 1,  2 3]
		[ 2 3,  1]
		[ 2,  1 3]
		[ 3,  1 2]
		[,  1 2 3]
	 */
	// Working
	// Time	= O(kⁿ), Space = O(n × k)
	static void partitionInKSubsets(int[] nums, int idx, List<List<Integer>> buckets) {
		if (idx == nums.length) {
			// Ensure all buckets are non-empty
			for (List<Integer> b : buckets) {
				if (b.isEmpty()) 
					return;
			}
			System.out.println(buckets);
			return;
		}

		int currNum = nums[idx];
		for (int i=0; i<buckets.size(); i++) {
			List<Integer> bucket = buckets.get(i);

			bucket.add(currNum);
			partitionInKSubsets(nums, idx+1, buckets);
			bucket.remove(bucket.size() - 1);

			// 💡 Optimization: Avoid putting the same no. in multiple empty buckets
			if (bucket.isEmpty()) 
				break;
		}
	}
}
