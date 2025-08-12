package Problem_Solving.BinarySearch;

public class PeakElement {
	public static void main(String[] args) {
		int nums[] = {1,2};
		int ans = findPeakElement(nums);
		System.out.println("Index of peak element is: "+ans);
	}
	
	public static int findPeakElement(int[] nums) {
		if(nums.length == 1)
			return 0;
		return binarySearch(nums);
	}

	public static int binarySearch(int[] nums) {
		int start = 0;
		int end = nums.length-1;
		int mid = 0;
		int len = nums.length;

		while(start <= end) {
			mid = start + (end - start)/2;
			if(mid-1 >= 0 && mid+1 < len && nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1])
				return mid;
			if(mid ==0) {
				if(nums[mid] > nums[mid+1]) 
					return mid;
				else
					return mid+1;
			} else if(mid == len-1) {
				if(nums[mid] > nums[mid-1])
					return mid;
				else 
					return mid-1;
			}
			else if(mid+1 < len && nums[mid] < nums[mid+1]) {
				start = mid+1;
			} else if(mid+1 < len && nums[mid] > nums[mid+1]) {
				end = mid -1;
			} 
		}
		return -1;
	}
}