package Problem_Solving.Leetcode.Backtracking;

public class MaxProductOfLenof2PalindromicSubsequences {

	public static int maxProduct(String s) {
		if(s.length()==0)
			return 0;
		helper1(s,"","",0);
		return ans;
		//	        return  helper(s,"","",0,0);
	}

	private static int helper(String s,String pali1,String pali2,int pos,int max)	{
		if(pos>=s.length())  {
			if(isValidPalindrome(pali1) && isValidPalindrome(pali2))
				return Math.max(max,pali1.length()*pali2.length());
			return max;
		}

		return Math.max(helper(s,pali1+s.charAt(pos)+"",pali2,pos+1,max),
				Math.max(helper(s,pali1,pali2+s.charAt(pos)+"",pos+1,max),
						helper(s,pali1,pali2,pos+1,max)));
	}

	static int ans = Integer.MIN_VALUE;
	private static void helper1(String s, String pali1, String pali2, int pos)	{
		if(pos>=s.length())  {
			if(isValidPalindrome(pali1) && isValidPalindrome(pali2))
				ans = Math.max(ans,pali1.length()*pali2.length());
			return;
		}

		helper1(s,pali1+s.charAt(pos)+"",pali2,pos+1);
		helper1(s,pali1,pali2+s.charAt(pos)+"",pos+1);			//1st 2 calls will include all chars, hence 3rd call
		helper1(s,pali1,pali2,pos+1);
	}

	private static boolean isValidPalindrome(String str) {
		if(str.length()==0 || str.length()==1)
			return true;

		int i=0;int j=str.length()-1;
		while(i<j)	{
			if(str.charAt(i)!=str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}


	public static void main(String[] args) {
		String s = "leetcodecom";
		System.out.println(maxProduct(s));
	}
}
