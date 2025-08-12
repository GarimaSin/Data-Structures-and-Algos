package Problem_Solving.Backtrack_Recur_DC.Working;

import java.util.PriorityQueue;


// Heap = O(n) better than sorting since sorting and finding the kth largest will be O(nlogn)
// USE MIN HEAP

public class KthLargestElementInAnArray {
	
	public static void main(String[] args) {
		int nums[] = {3,2,1,5,6,4};
		int k = 2;
		KthLargestElementInAnArray kl = new KthLargestElementInAnArray();
		int kth = kl.findKthLargest(nums, k);
		System.out.println(kth);
	}
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int i : nums) {
			minHeap.add(i);
			if(minHeap.size() > k) {
				minHeap.remove();
			}
		}
		return minHeap.remove();
	}
}
