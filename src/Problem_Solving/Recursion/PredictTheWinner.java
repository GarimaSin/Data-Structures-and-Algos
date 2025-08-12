package Problem_Solving.Recursion;

public class PredictTheWinner {

	public static boolean predictTheWinner(int[] nums) {
		System.out.println(findWinner(nums, 0, nums.length - 1, 1, 0));
		return winner(nums, 0, nums.length - 1, 1) >= 0;
	}
	
	
	public static int winner(int[] nums, int s, int e, int turn) {
		if (s == e)
			return turn * nums[s];
		int a = turn * nums[s] + winner(nums, s + 1, e, -turn);
		int b = turn * nums[e] + winner(nums, s, e - 1, -turn);
		return turn * Math.max(turn * a, turn * b);
	}
	
	public static int findWinner(int[] nums, int s, int e, int turn, int total) {
		if (s>e || e < 0)
			return total;
		int a = findWinner(nums, s + 1, e,  (turn == 1) ? 2 : 1, (turn == 1) ? total+nums[s] : total-nums[s]);
		int b = findWinner(nums, s, e - 1, (turn == 1) ? 2 : 1, (turn == 1) ? total+nums[e] : total-nums[e]);
	
//		int tmp = ;
		return Math.max(a, b);
	}
	
	public static void main(String[] args) {
		int arr[] = {1,5,2};
		predictTheWinner(arr);
	}
}
