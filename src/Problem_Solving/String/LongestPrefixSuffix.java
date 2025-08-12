package Problem_Solving.String;

/**
 * Efficient Java program to find length of the longest 
 * prefix which is also suffix and the two do not overlap
 * 
 * Taken from KMP algo
 */

public class LongestPrefixSuffix {
	
	static int[] longestPrefixSuffix(String s) {
		int n = s.length();

		int lps[] = new int[n];

		// lps[0] is always 0
		lps[0] = 0; 

		// length of the previous longest prefix suffix
		int i = 0;

		// the loop calculates lps[i] for i = 1 to n-1
		int j = 1;
		while (j < n) {
			if (s.charAt(j) == s.charAt(i)) {
				lps[j] = i+1;
				i++;
				j++;
			}
			else {
				if (i != 0) {
					i = lps[i-1];
					// Also, note that we do not increment j here
				}

				// if (i == 0)
				else {
					lps[j] = 0;
					j++;
				}
			}
		}
//		int res = lps[n-1];
		// Since we are looking for non overlapping parts.
//		System.out.println((res > n/2)? n/2 : res);
		return lps;
	}

	public static void main (String[] args) {
		String s = "abcabcabc";
//		System.out.println(longestPrefixSuffix(s));
		
		String result = "";
        if (s == null || s.length() == 0) {
            System.out.println(result);
        }
        int lps[] = longestPrefixSuffix(s);
        for(int i: lps)
        	System.out.print(i + " ");
        System.out.println();
        
        int lastIndex = lps[s.length() - 1];
        if (lastIndex == 0) {
        	System.out.println(result);
        } else {
            result = s.substring(0, lastIndex);				/** Imp: check the answer **/
        }
        System.out.println(result);
	}
}
