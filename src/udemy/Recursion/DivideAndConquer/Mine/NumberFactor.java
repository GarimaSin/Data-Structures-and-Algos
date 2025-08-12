package udemy.Recursion.DivideAndConquer.Mine;

public class NumberFactor {
	
	static int inputArray[] = {1,3,4};
	static int arraySize = inputArray.length;
	static int sum = 5;
	
	public static void main(String[] args) {
		 
		 
		findNoOfFactors(0, "", 0);
	}

	private static void findNoOfFactors(int val, String output, int start) {
		if(val > sum)
			return;
		if(val == sum) {
			System.out.println(output);
			return;
		}
		
		for(int i=0; i<arraySize; i++) {
			String old = output;
			int oldInt = inputArray[i];
			output = output + oldInt;
			val = val + oldInt;
			findNoOfFactors(val, output, i);
			output = old;
			val = val - oldInt;
		}
	}
}
