package Problem_Solving.Trie;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWords {

	public static TrieNode root;
	public DesignAddAndSearchWords() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public static void addWord(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
		System.out.println("Successfully inserted " + word + " in Trie !");
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public static boolean searchWord(String word, int index, TrieNode root) {
        if(index>=word.length())
            return root.endOfWord;
        
        char ch=word.charAt(index);
        
        if(ch=='.') {
            //check for all keys, starting from index+1
            for(char c: root.children.keySet()){
                if(searchWord(word, index+1, root.children.get(c)))
                    return true;
            }
            //if we dont find it, return false
            return false;
        }
        //if the given character is not present, return false
        else if(root.children.get(ch)==null)
            return false;
        else
            return searchWord(word, index+1, root.children.get(ch)); //start with next index & next child node
    }
	
	public static boolean search(String word) { 
		return searchWord(word, 0, root);
	}
	
	public static void main(String[] args) {
		new DesignAddAndSearchWords();
		addWord("a");
//		addWord("dad");
//		addWord("mad");
//		System.out.println(search("pad")); 
//		System.out.println(search("bad"));
		System.out.println(search(".a"));
		System.out.println(search("a."));
	}
	
	private static class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}
	}
}