package Problem_Solving.DP.Leetcode;

/**
 * Since 2 recursive steps are:
 * 		index + 1
 * 		index + 2
 * Call the recursive method twice (as Line#24, 25), to generate both odd and even nos for index+2 case
 * Add the values to the resultset in both recursive calls
 *
 * We can use either of the Base cases: Line1 or Line2. Using anyone of it will work fine
 */
public class MinCostClimbingStairs {

	int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int[] cost = {10, 15, 20};
		MinCostClimbingStairs min = new MinCostClimbingStairs();
		//		min.minCostClimbingStairs(cost);
		System.out.println(min.minCostClimbingStairs(cost));
	}


	//TLE but working - Step 1
	public int minCostClimbingStairs(int[] cost) {
		int c1 = climbStairs(cost, 0);
		int c2 = climbStairs(cost, 1);
		return Math.min(c1, c2);
	}

	public int climbStairs(int[] cost, int step) {

//		if(step == cost.length-1 || step == cost.length-2) {
//			return cost[step];
//		}
		//OR
		if(step>=cost.length)								/** Line 2 **/
			return 0;

		int c1 = climbStairs(cost, step+1) + cost[step];
		int c2 = climbStairs(cost, step+2) + cost[step];
		int ans = Math.min(c1, c2);
		return ans;
	}


	/** Working using Memoisation - Step 2 **/
	public int minCostClimbingStairs1(int[] cost) {
		int[] memo = new int[cost.length];
		if(cost.length == 2)
			return Math.min(cost[0], cost[1]);

		int cost1 = findMin(cost, 0, memo);
		int cost2 = findMin(cost, 1, memo);

		return Math.min(cost1, cost2);
	}

	int findMin(int[] cost, int steps, int[] memo) {
		//if(i == cost.length-1 || i == cost.length-2)	/** Line 1 **/
		//    return cost[i];

		if(steps>=cost.length)								/** Line 2 **/
			return 0;

		if(memo[steps] > 0) 
			return memo[steps]; 

		int cost1 = cost[steps] + findMin(cost, steps+1, memo);
		int cost2 = findMin(cost, steps+2, memo) + cost[steps];

		memo[steps] = Math.min(cost1, cost2);
		return Math.min(cost1, cost2);
	}
}
