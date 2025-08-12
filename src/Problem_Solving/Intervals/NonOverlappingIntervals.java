package Problem_Solving.Intervals;

import java.util.ArrayList;
import java.util.Arrays;

public class NonOverlappingIntervals {

	public static void main(String[] args) {
		int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
		int ans = eraseOverlapIntervals(intervals);
		System.out.println(ans);
	}
	
	public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> res = new ArrayList<>();
        int count = 0;
        for(int[] interval: intervals) {
            if(res.size() == 0) 
                res.add(interval);
            else {
                int[] prev = res.get(res.size()-1);
                if(prev[1] <= interval[0])
                    res.add(interval);
                else {
                    if(prev[1] > interval[1]) {			//Compare ends of both to get the larger sized interval
                        res.remove(res.size()-1);
                        res.add(interval);
                    } else {
                    	//do nothing coz we dont want to add new interval coz 
                    	//new interval is greater.
                    }
                    count++;
                }
            } 
        }
        return count;
    }
}
