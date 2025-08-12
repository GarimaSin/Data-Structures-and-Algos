package Problem_Solving.Intervals;

import java.util.ArrayList;
import java.util.Arrays;


//https://youtu.be/NWM4e4yda0w
public class InsertInterval {

	@SuppressWarnings("unused")
	public static int[][] insertIntervals(int intervals[][], int newInterval[]) {
		ArrayList<int[]> list = new ArrayList<>();
		if (intervals.length == 0 && intervals == null) {
			int[][] ans = new int[0][newInterval.length];
			ans[0] = newInterval;
			return ans;
		}
		
		for (int[] interval : intervals) {
			//situation1,interval < new
			if (interval[1] < newInterval[0]) {
				list.add(interval);								//add old interval
			} else if (interval[0] > newInterval[1]) {
				//situation2,new < interval
				list.add(newInterval);							//add new interval
				newInterval = interval;
			} else {
				//situation3,merge the two arrays into a new array
				newInterval[0] = Math.min(interval[0], newInterval[0]);
				newInterval[1] = Math.max(interval[1], newInterval[1]);
			}
		}
		//if we don't add it at last,we will lose the last answer of array
		list.add(newInterval);
		return list.toArray(new int[list.size()][]);
	}

	public static void main(String[] args) {
		int intervalList[][] = {{3,5},{8,10}};
		int newInterval[] = {1,2};

		int ans[][] = insertIntervals(intervalList, newInterval);

		System.out.print("[");
		for (int interval[] : ans) {
			System.out.print(Arrays.toString(interval));
		}
		System.out.println("]");
	}
}
