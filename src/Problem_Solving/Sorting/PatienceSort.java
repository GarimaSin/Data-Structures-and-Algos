package Problem_Solving.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Binary research, return example:
 * int[] arr = {10, 20, 30, 40}; 
 * The insertion point is 2 (between 20 and 30). The method returns -(2) - 1 = -3.
 */

public class PatienceSort {

	public static void main(String[] args) {

	}
	
	public int lengthOfLIS(int[] nums) {
        List<Integer> piles = new ArrayList<>();
        
        for (int num : nums) {
            int idx = Collections.binarySearch(piles, num);
            
            if (idx<0) 
            	idx = -(idx + 1); // Find insertion point
            
            if (idx == piles.size()) {
                piles.add(num); // New pile
            } else {
                piles.set(idx, num); // Replace pile top
            }
        }
        return piles.size();
    }
}
