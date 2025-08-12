package Problem_Solving.BinarySearch;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int nums[] = {3,1};
		//				int nums[] = {4,5,6,7,0,1,2};
		//		int nums[] = {6,7,0,1,2,4,5};
		int target = 3;
		int ans = search(nums, target);
		System.out.println(ans);
	}
	
	//Working, same logic as MinInSortedRotatedArray
	public static int search(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int end = len-1;
        int pivot = 0;
        int ans = -1;
        int mid = 0;
        
        while(start <= end) {
            mid = start + (end-start)/2;
            int prev = (mid+len-1) % len;
            int next = (mid + 1)%len;
            if(nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                pivot = mid;
                break;
            } else {
                if(nums[mid] > nums[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        
        if(pivot-1 >= 0 && target <= nums[pivot-1] && target >= nums[0]) {
            ans = search(nums, target, 0, pivot-1);
        } else if(target >= nums[pivot] && target <= nums[len-1]){
            ans = search(nums, target, pivot, len-1);
        }
        return ans;
    }
    
    static int search(int[] nums, int target, int start, int end) {
        int mid = 0;
        while(start <= end) {
            mid = start + (end-start)/2;
            if(target == nums[mid])
                return mid;
            if(nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;        
    }
}