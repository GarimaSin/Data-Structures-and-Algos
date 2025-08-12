package Problem_Solving.Intervals;

import java.util.Arrays;

public class MinPlatform {

	public static int findMinPlatforms(int[] arrival, int[] departure) {
		// sort arrival time of trains
		Arrays.sort(arrival);
		// sort departure time of trains
		Arrays.sort(departure);
		
		int maxTrain = 0;
		int platforms = 0;

		int i = 0, j = 0;

		while (i < arrival.length) {
			if (arrival[i] <= departure[j])	{
				maxTrain++;
				i++;
			} else {
				maxTrain--;
				j++;
			}
			platforms = Math.max(platforms, maxTrain);
		}
		return platforms;
	}

	public static void main(String[] args) {
		int[] arrival = {900, 940, 950, 1100, 1500, 1800};
		int[] departure = {910, 1200, 1120, 1130, 1900, 2000};

		System.out.print("Minimum platforms needed is "
				+ findMinPlatforms(arrival, departure));
	}
}