package udemy.Recursion.DivideAndConquer.Mine;

public class Knapsack01 {

	static int maxProfit = 0;
	static int maxAllowedWeight = 7;
	
	public static void main(String[] args) {
		int weights[] = {3,1,5,2};
		int profits[] = {31,26,72,17};
		
		findMaxProfit(weights, profits, 0, 0, 0);
		System.out.println(maxProfit);
	}

	private static void findMaxProfit(int[] weights, int[] profits, int currProfit, int index, int currWeight) {
		if(index >= weights.length)
			return;
		
		if(currWeight > maxAllowedWeight)
			return;
		
		if(currProfit > maxProfit)
			maxProfit = currProfit;
		
		
		findMaxProfit(weights, profits, currProfit, index+1, currWeight);
		findMaxProfit(weights, profits, currProfit+profits[index], index+1, currWeight+weights[index]);
	}
}
