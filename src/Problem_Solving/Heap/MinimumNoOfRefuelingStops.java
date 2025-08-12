package Problem_Solving.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNoOfRefuelingStops {

	public static void main(String[] args) {
		int target = 100, startFuel = 10; 
		int[][] stations = {{10,60},{20,30},{30,30},{60,40}};
		System.out.println(minRefuelStops(target, startFuel, stations));
	}
	
	public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Max heap to store past fuel station fuels
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int fuel = startFuel;
        int i = 0, n = stations.length;
        int stops = 0;

        while (fuel < target) {
            // Add all reachable stations to maxHeap
            while (i < n && stations[i][0] <= fuel) {
                maxHeap.add(stations[i][1]);
                i++;
            }

            // No stations in range and can't reach target
            if (maxHeap.isEmpty()) 
            	return -1;

            // Refuel at the station with the most fuel we've passed
            fuel += maxHeap.poll();
            stops++;
        }
        return stops;
    }

}
