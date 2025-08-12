package Problem_Solving.Array.Pepcoding;

import java.util.Arrays;

public class WiggleSort2 {

	public static void wiggleSort(int[] nums) {
	       int n=nums.length-1;
	        //copy values to new array
	       int[] newarr=Arrays.copyOf(nums,nums.length);
	        //sort new array
	       Arrays.sort(newarr);
	        //old arr=1,5,1,1,6,4
	        //new arr=1,1,1,4,5,6
	       
	        //odd position
	        for(int i=1;i<nums.length;i+=2)
	            nums[i]=newarr[n--];
	        
	        //even position
	        for(int i=0;i<nums.length;i+=2)
	            nums[i]=newarr[n--];
	    }

	// ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
	public static void main(String[] args) {
		int[] arr = {3, 5, 2, 1, 6, 4};

		wiggleSort(arr);
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
}
