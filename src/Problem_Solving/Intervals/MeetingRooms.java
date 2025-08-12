package Problem_Solving.Intervals;

import java.util.Arrays;

public class MeetingRooms {

	public static boolean meetingRooms(int intervals[][]){
		if(intervals.length == 0 || intervals.length == 1) 
			return true;

		Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

		for(int idx = 1 ; idx < intervals.length ; idx++){
			if(intervals[idx][0] < intervals[idx-1][1]){
				return false;
			}
		}
		return true;
	}


	public static void main(String args[]){
		int input[][] = {{1,3}, {8,10}, {7,8}, {9,15},{2,6}};
		boolean res = meetingRooms(input);
		System.out.println(res);
	}
}
