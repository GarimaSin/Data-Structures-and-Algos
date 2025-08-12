package Problem_Solving.Array.Pepcoding;

public class MaxChunksToMakeArraySorted {

	public static int maxChunksToSorted(int[] arr) {
		int count = 0;
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			max = Math.max(arr[i], max);

			if(i == max) 
				count++;
		}
		return count;    
	}

	// ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
	public static void main(String[] args) {
		int[] arr = {2, 0, 1, 3, 5, 4};
		int res = maxChunksToSorted(arr);
		System.out.println(res);
	}
}
