package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class WildcardMatching {

	public static boolean isMatch(String w1, String w2) {
        Boolean[][] dp = new Boolean[w1.length()+1][w2.length()+1];

        if(w1.equals(w2))
            return true;
        
        if(w1.equals("")) 
            return checkW2(0, w2);

        return findMatching(w1, w2, 0, 0, dp);
    }

    static boolean findMatching(String w1, String w2, int i, int j, Boolean[][] dp) {
		if(i >= w1.length() && j >= w2.length()) 
			return true; 
        if(i == w1.length() && j < w2.length()) 
        	return checkW2(j, w2);
        if(j == w2.length() && i < w1.length()) 
        	return false;
		
        if(dp[i][j] != null)
            return dp[i][j];

        Character c1 = w1.charAt(i), c2 = w2.charAt(j);
        boolean l1 = false, l2 = false, l3 = false;
        
        if(c2.equals('?') || c2.equals(c1)) {
        	l1 = findMatching(w1, w2, i+1, j+1, dp);
        	if(l1)
				return l1;
        } else if(c2.equals('*')) {
        	l2 = findMatching(w1, w2, i+1, j, dp);		// * is replaced with cu. char in s1 Or (* = c1*)
        	l3 = findMatching(w1, w2, i, j+1, dp);		// where * is replaced with nothing
        } else
        	return false;

        boolean ans = l1 || l2 || l3;
        dp[i][j] = ans;
        return ans;
    }

    static boolean checkW2(int j, String w2) {
        while(j < w2.length()) {
            Character c = w2.charAt(j);
            if(!c.equals('*')) 
                return false;
            j++;
        }
        return true;
    }
	public static void main(String a[])	{
		String w1 = "hi";
		String w2 = "*?";
		
		int[][] dp = new int[w1.length()+1][w2.length()+1];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        
        boolean ans = isMatch(w1, w2);
        System.out.println(ans);
	}
}
