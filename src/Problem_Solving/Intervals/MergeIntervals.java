package Problem_Solving.Intervals;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
	
	public static int[][] mergeIntervals(int Intervals[][]){
		Arrays.sort(Intervals, (a,b) -> Integer.compare(a[0], b[0]));
//		Arrays.sort(Intervals, (a,b) -> a[0] - b[0]);
		ArrayList<int[]> res = new ArrayList<>();

		for(int interval[] : Intervals) {
			if(res.size() == 0){			//if this is the first interval, add it to the answer list
				res.add(interval);
			} else {
				int prevInterval[] = res.get(res.size()-1);
				if(interval[0] <= prevInterval[1]) {						//If ending pt. of prev interval > cu. interval ==> merging (can be full or partial) 
					prevInterval[1] = Math.max(prevInterval[1],interval[1]);			//ending pt of merged interval = max of cu's (partial overlap) 
																														// and prev's (full overlap) ending pts.
//					OR check below code for better understanding
//					else if(prev[1] >= interval[0]) {
				        //             int start = Math.min(prev[0], interval[0]);
				        //             int end = Math.max(prev[1], interval[1]);
				        //             res.remove(res.size()-1);
				        //             int[] newInterval = {start, end};
				        //             res.add(newInterval);
				        //         }
				} else {
					res.add(interval);					// case of no overlap
				}
			}
		}
		return res.toArray(new int[res.size()][]);
	}
	
	public static void main(String args[]){
		// Input Format
		int input[][] = {{1,3},{2,4},{6,8},{10,14},{7,9}};

		// Output Format
		int [][]output = mergeIntervals(input);

		System.out.print("[");
		
		for(int arr[] : output){
			System.out.print(Arrays.toString(arr));
		}
		System.out.println("]");
	}
}
