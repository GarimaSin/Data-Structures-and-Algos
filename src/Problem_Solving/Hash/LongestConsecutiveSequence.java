package Problem_Solving.Hash;

import java.util.HashMap;

public class LongestConsecutiveSequence {

	public static int longestConsecutive(int[] nums) {
		HashMap<Integer, Boolean> hm = new HashMap<>();
        for(int i =0; i <nums.length; i++)
            hm.put(nums[i], true);
      
        for(int i =0; i <nums.length; i++) {
            if(hm.containsKey(nums[i] - 1)) {		//no need of while, only if will do, coz the loop runs for every elem
                hm.put(nums[i], false);
            }
        }
        
        int max = 0;
        for(Integer key : hm.keySet()) {
            if(hm.get(key) == true) {
                int ans  = 0;
                while(hm.containsKey(key)) {
                    ans++;
                    key++;
                }
                max = Math.max(max, ans);
             }
       }
        return max;
    }
	
	public static void main(String[] args) {
		int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
		System.out.println(longestConsecutive(nums));
	}
}
