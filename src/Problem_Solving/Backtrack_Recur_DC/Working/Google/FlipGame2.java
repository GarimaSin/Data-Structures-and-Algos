package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working.Google;

/**
 * 
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters:
 *  + and -, you and your friend take turns to flip two consecutive "++" into "--". 
 *  The game ends when a person can no longer make a move and therefore the other person will be the winner.
	Write a function to determine if the starting player can guarantee a win.
	For example, given s = "++++", return true. 
	The starting player can guarantee a win by flipping the middle "++" to become "+--+".
	
	T(N) = T(N-2) + T(N-3) + [T(2) + T(N-4)] + [T(3) + T(N-5)] + ... 
        [T(N-5) + T(3)] + [T(N-4) + T(2)] + T(N-3) + T(N-2)
     = 2 * sum(T[i])  (i = 3..N-2)
	You will find that T(N) = 2^(N-1) satisfies the above equation. 
	Therefore, this algorithm is at least exponential.

 *
 */

public class FlipGame2 {
	public static void main(String[] args) {
		FlipGame2 flip = new FlipGame2();
		System.out.println(flip.canWin("++++"));
	}
	
	public boolean canWin(String s) {
		flipGame2Helper(s.toCharArray(), 0);
		return answer;
	}
	
	Boolean answer = false;
	public void flipGame2Helper(char[] ary, int noOfMoves) {
		
		for(int i=0; i<ary.length-1; i++) {
			if(ary[i] == '+' && ary[i + 1] == '+') {
				ary[i] = '-';
				ary[i + 1] = '-';
				flipGame2Helper(ary, noOfMoves+1);
				ary[i] = '+';
				ary[i + 1] = '+';
			}
		}
		if(noOfMoves %2 != 1)			// if at the end of 1 permutation ans = true => there is 1 move thru which we can win
			answer = true;
		else 
			answer = false;
	}
}
