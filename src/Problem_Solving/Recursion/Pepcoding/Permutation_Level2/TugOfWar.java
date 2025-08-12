package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.ArrayList;

public class TugOfWar {
	
	static int mindiff = Integer.MAX_VALUE; //mindiff= minimum difference
	static String ans = "";
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
		System.out.println(ans);
	}
	
	public static void solve(int[] arr, int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1, int soset2) {
		if (vidx == arr.length) { //1
			int delta = Math.abs(soset1 - soset2);
			if (delta < mindiff) {
				mindiff = delta;
				ans = set1 + " " + set2;
			}
			return;
		}

		if (set1.size() < (arr.length + 1) / 2) { //2
			set1.add(arr[vidx]);
			solve(arr, vidx + 1, set1, set2, soset1 + arr[vidx], soset2);
			set1.remove(set1.size() - 1);
		}
		if (set2.size() < (arr.length + 1) / 2) { //3
			set2.add(arr[vidx]);
			solve(arr, vidx + 1, set1, set2, soset1, soset2 + arr[vidx]);
			set2.remove(set2.size() - 1);
		}
	}
}
