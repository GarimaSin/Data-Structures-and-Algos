package Problem_Solving.Array;

import java.util.Random;

public class RandomPickWeight {

	//w =   {2, 5, 3}
	//range {2, 7, 10}
	//so if the random number is 1 or 2, this means index 0 is selected
	//   if the random number is between 2-7, then index 1 is selected
	//   if the random number is between 7-10, then index 2 is selected

	private int[] sums;
	private int sum;
	private Random random;

	public RandomPickWeight(int[] w) {
		sums = new int[w.length];
		random = new Random();
		sum = 0;

		for(int i = 0; i < w.length; i++) {
			sum += w[i];
			sums[i] = sum;
		}
	}

	public int pickIndex() {
		int value = random.nextInt(sum);
		int index = binarySearch(sums, value);
		if(sums[index] == value) {
			return index+1;
		}
		return index;
	}

	private int binarySearch(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;

		while(left < right) {
			int mid = left + (right - left)/2;

			if(array[mid] == target)
				return mid;
			else if(array[mid] < target)
				left = mid + 1;
			else 
				right = mid;
		}
		return left;
	}

	public static void main(String[] args) {
		int wt[] = {1,2,3};
		RandomPickWeight ran = new RandomPickWeight(wt);
		ran.pickIndex();
	}
}