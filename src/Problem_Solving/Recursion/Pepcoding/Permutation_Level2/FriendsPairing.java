package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

public class FriendsPairing {

	public static void main(String[] args) {
		int n = 4;
		boolean[] used = new boolean[n+1];
		printPairing(1, n, used, "");
	}

	static void printPairing(int i, int n, boolean[] used, String ans) {
		if(i > n) {
			System.out.println(ans);
			return;
		}

		if(used[i] == true) {
			printPairing(i+1, n, used, ans);
		} else {
			used[i] = true;
			printPairing(i+1, n, used, ans+i+"- ");		//wont form pair with anyone ==> alone
			for(int j=i+1; j <= n; j++) {					// i+1 again coz it will not form pair with itself, will always form pair with 1 elem ahead of this elem  
				if(!used[j]) {
					used[j] = true;
					printPairing(i+1, n, used, ans+i+","+j+"- ");
					used[j] = false;
				}
			}
			used[i] = false;
		}
	}
}