package Problem_Solving.DP.Leetcode;

public class RegularExpressionMatching {
	public static void main(String[] args) {
		String s = "aa", p = "a*";
		System.out.println(isMatch(s, p, 0, 0, new Boolean[s.length()+1][p.length()+1]));
	}

	//Working
	public boolean isMatch(String text, String pattern) {
		if (pattern.isEmpty()) 
			return text.isEmpty();

		if (pattern.length() >= 1 && pattern.charAt(1) == '*') {		//Case, text = "
			if(isMatch(text, pattern.substring(2)))
				return true;
			if((text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.') && text.length() > 0)
				return isMatch(text.substring(1), pattern);
			return false;
		} else {
			if((text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.') && text.length() > 0)
				return isMatch(text.substring(1), pattern.substring(1));
			return false;
		}
	}
	
	
	//Working
	public static Boolean isMatch(String text, String pattern, int i, int j, Boolean[][] memo) {
		if(i >= text.length() && j >= pattern.length())
            return true;
		
		if(j >= pattern.length())
            return false;

		if(memo[i][j] == null) {
			if (pattern.length() > j+1 && pattern.charAt(j+1) == '*') {
				if(isMatch(text, pattern, i, j+2, memo))
					memo[i][j] = true;
				else if(text.length() > i && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.'))
					memo[i][j] = isMatch(text, pattern, i+1, j, memo);
				else
					memo[i][j] = false;
			} else {
				if(text.length() > i && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.') )
					memo[i][j] = isMatch(text, pattern, i+1, j+1, memo);
				else
					memo[i][j] = false;
			}
		}
		return memo[i][j];
	}
}
