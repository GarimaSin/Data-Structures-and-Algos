package Problem_Solving.Leetcode.Backtracking;

import java.util.HashMap;

//Running fine on local for failing TCs on Leetcode
public class ClosestDessertCost {

	static public void closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		for (int i = 0; i < baseCosts.length; i++) {
			findClosestCost(toppingCosts, target, new HashMap<Integer, Integer>(), 0, baseCosts[i]);
		}
		System.out.println(ans);
	}

	static int ans = Integer.MIN_VALUE;
	static void findClosestCost(int[] toppingCosts, int target, HashMap<Integer, Integer> toppings, int idx, int cost) {
		if(Math.abs(cost-target) < Math.abs(ans-target)) {
			ans = cost;
		}	else if(Math.abs(cost - target) == Math.abs(ans - target)) {
            ans = Math.min(ans, cost);
        }

		for (int i = 0; i < toppingCosts.length; i++) {
			if(toppings.get(toppingCosts[i]) != null && toppings.get(toppingCosts[i]) >= 2)
				return;
			else {
				if(toppings.get(toppingCosts[i]) == null) {
					toppings.put(toppingCosts[i], 1);
					findClosestCost(toppingCosts, target, toppings, i, cost+toppingCosts[i]);
					toppings.put(toppingCosts[i], toppings.get(toppingCosts[i]) -1);
				} else {
					toppings.put(toppingCosts[i], toppings.get(toppingCosts[i]) +1);
					findClosestCost(toppingCosts, target, toppings, i, cost+toppingCosts[i]);
					toppings.put(toppingCosts[i], toppings.get(toppingCosts[i]) -1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int baseCosts[] = {10};
		int toppingCosts[] = {1};
		int target = 1;
		closestCost(baseCosts, toppingCosts, target);
	}
}