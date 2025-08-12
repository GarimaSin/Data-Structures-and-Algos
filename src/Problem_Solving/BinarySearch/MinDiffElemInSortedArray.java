package Problem_Solving.BinarySearch;

public class MinDiffElemInSortedArray {
	
	public static void main(String[] args) {
		int nums[] = {1,3,8,9,15};
		int target = 12;
		int ans = search(nums, target);
		System.out.println(ans);
	}

	public static int search(int[] nums, int target) {
		int end = nums.length-1;
        int start = 0;
        int low = 0;
        int high = 0;
       while(start <= end) {
    	   int mid = start + (end-start)/2;
    	   if(nums[mid] == target)
    		   return 0;
    	   else if(nums[mid] < target) {
    		   low = nums[mid];
    		   start = mid +1;
    	   } else {
    		   high = nums[mid];
    		   end = mid - 1;
    	   }
       }
       return Math.min(target-low, high-target);
	}

}
