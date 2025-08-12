package Problem_Solving.BinarySearch;

public class MedianOfTwoSortedArray {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int total = len1 + len2;
		int medianIdx = total / 2;
		boolean flag = total % 2 == 0;

		int i = 0;
		int j = 0;
		double median = 0.0;
		double prev = 0.0;
		while((i + j) <= medianIdx) {
			prev = median;
			if(i >= len1) {
				median = nums2[j];
				j++;                
			}
			else if(j >= len2) {
				median = nums1[i];
				i++;                
			}
			else if(nums1[i] < nums2[j]) {
				median = nums1[i];
				i++;
			} else {
				median = nums2[j];
				j++;
			}
		}

		if(flag) {
			return (prev + median) / 2;
		}
		return median;
	}
}
