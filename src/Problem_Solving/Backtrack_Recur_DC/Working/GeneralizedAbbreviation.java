package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

/**
 * 
 * Write a function to generate the generalized abbreviations of a word.
	Example:
	Given word ="word", return the following list (order does not matter):
	["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 *
 *	Sol = for each character either generalize or not
 *	curr + count + word.charAt(pos)
 *
 *	CODE IS SIMILAR TO POWERSET COMB, JUST ADD NOS WHERE CHARS ARE MISSING 
 */



//Same as Abbreviations from Pepcoding