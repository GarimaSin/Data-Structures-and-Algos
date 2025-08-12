package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.Arrays;
import java.util.HashMap;

/** 
 * Level = Easy
 * 
 * **/

// Time = n, Space = n
public class MajorityElement {
	
	public static void main(String[] args) {
		MajorityElement maj = new MajorityElement();
		int nums[] = {8,9,8,9,8};
		System.out.println(maj.majorityElement(nums));
		int nums1[] = {3,3,4};
		System.out.println(maj.majorityElement(nums1));
	}

	public int majorityElement(int[] nums) {
        int ans = 0;
    	int size = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
        	int num = nums[i];
        	if(map.get(num) != null)
        		map.put(num, map.get(num)+1);
        	else 
        		map.put(num, 1);
            if(map.get(num) > Math.floor(size/2)) {
            	ans = num;
            }
        }
        return ans;
    }
}


// Time = nlogn, space = 1 or n
// Approach = sort the array
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}