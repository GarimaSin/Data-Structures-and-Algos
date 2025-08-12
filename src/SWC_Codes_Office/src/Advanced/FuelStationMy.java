package Advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FuelStationMy {

	
static int Answer, N;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("fuelStation.txt"));
		int T = sc.nextInt();
		for(int test_case = 0; test_case<T; test_case++){
			Answer = Integer.MAX_VALUE;
			N = sc.nextInt();
			int[] parkingMap = new int[N+2];
			boolean[] track = new boolean[N+2];
			
			parkingMap[0] = -1;       //Gasoline Station
			parkingMap[N+1] = -2;     //Diesel Station
			
			for(int i=1; i<=N; i++){
				parkingMap[i] = sc.nextInt();
			}
			fillCars(N, 2, 0, parkingMap, track, 0, 0);
			System.out.println("Case #"+ (test_case+1)+" "+Answer);
		}
		sc.close();
	}

	private static void fillCars(int remainingCars, int gasolineCount, int dieselCount, int[] parkingMap, boolean[] track, int robotMoves, int lastLocation) {
		if(robotMoves > Answer)
			return;
		
		if(lastLocation < 0 || lastLocation> N+1)
			return;
		
		if(remainingCars == 0){
			if(robotMoves < Answer)
				Answer = robotMoves;
			return;
		}
		
		for(int i=0; i<N; i++){
			
		}
	}

}
