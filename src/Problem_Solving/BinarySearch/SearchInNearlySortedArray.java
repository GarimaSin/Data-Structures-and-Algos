package Problem_Solving.BinarySearch;

public class SearchInNearlySortedArray {
	public static void main(String[] args) {
		int[] nums = {1, 8, 9, 10, 15};
		int target = 11;
		int ans = findIndex(nums, target);
		System.out.println(ans);
	}

	//Working - verified thru techiedelight
	public static int findIndex(int[] nums, int target)	{
		int start = 0;
		int end = nums.length -1;
		int mid = 0;
		while(start <= end) {
			mid = start + (end-start)/2;
			if(nums[mid] == target)
				return mid;
			else if(mid-1 >= 0 && nums[mid-1] == target)
				return mid-1;
			else if(mid+1 <= end && nums[mid+1] == target)
				return mid+1;
			else if(nums[mid] > target)
				end = mid-2;
			else if(nums[mid] < target)
				start = mid+2;
		}
		return -1;
	}
}
