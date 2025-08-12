package Problem_Solving.DP.Longest_Common_Subsequence;

import java.util.HashMap;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String s1 = "ABCDGH";
		String s2 = "ACDGHR";
		int l1 = s1.length();
		int l2 = s2.length();
		int[][][] dp = new int[l1+1][l2+1][Math.max(l1, l2)+1];
		for (int i = 0; i < l1+1; i++) {
			for (int j = 0; j < l2+1; j++) {
				for (int k = 0; k < Math.max(l1, l2)+1; k++) {
					dp[i][j][k] = -1;
				}
			}
		}

		int ans = findMaxSubstringLen(s1, s2, 0, 0, 0, dp);
		System.out.println(ans);
		System.out.println(findLength(s1, s2));
	}


	//Got OOM error for a very long i/p string, TC score = 109/118
	static int findMaxSubstringLen(String s1, String s2, int i, int j, int count, int[][][] dp) {
		if(i == s1.length() || j == s2.length()) {
			return count;
		}

		if(dp[i][j][count] != -1) {
			return dp[i][j][count];
		} else {
			int l1 = count;
			if(s1.charAt(i) == s2.charAt(j)) {
				l1 = findMaxSubstringLen(s1, s2, i+1, j+1, count+1, dp);
			}																// Else here will not work, unlike LCS.
			int l2 = findMaxSubstringLen(s1, s2, i+1, j, 0, dp);
			int l3 = findMaxSubstringLen(s1, s2, i, j+1, 0, dp);
			dp[i][j][count] = Math.max(Math.max(l1, l2), l3);
			return dp[i][j][count];
		}
	}

	//Got TLE for a very long i/p string, TC score = 109/118
	static int findMaxSubstringLen(String s1, String s2, int i1, int i2, int lcsCount, HashMap<String, Integer> dp) {
		if(i1 == s1.length() || i2 == s2.length()) {
			return lcsCount;
		}
		//		System.out.println("i1 ="+i1+"............i2="+i2);

		String key = i1+" - "+i2+" - "+lcsCount;
		if(dp.containsKey(key)) {
			return dp.get(key);
		} else {
			int l1 = lcsCount;									// CHECK THIS
			if(s1.charAt(i1) == s2.charAt(i2)) {
				l1 = findMaxSubstringLen(s1, s2, i1+1, i2+1, lcsCount+1, dp);
			}
			int l2 = findMaxSubstringLen(s1, s2, i1+1, i2, 0, dp);
			int l3 = findMaxSubstringLen(s1, s2, i1, i2+1, 0, dp);
			int tmp = Math.max(Math.max(l1, l2), l3);
			dp.put(key,tmp);
			return tmp;
		}
	}


	//Working - Tabulation
	public static int findLength(String s1, String s2) {
		int T[][] = new int[s1.length()+1][s2.length()+1];

		int max = 0;
		if(s1.charAt(0) == s2.charAt(0)) {
			T[0][0] = 0;
		}

		for(int i=1; i <= s1.length(); i++){
			for(int j=1; j <= s2.length(); j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					T[i][j] = T[i-1][j-1] +1;
					if(max < T[i][j]){
						max = T[i][j];
					}
				} else {
					T[i][j] = 0;
				}
			}
		}
		return max;
	}
}