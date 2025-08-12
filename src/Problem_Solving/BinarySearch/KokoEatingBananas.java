package Problem_Solving.BinarySearch;

public class KokoEatingBananas {

	//Working
	public static int minEatingSpeed(int[] piles, int h) {
        if(piles.length == 1 && h > piles[0])
            return 1;
        
        int max = 0;
        for(int i: piles) {
            max = Math.max(max, i);
        }
        
        int start = 0, end = max, mid = 0;
        int ans = 0;
        while(start <= end) {
			mid = start + (end-start)/2;
			if(canEat(piles, mid, h)) {
				end = mid -1;
				ans = mid;
			} else {
				start = mid+1;
			}
		}
        return ans;
    }

	private static boolean canEat(int[] piles, int mid, int h) {
		int time = 0;
		for (int i = 0; i < piles.length; i++) {
			int tmp = piles[i]/mid;
			if(piles[i]%mid != 0)
				tmp++;
			time = time+tmp;
			if(time > h)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int piles[] = {312884470}, h = 968709470;
		int ans = minEatingSpeed(piles, h);
		System.out.println(ans);
	}
}