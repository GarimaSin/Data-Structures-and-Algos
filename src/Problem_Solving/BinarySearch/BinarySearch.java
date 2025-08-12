package Problem_Solving.BinarySearch;

public class BinarySearch {
	public static void main(String[] args) {
		int nums[] = {-1,0,5};
		int target = 0;
		int ans = search(nums, target);
		System.out.println(ans);
	}

	public static int search(int[] nums, int target) {
		int end = nums.length-1;
        int start = 0;
        if(nums[start] == target)
            return start;
        if(nums[end] == target)
            return end;
        
        int mid = start + (end-start)/2;
        if(nums[mid] == target)
        	return mid;
        
        while(start <= end) {
            mid = start + (end-start)/2;
            if(nums[mid] > target) {
                end = mid-1;
            } else if(nums[mid] < target)
                start = mid+1;
            else if(nums[mid] == target) 
                return mid;
        }
        return -1;
    }
}
