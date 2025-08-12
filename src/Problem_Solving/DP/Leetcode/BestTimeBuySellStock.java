package Problem_Solving.DP.Leetcode;

public class BestTimeBuySellStock {

	public static void main(String[] args) {
		int prices[] = {7,6,4,3,1};
		System.out.println(maxProfit1(prices));
	}

	// O(n2)
	public static int maxProfitMine(int[] prices) {
		int max = 0;
		for(int i=0; i<prices.length-1; i++) {
			for(int j=i+1; j<prices.length; j++) {
				int buy = prices[i];
				int sell = prices[j];
				int temp = sell - buy;
				if(max < temp)
					max = temp;
			}
		}
		return max;
	}
	
	//O(n) Check this - good
	public static int maxProfit1(int[] prices) {
	    if(prices==null||prices.length<=1)
	        return 0;
	 
	    int min=prices[0]; // min so far
	    int result=0;
	 
	    for(int i=1; i<prices.length; i++){
	    	min = Math.min(min, prices[i]);
	        result = Math.max(result, prices[i]-min);
	    }
	    return result;
	}
}