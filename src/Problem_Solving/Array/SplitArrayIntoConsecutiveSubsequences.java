package Problem_Solving.Array;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {

	public static boolean isPossible(int[] nums) {
        Map<Integer, Integer> subseq = new HashMap<>();
        Map<Integer, Integer> frq = new HashMap<>();
        
        for (int num : nums) {
            frq.put(num, frq.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums) {
            //num already part of a valid subsequence.
            if (frq.get(num) == 0) 
                continue;
            
            // If a valid subsequence exists with the last element = num - 1.
            if (subseq.getOrDefault(num - 1, 0) > 0) {
                subseq.put(num - 1, subseq.getOrDefault(num - 1, 0) - 1);	// remove the subseq ending at num-1 and make it end at num
                subseq.put(num, subseq.getOrDefault(num, 0) + 1);				// hence put(num-1, -1) and put(num, +1)
            } else if (frq.getOrDefault(num + 1, 0) > 0 && 
                       frq.getOrDefault(num + 2, 0) > 0) {
                // If we want to start a new subsequence, check if num + 1 and num + 2 exist.
                // Update the list of subseq with the newly created subsequence
                subseq.put(num + 2, subseq.getOrDefault(num + 2, 0) + 1);
                frq.put(num + 1, frq.getOrDefault(num + 1, 0) - 1);
                frq.put(num + 2, frq.getOrDefault(num + 2, 0) - 1);
            } else {
                //No valid subsequence is possible with num
                return false;
            }
            frq.put(num, frq.get(num) - 1);
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,3,4,4,5,5};
		isPossible(nums);
	}
}
