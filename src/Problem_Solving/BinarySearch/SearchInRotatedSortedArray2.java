package Problem_Solving.BinarySearch;

public class SearchInRotatedSortedArray2 {

	public static void main(String[] args) {
		int nums[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}; 
		int target = 2;
		boolean ans = search(nums, target);
		System.out.println(ans);
	}
	
	public static boolean search(int[] nums, int target) {
		int st = 0;
		int end = nums.length-1;

		if(nums[st] == target || nums[end] == target)
			return true;
		if(nums.length == 1)
			return nums[0] == target;

		while(st <= end) {
			int mid = st + (end-st)/2;
			if(nums[mid] == target)
				return true;
			if(nums[mid] < nums[end]) {
				if(target >= nums[mid] && target <= nums[end]) 
					return search(mid, end, target, nums); 
				else
					end = mid-1;
			} else if(nums[mid] > nums[st]) {
				if(target >= nums[st] && target <= nums[mid])
					return search(st, mid, target, nums);
				else
					st = mid+1;
			} else if(nums[mid] == nums[st]) {	// perform linear search coz in cases: 1,1,2,1,1,1,1, ans cud b in any half
				st++;							
				continue;
			} else if(nums[mid] == nums[end])	// perform linear search coz in cases: 1,1,2,1,1,1,1, ans cud b in any 1/2
				end--;
		}
		return false;
	}

	static boolean search(int st, int end, int target, int[] nums) {
		if(nums[st] == target || nums[end] == target)
			return true;

		while(st <= end) {
			int mid = st + (end-st)/2;
			if(nums[mid] == target)
				return true;

			if(nums[mid] > target) {
				end = mid-1;
			} else if(nums[mid] < target)
				st = mid+1;
		}
		return false;
	}
}