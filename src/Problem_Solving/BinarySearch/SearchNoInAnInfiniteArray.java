package Problem_Solving.BinarySearch;

public class SearchNoInAnInfiniteArray {
	public static void main(String[] args) {
        int arr[] = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int ans = findPos(arr,10);
         
        if (ans==-1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + ans);
    }

	private static int findPos(int[] arr, int key) {
		int start = 0, end = 1;
        int val = arr[0];
 
        while (val < key)  {
        	start = end;     // store previous high
            if(2*end < arr.length-1)
            	end = 2*end;            
            else
            	end = arr.length-1;
             
            val = arr[end]; 
        }
        return binarySearch(arr, start, end, key);
	}

	private static int binarySearch(int[] nums, int start, int end, int target) {
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