package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
	For example:
	Given s = "aabb", return ["abba", "baab"].
	Given s = "abc", return [].
	Hint:
	If a palindromic permutation exists, we just need to generate the first half of the string.
	To generate all distinct permutations of a (half of) string, use a similar approach from: 
	Permutations II or Next Permutation.
	
	Code = Perm WO R since here vis[] is taken care by: inp[i] -= 2, or the 2 chars are removed so they wont be added again to create repetitions
 *
 */

public class PalindromePermutation2 {

	public static void main(String[] args) {
		PalindromePermutation2 pp = new PalindromePermutation2();
		List<String> answer = pp.generatePalindromes("aabb");
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}
	
	public List<String> generatePalindromes(String s) {
		List<String> res = new ArrayList<String>();
        int odd = 0; 						// How many characters that have odd number of count
        int[] inp = new int[256]; 			// map from character to its frequency
        for (char c: s.toCharArray()) {
            inp[c]++;
            if(inp[c] % 2 == 1)
            	odd++;
            else 
            	odd--;
        }
        if (s.length() ==0 || odd>1)   
        	return res;

        String tmp = "";
        for (int i = 0; i < 256 && odd > 0; i++) {			// Add the only odd character to the answer string
            if (inp[i] %2 == 1) {
            	tmp += (char) i;
            	inp[i]--;
            	break;
            }
        }
        helper(res, inp, s.length(), tmp);
        return res;
    }

	//Method to create permutations
	private void helper(List<String> res, int[] inp, int n, String tmp) {
		if(tmp.length() == n) {
			res.add(tmp);
			return;
		}
		
		for(int i=0; i<256; i++) {
			if(inp[i] > 0) {
				inp[i] -= 2;									// dec the char count by 2					
				helper(res, inp, n, (char)i + tmp+ (char)i);		// add the char before and after 
				inp[i] += 2;
			}
		}
	}
}
