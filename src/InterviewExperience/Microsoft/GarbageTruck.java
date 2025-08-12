package InterviewExperience.Microsoft;

public class GarbageTruck {

	static public int solution(int[] D, String[] T) {
		// 0 = glass, 1 = metal, 2 = plastic
		int[] garbageCount;
		int[] lastStop = new int[3];
		int gTruck = 0;
		int mTruck = 0;
		int pTruck = 0;
		int returnTrip[] = new int[D.length];
		returnTrip[0] = D[0];
		for (int i = 0; i < D.length; i++) {
			if(i > 0)
				returnTrip[i] = returnTrip[i-1] + D[i];
			garbageCount = new int[3];
			for(char ch: T[i].toCharArray()) {
				if(ch == 'P') {
					garbageCount[2] = garbageCount[2] +1;
					pTruck = pTruck + 1;
					lastStop[2] = i;
				} else if(ch == 'M') {
					garbageCount[1] = garbageCount[1] +1;
					mTruck = mTruck + 1;
					lastStop[1] = i;
				} if(ch == 'G') {
					garbageCount[0] = garbageCount[0] +1;
					gTruck = gTruck + 1;
					lastStop[0] = i;
				}
			}
			if(garbageCount[2] != 0)
				pTruck = pTruck + D[i];
			if(garbageCount[1] != 0)
				mTruck = mTruck + D[i];
			if(garbageCount[0] != 0)
				gTruck = gTruck + D[i];	
		}
		pTruck = pTruck + returnTrip[lastStop[2]];
		mTruck = mTruck + returnTrip[lastStop[1]];
		gTruck = gTruck + returnTrip[lastStop[0]];
		return Math.max(pTruck, Math.max(mTruck, gTruck));
	}
	
	
	public static void main(String[] args) {
		int D[] = {2,5};
		String T[] = {"PGP", "M"};
		System.out.println(solution(D, T));
	}
}
