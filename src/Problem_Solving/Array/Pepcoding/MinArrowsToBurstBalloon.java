package Problem_Solving.Array.Pepcoding;

import java.util.Arrays;

public class MinArrowsToBurstBalloon {

	//Working
	public static int findMinArrowShots(int[][] points) {
		Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
		int count = 1;
		int pos = points[0][1];
		for(int i=1; i<points.length; i++){
			// if new balloon is starting before (or equal to) the end of cu. balloon 
			//  means no new arrow is needed
			if(pos >= points[i][0]) {										
				continue;
			} else {
				count++;										// else new arrow
				pos = points[i][1];
			}
		}
		return count;
	}

	//Working - both are same code
	public static int findMinArrows(int coordinates[][]) {
		Arrays.sort(coordinates, (a, b) -> Integer.compare(a[1], b[1]));
		
		int end = coordinates[0][1], arrow = 1;
		for (int i = 1; i < coordinates.length ; i++) {
			if (coordinates[i][0] > end) {
				end = coordinates[i][1];
				arrow++;
			} else {
			}
		}
		return arrow;
	}

	public static void main(String[] args) {
		int input[][] = {{10,16},{2,8},{1,6},{7,12}};
		int output = findMinArrowShots(input);
		System.out.print(output);
	}
}
