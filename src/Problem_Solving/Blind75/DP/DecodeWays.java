package Problem_Solving.Blind75.DP;

public class DecodeWays {

	//Working
	public static int numDecodings(String s) {
		return countDecodings(s);
	}

	static int countDecodings(String s) {
		if(s.length() == 1 || s.length() == 0)
			return 1;

		int i1 = 0, i2 = 0;
		if(s.charAt(0) != '0') {
			int tmp = Integer.parseInt(s.substring(0, 1));
			if(tmp < 27)
				i1 = countDecodings(s.substring(1));
		}

		if(s.length() >= 2) {
			int tmp2 = Integer.parseInt(s.substring(0, 2));
			if(tmp2 < 27 && s.charAt(0) != '0')
				i2 = countDecodings(s.substring(2));
		}
		return i1+i2;
	}

	//Working
	static int countDecodings(String s, int idx, Integer[] memo) {
		if(idx >= s.length())
			return 1;

		if(s.charAt(idx) == '0')
			return 0;

		int i1 = 0, i2 = 0;
		if(memo[idx] == null) {
			if(s.charAt(0) != '0') {
				int tmp = Integer.parseInt(s.substring(idx, idx+1));
				if(tmp < 27)
					i1 = countDecodings(s, idx+1, memo);
			}

			if(s.length() >= idx+2) {
				int tmp2 = Integer.parseInt(s.substring(idx, idx+2));
				if(tmp2 < 27 && s.charAt(0) != '0')
					i2 = countDecodings(s, idx+2, memo);
			}
			memo[idx] = i1+i2;
		}
		return memo[idx];
	}

	public static void main(String[] args) {
		String s = "10";
		int ans = numDecodings(s);
		System.out.println(ans);
		System.out.println(countDecodings(s, 0, new Integer[s.length()+1]));
	}
}