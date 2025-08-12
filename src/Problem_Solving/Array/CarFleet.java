package Problem_Solving.Array;

import java.util.Arrays;

public class CarFleet {

	public int carFleet(int target, int[] position, int[] speed) {
		int len = speed.length;
		double[][] carPos = new double[len][2];
		for(int i=0; i<len; i++) {
			carPos[i][0] = position[i]*1d;
			carPos[i][1] = (target-position[i])*1d/speed[i];
		}

		Arrays.sort(carPos, (a,b) -> Double.compare(a[0], b[0]));
		int ans = 1;
		double maxTime = carPos[len-1][1];

		for(int i=len-2; i>=0; i--) {
			if(carPos[i][1] > maxTime) {
				ans++;
				maxTime = carPos[i][1];
			}
		}
		return ans;
	}
}
