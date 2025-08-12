package Problem_Solving.DP.Leetcode;

import java.util.Arrays;

public class EditDistance {
	
	public static void main(String[] args) {
		String word1 = "horse";
		String word2 = "ros";
		int memo[][] = new int[word1.length()+1][word2.length()+1];
        for(int[] l: memo)
            Arrays.fill(l, -1);
        
        System.out.println(memoized1(word1, word2, 0, 0, memo));
        System.out.println(memoized(word1, word2, memo));
//        return ans;
	}


	//Working
	static int memoized(String s, String t, int[][] memo) {
		int i = s.length();
		int j = t.length();
		if(i == 0)
			return j;

		if(j == 0)
			return i;

		if(memo[i][j] == -1) {
			if(s.charAt(0) == t.charAt(0)) {
				memo[i][j] = memoized(s.substring(1), t.substring(1), memo);
			} else {
				int op1 =  memoized(s.substring(1), t.substring(1), memo);		//Replace
				int op2 =  memoized(s, t.substring(1), memo);								//Insert
				int op3 =  memoized(s.substring(1), t, memo);								//Delete
				memo[i][j] = 1 + Math.min(op1, Math.min(op2, op3));
			}
		}
		return memo[i][j];
	}

	//Working
	static int memoized1(String s, String t, int i, int j, int[][] memo) {
		if(i == s.length())
			return t.length()-j;

		if(j == t.length())
			return s.length()-i;

		if(memo[i][j] == -1) {
			if(s.charAt(i) == t.charAt(j)) {
				memo[i][j] = memoized1(s, t, i+1, j+1, memo);
			} else {
				int op1 =  memoized1(s, t, i+1, j+1, memo);		//Replace
				int op2 =  memoized1(s, t, i, j+1, memo);		//Insert = i Will not change as v r assuming v hv inserted
																// a char b4 i ==> v still will hv to Compare cur. char 
				int op3 =  memoized1(s, t, i+1, j, memo);		//Delete
				memo[i][j] = 1 + Math.min(op1, Math.min(op2, op3));
			}
		}
		return memo[i][j];
	}


	//Working
	public static int recursion(String s, String t){
		if(s.length() == 0)
			return t.length();

		if(t.length() == 0)
			return s.length();

		//if char are same
		if(s.charAt(0)  == t.charAt(0))
			return recursion(s.substring(1), t.substring(1));
		else{
			int op1 =  recursion(s.substring(1), t.substring(1));
			int op2 =  recursion(s, t.substring(1));
			int op3 =  recursion(s.substring(1), t);

			return 1 + Math.min(op1, Math.min(op2, op3));
		}
	}
}
