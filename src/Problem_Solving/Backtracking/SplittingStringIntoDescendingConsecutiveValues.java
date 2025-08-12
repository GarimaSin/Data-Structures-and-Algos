package Problem_Solving.Leetcode.Backtracking;

public class SplittingStringIntoDescendingConsecutiveValues {


	static public boolean splitString(String s) {
		canSplit(s, -1, "", s);
		return true;
	}

	static boolean res = false;
	static void canSplit(String s, long prev, String ans, String input)	{   
		if(s.length() == 0) {
			res = true;
			System.out.println(ans);
			return;
		}

		for(int i = 0; i < s.length(); i++)	    {
			String num = s.substring(0, i+1);
			Long curr = Long.parseLong(num);
			if(curr >= 10000000000L) 
				return;
			if(prev == -1 || (prev > curr && prev - curr == 1))   
				if(num.length() != input.length())
					canSplit(s.substring(i+1, s.length()), curr, ans+" - "+curr, input);
		}
	}

	public static void main(String[] args) {
		String s = "0090089";
		splitString(s);
	}

}
