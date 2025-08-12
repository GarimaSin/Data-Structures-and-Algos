package Problem_Solving.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInAStream {
	private PriorityQueue<Integer> minHeap;
	private PriorityQueue<Integer> maxHeap;

	public MedianInAStream() {
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	}

	public void addNum(int num) {
		// add the num to the heap based on size 
		if(maxHeap.isEmpty() || maxHeap.peek() >= num)
			maxHeap.add(num);
		else
			minHeap.add(num);

		//Balance the size of both the heaps
		if (maxHeap.size()-1 > minHeap.size()) {
			minHeap.add(maxHeap.remove());
		} else if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.remove());
		}
	}

	public double findMedian() {
		if (minHeap.size() == maxHeap.size()) {
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}
}