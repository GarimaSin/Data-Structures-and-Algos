package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

public class KthSymbolInGrammar {

	public static void main(String[] args) {

	}

	public int kthGrammar(int N, int K) {
		return Integer.bitCount(K-1) & 1;
//		int cols = 2^(N-1);
//		if(K ==0)
//			return 0;
//		 
//		findKthSymbol(N, K, 0, new int[cols]);
//		return 0;
	}

//	private void findKthSymbol(int n, int k, int counter, int[] ans) {
//		if(counter == n) {
//			System.out.println(ans[k]);
//			return;
//		}
//		
//		String temp = "";
//		for(char c: )
//		findKthSymbol(n, k, counter+1, ans);
//	}
}
