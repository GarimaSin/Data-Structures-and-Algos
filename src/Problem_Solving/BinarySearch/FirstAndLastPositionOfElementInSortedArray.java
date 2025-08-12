package Problem_Solving.BinarySearch;

public class FirstAndLastPositionOfElementInSortedArray {
	
	public static void main(String[] args) {
		int nums[] = {5,7,7,8,8,10};
		int target = 8;
		searchRange(nums, target);
	}

	public static int[] searchRange(int[] nums, int target) {
		int first = findFirstPosition(nums, target);
		int last = findLastPosition(nums, target);
		int ans[] = new int[2];
		ans[0] = first;
		ans[1] = last;
		System.out.println(first+"   "+last);
		return ans;
	}

	public static int findFirstPosition(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;
		int mid = 0;
		int first = -1;

		while(start <= end) {
			mid = start + (end - start)/2;
			if(nums[mid] == target) {
				end = mid-1;
				first = mid;
			} else if(nums[mid] > target) {
				end = mid-1;
			} else
				start = mid+1;
		}
		return first;
	}

	public static int findLastPosition(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;
		int mid = 0;
		int last = -1;

		while(start <= end) {
			mid = start + (end - start)/2;
			if(nums[mid] == target) {
				start = mid+1;
				last = mid;
			} else if(nums[mid] > target) {
				end = mid-1;
			} else
				start = mid+1;
		}
		return last;
	}
}
