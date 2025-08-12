package Problem_Solving.BitManipulation;

public class MaxProductOfWordLengths {
	
	public static int maxProduct(String[] words) {
		int len = words.length;
		int state[] = new int[len];
		int ans = 0;
		
		for (int i = 0; i < words.length; i++) {
			for(char c: words[i].toCharArray()) {
				state[i] = state[i] | 1<<(c-'a');
			}
			
			for (int j = 0; j<i; j++) {
				if((state[i] & state[j]) == 0) {
					ans = Math.max(ans, words[i].length() * words[j].length());
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
		maxProduct(words);
	}
}
