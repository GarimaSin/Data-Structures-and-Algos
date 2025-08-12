package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.HashMap;

public class AllPalindromicPermutations {

	public static void main(String[] args) {
		String str = "aaabb";
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(fmap.containsKey(ch)) {
				int of = fmap.get(ch);
				fmap.put(ch, of+1);
			} else
				fmap.put(ch, 1);
		}
		
		Character odd = null;
		int  odds = 0;
		int len = 0;
		for(char ch: fmap.keySet()) {
			int freq = fmap.get(ch);
			if(freq %2 == 1) {
				odd = ch;
				odds++;
			}
			if(odds > 1) {
				System.out.println(-1);
				return;
			}
			fmap.put(ch, freq/2);
			len += freq/2;
		}
		
		generatePalindromePermutations(1, len, fmap, odd, "");
	}
	
	static void generatePalindromePermutations(int count, int tot, HashMap<Character, Integer> fmap, Character odd, String ans) {
		if(count > tot) {
			System.out.println(ans+fmap);
			String rev = "";
			for (int i = ans.length()-1; i>=0;  i--) {
				rev += ans.charAt(i);
			}
			
			String res = ans;
			if(odd != null)
				res += odd;
			res += rev;
			System.out.println(res);
			return;
		}
		
		for(char ch: fmap.keySet()) {
			int freq = fmap.get(ch);
			if(freq > 0) {
				fmap.put(ch, freq-1);
				generatePalindromePermutations(count+1, tot, fmap, odd, ans+ch);
				fmap.put(ch, freq);
			}
		}
	}
}
 