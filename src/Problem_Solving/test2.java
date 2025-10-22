package Problem_Solving;

import java.util.ArrayList;
import java.util.List;

public class test2 {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> allSubsets = subsets(nums, 0, new ArrayList<>());
		System.out.println(allSubsets);
	}

	static List<List<Integer>> subsets(int[] nums, int st, List<Integer> current) {
		List<List<Integer>> result = new ArrayList<>();

		// Add current subset (make a copy because 'current' is mutable)
		result.add(new ArrayList<>(current));


		for (int j=st; j < nums.length; j++) {
			current.add(nums[j]);   // choose
			result.addAll(subsets(nums, j + 1, current)); // explore
			current.remove(current.size() - 1); // backtrack
		}
		return result;
	}



	//	public static List<List<Integer>> subsets(int[] nums) {
	//        return subsets(nums, 0, new ArrayList<Integer>(), new ArrayList<List<Integer>>(), "");
	//    }

	//	static List<List<Integer>> subsets1(int[] nums, int i, List<Integer> list, List<List<Integer>> ans, String s) {
	//    	if(i >= nums.length) {
	//    		System.out.println(s);
	//    		return new ArrayList<List<Integer>>();
	//    	}
	//    	
	////    	System.out.println(s);
	//    	list = new ArrayList<Integer>(list);
	//        list.add(nums[i]);
	//        ans.add(list);
	//        
	//        subsets1(nums, i+1, list, ans, s+nums[i]);
	//        subsets1(nums, i+1, list, ans, s);
	//        
	//        return ans;
	//    }
	//
	//    static List<List<Integer>> subsets(int[] nums, int st, List<Integer> list, List<List<Integer>> ans, String s) {
	////    	System.out.println("String: " + s + " | List: " + list);
	//        
	//        if (st >= nums.length)
	//            return ans;
	//        // creating a new list (newList) from list in that recursion so that each recursive branch gets its own copy 
	//        // of subset instead of all branches sharing the same mutable list.
	//        for (int i=st; i < nums.length; i++) {
	//            List<Integer> newList = new ArrayList<>(list);
	//            newList.add(nums[i]);
	//            ans.add(newList);
	//            
	//            subsets(nums, i+1, newList, ans, s+nums[i]);
	//        }
	//        return ans;
	//    }
}