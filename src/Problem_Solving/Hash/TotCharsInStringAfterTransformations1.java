package Problem_Solving.Hash;

public class TotCharsInStringAfterTransformations1 {

	public static void main(String[] args) {

	}
	
	private static final int MOD = 1_000_000_007;

	
	// Working
	// T.C : O(n+t)
	// S.C : O(26) ~= O(1)
    public int lengthAfterTransformations(String s, int t) {
        int[] mp = new int[26];

        // Count frequencies of each char in the i/p string
        for (char ch : s.toCharArray()) {
            mp[ch-'a']++;
        }

        // Perform t transformations
        for (int count=1; count <= t; count++) {
            int[] temp = new int[26];

            for (int i=0; i<26; i++) {
                char ch = (char) (i+'a');
                int freq = mp[i];

                if (ch != 'z') {
                    temp[ch+1 -'a'] = (temp[ch+1 -'a'] + freq) % MOD;
                } else {
                    temp['a'-'a'] = (temp['a'-'a'] + freq) % MOD;
                    temp['b'-'a'] = (temp['b'-'a'] + freq) % MOD;
                }
            }
            mp = temp; // update for next round
        }

        // Sum all frequencies to get final string length
        int result = 0;
        for (int val : mp) {
            result = (result + val) % MOD;
        }
        return result;
    }

}
