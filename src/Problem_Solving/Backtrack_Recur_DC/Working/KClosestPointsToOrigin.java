package Problem_Solving.Backtrack_Recur_DC.Working;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		KClosestPointsToOrigin k = new KClosestPointsToOrigin();
		int[][] points = {{1,3},{-2,2}};
		int K = 1;
		k.kClosest(points, K);
	}

	public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
				(a,b) -> (b[0]*b[0] + b[1]*b[1] - (a[0]*a[0] + a[1]*a[1])));	// d = sqrt{ (x2-x1) + (y2-y1) }
		for(int[] point: points) {
			maxHeap.add(point);
			if(maxHeap.size() > K)
				maxHeap.remove();
		}
		
		int[][] res = new int[K][2];
		while(K --> 0) 
			res[K] = maxHeap.remove();
		
		return res;
	}

}
