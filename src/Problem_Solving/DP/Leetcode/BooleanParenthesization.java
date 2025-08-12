package Problem_Solving.DP.Leetcode;

import java.util.HashMap;

public class BooleanParenthesization {

	/**
	 * Input: s = "T|T&F^T"
	 * Output: 4
	 * Explaination: The expression evaluates to true in 4 ways: 
	 * ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
	 */
	
	public static void main(String[] args) {
		System.out.println(countWays("T|T&F^T"));
	}

	static int countWays(String s) {
		HashMap<String, Integer> dp = new HashMap<>();
		return countWays(0, s.length()-1, s, true, dp);		// isTrue = true coz v need all ans for true.
	}

	private static int countWays(int st, int end, String s, boolean isTrue, HashMap<String, Integer> dp) {
		if(st == end) {
			if(isTrue) {
				return s.charAt(st) == 'T' ? 1 : 0;
			} else {
				return s.charAt(st) == 'F' ? 1 : 0;
			}
		}

		String key = st+ "," +end+ "," +isTrue;
		if(dp.get(key) != null)
			return dp.get(key);
		
		int ways = 0;
		for(int i=st; i<end; i=i+2) {
			Character op = s.charAt(i+1);
			int leftT = countWays(st, i, s, true, dp);
			int leftF = countWays(st, i, s, false, dp);
			int rightT = countWays(i+2, end, s, true, dp);
			int rightF = countWays(i+2, end, s, false, dp);

			if (isTrue) {
	            if(op.equals('|')) {
	                ways += leftT*rightF + rightT*leftF + leftT*rightT;
	            }
	            if(op.equals('&')) {
	                ways += leftT*rightT;
	            }
	            if(op.equals('^')) {
	                ways += leftT*rightF + rightT*leftF;
	            }
	        } else {
	            if(op.equals('|')) {
	                ways += leftF*rightF;
	            }
	            if(op.equals('&')) {
	                ways += leftF*rightF + leftT*rightF + leftF*rightT;
	            }
	            if(op.equals('^')) {
	                ways += leftT*rightT + leftF*rightF;
	            }
	        }
		}
		dp.put(key, ways);
		return ways;
	}
}
