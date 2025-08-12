package Problem_Solving.Array.Pepcoding;

public class MaxChunksToMakeArraySorted2 {

	public static int maxChunksToSorted2(int[] arr) {
        int[] rmin = new int[arr.length + 1];
        
        int val = Integer.MAX_VALUE;
        rmin[arr.length] = val;
        for(int i = arr.length - 1; i>= 0; i--) {
            val = Math.min(val, arr[i]);
            rmin[i] = val;
        }
        
        int lmax = arr[0];
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            lmax = Math.max(lmax, arr[i]);
            
            if(lmax <= rmin[i + 1])
                count++;
        }
        return count;
    }

	// ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
	public static void main(String[] args) {
		int[] arr = {2, 0, 1, 3, 5, 4};
		int res = maxChunksToSorted2(arr);
		System.out.println(res);
	}
}
