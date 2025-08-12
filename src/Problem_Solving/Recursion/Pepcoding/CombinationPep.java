package Problem_Solving.Recursion.Pepcoding;

public class CombinationPep {
	
	
	//Placing 2 items in 4 boxes
	public static void main(String[] args) {
		printCombinations(1, 4, 0, 2, "");	
	}
	
	//Without repetition
	static void printCombinations(int cuBox, int totbox, int selSoFar, int totSel, String ans) {
		if(cuBox > totbox) {
			if(selSoFar == totSel)
				System.out.println(ans);
			return;
		}
		printCombinations(cuBox+1, totbox, selSoFar+1, totSel, ans+" i ");				// an item selected 
		printCombinations(cuBox+1, totbox, selSoFar, totSel, ans+" - ");					//nothing selected
	}
	
	
//	static void printCombinations(int cuBox, int totbox, int selSoFar, int totSel, String ans) {
//		if(cuBox > totbox) {
//			if(selSoFar == totSel)
//				System.out.println(ans);
//			return;
//		}
//		printCombinations(cuBox+1, totbox, selSoFar+1, totSel, ans+" i ");				// an item selected 
//		printCombinations(cuBox+1, totbox, selSoFar, totSel, ans+" - ");					//nothing selected
//	}
}
