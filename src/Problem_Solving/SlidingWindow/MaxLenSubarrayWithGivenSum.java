package Problem_Solving.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxLenSubarrayWithGivenSum {

	// Find the max length sub-array with sum `target' present in a given array
    public static void findMaxLenSubarray(int[] nums, int target)  {
        // create an empty HashMap to store the ending index of the first sub-array having some sum
        Map<Integer, Integer> map = new HashMap<>();
 
        // insert (0, -1) pair into the set to handle the case when a sub-array with sum `S` starts from index 0
        map.put(0, -1);
 
        int currSum = 0;
 
        // `len` stores the max length of sub-array with sum `target`
        int len = 0;
 
        // stores ending index of the max length sub-array having sum `target`
        int ending_index = -1;
 
        // traverse the given array
        for (int i = 0; i < nums.length; i++) {
            // sum of elements so far
            currSum += nums[i];
 
            // if the sum is seen for the first time, insert the sum with its into the map
            map.putIfAbsent(currSum, i);
 
            // update len and ending index of the max len sub-array having sum `target`
            if (map.containsKey(currSum - target) && len < i - map.get(currSum - target))  {
                len = i - map.get(currSum - target);
                ending_index = i;
            }
        }
        System.out.println("[" + (ending_index - len + 1) + ", " + ending_index + "]");
    }
 
    public static void main (String[] args)  {
        int[] nums = { 5, 6, -5, 5, 3, 5, 3, -2, 0 };
        int target = 8;
 
        findMaxLenSubarray(nums, target);
    }
}
