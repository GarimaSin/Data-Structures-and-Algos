package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.ArrayList;

public class PartitionInKSubsets {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> ans  = new ArrayList<ArrayList<Integer>>();
		int k = 2;
		for(int i=0; i<k; i++) {
			ans.add(new ArrayList<Integer>());
		}
		getPartitions(0, 3, k, 0, ans);
		System.out.println("_______________");
		getPartitions1(0, 3, k, 0, ans,0);
	}

	//Use hashset to avoid permutation (or similar partitions)
	//Using permutation to get the answer
	static void getPartitions1(int count, int n, int k, int setCount, ArrayList<ArrayList<Integer>> ans, int start) {
		if(count > n) {
			for(ArrayList<Integer> set: ans) {
				if(set.size() == 0)
					return;
			}
			for(ArrayList<Integer> set: ans) {
				System.out.print(set+ " ");
			}
			System.out.println();
			return;
		}

		for(int j=start; j<k; j++) {
			//			if(ans.get(j).size() > 0) {
			ans.get(j).add(count);
			getPartitions1(count+1, n, k, setCount+1, ans, j);		//appending the element to the existing set
			ans.get(j).remove(ans.get(j).size()-1);
		}
	}

	static void getPartitions(int count, int n, int k, int setCount, ArrayList<ArrayList<Integer>> ans) {
		if(count > n) {
			if(setCount == k) {
				for(ArrayList<Integer> set: ans) {
					System.out.print(set+ " ");
				}
				System.out.println();
			}
			return;
		}

		if(setCount > k)
			return;

		for(int j=0; j<ans.size(); j++) {
			if(ans.get(j).size() > 0) {								// if the set's size > 0 ==> old set else a new set
				ans.get(j).add(count);
				getPartitions(count+1, n, k, setCount, ans);		//appending the element to the existing set
				ans.get(j).remove(ans.get(j).size()-1);
			} else {
				ans.get(j).add(count);
				getPartitions(count+1, n, k, setCount+1, ans);		//creating new set of its own
				ans.get(j).remove(ans.get(j).size()-1);
				break;												// to avoid forming permutations, eg. 1|2|_ and 1|_|2
			}
		}
	}
}