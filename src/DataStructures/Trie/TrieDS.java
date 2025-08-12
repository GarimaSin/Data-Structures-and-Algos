package DataStructures.Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Trie using list instead of map
class TrieNode {
	// Define the alphabet size (26 characters for `a – z`)
    private static final int CHAR_SIZE = 26;
 
    boolean endOfWord;
    List<TrieNode> children = null;
 
    TrieNode()  {
    	endOfWord = false;
        children = new ArrayList<>(Collections.nCopies(CHAR_SIZE, null));
    }
}


public class TrieDS {
    
	TrieNode root = new TrieNode();

	public void insert(String key) {
        System.out.println("Inserting \"" + key + "\"");
        // start from the root node
        TrieNode curr = root;
 
        for (char c: key.toCharArray()) {
            // create a new Trie node if the path does not exist
            if (curr.children.get(c - 'a') == null) {
                curr.children.set(c - 'a', new TrieNode());
            }
            // go to the next node
            curr = curr.children.get(c - 'a');
        }
 
        // mark the current node as a leaf
        curr.endOfWord = true;
    }
 
    public boolean search(String key) {
        System.out.print("Searching \"" + key + "\" : ");
 
        TrieNode curr = root;
        for (char c: key.toCharArray()) {
            // go to the next node
            curr = curr.children.get(c - 'a');
 
            if (curr == null) {
                return false;
            }
        }
        return curr.endOfWord;
    }
    
    public void delete(String word) {
        System.out.println(delete(root, word, 0) + "....");
    }
    
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            return current.children.isEmpty();
        }
        
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch-'a');
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.endOfWord;

        if (shouldDeleteCurrentNode) {
            current.children.remove(ch-'a');
            return current.children.isEmpty();
        }
        return false;
    }
}