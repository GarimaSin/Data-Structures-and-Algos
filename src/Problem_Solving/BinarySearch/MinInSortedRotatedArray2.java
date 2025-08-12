package Problem_Solving.BinarySearch;

public class MinInSortedRotatedArray2 {

	public static void main(String[] args) {
		int nums[] = {2,2,2,0,0,1};
		System.out.println(findMin(nums));
	}

	// Working
	public static int findMin(int[] nums) {
		int start = 0;
		int end = nums.length-1;
		int ans = -1;

		while(start <= end) {
			if(nums[start] < nums[end] || nums.length == 1)
				return nums[start];

			int mid = start + (end-start)/2;
			if((mid-1 >=0 && nums[mid] < nums[mid-1]) && mid+1<=end && nums[mid] < nums[mid+1])
				return nums[mid];
			if(nums[mid] > nums[start]) {
				ans = mid+1;
				start = mid+1;
			} else if(nums[mid] < nums[end]) {
				ans = mid;
				end = mid;
			} else if(nums[mid] == nums[start]){
				ans = start;
				start++;
			} else if(nums[mid] == nums[end]) {
				ans = end;
				end--;
			}
		}
		return ans == -1 ? nums[0] : nums[ans];
	}
}
