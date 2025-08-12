package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.HashMap;

public class AddAndSearchWord {

	HashMap<String, Boolean> dict = new HashMap<>();
	public static void main(String[] args) {
		AddAndSearchWord add = new AddAndSearchWord();
//		String s1 = "";
//		String s1 = "";
//		String s1 = "";
		add.addWord("bad");
		add.addWord("dad");
		add.addWord("mad");
		System.out.println(add.search("pad"));
		System.out.println(add.search("bad"));
		System.out.println(add.search(".ad"));
		System.out.println(add.search("b.."));
	}
	
	public void addWord(String word) {
        dict.put(word, true);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dict.containsKey(word);
    }
}
