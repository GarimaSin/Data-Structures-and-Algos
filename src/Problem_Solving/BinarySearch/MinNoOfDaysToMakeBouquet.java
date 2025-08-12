package Problem_Solving.BinarySearch;

public class MinNoOfDaysToMakeBouquet {

	public static void main(String a[])	{
		int bloomDay[] = {7,7,7,7,12,7,7}, m = 2, k = 3;
		System.out.println(minDays(bloomDay, m, k));
	}

  
	// Working
	public static int minDays(int[] bloomDay, int m, int k) {
        int min = 9999999;
        int max = 0;
        
        if(bloomDay.length < m*k)
            return -1;
        
        for(int i: bloomDay) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
 
        int ans = -1;
        int start = min;
        int end = max;
        while(start <= end) {
            int mid = start + (end-start)/2;
             if(ifBouquetPossible(bloomDay, mid, m, k)) {
                end = mid-1;
                ans = mid;
            } else 
                start = mid+1;
        }
        return ans;
    }


    static boolean ifBouquetPossible(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int tot = 0;
        for(int i: bloomDay) {
            if(day >= i) {
                count++;
                if(count >= k) {
                	tot++;
                	count = 0;
                }
                if(tot >= m)
                    return true;
            } else
                count = 0;
        }
        if(tot >= m)
            return true;
        return false;
    }
}
