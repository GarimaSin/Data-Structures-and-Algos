package Problem_Solving.Recursion.Pepcoding;

public class TargetSumSubsets {
	public static void main(String[] args) {
		int [] arr = {1, 2, 3, 4, 5};
		int target = 7;
		String ans = "";
		findSubsets(arr, target, 0, ans, 0);
		//		System.out.println(ans);
	}

	static void findSubsets(int inp[], int target, int sum, String ans, int index) {
		if(index >= inp.length || sum > target)
			return; 
		if(sum == target) {
			System.out.println(ans);
			return;
		}

		findSubsets(inp, target, sum+inp[index], ans+" "+inp[index], index+1);
		findSubsets(inp, target, sum, ans, index+1);
	}
}
