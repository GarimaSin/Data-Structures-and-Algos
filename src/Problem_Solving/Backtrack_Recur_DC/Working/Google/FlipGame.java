package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working.Google;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take 
 * turns to flip two consecutive “++” into “–”. The game ends when a person can no longer make a move and therefore the other person will be the winner.
	Write a function to compute all possible states of the string after one valid move.
	
	Input: s = “++++“
	Output:
	[
	”--++”,
	"+--+",
	"++--"
	]
	Note: If there is no valid move, return an empty list [].
 *
 */

public class FlipGame {

	public static void main(String[] args) {
		FlipGame flip = new FlipGame();
		List<String> ans = flip.flip("++++");
		for(int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}

	public List<String> flip(String s){
		List<String> res = new ArrayList<>();
		char[] ary = s.toCharArray();
		for(int i = 0; i < ary.length - 1; i++) {
			if(ary[i] == '+' && ary[i + 1] == '+') {
				ary[i] = '-';
				ary[i + 1] = '-';
				res.add(new String(ary));
				ary[i] = '+';
				ary[i + 1] = '+';
			}
		}
		return res;
	}
}
