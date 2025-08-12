package Problem_Solving.Intervals;

import java.util.Arrays;

public class MeetingRooms2 {
	public static int meetingRoomsUsingCO(int intervals[][]) {
		int et[] = new int[intervals.length];
		int st[] = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			et[i] = intervals[i][1];
			st[i] = intervals[i][0];
		}

		Arrays.sort(et);
		Arrays.sort(st);

		int i = 0, j = 0, count = 0;
		while (i < intervals.length) {
			if (et[j] > st[i]) {
				count++;
				i++;
			} else {
				i++;
				j++;
			}
		}
		return count;
	}


	public static void main(String args[]) {
		int input[][] = {{1,3},{3,10},{12,20}};
		System.out.println(meetingRoomsUsingCO(input));
	}
}

