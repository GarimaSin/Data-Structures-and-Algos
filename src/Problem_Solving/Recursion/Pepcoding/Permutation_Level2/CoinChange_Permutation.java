package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

public class CoinChange_Permutation {

	public static void main(String[] args) {
		int[] coins = {4,2};
		findChange(6, 0, coins, new boolean[coins.length], "");
		System.out.println("_________________________");
		findChange2(6, 0, coins, "");
	}

	//With repetition
	static void findChange(int tot, int sum, int[] coins, boolean[] used, String ans) {
		if(sum == tot) {
			System.out.println(ans); 
			return;
		} else if(sum > tot)
			return;

		for(int i=0; i< coins.length; i++) {
			if(!used[i]) {
				used[i] = true;
				findChange(tot, sum+coins[i], coins, used, ans+coins[i]+"-");		//check this line
				used[i] = false;
			}
		}
	}

	//With repetition
	static void findChange2(int tot, int sum, int[] coins, String ans) {
		if(sum == tot) {
			System.out.println(ans); 
			return;
		} else if(sum > tot)
			return;

		for(int i=0; i< coins.length; i++)
			findChange2(tot, sum+coins[i], coins, ans+coins[i]+"-");		//check this line
	}
}
