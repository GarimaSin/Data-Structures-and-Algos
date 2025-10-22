package Problem_Solving.BinarySearch;

public class MinInSortedRotatedArray {

	public static void main(String[] args) {
		int nums[] = {2,1};
		//				int nums[] = {4,5,6,7,0,1,2};
		//		int nums[] = {6,7,0,1,2,4,5};
		int ans = findMin(nums);
		System.out.println(ans);
	}

	//Working
	public static int findMin(int[] nums) {
		int len = nums.length;
		int start = 0;
		int end = len-1;
		int mid = 0;
		if(nums[0] <= nums[len-1]) {
			return nums[0];
		}

		while(start <= end) {
			mid = start + (end - start)/2;
			int next = (mid+1) % len;		// make the array circular by pointing next to 0th index if mid = last elem
			int prev = (mid-1 +len) % len;  // make the array circular by pointing prev to last index if mid = 0th elem
			if(nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
				return nums[mid];
			}
			if(nums[mid] >= nums[end]) {
				start = mid +1;
			} else {
				end = mid-1;
			}
		}
		return -1;
	}

	//Working
	public static int findMin1(int[] nums) {
		int len = nums.length-1;
		if(nums[0] < nums[len])
			return nums[0];

		int start = 0, end = len, mid = 0;
		while(start < end) {
			mid = (end+start)/2;
			if(nums[mid] > nums[end])
				start = mid+1;
			else 
				end = mid;			//not mid-1
		}
		return nums[start];			//not mid
	}
}
