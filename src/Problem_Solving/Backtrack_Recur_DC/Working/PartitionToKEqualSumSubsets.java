package Problem_Solving.Backtrack_Recur_DC.Working;

import java.util.ArrayList;

// If the array has to be divided into k subsets with equal sum => 
// total sum of the array shud be equally divided into k subsets => totalSum / k shud not be floating no. 
/**
 * 
 * If sum is not divisible by k, we cannot divide the array into k subsets with equal sum. 
 * If sum is divisible by k, we check if k subsets with sum of elements equal to (sum/k)
 * exists or not.
 * Here, we find subsequence not subsets 
 * 
 * Code = CombWORep
 */


public class PartitionToKEqualSumSubsets {

	public static void main(String[] args) {
		int nums[] = {4,3,5,2,1};
		int k = 3;
		PartitionToKEqualSumSubsets part = new PartitionToKEqualSumSubsets();
		System.out.println(part.canPartitionKSubsets1(nums, k));
		System.out.println(part.canPartitionKSubsets(nums, k));
	}


	//Working - Code = CombWORep, No TLE w/o DP also
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for(int i=0; i<nums.length; i++) {
			sum = sum + nums[i];
		}
		if(sum%k == 0) {
			return partitionKSubsets(nums, new boolean[nums.length], 0, k, 0, 0, sum/k);
		} else
			return false;
	}

	private boolean partitionKSubsets(int[] nums, boolean[] vis, int start, int k, int cur_sum, 
			int cur_num, int target) {

		if(cur_num >= k-1) 
			return true;

		if(cur_sum == target) {
			cur_num = cur_num +1;
			return partitionKSubsets(nums, vis, 0, k, 0, cur_num, target);	// start wid another set once 1 set is complete
		}

		for(int i=start; i<nums.length; i++) {
			if(!vis[i]) {
				if (cur_sum + nums[i] > target) 
					continue;
				
				vis[i] = true;
				if(partitionKSubsets(nums, vis, i+1, k, cur_sum+nums[i], cur_num, target))
					return true;
				vis[i] = false;
			}
		}
		return false;
	}

	public boolean canPartitionKSubsets1(int[] nums, int k) {
		int totSum = 0;

		for(int i=0; i<nums.length; i++) {
			totSum = totSum + nums[i];
		}

		int maxValAllowed = totSum/k;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > maxValAllowed)
				return false;
		}

		if(totSum%k != 0)
			return false;

		Boolean[][] dp = new Boolean[nums.length+1][totSum+1];
		boolean vis[] = new boolean[nums.length+1];
		//        int[] subsets = new int[k];
		return ifSubsetExists(nums, dp, 0, 0, maxValAllowed, k, vis, totSum);
		//        return ifSubsetExists1(nums, dp, 0, maxValAllowed, k, vis, subsets);
	}

	//Working (TLE) - Time = k^n (not sure abt the 2nd dp param but it shud be state of subset[])
	boolean ifSubsetExists1(int[] inp, Boolean[][] dp, int idx, int maxValAllowed, int k, boolean[] vis, int[] subsets) {
		if(idx > inp.length || k<0)
			return false;

		if(idx == inp.length) {
			for(int i=0; i<k; i++) {
				if(subsets[i] == maxValAllowed)
					return true;
			}
			return false;
		}

		Boolean i1 = false;
		//        if(dp[idx][sum] != null)  return dp[idx][sum]; else {
		for(int i=0; i<k; i++) {
			if(!vis[idx]) {
				if(subsets[i]+inp[idx] <= maxValAllowed) {
					vis[idx] = true;
					subsets[i] = subsets[i]+inp[idx];
					i1 = ifSubsetExists1(inp, dp, idx+1, maxValAllowed, k, vis, subsets);
					if(i1) 
						return true;

					subsets[i] = subsets[i]-inp[idx];
					vis[idx] = false;
				}
			}
		}
		//        dp[idx][subsets] = i1;
		return i1; 
	}


	//Working - Time = k * 2^n --> Much better than k^n
	boolean ifSubsetExists(int[] inp, Boolean[][] dp, int idx, int sum, int maxValAllowed, int k, boolean[] vis, int totSum) {
		if(idx > inp.length || sum > maxValAllowed || k<0)
			return false;

		if(k == 1)
			return true;

		if(sum == maxValAllowed) {
			dp = new Boolean[inp.length+1][totSum+1];				// Initialize dp[]
			return ifSubsetExists(inp, dp, 0, 0, maxValAllowed, k-1, vis, totSum);
		}

		if(idx == inp.length) {
			if(sum == maxValAllowed)
				return ifSubsetExists(inp, dp, 0, 0, maxValAllowed, k-1, vis, totSum);	
			else 
				return false;
		}

		Boolean i1 = false;
		if(dp[idx][sum] != null)
			return dp[idx][sum];
		else {
			if(!vis[idx]) {
				vis[idx] = true;
				i1 = ifSubsetExists(inp, dp, idx+1, sum+inp[idx], maxValAllowed, k, vis, totSum);
				if(i1) {
					dp[idx][sum] = true;
					return true;
				}
				vis[idx] = false;
			}
		}

		Boolean i2 = ifSubsetExists(inp, dp, idx+1, sum, maxValAllowed, k, vis, totSum);
		dp[idx][sum] = i1 || i2;
		return dp[idx][sum]; 
	}
	
	
	// Pepcoding - Print all k subsets - Working
	public void canPartitionKSubsets2(int[] nums, int k) {
		int[] arr = {7, 3, 5, 12, 2, 1, 5, 3, 8, 4, 6, 4};
		int n = arr.length;
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		// if k is equal to 1, then whole array is your answer 
		if(k == 1) {
			System.out.print("[");
			for(int i=0 ; i<arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			return;
		}
		//if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
		if(k>n || sum%k != 0) {
			System.out.println("-1");
			return;
		}
		
		int[] subsetSum = new int[k];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < k; i++)
			ans.add(new ArrayList<>());
		
		getEqualSumKPartitions(arr,0,n,k,subsetSum,0,ans);
	}
	
	void getEqualSumKPartitions(int[] arr, int count, int n, int k, int[] subsetSum, int setCount,
			ArrayList<ArrayList<Integer>> ans) {
		if(count == arr.length) {
			if(setCount == k) {
				boolean flag = true;
				for(int i=0; i<subsetSum.length-1; i++) {
					if(subsetSum[i] != subsetSum[i+1]) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(ArrayList<Integer> parts: ans) {
						System.out.print(parts+" ");
					}
					System.out.println();
				}
			}
			return;
		}
		
		for(int j=0; j<ans.size(); j++) {							// iterate over sets = permutation logic only
			if(ans.get(j).size() > 0) {								// if the set is non-empty or size > 0 
				ans.get(j).add(count);
				subsetSum[j] += arr[count];
				getEqualSumKPartitions(arr, count+1, n, k, subsetSum, setCount, ans);	//appending the elem to the existing set
				subsetSum[j] -= arr[count];
				ans.get(j).remove(ans.get(j).size()-1);
			} else {
				ans.get(j).add(count);
				subsetSum[j] += arr[count];
				getEqualSumKPartitions(arr, count+1, n, k, subsetSum, setCount+1, ans);	//creating new set of its own
				subsetSum[j] -= arr[count];
				ans.get(j).remove(ans.get(j).size()-1);
				break;																	// to avoid forming permutations, eg. 1|2|_ and 1|_|2
			}
		}
	}
	
}
