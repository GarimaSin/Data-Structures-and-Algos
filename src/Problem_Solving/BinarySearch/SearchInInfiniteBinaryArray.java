package Problem_Solving.BinarySearch;

public class SearchInInfiniteBinaryArray {
	public static void main(String[] args)  {
 
        int arr[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 };
        System.out.println("Index = " + posOfFirstOne(arr));
    }

	private static int posOfFirstOne(int[] arr) {
		int end = 1;
		while(arr[end] != 1 && 
				end < arr.length) {		//This is not needed in infinte array.
			end = end*2;
		}
		return binarySearch(0, end, arr);
	}

	private static int binarySearch(int start, int end, int[] arr) {
		int mid = 0;
		int ans = -1;
		while(start <= end) {
			mid = start + (end-start)/2;
			int tmp = arr[mid];
			if(tmp == 0) {
				start = mid+1;
			} else if(tmp == 1) {
				ans = mid;
				end = mid-1;
			}
		}
		return ans;
	}
}