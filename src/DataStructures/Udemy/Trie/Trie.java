package DataStructures.Udemy.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * BETTER CODE - coz map internally maintains an array, hence we dont have to create a list of chars inside TrieNode
 * 
 * Always remove from parent Eg. as below:
 * Check out lines: 110 (parent.remove and not child.remove) and Line No. 128
 * 
 * Better and faster sol than if TrieNode has list instead of a map & in cases where we have to search thru "."
 * Coz in "." we have to traverse thru the entire list () 
 * 
 * COZ LISTS CONTAINS NULL FOR EACH CHAR WHICH ARE NOT HAVING CHILDREN WHILE MAP REMAINS EMPTY FOR IT,  
 * and will only store the chars which has children else it will be empty
 * hence we dont have to iterate thru the entire 26 char list to find which is not null.
 */

public class Trie {

	public class TrieNode {
		public Map<Character, TrieNode> children;
		public boolean endOfWord;

		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}
	}

	public final TrieNode root;
	public Trie() {
		root = new TrieNode();
	}


	// Insert word into Trie
	public void insert(String word) {
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


	// Search for a word in Trie
	public boolean search(String word) {
		TrieNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = currentNode.children.get(ch); 
			if (node == null) { 						//CASE#1 -- if node does not exist for given char then return false
				System.out.println("Word: " + word + " does not exists in Trie !");
				return false;
			}
			currentNode = node;
		}
		if(currentNode.endOfWord == true) {
			System.out.println("Word: " + word + " exists in Trie !"); //CASE#2 -- Word exists in Trie
		} else {												//CASE#3 -- Current word is a prefix of another word. But this word does not exists
			System.out.println("Word: " + word + " does not exists in Trie ! But this is a Prefix of another Word !");
		}
		return currentNode.endOfWord;
	}

	// Delete word from Trie
	public void delete(String word) {
		if (search(word) == true) {
			System.out.println(delete(root, word, 0) + "....");
		}
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
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.endOfWord;

        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.isEmpty();
        }
        return false;
    }
	
	public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			TrieNode node = currentNode.children.get(ch); 
			if (node == null) { 
				return false;
			}
			currentNode = node;
		}
		return true;
    }
	
	public static void preorder(TrieNode curr, String s) {
		// return false if Trie is empty
		if (curr == null) {
			return;
		}
//		for (int i = 0; i < 26; i++) {
//			if (curr.children.get(i) != null) {
//				// if leaf node, print key
//				if (curr.character[i].key != null) {
//					System.out.println(curr.character[i].key);
//				}
//				preorder(curr.character[i]);
//			}
//		}
	}
	
//	// Returns true if parent should delete the mapping
//	private boolean delete(TrieNode parentNode, String word, int index) {
//
//		// CASE#1 -- Some other word's prefix is same as Prefix of this word (BCDE, BCKG)
//		// CASE#2 -- We are at last character of this word and This word is a Prefix of some other word (BCDE, BCDEFG)
//		// CASE#3 -- Some other word is a Prefix of this word (BCDE, BC)
//		// CASE#4 -- No one is dependent on this Word (BCDE, BCDE)
//
//		char ch = word.charAt(index);
//		TrieNode currentNode = parentNode.children.get(ch);
//
//		boolean canThisNodeBeDeleted;
//
//		if (currentNode.children.size() > 1) {
//			System.out.println("Entering Case#1");
//			delete(currentNode, word, index + 1); // CASE#1
//			return false;
//		}
//
//
//
//		if (index == word.length() - 1) { // CASE#2
//			System.out.println("Entering Case#2");
//			if (currentNode.children.size() >= 1) {
//				currentNode.endOfWord = false;//updating endOfWord will signify that this word is not there in Trie
//				return false;
//			} else {
//				System.out.println("Character " + ch + " has no dependency, hence deleting it from last");
//				parentNode.children.remove(ch);														/** check this **/
//				return true;// If this word is not a prefix of some other word, and since this is last
//				// character, we should return true, indicating we are ok to delete this node
//			}
//		}
//
//
//		if (currentNode.endOfWord == true) { // CASE#3
//			System.out.println("Entering Case#3");
//			delete(currentNode, word, index + 1); 
//			return false;
//		}
//
//
//		System.out.println("Entering Case#1");
//		canThisNodeBeDeleted = delete(currentNode, word, index + 1); // CASE#4
//		if (canThisNodeBeDeleted == true) {
//			System.out.println("Character " + ch + " has no dependency, hence deleting it");
//			parentNode.children.remove(ch);														/** check this **/
//			return true; // Current node can also be deleted
//		} else {
//			return false; // Someone is dependent on this node, hence don't delete it
//		}
//	}
}