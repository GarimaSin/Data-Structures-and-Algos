package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

public class PermutationSequence {

	String answer = "";
	int count = 0;
	public static void main(String[] args) {
		PermutationSequence perm = new PermutationSequence();
		perm.getPermutation(3, 3);
	}

	public String getPermutation(int n, int k) {
		permute(n,k,"", new boolean[n+1], false);
		System.out.println(answer);
		return null;
	}

	private String permute(int n, int k, String ans, boolean vis[], boolean isDone) {
		if(ans.length() == n) {
			count++;
//			System.out.println(ans +"........"+count);
			if(count == k) {
				isDone = true;
				answer = ans;
			}
			return null;
		}
		
		for(int i=1; i<=n; i++) {
			if(isDone)
				break;
			if(!vis[i]) {
				vis[i] = true;
				permute(n, k, ans+i, vis, isDone);
				vis[i] = false;
			}
			
		}
		return ans;
	}

}
