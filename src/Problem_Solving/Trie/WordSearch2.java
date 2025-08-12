package Problem_Solving.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordSearch2 {

	
	static boolean vis[][];
	//My Sol, working for 62 TCs out of 63. Giving TLE
	public static LinkedList<String> findWords(char[][] board, String[] words) {
		vis = new boolean[board.length][board[0].length];
		LinkedList<String> ans = new LinkedList<>();
		HashMap<Character, ArrayList<Cell>> map = new HashMap<>();
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				Character c = board[i][j];
				ArrayList<Cell> list;
				if(map.containsKey(c))
					list = map.get(c);
				else
					list = new ArrayList<>();
				list.add(new Cell(i,j));
				map.put(c, list); 
			}
		}

		boolean found = false;
		for(String word: words) {
			found = false;
			Character ch = word.charAt(0);
			if(map.containsKey(ch)) {
				for(Cell c: map.get(ch)) {
					vis[c.row][c.col] = true;
					if(solution(c.row, c.col, board, word, 1)) {
						found = true;
						ans.add(word);
						vis[c.row][c.col] = false;
						break;
					}
					vis[c.row][c.col] = false;
					if(found)
						break;
				}
			}
		}
		return ans;
	}

	private static boolean solution(int i, int j, char[][] board, String word, int idx) {
		if(idx >= word.length()) {
			return true;
		}

		char c = word.charAt(idx);
		if(isValid(i+1, j, board, c)) {
			vis[i+1][j] = true;
			boolean ans = solution(i+1, j, board, word, idx+1);
			vis[i+1][j] = false;
			if(ans)
				return ans;
		}
		if(isValid(i, j+1, board, c)) {
			vis[i][j+1] = true;
			boolean ans = solution(i, j+1, board, word, idx+1);
			vis[i][j+1] = false;
			if(ans)
				return ans;
		}
		if(isValid(i-1, j, board, c)) {
			vis[i-1][j] = true;
			boolean ans = solution(i-1, j, board, word, idx+1);
			vis[i-1][j] = false;
			if(ans)
				return ans;
		}
		if(isValid(i, j-1, board, c)) {
			vis[i][j-1] = true;
			boolean ans = solution(i, j-1, board, word, idx+1);
			vis[i][j-1] = false;
			if(ans)
				return ans;
		}
		return false;
	}

	static boolean isValid(int i, int j, char[][] board, char c) {
		if(i <board.length && i >= 0 && j < board[0].length && j >= 0 && !vis[i][j]) 
			if(c == board[i][j])
				return true;
		return false;
	}

	public static void main(String[] args) {
		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = {"oath","pea","eat","rain","oathi","oathk","oathf","oate","oathii","oathfi","oathfii"};
		LinkedList<String> ans = findWords(board, words);				
		for(String s: ans)
			System.out.println(s);
	}

	static class Cell {
		int row;
		int col;

		public Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}



//Working sol 4m LC
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            buildTrie(word, root, 0);
        }
        List<String> res = new ArrayList<>();
        boolean[][] seen = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res, seen);
            }
        }
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res, boolean[][] seen) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) return;
        if (seen[i][j]) return;
        node = node.next[board[i][j] - 'a'];
        if (node == null) return;
        seen[i][j] = true;
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        dfs(board, i + 1, j, node, res, seen);
        dfs(board, i - 1, j, node, res, seen);
        dfs(board, i, j + 1, node, res, seen);
        dfs(board, i, j - 1, node, res, seen);
        seen[i][j] = false;
    }
    
    private void buildTrie(String word, TrieNode node, int i) {
        if (i == word.length()) {
            node.word = word;
        } else {
            char next = word.charAt(i);
            int nextI = next - 'a';
            if (node.next[nextI] == null) {
                node.next[nextI] = new TrieNode();
            }
            buildTrie(word, node.next[nextI], ++i);
        }
    }
    
    class TrieNode {
        TrieNode[] next;
        String word;
        
        TrieNode() {
            next = new TrieNode[26];
        }
    }
}