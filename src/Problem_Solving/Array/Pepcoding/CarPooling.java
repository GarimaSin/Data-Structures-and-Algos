package Problem_Solving.Array.Pepcoding;

public class CarPooling {
	
	public static boolean carPooling(int[][] trips, int capacity) {
		int max = 0;
		for(int i=0; i<trips.length; i++) 
			max = Math.max(max, trips[i][2]);

		int stops[] = new int[max+1];
		for(int i=0; i<trips.length; i++) {
			stops[trips[i][1]] = stops[trips[i][1]] + trips[i][0];
			stops[trips[i][2]] = stops[trips[i][2]] - trips[i][0];
			if(trips[i][0] > capacity)
				return false;
		}
		int currCapacity = stops[0];
		for(int i=1; i<stops.length; i++) {
			stops[i] = stops[i-1] + stops[i];
			currCapacity = Math.max(currCapacity, stops[i]);
			if(currCapacity > capacity)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] trips = {{2,1,5},{3,3,7}};
		int capacity = 5;
		System.out.println(carPooling(trips, capacity));
	}
}

